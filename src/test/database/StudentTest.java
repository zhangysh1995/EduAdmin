package database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import roles.impl.Student;

/**
 * Created by KellyZhang on 2017/6/1.
 */
public class StudentTest {
    // auto-generated stub

    public static void main(String [] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("~/");

        StudentManager sm = (StudentManager) ctx.getBean("studentDAO");

        Student student = new Student();
        student.setUsername("zhangysh1995");
        student.setPassword("123456");
        student.setName("zhang yushan");
        student.setStudentNo(11310380);
        student.setDept(0);

        sm.add(student);
    }
}
