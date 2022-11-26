
create table baskets
(
    id        bigserial
        primary key,
    last_date date
);

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
    role       varchar(16) not null default 'USER',
    basket_id   bigint
        constraint fkm1fvhmsboke8kuww98n60ekqt
            references baskets
);

create table authorities(
    id          bigserial    primary key,
    username varchar(50) not null
                        constraint authorities_users_fk references customers(email)
                        on delete cascade on update cascade ,
    authority varchar(50) not null default 'USER'
);

create table items
(
    id          bigserial
        primary key,
    name        varchar(30),
    category    varchar(45) not null,
    description varchar(255),
    image       varchar(255),
    number      integer default 1,
    in_stock    boolean default true,
    price       double precision
);

create table baskets_items
(
    basket_id bigint not null
        constraint fkd89cat6cakhjxrbf2vo8olf8h
            references baskets,
    items_id  bigint not null
        constraint uk_qsphd4qorojqidqj7e6fe3ltj
            unique
        constraint fkqf75k2lgfp0he2ca2rjkgeyj4
            references items
);

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


