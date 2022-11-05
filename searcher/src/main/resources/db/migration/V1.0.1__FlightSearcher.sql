create table country
(
    code varchar(16) primary key,
    name varchar(64)
);

create table city
(
    code         varchar(16) primary key,
    name         varchar(64),
    country_code varchar(16) references country (code)

);


create table ticket (
    id serial primary key,
    value bigint,
    origin varchar(16) references city(code),
    destination varchar(16) references city(code)
);

