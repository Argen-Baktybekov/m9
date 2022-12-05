
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
    firs_name   varchar(30),
    last_name   varchar(30),
    email       varchar(45) NOT NULL unique ,
    password    varchar(255) NOT NULL,
    phone       varchar(30),
    card_number varchar(16),
    enabled     boolean not null default true,
    role       varchar(16) not null default 'USER'
);

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
    id      bigserial
        primary key,
    amount  integer,
    email   varchar(255),
    price   double precision not null,
    time    timestamp,
    total   double precision,
    item_id bigint
        constraint fk247nnxschdfm8lre0ssvy3k1r
            references items
);

alter table orders
    owner to postgres;

create table reviews
(
    id       bigserial
        primary key,
    comment  varchar(255),
    time     timestamp,
    username varchar(255),
    item_id  bigint
        constraint fkd0qivr20lp2u34cfcrr0ibct7
            references items
);

alter table reviews
    owner to postgres;