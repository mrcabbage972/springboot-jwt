INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

-- Populate random city table

INSERT INTO random_city(id, name) VALUES (1, 'Bamako');
INSERT INTO random_city(id, name) VALUES (2, 'Nonkon');
INSERT INTO random_city(id, name) VALUES (3, 'Houston');
INSERT INTO random_city(id, name) VALUES (4, 'Toronto');
INSERT INTO random_city(id, name) VALUES (5, 'New York City');
INSERT INTO random_city(id, name) VALUES (6, 'Mopti');
INSERT INTO random_city(id, name) VALUES (7, 'Koulikoro');
INSERT INTO random_city(id, name) VALUES (8, 'Moscow');

INSERT INTO role (id, name) VALUES (1, 'STANDARD_USER');

INSERT INTO users (id, username, email, password, enabled, first_name, last_name, last_password_reset_date)
VALUES (1, 'user', 'user@example.com', '$2a$04$bzS11/R/yDFHWOxVfj942.t4IhCwIr2qG65Bf1O2BkdR/7hrpThqe', TRUE, 'User', 'User', null);

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);