package roles.impl;

import roles.Person;

/**
 * Created by KellyZhang on 2017/5/31.
 */
public class Teacher implements Person {
    // auto-generated stub
    int teacherNo;
    int dept;
    String name;

    public Teacher(int teacherNo, int dept, String name) {
        this.teacherNo = teacherNo;
        this.dept = dept;
        this.name = name;
    }

    @Override
    public String getRole() {
        return "teacher";
    }

    public int getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(int teacherNo) {
        this.teacherNo = teacherNo;
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
