create table book(
id INT primary key auto_increment,
bno VARCHAR(20) not NULL,
bname VARCHAR(20) not NULL,
author VARCHAR(20) not NULL,
price INT,
mark varchar(50)
)
insert into book VALUES(1,'b001','西游记','吴承恩',68,'四大名著');
insert into book VALUES(2,'b002','红楼梦','曹雪芹',98,'四大名著');
insert into book VALUES(3,'b003','三国演义','罗贯中',48,'四大名著');
insert into book VALUES(4,'b004','水浒传','施耐庵',58,'四大名著');

SELECT *FROM book;

select * from book order by price desc
select * from book order by price

create table admin(
id INT primary key auto_increment,
username varchar(20) not NULL ,
password varchar(20) not NULL
)

insert into admin values(1,'admin','123')

SHOW tables;

SELECT *FROM book;
SELECT *FROM admin;
delete from admin WHERE username  =1001;
delete from book WHERE bname = "童年"



select * from admin where username = 'admin' and password = '123'