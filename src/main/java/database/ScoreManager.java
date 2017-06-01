package database;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by KellyZhang on 2017/6/1.
 */
public class ScoreManager {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
