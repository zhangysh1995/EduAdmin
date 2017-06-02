package database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import roles.impl.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by KellyZhang on 2017/6/1.
 */
public class StudentManager {
    private static JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void add(Student s) {
        String sql="insert into student values( '" + s.getUsername() + "','" + s.getName()
                        + "','" + s.getName() + "','" + s.getStudentNo() + "','" + s.getDept() + " ')";

        jdbcTemplate.update(sql);
        System.out.println("Add new student");
    }

    static void remove(int studentNo) {

    }

    public static Student validate(String username, String password) {
        String sql="select * from student where username='" + username + "' and password='" + password + "';";
//        jdbcTemplate.query(sql, handler);
        System.out.println("username: " + username + " password: " + password);

        Student student  = (Student)jdbcTemplate.queryForObject(sql,new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setName(rs.getString("name"));
                student.setStudentNo(rs.getInt("studentNo"));
                student.setDept(rs.getInt("deptNo"));
                return student;
            }
        });

        return student;
    }

}