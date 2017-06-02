package database;

import org.springframework.jdbc.core.JdbcTemplate;
import roles.impl.Teacher;

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

    static boolean validate(String username, String password) {

        return true;
    }
}
