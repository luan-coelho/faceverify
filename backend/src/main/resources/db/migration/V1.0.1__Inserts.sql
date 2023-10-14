INSERT INTO role(role_id, description)
VALUES (DEFAULT, 'ADMIN');

INSERT INTO role(role_id, description)
VALUES (DEFAULT, 'STUDENT');

INSERT INTO tb_user(user_id, name, email, cpf, password, face_photo)
VALUES (DEFAULT, 'Teacher', 'teacher@unitins.br', '00000000000', '123', null);

INSERT INTO tb_user(user_id, name, email, cpf, password, face_photo)
VALUES (DEFAULT, 'Studant', 'student@unitins.br', '11111111111', '123', null);

INSERT INTO user_role(user_id, role_id)
VALUES (1, 1);

INSERT INTO user_role(user_id, role_id)
VALUES (2, 2);

INSERT INTO device(device_id, name, bluetooth_identifier, user_id)
VALUES (DEFAULT, 'Dispositivo do Usuário', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 1);

INSERT INTO event(event_id, description)
VALUES (DEFAULT, 'Labin IV');
