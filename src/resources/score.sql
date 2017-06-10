use spring;

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