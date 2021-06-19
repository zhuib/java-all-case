package course;

/**
 * Date: 2021/4/7 14:55
 */
public class Geely {
    public static void main(String[] args) {
        Course course;
        System.out.println("Geely 正在学习的课程有：");
        course = new JavaCourse();
        course.study();
        course = new FECourse();
        course.study();

    }
}
