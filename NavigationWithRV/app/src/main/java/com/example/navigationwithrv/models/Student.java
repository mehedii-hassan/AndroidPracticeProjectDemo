package com.example.navigationwithrv.models;

import java.util.ArrayList;
import java.util.List;

public class Student {

    public static final String SEIP="SEIP";
    public static final String PAID="PAID";
    private String  name;
    private String courseType;
    private String courseName;

    public Student(String name, String courseType, String courseName) {
        this.name = name;
        this.courseType = courseType;
        this.courseName = courseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public static List<String> paidCourseList = new ArrayList<>();
    public static List<String> seipCourseList = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

    static {
        paidCourseList.add("Mastering Flutter on Android and IOS");
        paidCourseList.add("Professional Android app development with java");
        paidCourseList.add("Professional Android app development with kotlin");
        paidCourseList.add("Web development using laravel and vue");
        paidCourseList.add("Graphics Design");
        seipCourseList.add("Mobile application development android");
        seipCourseList.add("Graphics & UI design");
        seipCourseList.add("Dot net Framework");
    }
}
