create table users(
	id SERIAL PRIMARY KEY NOT NULL,
	sureName VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	age INTEGER NOT NULL,
	city VARCHAR(255) NOT NULL,
	country VARCHAR(255) NOT NULL,
	subject VARCHAR(255) NOT NULL
);