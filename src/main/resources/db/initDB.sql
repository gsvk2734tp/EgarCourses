CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR                           NOT NULL,
  email      VARCHAR                           NOT NULL,
  password   VARCHAR                           NOT NULL,
  registered TIMESTAMP           DEFAULT now() NOT NULL,
  enabled    BOOLEAN             DEFAULT TRUE  NOT NULL
);

CREATE UNIQUE INDEX users_unique_emails_idx ON users (email);

CREATE TABLE roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE address
(
  user_id INTEGER NOT NULL,
  country VARCHAR NOT NULL,
  city    VARCHAR NOT NULL,
  street  VARCHAR NOT NULL,
  house   INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE cars
(
  id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name         VARCHAR   NOT NULL,
  model        VARCHAR   NOT NULL,
  release_year TIMESTAMP NOT NULL,
  speed        INTEGER
);

CREATE TABLE pets
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR   NOT NULL,
  sex      BOOLEAN   NOT NULL,
  birthday TIMESTAMP NOT NULL
);


