CREATE table categories (
    id tinyint auto_increment primary key,
    name varchar(255) not null
);

CREATE table products (
    id BIGINT auto_increment primary key,
    name varchar(255) not null,
    price decimal(10, 2) not null,
    category_id tinyint,
    foreign key (category_id) references categories(id) on delete restrict
);
