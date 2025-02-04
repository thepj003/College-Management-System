create database universitymanagement;
use universitymanagement;


create table login(username varchar(30),
password varchar(30));
insert into login values('pranay', 'abcd123');
insert into login values('student1', 'muj123'),
                        ('student2', 'muj123'),
                        ('student3', 'muj123'),
                        ('student4', 'muj123'),
                        ('student5', 'muj123');
select * from login;

create table teacher (
Tname varchar(50), Fname varchar(50), 
empID varchar(50), dob varchar(50), 
address varchar(50), phone varchar(50), 
email varchar(50), cl_x varchar(50), 
cl_xii varchar(50), aadhar varchar(50), 
edu varchar(50), dep_id varchar(50),
primary key(empID),
foreign key (dep_id) references department(dep_id)
);


create table student (
Sname varchar(50), Fname varchar(50), 
roll varchar(50), dob varchar(50), 
address varchar(50), phone varchar(50), 
email varchar(50), cl_x varchar(50), 
cl_xii varchar(50), aadhar varchar(50), 
course varchar(50), dep_id varchar(50),
primary key(roll),
foreign key (dep_id) references department(dep_id) 
);


create table department(
dep_name varchar(50),
dep_id varchar(50),
school_id varchar(50),
primary key (dep_id),
foreign key (school_id) references school(school_id)
 );
 
 
insert into department values ('Computer and Communication Engineering', 'CCE'),
							   ('Computer Science Engineering', 'CSE'),
                               ('Electrical and Electronics Engineering', 'EEC'),
                               ('Mechanical Engineering', 'ME'),
                               ('Internet Of Things', 'IOT'),
                               ('Artificial Intelligence and Machine Learning', 'AIML'),
                               ('Civil Engineering', 'CE'),
                               ('Information Technology', 'IT'),
                               ('Data Science', 'DS');
create table school (
school_name varchar(250) not null,
school_id varchar(50) ,
primary key(school_id)
 );
insert into school values ('School of Computer and Communication Engineering', 'SCCE'),
						   ('School of Computer Science Engineering', 'SCSE'),
                           ('School of Mechanical Engineering', 'SME'),
                           ('School of Civil Engineering', 'SCE'),
                           ('School of Electronics Engineering', 'SEE'),
                           ('School of Information Technology', 'SIT');
alter table teacher add column dep_id varchar(50);
alter table teacher drop column dep_name;
update teacher set dep_ID ='CSE' where empID = 229308149;
update teacher set dep_ID ='CCE' where empID = 229304925;
select * from teacher;
select * from student;
select * from department;
select * from school;

alter table student add column dep_id varchar(50);
alter table student drop column branch;

alter table student add constraint primary key(roll);

alter table department add column school_id varchar(50);
update department set school_id = 'SCCE' where dep_id = 'CCE';
update department set school_id = 'SCSE' where dep_id = 'CSE';
update department set school_id = 'SEE' where dep_id = 'EEC';
update department set school_id = 'SME' where dep_id = 'ME';
update department set school_id = 'SCCE' where dep_id = 'IOT';
update department set school_id = 'SCSE' where dep_id = 'AIML';
update department set school_id = 'SCE' where dep_id = 'CE';
update department set school_id = 'SIT' where dep_id = 'IT';
update department set school_id = 'SIT' where dep_id = 'DS';

update student set dep_ID ='IOT' where roll = 149309261;

create table subject(
roll varchar(50),
sem varchar(50),
sub1 varchar(50),
sub2 varchar(50),
sub3 varchar(50),
sub4 varchar(50),
sub5 varchar(50)
);

select * from subject;

create table marks(
roll varchar(50),
sem varchar(50),
mark1 varchar(50),
mark2 varchar(50),
mark3 varchar(50),
mark4 varchar(50),
mark5 varchar(50)
);

select * from marks;

create table fee(course varchar(20), semester1 varchar(20), semester2 varchar(20), semester3 varchar(20), semester4 varchar(20), semester5 varchar(20), semester6 varchar(20), semester7 varchar(20), semester8 varchar(20));


insert into fee values("BTech", "49000", "43000","43000","43000","43000","43000","43000","43000");


insert into fee values("MTech", "70000", "60000","60000","60000","60000","60000","","");

insert into fee values("Ph.D", "44000", "45000","45000","45000","45000","45000","","");

select * from fee;

create table feecollege(
roll varchar(50),
course varchar(50),
branch varchar(50),
sem varchar(20),
total varchar(20)
);

select * from feecollege;
