CREATE TABLE IF NOT EXISTS users (
    id SERIAL UNIQUE PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    gender VARCHAR(255),
    age INT,
    email VARCHAR(255),
    password VARCHAR(255)
);