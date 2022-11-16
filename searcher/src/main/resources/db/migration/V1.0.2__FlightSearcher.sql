create table if not exists country
(
    code varchar(16) primary key,
    name varchar(64)
);

create table if not exists city
(
    code         varchar(16) primary key,
    name         varchar(64),
    country_code varchar(16) references country (code)

);

create table if not exists ticket
(
    id          serial primary key,
    value       bigint,
    origin      varchar(16) references city (code),
    destination varchar(16) references city (code)
);

create table if not exists airport
(
    code        varchar(16) primary key,
    iata_type   varchar(16),
    name   varchar(64),
    country_code varchar(16) references city (code),
    city_code varchar(16) references city (code)
);
