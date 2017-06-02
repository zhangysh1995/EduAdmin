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

    static void remove(int studentNo) {

    }

    public static boolean validate(String username, String password) {
        String sql="select * from student where username='" + username + "' and password='" + password + "';";
//        jdbcTemplate.query(sql, handler);
        System.out.println("username: " + username + " password: " + password);

        List<String> strLst  = jdbcTemplate.query(sql,new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                System.out.println("No. of rows: "+rowNum);
                return rs.getString(1);
            }
        });

        return strLst.size() > 0;
    }

}

//jdbcTemplate.query(
//        "SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
//        new Object[] { "Josh" },
//        (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
//        ).forEach(customer -> log.info(customer.toString()));