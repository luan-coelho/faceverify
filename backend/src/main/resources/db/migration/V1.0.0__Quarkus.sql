CREATE SEQUENCE facephoto_seq START 1;
CREATE TABLE face_photo
(
    face_photo_id BIGINT PRIMARY KEY DEFAULT nextval('facephoto_seq')
);

CREATE SEQUENCE role_seq START 1;
CREATE TABLE role
(
    role_id     BIGINT PRIMARY KEY DEFAULT nextval('role_seq'),
    description VARCHAR(255)
);

CREATE SEQUENCE user_seq START 1;
CREATE TABLE tb_user
(
    user_id    BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
    name       VARCHAR(255),
    email      VARCHAR(255),
    cpf        VARCHAR(11),
    password   VARCHAR(255),
    face_photo BIGINT REFERENCES face_photo (face_photo_id),
    role_id    BIGINT REFERENCES role (role_id)
);

CREATE TABLE device
(
    identifier UUID PRIMARY KEY,
    name       VARCHAR(255),
    user_id    BIGINT REFERENCES tb_user (user_id)
);

CREATE SEQUENCE event_seq START 1;
CREATE TABLE event
(
    event_id    BIGINT PRIMARY KEY DEFAULT nextval('event_seq'),
    description VARCHAR(255)
);

CREATE SEQUENCE point_registration_seq START 1;
CREATE TABLE point_registration
(
    point_registration_id BIGINT PRIMARY KEY DEFAULT nextval('point_registration_seq'),
    date                  DATE
);

CREATE SEQUENCE point_seq START 1;
CREATE TABLE point
(
    point_id  BIGINT PRIMARY KEY DEFAULT nextval('point_seq'),
    date_time TIMESTAMP
);

CREATE TABLE point_registration_users
(
    point_registration_id BIGINT REFERENCES point_registration (point_registration_id),
    user_id               BIGINT REFERENCES tb_user (user_id),
    PRIMARY KEY (point_registration_id, user_id)
);

CREATE TABLE point_registration_points
(
    point_registration_id BIGINT REFERENCES point_registration (point_registration_id),
    point_id              BIGINT REFERENCES point (point_id),
    PRIMARY KEY (point_registration_id, point_id)
);

CREATE TABLE event_point_registrations
(
    event_id              BIGINT REFERENCES event (event_id),
    point_registration_id BIGINT REFERENCES point_registration (point_registration_id),
    PRIMARY KEY (event_id, point_registration_id)
);