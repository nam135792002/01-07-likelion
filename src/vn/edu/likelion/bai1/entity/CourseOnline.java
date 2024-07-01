package vn.edu.likelion.bai1.entity;

import java.util.ArrayList;
import java.util.List;

public class CourseOnline extends Course{
    private String platform;
    private int time;

    public CourseOnline(int courseId, String courseName, String mentorName, int credit, String platform, int time) {
        super(courseId, courseName, mentorName, credit);
        this.platform = platform;
        this.time = time;
    }

    @Override
    public void displayDetailCourse() {
        super.displayDetailCourse();
    }

    @Override
    public String toString() {
        return super.toString() + ", Platform: " + this.platform + ", Time: " + time + " hours";
    }
}
