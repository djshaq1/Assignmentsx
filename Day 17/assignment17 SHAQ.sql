drop table if exists student_class;
drop table if exists major_class;
drop table if exists class;
drop table if exists instructor;
drop table if exists major;


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

create table major_class(
	id int primary key auto_increment,
	major_id int not null,
	class_id int not null,
	assignment_id int not null,
	foreign key (major_id)
	  references major(id),
	foreign key (class_id)
	  references class(id),
	foreign key (assignment_id)
	  references assignment(id)
);
create table student_class(
	id int primary key auto_increment,
	student_id int not null,
	class_id int not null,
	foreign key (student_id)
	  references student(id),
	foreign key (class_id)
	  references class(id)
);
