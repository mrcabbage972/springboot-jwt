CREATE TABLE random_city (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE role (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users (
    id bigint NOT NULL AUTO_INCREMENT,
    email varchar(255) DEFAULT NULL,
    enabled BOOLEAN DEFAULT NULL,
    first_name varchar(255) DEFAULT NULL,
    last_name varchar(255) DEFAULT NULL,
    last_password_reset_date timestamp NULL,
    password varchar(255) DEFAULT NULL,
    username varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users_roles (
  user_id bigint NOT NULL,
  role_id bigint NOT NULL,
  CONSTRAINT FK2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT FKj6m8fwv7oqv74fcehir1a9ffy FOREIGN KEY (role_id) REFERENCES role (id)
);