INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_TECNICO');
INSERT INTO roles (name) VALUES ('ROLE_CLIENTE');

INSERT INTO users (nombres, apellidos, correo, password, username, direccion, telefono, eliminado) VALUES ('Juan', 'Pérez', 'juan.perez@example.com', '$2a$12$C8ji4900d8S.nwnpOyvKp.45oHsoUbHYycJZwT9avYsv4sZXOxpbm', 'juanp', 'Av. Lima 123', '987654321',false);
INSERT INTO users (nombres, apellidos, correo, password, username, direccion, telefono, eliminado) VALUES ('María', 'Lopez', 'maria.lopez@example.com', '$2a$12$amVu.o7LKByGFRmw/LWgD.R50Fs5aDAmlUMJ0sARunD5sBLNyQBFC', 'marial', 'Av. Peru 456','987659321',false);
INSERT INTO users (nombres, apellidos, correo, password, username, direccion, telefono, eliminado) VALUES ('Carlos', 'Ramirez', 'carlos.ramirez@example.com', '$2a$12$RJGHzOhdMHiJgKoOA6pUxeaAaFarqzKBKn4nX6Ub.ML8p2SWyqYKO', 'carlosr', 'Av. Arequipa 789', '987654621',false);
INSERT INTO users (nombres, apellidos, correo, password, username, direccion, telefono, eliminado) VALUES ('Ana', 'Gonzalez', 'ana.gonzalez@example.com', '$2a$12$yuu8KC7faCvJ7CR.lgqlu.lAWC1Oj4Ckuifx0sJ1TdRLXE8ZEZn0i', 'anag', 'Av. Brasil 101', '987654342',false);
INSERT INTO users (nombres, apellidos, correo, password, username, direccion, telefono, eliminado) VALUES ('Luis', 'Fernandez', 'luis.fernandez@example.com', '$2a$12$he3HXaiWu6Opyr.5unu69uUMdieDU0raEgPv4o1kIhlNJPNeBwA96', 'luisf', 'Av. San Juan 202', '987658321',false);

INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);  -- Cliente1 con ROLE_TECNICO
INSERT INTO user_roles (user_id, role_id) VALUES (2, 1);  -- Cliente2 con ROLE_USUARIO
INSERT INTO user_roles (user_id, role_id) VALUES (3, 4);  -- Tecnico1 con ROLE_CLIENTE
INSERT INTO user_roles (user_id, role_id) VALUES (4, 2);  -- Tecnico2 con ROLE_ADMIN
INSERT INTO user_roles (user_id, role_id) VALUES (5, 3);  -- Admin con ROLE_TECNICO



