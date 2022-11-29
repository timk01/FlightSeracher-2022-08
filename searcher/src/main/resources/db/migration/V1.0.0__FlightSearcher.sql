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
    id                serial primary key,
    price             bigint,
    depart_date       timestamptz,
    number_of_changes int,
    duration          bigint,
    origin            varchar(16) references city (code),
    destination       varchar(16) references city (code)
);

create table if not exists airport
(
    code              varchar(16) primary key,
    type_of_transport varchar(16),
    name              varchar(64),
    country_code      varchar(16) references city (code),
    city_code         varchar(16) references city (code)
);
