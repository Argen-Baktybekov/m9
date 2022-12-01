
create table authorities
(
    id        bigserial
        primary key,
    authority varchar(45) default 'USER'::character varying,
    username  varchar(255)
);

alter table authorities
    owner to postgres;

create table customers
(
    id          bigserial
        primary key,
    card_number varchar(255),
    email       varchar(255),
    firs_name   varchar(25),
    last_name   varchar(255),
    password    varchar(255),
    phone       varchar(255),
    enabled     boolean not null default true,
    role       varchar(16) not null default 'USER'
);

alter table customers
    owner to postgres;

create table baskets
(
    id          bigserial
        primary key,
    customer_id bigint
        constraint fkd9n51h863f9df2m0js5v3slv4
            references customers
);

alter table baskets
    owner to postgres;

create table items
(
    id          bigserial
        primary key,
    category    varchar(255)     not null,
    description varchar(255),
    image       varchar(255)     not null,
    in_stock    boolean default true,
    name        varchar(255),
    price       double precision not null
);

alter table items
    owner to postgres;

create table items_with_amounts
(
    id        bigserial
        primary key,
    number    integer,
    basket_id bigint
        constraint fk7pq71lcbnnv2o36ettrltgdyc
            references baskets,
    item_id   bigint
        constraint fk54pwai2knwsulevrr48ohijnr
            references items
);

alter table items_with_amounts
    owner to postgres;

create table orders
(
    id          bigserial
        primary key,
    time        timestamp,
    total       double precision,
    customer_id bigint
        constraint fkpxtb8awmi0dk6smoh2vp1litg
            references customers
);

alter table orders
    owner to postgres;

create table orders_items
(
    order_id bigint not null
        constraint fkij1wwgx6o198ubsx1oulpopem
            references orders,
    items_id bigint not null
        constraint uk_7qrg5pfgjon82yhgwfqrdijm5
            unique
        constraint fklbp1l1no3u5k9ry42w038iip7
            references items
);

alter table orders_items
    owner to postgres;

create table reviews
(
    id       bigserial
        primary key,
    comment  varchar(255),
    time     timestamp,
    username varchar(255)
);

alter table reviews
    owner to postgres;

create table items_review
(
    item_id   bigint not null
        constraint fkaoqw5yvvcswi8eblbav7cuati
            references items,
    review_id bigint not null
        constraint uk_11ovqxdfppd1sbemd4b8nc47f
            unique
        constraint fk5ig2u489co5p4x87qcjajdmff
            references reviews
);

alter table items_review
    owner to postgres;

