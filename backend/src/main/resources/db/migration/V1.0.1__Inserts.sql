INSERT INTO role(role_id, description)
VALUES (DEFAULT, 'ADMIN');

INSERT INTO tb_user(user_id, name, email, cpf, password, face_photo, role_id)
VALUES (DEFAULT, 'Professor', 'professor@unitins.br', '00000000000', '123', null, (SELECT last_value FROM role_seq));

INSERT INTO device(device_id, name, bluetooth_identifier, user_id)
VALUES (DEFAULT, 'Dispositivo do Usuário', 'a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', (SELECT last_value FROM user_seq));
