-- Postgres dialect

DROP TABLE IF EXISTS users, delivery_types, roles, permissions, products, orders, baskets, users_roles, orders_products, product_basket, roles_permissions CASCADE;

CREATE TABLE users
(
  id         INTEGER UNIQUE PRIMARY KEY NOT NULL,
  name       VARCHAR                    NOT NULL,
  email      VARCHAR                    NOT NULL,
  password   VARCHAR                    NOT NULL,
  registered TIMESTAMP DEFAULT now()    NOT NULL,
  enabled    BOOLEAN   DEFAULT TRUE     NOT NULL
);

CREATE TABLE delivery_types
(
  id        INTEGER PRIMARY KEY UNIQUE NOT NULL,
  type_name VARCHAR
);

CREATE TABLE roles
(
  id   INTEGER UNIQUE NOT NULL,
  role VARCHAR
);

CREATE TABLE permissions
(
  id        INTEGER UNIQUE NOT NULL,
  perm_name VARCHAR
);

CREATE TABLE products
(
  id   INTEGER UNIQUE PRIMARY KEY,
  name VARCHAR
);

CREATE TABLE orders
(
  id                INTEGER PRIMARY KEY NOT NULL,
  name              VARCHAR,
  user_id           INTEGER,
  delivery_types_id INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id), /* Связь с таблицей USERS one to one */
  FOREIGN KEY (delivery_types_id) REFERENCES delivery_types (id) /* Связь с таблицей DELIVERY_TYPES one to one */
);

CREATE TABLE baskets
(
  id      INTEGER UNIQUE PRIMARY KEY NOT NULL,
  name    VARCHAR,
  user_id INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id) /* Связь с таблицей USERS one to one */
);


/* Соединительная таблица ROLES и USERS связь many to many */
CREATE TABLE users_roles
(
  user_id  INTEGER NOT NULL,
  roles_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (roles_id) REFERENCES roles (id)

);

/* Соединительная таблица ROLES и PERM связь many to many */
CREATE TABLE roles_permissions
(
  roles_id      INTEGER NOT NULL,
  permission_id INTEGER NOT NULL,
  FOREIGN KEY (roles_id) REFERENCES roles (id),
  FOREIGN KEY (permission_id) REFERENCES permissions (id)
);

/* Соединительная таблица BASKET и PRODUCT связь many to many */
CREATE TABLE product_basket
(
  product_id INTEGER NOT NULL,
  basket_id  INTEGER NOT NULL,
  FOREIGN KEY (product_id) REFERENCES products (id),
  FOREIGN KEY (basket_id) REFERENCES baskets (id)
);

/* Соединительная таблица ORDERS и PRODUCT связь many to many */
CREATE TABLE orders_products
(
  orders_id   INTEGER NOT NULL,
  products_id INTEGER NOT NULL,
  FOREIGN KEY (orders_id) REFERENCES orders (id),
  FOREIGN KEY (products_id) REFERENCES products (id)
);
