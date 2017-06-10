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