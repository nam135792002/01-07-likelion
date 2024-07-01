package vn.edu.likelion.bai1.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    protected int courseId;
    protected String courseName;
    protected String mentorName;
    protected int credit;

    private List<Student> listStudent = new ArrayList<>();

    public Course(int courseId, String courseName, String mentorName, int credit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.mentorName = mentorName;
        this.credit = credit;
    }

    public void addStudent(Student student){
        this.listStudent.add(student);
    }

    public void displayDetailCourse(){
        System.out.println(this);
    }

    public void displayStudent(){
        System.out.println("Course Name: " + this.courseName);
        for (Student student : this.listStudent){
            System.out.println(student.toString());
        }
        System.out.println("--------------------------------------------");
    }

    @Override
    public String toString() {
        return "Course id: " + this.courseId + ", Name: " + this.courseName + ", Mentor: " + this.mentorName +
                ", Credit: " + this.credit;
    }
}
