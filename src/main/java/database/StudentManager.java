package database;

import org.springframework.jdbc.core.JdbcTemplate;
import roles.impl.Student;

/**
 * Created by KellyZhang on 2017/6/1.
 */
public class StudentManager {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void add(Student s) {
        String query="insert into student values( '" + s.getUsername() + "','" + s.getName()
                        + "','" + s.getName() + "','" + s.getStudentNo() + "','" + s.getDept() + " ')";
        System.out.println("Add new student");
    }

    static void remove(int studentNo) {

    }

    static void validate(String username, String password) {

    }
}
