insert into items (category, description, image, name, price)
VALUES ('FLOWERS', 'flowers for You', 'images/1.jpeg', 'Rose', 15);

insert into items (category, description, image, name, price)
VALUES ('FLOWERS', 'flowers for You', 'images/anon.jpeg', 'Rose', 15);

insert into items (category, description, image, name, price)
VALUES ('FLOWERS', 'flowers for You', 'images/6.jpeg', 'Rose', 15);

insert into items (category, description, image, name, price)
VALUES ('FLOWERS', 'flowers for You', 'images/2.jpeg', 'Tulpan', 10);

insert into items (category, description, image, name, price)
VALUES ('FLOWERS', 'flowers for You', 'images/3.jpeg', 'Astra', 5);

insert into items (category, description, image, name, price)
VALUES ('FLOWERS', 'flowers for You', 'images/2.jpeg', 'Astra', 5);

insert into items (category, description, image, name, price)
VALUES ('FLOWERS', 'flowers for You', 'images/4.jpeg', 'Astra', 5);

insert into items (category, description, image, name, price)
VALUES ('FLOWERS', 'flowers for You', 'images/5.jpeg', 'Astra', 5);


insert into customers(firs_name, last_name, email, password, phone)
VALUES('Argen', 'Baktybekov', 'a@test.com', '$2a$10$PaB43DWvQCJm9buZXV92/uhXwxUVMk0cQvtwhcydRbt9KKgvU9Vey', '0703039401');

insert into authorities (username)
VALUES('a@test.com');

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

insert into baskets(customer_id)
values (1);

-- insert into items_with_amounts(item_id, basket_id)
-- values (1, 1);
-- insert into items_with_amounts(item_id, basket_id)
-- values (2, 1);
-- insert into items_with_amounts(item_id, basket_id)
-- values (3, 1);

-- insert into baskets_itemswa(basket_id, itemswa_id)
-- values (1, 1);
-- insert into baskets_itemswa(basket_id, itemswa_id)
-- values (1, 2);
-- insert into baskets_itemswa(basket_id, itemswa_id)
-- values (1, 3);

