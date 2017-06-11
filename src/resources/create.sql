create database spring;

Use spring;

CREATE TABLE `dept` (
` deptName` varchar(30) NOT NULL,
` deptNo` varchar(1) NOT NULL PRIMARY KEY 
);

CREATE TABLE `student` (
  `username` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `studentNo` char(8) NOT NULL,
  `deptNo` varchar(1) NOT NULL  References dept.deptNo,
  PRIMARY KEY (`studentNo`)
) ;

CREATE TABLE `teacher` (
  `username` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `teacherNo` char(8) NOT NULL,
  `deptNo` varchar(1) NOT NULL  References dept.deptNo,
  PRIMARY KEY (`teacherNo`)
) ;

create table `course` (
`courseNo` varchar(5) not null,
`courseName` varchar(50) not null,
primary key(`courseNo`)			
);

create table `score` (
`studentNo` char(8) NOT NULL references student.studentNo,
`courseNo`	 varchar(5) NOT NULL references course.courseNo,
`score` varchar(3),
primary key(`studentNo`, `courseNo`)
);

insert into course values('CS304','Software Engineering');
insert into course values('CS101','Introduction to Computer Science');
insert into course values('CS306','Cloud Computing');

insert into score values('11310000', 'CS304','99');
insert into score values('11310000', 'CS101','97');
insert into score values('11310000', 'CS306','99');
insert into score values('11310001', 'CS304','99');
insert into score values('11310001', 'CS101','97');
insert into score values('11310001', 'CS306','99');
insert into score values('11310002', 'CS304','99');
insert into score values('11310002', 'CS101','97');
insert into score values('11310002', 'CS306','99');