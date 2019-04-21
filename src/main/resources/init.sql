/*
    Database initialization script that runs on every web-application redeployment.
*/
DROP TABLE IF EXISTS publications CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    login_name TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
	CONSTRAINT login_name_not_empty CHECK (login_name <> ''),
	CONSTRAINT password_not_empty CHECK (password <> '')
);

CREATE TABLE publications (
    p_id SERIAL PRIMARY KEY,
    u_id INTEGER,
    title varchar(40),
    published_year INTEGER,
    FOREIGN KEY (u_id) REFERENCES users(id)
);

INSERT INTO users (login_name, password) VALUES
	('rejtojeno', 'rejto'), -- 1
    ('petofisandor', 'petofi'); -- 1

