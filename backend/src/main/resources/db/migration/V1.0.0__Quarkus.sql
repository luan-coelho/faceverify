CREATE SEQUENCE facephoto_seq START 1;
CREATE TABLE face_photo
(
    face_photo_id BIGINT PRIMARY KEY DEFAULT nextval('facephoto_seq') NOT NULL
);

CREATE SEQUENCE role_seq START 1;
CREATE TABLE role
(
    role_id     BIGINT PRIMARY KEY DEFAULT nextval('role_seq') NOT NULL,
    description VARCHAR(255)                                   NOT NULL
);

CREATE SEQUENCE user_seq START 1;
CREATE TABLE tb_user
(
    user_id    BIGINT PRIMARY KEY DEFAULT nextval('user_seq') NOT NULL,
    name       VARCHAR(255)                                   NOT NULL,
    email      VARCHAR(255)                                   NOT NULL,
    cpf        VARCHAR(11)                                    NOT NULL,
    password   VARCHAR(255)                                   NOT NULL,
    face_photo BIGINT                                         NULL REFERENCES face_photo (face_photo_id)
);

CREATE SEQUENCE device_seq START 1;
CREATE TABLE device
(
    device_id            BIGINT PRIMARY KEY DEFAULT nextval('device_seq') NOT NULL,
    bluetooth_identifier UUID                                             NOT NULL,
    name                 VARCHAR(255)                                     NOT NULL,
    user_id              BIGINT REFERENCES tb_user (user_id)
);

CREATE SEQUENCE event_seq START 1;
CREATE TABLE event
(
    event_id    BIGINT PRIMARY KEY DEFAULT nextval('event_seq') NOT NULL,
    description VARCHAR(255)                                    NOT NULL
);

CREATE SEQUENCE point_registration_seq START 1;
CREATE TABLE point_registration
(
    point_registration_id BIGINT PRIMARY KEY DEFAULT nextval('point_registration_seq') NOT NULL,
    date                  DATE                                                         NOT NULL,
    event_id              BIGINT REFERENCES event (event_id)
);

CREATE SEQUENCE point_seq START 1;
CREATE TABLE point
(
    point_id              BIGINT PRIMARY KEY DEFAULT nextval('point_seq') NOT NULL,
    date_time             TIMESTAMP                                       NOT NULL,
    validated             BOOLEAN,
    point_registration_id BIGINT REFERENCES point_registration (point_registration_id)
);

CREATE TABLE point_registration_user
(
    point_registration_id BIGINT REFERENCES point_registration (point_registration_id),
    user_id               BIGINT REFERENCES tb_user (user_id),
    PRIMARY KEY (point_registration_id, user_id)
);

CREATE TABLE user_role
(
    user_id BIGINT REFERENCES tb_user (user_id),
    role_id BIGINT REFERENCES role (role_id),
    PRIMARY KEY (user_id, role_id)
)