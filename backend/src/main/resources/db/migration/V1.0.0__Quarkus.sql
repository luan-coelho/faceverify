CREATE TABLE device
(
    identifier UUID PRIMARY KEY,
    name       VARCHAR(100)
);

INSERT INTO device(identifier, name)
VALUES ('a0eebc99-9c0b-4ef8-bb6d-6bb9bd380a11', 'nome do dispositivo');

