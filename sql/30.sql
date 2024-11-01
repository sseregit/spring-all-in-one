use library;

create table book
(
    id   bigint auto_increment,
    name varchar(255),
    primary key (id)
);

select *
from book;