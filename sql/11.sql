create database library;

show databases;

drop database library;

use library;

create table fruit
(
    id           bigint auto_increment,
    name         varchar(20),
    price        int,
    stocked_date date,

    primary key (id)
);

show tables;

drop table fruit;