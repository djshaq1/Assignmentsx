drop table if exists student_class;
drop table if exists major_class;
drop table if exists class;
drop table if exists instructor;
drop table if exists major;
drop table if exists assignment;
drop table if exists student;


create table student(
	id int primary key,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	GPA decimal(5,1),
	SAT int,
	major_id int,
	foreign key (major_id) references major(id)
	);

insert student values(100,'Eric','Ephram',3.4,1100,1);
insert student values(110,'Greg','Gould',4.0,1200,2);
insert student values(120,'Adam','Ant',3.2,1400,3);
insert student values(130,'Howard','Hess',3.0,1500,4);
insert student values(140,'Charles','Caldwell',3.6,1600,5);
insert student values(150,'James','Joyce',3.8,1250,6);
insert student values(160,'Doug','Dumas',3.1,1375,7);
insert student values(170,'Kevin','Kraft',4.0,1175,4);
insert student values(180,'Frank','Fountain',3.8,1050,3);
insert student values(190,'Brian','Biggs',4.0,1300,5);



create table major(
	id int primary key auto_increment,
	name varchar(50) not null,
	score int
);
insert into major (name,score) values('General Business',800);
insert into major (name,score) values('Accounting',1000);
insert into major (name,score) values('Finance',1100);
insert into major (name,score) values('Math',1300);
insert into major (name,score) values('Engineering',1350);
insert into major (name,score) values('Education', 900);
insert into major (name,score) values('General Studies',500);

create table instructor (
	id int primary key auto_increment,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	years_of_experience int not null,
	tenured tinyint not null,
	major_id int,
	foreign key (major_id)
	  references major(id)
);


INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Margaret','Muse',10,1,1);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('James','Dean',25,1,2);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Dina','Fiasconaro',6,0,3);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Van','Exul',30,1,4);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Kanye','West',12,0,4);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Jay','Z',20,1,5);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Beyonce','Knowles',16,1,6);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Frank','Ocean',4,0,7);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Champagne','Champagne',40,1,1);
INSERT into instructor (first_name,last_name,years_of_experience,tenured,major_id) values('Sean','Combs',25,1,2);




create table class(
	id int primary key auto_increment,
	name varchar(50) not null,
	number int,
	instructor_id int,
	foreign key (instructor_id)
	  references instructor(id)
);
insert into class(name,number) values('English',101);
insert into class(name,number) values('English',102);
insert into class(name,number) values('English',103);
insert into class(name,number) values('English',201);
insert into class(name,number) values('English',202);
insert into class(name,number) values('English',203);
insert into class(name,number) values('English',301);
insert into class(name,number) values('English',302);
insert into class(name,number) values('English',303);
insert into class(name,number) values('Math',201);
insert into class(name,number) values('Math',202);
insert into class(name,number) values('Math',203);
insert into class(name,number) values('Math',204);
insert into class(name,number) values('Math',301);
insert into class(name,number) values('Math',302);
insert into class(name,number) values('Math',303);
insert into class(name,number) values('Math',304);
insert into class(name,number) values('History',101);
insert into class(name,number) values('History',201);
insert into class(name,number) values('History',301);
insert into class(name,number) values('Computer Science',311);
insert into class(name,number) values('Computer Science',312);
insert into class(name,number) values('Computer Science',313);
insert into class(name,number) values('Computer Science',441);
insert into class(name,number) values('Computer Science',442);
insert into class(name,number) values('Computer Science',443);
insert into class(name,number) values('Education',221);
insert into class(name,number) values('Education',222);
insert into class(name,number) values('Education',223);
insert into class(name,number) values('Education',351);
insert into class(name,number) values('Education',352);
insert into class(name,number) values('Education',353);
insert into class(name,number) values('Psychology',101);
insert into class(name,number) values('Psychology',102);
insert into class(name,number) values('Psychology',231);
insert into class(name,number) values('Psychology',232);

create table assignment(
	id int primary key, 
	student_id int not null,
	assignment_nbr int not null,
	grade varchar(30), 
	index student_id_idx (student_id), 
	class_id int,
	foreign key (student_id) 
		references student(id),
	foreign key (class_id) 
		references class(id)
);




create table major_class(
	id int primary key auto_increment,
	major_id int not null,
	class_id int not null,
	assignment_id int not null,
	foreign key (major_id)
	  references major(id),
	foreign key (class_id)
	  references class(id),
	
);

insert major_class (major_id, class_id) values (1,1);
insert major_class (major_id, class_id) values (1,2);
insert major_class (major_id, class_id) values (1,3);
insert major_class (major_id, class_id) values (1,18);
insert major_class (major_id, class_id) values (1,33);
insert major_class (major_id, class_id) values (1,34);
insert major_class (major_id, class_id) values (2,1);
insert major_class (major_id, class_id) values (2,2);
insert major_class (major_id, class_id) values (2,3);
insert major_class (major_id, class_id) values (2,10);
insert major_class (major_id, class_id) values (2,11);
insert major_class (major_id, class_id) values (2,12);
insert major_class (major_id, class_id) values (2,13);
insert major_class (major_id, class_id) values (2,14);
insert major_class (major_id, class_id) values (2,15);
insert major_class (major_id, class_id) values (2,16);
insert major_class (major_id, class_id) values (2,17);
insert major_class (major_id, class_id) values (2,33);
insert major_class (major_id, class_id) values (2,34);
insert major_class (major_id, class_id) values (3,1);
insert major_class (major_id, class_id) values (3,2);
insert major_class (major_id, class_id) values (3,3);
insert major_class (major_id, class_id) values (3,10);
insert major_class (major_id, class_id) values (3,11);
insert major_class (major_id, class_id) values (3,12);
insert major_class (major_id, class_id) values (3,13);
insert major_class (major_id, class_id) values (3,14);
insert major_class (major_id, class_id) values (3,15);
insert major_class (major_id, class_id) values (3,16);
insert major_class (major_id, class_id) values (3,17);
insert major_class (major_id, class_id) values (3,33);
insert major_class (major_id, class_id) values (3,34);
insert major_class (major_id, class_id) values (4,1);
insert major_class (major_id, class_id) values (4,2);
insert major_class (major_id, class_id) values (4,3);
insert major_class (major_id, class_id) values (4,10);
insert major_class (major_id, class_id) values (4,11);
insert major_class (major_id, class_id) values (4,12);
insert major_class (major_id, class_id) values (4,13);
insert major_class (major_id, class_id) values (4,14);
insert major_class (major_id, class_id) values (4,15);
insert major_class (major_id, class_id) values (4,16);
insert major_class (major_id, class_id) values (4,17);
insert major_class (major_id, class_id) values (4,33);
insert major_class (major_id, class_id) values (4,34);
insert major_class (major_id, class_id) values (5,1);
insert major_class (major_id, class_id) values (5,2);
insert major_class (major_id, class_id) values (5,3);
insert major_class (major_id, class_id) values (5,10);
insert major_class (major_id, class_id) values (5,11);
insert major_class (major_id, class_id) values (5,12);
insert major_class (major_id, class_id) values (5,13);
insert major_class (major_id, class_id) values (5,14);
insert major_class (major_id, class_id) values (5,15);
insert major_class (major_id, class_id) values (5,16);
insert major_class (major_id, class_id) values (5,17);
insert major_class (major_id, class_id) values (5,18);
insert major_class (major_id, class_id) values (5,33);
insert major_class (major_id, class_id) values (5,34);
insert major_class (major_id, class_id) values (6,1);
insert major_class (major_id, class_id) values (6,2);
insert major_class (major_id, class_id) values (6,3);
insert major_class (major_id, class_id) values (6,3);
insert major_class (major_id, class_id) values (6,4);
insert major_class (major_id, class_id) values (6,5);
insert major_class (major_id, class_id) values (6,6);
insert major_class (major_id, class_id) values (6,7);
insert major_class (major_id, class_id) values (6,8);
insert major_class (major_id, class_id) values (6,9);
insert major_class (major_id, class_id) values (6,10);
insert major_class (major_id, class_id) values (6,11);
insert major_class (major_id, class_id) values (6,12);
insert major_class (major_id, class_id) values (6,13);
insert major_class (major_id, class_id) values (6,14);
insert major_class (major_id, class_id) values (6,15);
insert major_class (major_id, class_id) values (6,16);
insert major_class (major_id, class_id) values (6,17);
insert major_class (major_id, class_id) values (6,18);
insert major_class (major_id, class_id) values (6,19);
insert major_class (major_id, class_id) values (6,20);
insert major_class (major_id, class_id) values (6,27);
insert major_class (major_id, class_id) values (6,28);
insert major_class (major_id, class_id) values (6,29);
insert major_class (major_id, class_id) values (6,30);
insert major_class (major_id, class_id) values (6,31);
insert major_class (major_id, class_id) values (6,32);
insert major_class (major_id, class_id) values (6,33);
insert major_class (major_id, class_id) values (6,34);
insert major_class (major_id, class_id) values (7,1);
insert major_class (major_id, class_id) values (7,2);
insert major_class (major_id, class_id) values (7,3);
insert major_class (major_id, class_id) values (7,18);
insert major_class (major_id, class_id) values (7,33);
insert major_class (major_id, class_id) values (7,34);


select major.name,concat(class.name,class.number)
from major
join major_class
on major.id = major_class.major_id
join class
on class.id = major_class.class_id;

create table student_class(
	id int primary key auto_increment,
	student_id int not null,
	class_id int not null,
	foreign key (student_id)
	  references student(id),
	foreign key (class_id)
	  references class(id)
);


insert student_class (student_id, class_id) values (100,1);
insert student_class (student_id, class_id) values (100,2);
insert student_class (student_id, class_id) values (100,3);
insert student_class (student_id, class_id) values (100,18);
insert student_class (student_id, class_id) values (100,33);
insert student_class (student_id, class_id) values (100,34);
insert student_class (student_id, class_id) values (110,1);
insert student_class (student_id, class_id) values (110,2);
insert student_class (student_id, class_id) values (110,3);
insert student_class (student_id, class_id) values (110,10);
insert student_class (student_id, class_id) values (110,11);
insert student_class (student_id, class_id) values (110,12);
insert student_class (student_id, class_id) values (110,13);
insert student_class (student_id, class_id) values (110,14);
insert student_class (student_id, class_id) values (110,15);
insert student_class (student_id, class_id) values (110,16);
insert student_class (student_id, class_id) values (110,17);
insert student_class (student_id, class_id) values (110,33);
insert student_class (student_id, class_id) values (110,34);
insert student_class (student_id, class_id) values (120,1);
insert student_class (student_id, class_id) values (120,2);
insert student_class (student_id, class_id) values (120,3);
insert student_class (student_id, class_id) values (120,10);
insert student_class (student_id, class_id) values (120,11);
insert student_class (student_id, class_id) values (120,12);
insert student_class (student_id, class_id) values (120,13);
insert student_class (student_id, class_id) values (120,14);
insert student_class (student_id, class_id) values (120,15);
insert student_class (student_id, class_id) values (120,16);
insert student_class (student_id, class_id) values (120,17);
insert student_class (student_id, class_id) values (120,33);
insert student_class (student_id, class_id) values (120,34);
insert student_class (student_id, class_id) values (130,1);
insert student_class (student_id, class_id) values (130,2);
insert student_class (student_id, class_id) values (130,3);
insert student_class (student_id, class_id) values (130,10);
insert student_class (student_id, class_id) values (130,11);
insert student_class (student_id, class_id) values (130,12);
insert student_class (student_id, class_id) values (130,13);
insert student_class (student_id, class_id) values (130,14);
insert student_class (student_id, class_id) values (130,15);
insert student_class (student_id, class_id) values (130,16);
insert student_class (student_id, class_id) values (130,17);
insert student_class (student_id, class_id) values (130,33);
insert student_class (student_id, class_id) values (130,34);
insert student_class (student_id, class_id) values (140,1);
insert student_class (student_id, class_id) values (140,2);
insert student_class (student_id, class_id) values (140,3);
insert student_class (student_id, class_id) values (140,10);
insert student_class (student_id, class_id) values (140,11);
insert student_class (student_id, class_id) values (140,12);
insert student_class (student_id, class_id) values (140,13);
insert student_class (student_id, class_id) values (140,14);
insert student_class (student_id, class_id) values (140,15);
insert student_class (student_id, class_id) values (140,16);
insert student_class (student_id, class_id) values (140,17);
insert student_class (student_id, class_id) values (140,18);
insert student_class (student_id, class_id) values (140,33);
insert student_class (student_id, class_id) values (140,34);
insert student_class (student_id, class_id) values (150,1);
insert student_class (student_id, class_id) values (150,2);
insert student_class (student_id, class_id) values (150,3);
insert student_class (student_id, class_id) values (150,3);
insert student_class (student_id, class_id) values (150,4);
insert student_class (student_id, class_id) values (150,5);
insert student_class (student_id, class_id) values (150,6);
insert student_class (student_id, class_id) values (160,7);
insert student_class (student_id, class_id) values (160,8);
insert student_class (student_id, class_id) values (160,9);
insert student_class (student_id, class_id) values (160,10);
insert student_class (student_id, class_id) values (160,11);
insert student_class (student_id, class_id) values (160,12);
insert student_class (student_id, class_id) values (160,13);
insert student_class (student_id, class_id) values (160,14);
insert student_class (student_id, class_id) values (160,15);
insert student_class (student_id, class_id) values (160,16);
insert student_class (student_id, class_id) values (160,17);
insert student_class (student_id, class_id) values (160,18);
insert student_class (student_id, class_id) values (160,19);
insert student_class (student_id, class_id) values (160,20);
insert student_class (student_id, class_id) values (160,27);
insert student_class (student_id, class_id) values (160,28);
insert student_class (student_id, class_id) values (160,29);
insert student_class (student_id, class_id) values (160,30);
insert student_class (student_id, class_id) values (160,31);
insert student_class (student_id, class_id) values (160,32);
insert student_class (student_id, class_id) values (160,33);
insert student_class (student_id, class_id) values (160,34);
insert student_class (student_id, class_id) values (170,1);
insert student_class (student_id, class_id) values (170,2);
insert student_class (student_id, class_id) values (170,3);
insert student_class (student_id, class_id) values (170,18);
insert student_class (student_id, class_id) values (170,33);
insert student_class (student_id, class_id) values (170,34);
insert student_class (student_id, class_id) values (180,1);
insert student_class (student_id, class_id) values (180,2);
insert student_class (student_id, class_id) values (180,3);
insert student_class (student_id, class_id) values (180,3);
insert student_class (student_id, class_id) values (180,4);
insert student_class (student_id, class_id) values (180,5);
insert student_class (student_id, class_id) values (180,6);
insert student_class (student_id, class_id) values (190,1);
insert student_class (student_id, class_id) values (190,2);
insert student_class (student_id, class_id) values (190,3);
insert student_class (student_id, class_id) values (190,10);
insert student_class (student_id, class_id) values (190,11);
insert student_class (student_id, class_id) values (190,12);
insert student_class (student_id, class_id) values (190,13);
insert student_class (student_id, class_id) values (190,14);
insert student_class (student_id, class_id) values (190,15);
insert student_class (student_id, class_id) values (190,16);
insert student_class (student_id, class_id) values (190,17);
insert student_class (student_id, class_id) values (190,18);
insert student_class (student_id, class_id) values (190,33);
insert student_class (student_id, class_id) values (190,34);

select student.first_name,student.last_name,concat(class.name,class.number)
from student
join student_class
on student.id = student_class.student_id
join class
on class.id = student_class.class_id;



