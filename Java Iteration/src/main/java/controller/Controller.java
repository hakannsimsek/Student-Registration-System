package controller;

import model.*;

import java.util.LinkedList;

public class Controller {

    private static Controller controllerInstance = new Controller();

    private Controller(){}

    public static Controller controllerGetInstance(){
        return controllerInstance;
    }
    //getCourses



    public void getRegisteredCourses(Student student){
        student.printCoursesTaken(student);
    }

    public void getTotalCreditCompleted(Student student){
        System.out.println("Total credit completed: " + student.getTotalCreditCompleted());
    }

    public void registerCourse(Student student, LinkedList<Lecture>[] courseList, String semesterInput,LinkedList<NonTechnicalElective> nonTechnicalList,LinkedList<TechnicalElective>[] technicalList){
        student.seeCourses(courseList, semesterInput, nonTechnicalList, technicalList);
        student.writeAfterTranscriptJson();

    }

    public void getTranscriptInfo(Student student){
        student.printTranscipt();
    }

    //getCourseSchedule
    //public void getCourseSchedule
    //registerCourse
    //getStudentSchedule
    //getTranscript


}
