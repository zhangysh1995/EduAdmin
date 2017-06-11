package objects;

/**
 * Created by zhanysh1995 on 17/5/31.
 */
public class Score {
    String courseNo;
    String score;
    String studentNo;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    @Override
    public String toString() {
        return "CourseNo is " + this.getCourseNo() + " Score is " + this.getScore();
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
