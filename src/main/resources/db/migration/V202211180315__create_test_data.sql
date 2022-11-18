insert into items (category, description, image, name, price, number)
VALUES ('flowers', 'flowers for You', 'image1.jpeg', 'Rose', 15, 1);

insert into items (category, description, image, name, price, number)
VALUES ('flowers', 'flowers for You', 'image2.jpeg', 'Tulpan', 10, 3);

insert into items (category, description, image, name, price, number)
VALUES ('flowers', 'flowers for You', 'image3.jpeg', 'Astra', 5, 3);


insert into customers(firs_name, last_name, email, password, phone)
VALUES('Argen', 'Baktybekov', 'a@test.com', 'qwerty', '0703039401');

insert into orders(time, customer_id)
values ('2022-11-14 18:41:33.000000', 1);
insert into orders(time, customer_id)
values ('2022-11-14 18:41:33.000000', 1);

insert into orders_items(order_id, items_id)
values (1, 1);
insert into orders_items(order_id, items_id)
values (1, 2);
insert into orders_items(order_id, items_id)
values (1, 3);