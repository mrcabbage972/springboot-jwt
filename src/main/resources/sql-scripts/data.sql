INSERT INTO role (id, name) VALUES (1, 'STANDARD_USER');

INSERT INTO users (id, username, email, password, enabled, first_name, last_name, last_password_reset_date)
VALUES (1, 'user', 'user@example.com', '$2a$04$bzS11/R/yDFHWOxVfj942.t4IhCwIr2qG65Bf1O2BkdR/7hrpThqe', TRUE, 'User', 'User', null);

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);