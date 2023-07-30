create table authors(id number(8) primary key AUTO_INCREMENT, name varchar(65535) not null);
create table books(id number(8) primary key AUTO_INCREMENT, name varchar(65535) not null, created_by number(8), constraint fk foreign key (created_by) references authors(id));
insert into authors(name) values ('vatsal');