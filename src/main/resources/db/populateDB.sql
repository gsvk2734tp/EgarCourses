DELETE
FROM roles;
DELETE
FROM address;
DELETE
FROM users;
DELETE
FROM cars;
DELETE
FROM pets;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users(name, email, password)
VALUES ('User', 'user@ya.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('User2', 'user2@ya.ru', 'password2'),
       ('User3', 'user3@ya.ru', 'password3'),
       ('User4', 'user4@ya.ru', 'password4');

INSERT INTO roles (role, user_id)
VALUES ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001),
       ('ROLE_USER', 100001),
       ('ROLE_USER', 100002),
       ('ROLE_USER', 100003),
       ('ROLE_USER', 100004);

INSERT INTO address (user_id, country, city, street, house)
VALUES (100000, 'Russia', 'Moscow', 'Краснобогатырская', 6),
       (100001, 'Belarus', 'Gomel', 'Lenin Ave', 3),
       (100002, 'Russia', 'Moscow', 'Краснобогатырская', 6),
       (100003, 'Russia', 'Moscow', 'Краснобогатырская', 6),
       (100004, 'Russia', 'Moscow', 'Краснобогатырская', 6);

INSERT INTO cars(name, model, release_year, speed)
VALUES ('Nissan ALMERA', 'Седан', '10/4/2019', 175),
       ('bmw x5', 'Внедорожник', '11/1/2014', 230),
       ('Bugatti Veyron', 'Super Sport', '6/3/2014', 300);

INSERT INTO pets(name, sex, birthday)
VALUES ('Cat', TRUE, '1/1/2019'),
       ('Dog', FALSE, '2/2/2019'),
       ('Rat', FALSE, '3/3/2019');