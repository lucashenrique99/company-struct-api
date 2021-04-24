INSERT INTO users(id, created_date, last_modified_date, name, email, password) VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'Lucas', 'lucas@admin.com', '{bcrypt}$2a$10$upMv8.U1hslgE31GpI00DOUPBk6K8jkbMjDz3fQ76yFgcK0BEOGxy');
INSERT INTO employees (name, id, is_active) VALUES ('Lucas', 1, TRUE);

INSERT INTO permissions(name, description) VALUES ('ROLE_ROOT', 'CAN EXECUTE ALL ACTIONS');
INSERT INTO permissions(name, description) VALUES ('ROLE_ADMIN', 'USER HAS ACCESS TO ADMIN PANEL');

INSERT INTO users_has_permissions(user_id, permission_id) VALUES(1, 'ROLE_ROOT');

