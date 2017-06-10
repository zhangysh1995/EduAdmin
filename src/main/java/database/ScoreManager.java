package database;

import objects.Score;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by KellyZhang on 2017/6/1.
 */
public class ScoreManager {
    private static JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void add(String studentNo) {
//        String sql="insert into scores values( '" + " ')";
//
//        jdbcTemplate.update(sql);
//        System.out.println("Add new student");
    }

    public static Score[] fetchScore(String studentNo) throws NullPointerException {
        Score myScores[];
            String sql = "select * from score where studentNo='" + studentNo + "';";

            List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

            System.out.println("Get results: " + results.size());
            myScores = new Score[results.size()];

            for (int i = 0; i < results.size() - 1; i++) {
                Score score = new Score();
                score.setCourseNo((String) results.get(i).get("courseNo"));
//            score.setCourseName((String)results.get(i).get("courseName"));
                score.setScore((String) results.get(i).get("score"));

                myScores[i] = score;
                System.out.println(score);
            }

        return myScores;
    }

}
