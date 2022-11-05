create table test_table (
    id serial primary key,
    name varchar(64),
    some_number bigint
);

insert into test_table(name, some_number)
values ('Timur', 123);

insert into test_table(name, some_number)
values ('Timur', 123);

insert into test_table(name, some_number)
values ('Timur', 123);

insert into test_table(name, some_number)
values ('Egor', 123);

select * from test_table;

select t.name from test_table t
where t.name = 'Timur'

