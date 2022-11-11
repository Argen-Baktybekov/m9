
create table customers
(
    id        bigserial
        primary key,
    firs_name varchar(255) not null,
    last_name varchar(255),
    phone     varchar(255)
);

create table item
(
    id          bigserial
        primary key,
    category    varchar(255),
    description varchar(255),
    image       varchar(255),
    name        varchar(255),
    price       double precision,
    qty         double precision
);

create table orders
(
    id          bigserial
        primary key,
    time        timestamp,
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
        constraint fkpend8sfg922gwhn2d3n457khv
            references item
);