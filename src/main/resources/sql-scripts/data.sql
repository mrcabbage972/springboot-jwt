INSERT INTO app_role (role_name, description) VALUES ('STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (role_name, description) VALUES ('ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (first_name, last_name, password, username) VALUES ('John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe');
INSERT INTO app_user (first_name, last_name, password, username) VALUES ('Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

-- Populate random city table

INSERT INTO random_city(name) VALUES ('Bamako');
INSERT INTO random_city(name) VALUES ('Nonkon');
INSERT INTO random_city(name) VALUES ('Houston');
INSERT INTO random_city(name) VALUES ('Toronto');
INSERT INTO random_city(name) VALUES ('New York City');
INSERT INTO random_city(name) VALUES ('Mopti');
INSERT INTO random_city(name) VALUES ('Koulikoro');
INSERT INTO random_city(name) VALUES ('Moscow');