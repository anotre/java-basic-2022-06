CREATE DATABASE TestingSystemOtus ENCODING utf8;

CREATE TABLE roles
(
    id                  SERIAL          PRIMARY KEY,
    name                VARCHAR(100)    NOT NULL UNIQUE,
    permission_code     INTEGER         NOT NULL
);

CREATE TABLE users
(
    id                  SERIAL          PRIMARY KEY,
    student_id          INTEGER         NOT NULL UNIQUE,
    first_name          VARCHAR(100)    NOT NULL,
    last_name           VARCHAR(100)    NOT NULL,
    patronymic          VARCHAR(100)    NOT NULL,
    role_id             INTEGER         NOT NULL REFERENCES roles (id)
);

CREATE TABLE classes
(
    id                  SERIAL          PRIMARY KEY,
    name                VARCHAR(100)    NOT NULL
);

CREATE TABLE sessions
(
    id                  SERIAL          PRIMARY KEY,
    user_id             INTEGER         NOT NULL REFERENCES users (id),
    class_id            INTEGER         NOT NULL REFERENCES classes (id),
    date_start          TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    date_end            TIMESTAMP       NOT NULL,
    score               INTEGER         NOT NULL,
    user_answers_JSON   JSON            NOT NULL
);

CREATE TABLE questions
(
    id                  SERIAL          PRIMARY KEY,
    question            VARCHAR(400)    NOT NULL UNIQUE,
    author_id           INTEGER         REFERENCES users (id),
    creating_date       TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updating_date       TIMESTAMP
);

CREATE TABLE answers
(
    id                  SERIAL          PRIMARY KEY,
    answer              VARCHAR(400)    NOT NULL,
    question_id         INTEGER         NOT NULL,
    author_id           INTEGER         REFERENCES users (id),
    creating_date       TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updating_date       TIMESTAMP   
);

CREATE TABLE keys
(
    id                  SERIAL          PRIMARY KEY,
    keys                JSON            NOT NULL,
    question_id         INTEGER         NOT NULL REFERENCES questions (id)
);

SELECT * FROM pg_catalog.pg_tables WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema';










