ALTER TABLE airport
    DROP column country_code;

ALTER TABLE airport
    add column country_code varchar(16) references country (code);

