package roles.impl;

import roles.Person;

/**
 * Created by KellyZhang on 2017/5/31.
 */
public class Student implements Person {
    int studentNo;
    int dept;
    String name;

    public Student(int studentNo, int dept, String name) {
        this.studentNo = studentNo;
        this.dept = dept;
        this.name = name;
    }

    @Override
    public String getRole() {
        return "student";
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
