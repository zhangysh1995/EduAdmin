package database;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import roles.impl.Teacher;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by KellyZhang on 2017/6/1.
 */
public class TeacherManager {
    // auto-generated stub
    private static JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void add(Teacher t) {
        String sql="insert into teacher values( '" + t.getUsername() + "','" + t.getName()
                + "','" + t.getName() + "','" + t.getTeacherNo() + "','" + t.getDept() + " ')";

        jdbcTemplate.update(sql);
        System.out.println("Add new teacher");
    }

    public static void update(Teacher s) {
        String sql="update teacher set password='" + s.getPassword() + "' where teacherNo='" + s.getTeacherNo() +"';";
        jdbcTemplate.update(sql);
        System.out.println("teacher info changed");
    }

    public static boolean validate(String username, String password) {
        String sql="select * from teacher where username='" + username + "' and password='" + password + "';";

        List<String> strLst  = jdbcTemplate.query(sql,new RowMapper() {
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString(1);
                    }
                }
        );

        return strLst.size() > 0;
    }

    public static Teacher fetch(String username, String password) {
        String sql="select * from teacher where username='" + username + "' and password='" + password + "';";

        Teacher teacher  = (Teacher)jdbcTemplate.queryForObject(sql,new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Teacher teacher = new Teacher();
                teacher.setUsername(rs.getString("username"));
                teacher.setPassword(rs.getString("password"));
                teacher.setName(rs.getString("name"));
                teacher.setTeacherNo(rs.getInt("teacherNo"));
                teacher.setDept(rs.getInt("deptNo"));
                return teacher;
            }
        });
        return teacher;
    }

}