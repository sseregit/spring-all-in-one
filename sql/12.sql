use library;

insert into fruit (name, price, stocked_date)
values ('사과', 1000, '2023-01-01');

select *
from fruit;

select name, price
from fruit
where name = '사과' or price = 900;

update fruit
set price = 1500
where name = '사과';

delete from fruit where name = '사과';
