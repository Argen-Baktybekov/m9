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

insert into baskets(customer_id)
values (1);

