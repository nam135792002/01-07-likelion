package vn.edu.likelion.bai1.app;

import vn.edu.likelion.bai1.entity.Course;
import vn.edu.likelion.bai1.entity.CourseOnline;
import vn.edu.likelion.bai1.entity.Student;

public class CourseApp {
    public static void main(String[] args) {
        Course course1 = new Course(1, "OOP", "Nguyen Van A", 3);
        CourseOnline course2 = new CourseOnline(2, "OOK", "Nguyen Van B", 2, "App", 80);

        Student student1 = new Student(1, "Nguyen Phuong Nam");
        Student student2 = new Student(2, "Nguyen Phuong Tay");
        Student student3 = new Student(3, "Nguyen Phuong Bac");
        Student student4 = new Student(4, "Nguyen Phuong Dong");

        course1.addStudent(student1);
        course1.addStudent(student2);

        course2.addStudent(student3);
        course2.addStudent(student4);

        System.out.println("--------------------------------------------------------------------");

        course1.displayDetailCourse();
        course2.displayDetailCourse();

        System.out.println("--------------------------------------------------------------------");

        course1.displayStudent();
        course2.displayStudent();
    }
}
