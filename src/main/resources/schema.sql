DROP TABLE IF EXISTS contacts;

CREATE TABLE contacts
(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    phone VARCHAR(20)
);