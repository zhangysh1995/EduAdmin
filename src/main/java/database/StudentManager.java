package database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import roles.impl.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public static void update(Student s) {
        String sql="update student set password='" + s.getPassword() + "' where studentNo='" + s.getStudentNo() +"';";
        jdbcTemplate.update(sql);
        System.out.println("student info changed");
    }

    public static boolean validate(String username, String password) {
        String sql="select * from student where username='" + username + "' and password='" + password + "';";

        List<String> strLst  = jdbcTemplate.query(sql,new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        }
        );

        return strLst.size() > 0;
    }

    public static Student fetch(String username, String password) {
        String sql="select * from student where username='" + username + "' and password='" + password + "';";

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