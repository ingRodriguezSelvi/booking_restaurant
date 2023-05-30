CREATE SEQUENCE IF NOT EXISTS client_seq;
CREATE TABLE IF NOT EXISTS Client
(
    id int8 NOT NULL PRIMARY KEY DEFAULT nextval('client_seq'),
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    status BOOLEAN NOT NULL
    );

CREATE SEQUENCE IF NOT EXISTS person_seq;
CREATE TABLE IF NOT EXISTS Person
(
    id int8 NOT NULL PRIMARY KEY DEFAULT nextval('person_seq'),
    name TEXT NOT NULL,
    age INT NOT NULL,
    address TEXT NOT NULL,
    gender TEXT NOT NULL,
    phone TEXT NOT NULL,
    client_id int8 NOT NULL REFERENCES Client(id)
);