package roles.impl;

import roles.Person;

/**
 * Created by KellyZhang on 2017/5/31.
 */
public class Teacher implements Person {
    // auto-generated stub
    String username;
    String password;
    String name;
    int teacherNo;
    int dept;
;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
