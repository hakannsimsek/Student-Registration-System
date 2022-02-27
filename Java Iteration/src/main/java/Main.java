import course.CourseJSONReader;
import course.CourseJSONWriter;
import model.*;
import student.StudentJSONReader;
import student.StudentJSONWriter;
import teacher.TeacherJSONReader;
import teacher.TeacherJSONWriter;

import java.util.LinkedList;
import java.util.Scanner;

import controller.*;



public class Main {
    public static void main(String[] args) {

        String semesterInput = new input.InputReader().takeSemesterInput();
        System.out.println(semesterInput);

        Controller controller = Controller.controllerGetInstance();

        LinkedList<Student> studentList;
        LinkedList<Lecture>[] courseList;
        LinkedList<Teacher> teacherList;
        LinkedList<NonTechnicalElective> nonTechnicalList;
        LinkedList<TechnicalElective>[] technicalList;

        teacherList = new LinkedList<>();
        studentList = new LinkedList<>();
        nonTechnicalList = new LinkedList<>();
        technicalList = new LinkedList[2];
        technicalList[0] = new LinkedList<>();
        technicalList[1] = new LinkedList<>();


        courseList = new LinkedList[8];
        for (int i = 0 ; i < 8 ; i++){
            courseList[i] = new LinkedList<>();
        }


        TeacherJSONWriter teacherJSONWriter = new TeacherJSONWriter();
        teacherJSONWriter.writeJson();
        TeacherJSONReader teacherJSONReader = new TeacherJSONReader();
        teacherJSONReader.readJson(teacherList);


        CourseJSONWriter courseJSONWriter = new CourseJSONWriter();
        courseJSONWriter.writeJSON();
        CourseJSONReader courseJSONReader = new CourseJSONReader();
        courseJSONReader.readJson(courseList,teacherList,nonTechnicalList,technicalList,semesterInput);


        StudentJSONWriter studentJSONWriter = new StudentJSONWriter();
        studentJSONWriter.writeJson();
        StudentJSONReader studentJSONReader = new StudentJSONReader();
        studentJSONReader.readJson(studentList,courseList,teacherList,semesterInput);

        Student student;
        for (int i = 0 ; i < studentList.size() ; i++ ) {
            student = studentList.get(i);
            student.modifyTranscript(courseList,nonTechnicalList,technicalList,semesterInput);
            student.writeBeforeTranscriptJson();
            student.generateCoursesCanBeTakenThisSemester(semesterInput, courseList);

        }
        Scanner scanner = new Scanner(System.in);
        int selection = 1;
        Student tempSt = null;

        boolean wantToRegister = true;
        while(wantToRegister){

            String id = "";
            do {
                System.out.println("Enter your id: ");
                id = scanner.nextLine();
                boolean isFound = false;
                for (int i = 0; i < studentList.size(); i++) {
                    if (id.equals(studentList.get(i).getId())) {
                        tempSt = studentList.get(i);
                        isFound = true;
                    }
                }
                if(!isFound){
                    System.out.println("No such id try again.");
                    continue;
                }
                else{
                    break;
                }
            }while(true);

            do {

                System.out.println("============================================================="
                        + "==========================================\n"
                        + tempSt.toString()
                        + "\n============================================================="
                        + "=========================================="
                        + "\n1. Courses taken:(1)\n" + "2. Total credit completed:(2)\n"
                        + "3. Get transcript info:(3)\n" + "4. Register a course:(4)\n" + "5. Exit:(5)\n"
                        + "============================================================="
                        + "==========================================\n");
                selection = scanner.nextInt();
                switch(selection){
                    case 1:{
                        controller.getRegisteredCourses(tempSt);
                        break;
                    }
                    case 2:{
                        controller.getTotalCreditCompleted(tempSt);
                        break;
                    }
                    case 3:{
                        controller.getTranscriptInfo(tempSt);
                        break;
                    }
                    case 4:{
                        controller.registerCourse(tempSt, courseList, semesterInput, nonTechnicalList, technicalList);
                        break;
                    }
                    case 5:{
                        break;
                    }
                }
                System.out.println();
            } while(selection != 5);

            String isExit = scanner.nextLine();
            System.out.println("============================================================="
                    + "==========================================\n"
                    + "\n1. Do you want to register :(1)\n" + "2. Exit:(2)\n"
                    + "============================================================="
                    + "==========================================\n");
            if( isExit.equals(2) ){
                wantToRegister=false;
            }

        }

        /*for (int i = 0 ; i < courseList.length ; i++ ) {
            for (int j = 0 ; j < courseList[i].size() ; j++ ) {
                Lecture lecture = courseList[i].get(j);
                if( lecture instanceof NonTechnicalElective ){
                    System.out.println("Lecture name : " + lecture.getName() +  " number of registered students : " +
                            ((NonTechnicalElective)lecture).getRegisteredStudentsCount());
                } else if ( lecture instanceof TechnicalElective ) {
                    System.out.println("Lecture name : " + lecture.getName() +  " number of registered students : " +
                            ((TechnicalElective)lecture).getRegisteredStudentsCount());
                } else {
                    System.out.println("Lecture name : " + lecture.getName() +  " number of registered students : " +
                            ((Course)lecture).getRegisteredStudentsCount());
                }
            }
        }*/

        int isFall;
        if(semesterInput.equalsIgnoreCase("fall")) isFall=0;
        else isFall=1;
        new Department().writeDepartmentOutput(nonTechnicalList,technicalList,isFall);




    }


}
