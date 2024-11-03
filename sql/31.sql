create table user_loan_history (
    id bigint auto_increment,
    user_id bigint,
    book_name varchar(255),
    is_return tinyint,

    primary key (id)
);