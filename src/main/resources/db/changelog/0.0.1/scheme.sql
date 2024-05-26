--liquibase formatted sql

--changeset AkhmetZhanibek:1
--comment first migration
DROP TABLE IF EXISTS product;

CREATE TABLE IF NOT EXISTS product
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(10000)
);
-- insert into product(name, description)
-- values
-- ('latte','кофейный напиток на основе молока, представляющий собой трёхслойную смесь из молочной пены, молока и кофе эспрессо'),
-- ('cappuccino','кофейный напиток итальянской кухни на основе эспрессо с добавлением в него подогретого вспененного молока')

