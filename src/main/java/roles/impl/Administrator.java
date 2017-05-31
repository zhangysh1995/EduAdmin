package roles.impl;

import roles.Person;

/**
 * Created by KellyZhang on 2017/5/31.
 */
public class Administrator implements Person {
    int adminNo;
    int dept;
    String name;

    public Administrator(int adminNo, int dept, String name) {
        this.adminNo = adminNo;
        this.dept = dept;
        this.name = name;
    }

    @Override
    public String getRole() {
        return "admin";
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
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
