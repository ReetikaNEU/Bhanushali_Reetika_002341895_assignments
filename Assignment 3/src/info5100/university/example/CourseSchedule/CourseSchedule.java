/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info5100.university.example.CourseSchedule;

import info5100.university.example.CourseCatalog.Course;
import info5100.university.example.CourseCatalog.CourseCatalog;
import info5100.university.example.Department.Department;
import info5100.university.example.Persona.StudentDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    CourseCatalog coursecatalog;

    ArrayList<CourseOffer> schedule;
    String semester;
    private Department department;
    private CourseCatalog courseCatalog; 
    private StudentDirectory studentDirectory;

    public CourseSchedule(String s, CourseCatalog cc) {
        semester = s;
        coursecatalog = cc;
        schedule = new ArrayList();
        this.department = department;
        this.courseCatalog = courseCatalog;
        this.studentDirectory = new StudentDirectory(department);

    }
     public StudentDirectory getStudentDirectory() {
        return studentDirectory;
    }

    public CourseOffer newCourseOffer(String  n) {

        Course c = coursecatalog.getCourseByNumber(n);
        if(c==null) return null;
        CourseOffer co;
        co = new CourseOffer(c);
        schedule.add(co);
        return co;
    }

    public CourseOffer getCourseOfferByNumber(String n) {

        for (CourseOffer co : schedule) {

            if (co.getCourseNumber().equals(n)) {
                return co;
            }
        }
        return null;
    }

    public int calculateTotalRevenues() {
        int sum = 0;
        for (CourseOffer co : schedule) {

            sum = sum + co.getTotalCourseRevenues();

        }
        return sum;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
     public ArrayList<CourseOffer> getCourseOffers() {
        return schedule;
    }
     
     public Department getDepartment() {
        return department;
    }

    public CourseCatalog getCoursecatalog() {
        return coursecatalog;
    }

    public void setCoursecatalog(CourseCatalog coursecatalog) {
        this.coursecatalog = coursecatalog;
    }
     
    public void generateCourseOffers(CourseCatalog courseCatalog) {
        List<Course> predefinedCourses = courseCatalog.getCourseList();
        for (Course course : predefinedCourses) {
            CourseOffer courseOffer = newCourseOffer(course.getCOurseNumber());
            if (courseOffer != null) {
                courseOffer.generatSeats(10); // Assuming 10 seats for each course offer
            }
        }
    }

}
