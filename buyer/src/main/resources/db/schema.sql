create table if not exists buyer
(
    id         serial primary key,
    first_name varchar(64),
    is_bot     boolean,
    last_name  varchar(64),
    user_name  varchar(64)
);
