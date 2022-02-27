package model;

import java.util.LinkedList;
import java.util.Scanner;

public class NonTechnicalElective extends Lecture{

    private int quota;
    private LinkedList<Student> couldNotRegisteredQuotaProblem;

    public NonTechnicalElective(String name, String code, Teacher lecturer,int credit,int quota, String schedule,String grade) {
        super(name, code, lecturer,credit,credit,null, schedule);
        super.setGrade(grade);
        this.quota = quota;
        couldNotRegisteredQuotaProblem = new LinkedList<>();
    }

    public int getQuota() {
        return quota;
    }

    public int getRegisteredStudentsCount() {
        if(this.registeredStudents == null) return 0;
        return this.registeredStudents.size();
    }

    public boolean register ( Student student,LinkedList<NonTechnicalElective> nonTechnicalList ) {

        NonTechnicalElective selectedNTECourse = selectNTECourse(student,nonTechnicalList);

        //quota
        if ( selectedNTECourse.quota < this.registeredStudents.size() ){
            System.out.println("Cannot registered because quota is full");
            student.transcriptRelatedInformations += "Could not registered to " + this.getName() + " quota is full\n";
            couldNotRegisteredQuotaProblem.add(student);
            return false;
        }

        selectedNTECourse.registeredStudents.add(student);
        student.addToCoursesTaken(selectedNTECourse);
        return true;
    }

    NonTechnicalElective selectNTECourse (Student student,LinkedList<NonTechnicalElective> nonTechnicalList) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0 ; i < nonTechnicalList.size() ; i++ ) {
            System.out.println("\t Course name press(" + i + ") : " + nonTechnicalList.get(i).getName());
        }
        int enteredIndex;
        do{
            System.out.print("Enter number to take course");
            enteredIndex = scanner.nextInt();

            if(enteredIndex<0 | enteredIndex>nonTechnicalList.size()){
                System.out.print("Please enter a valid number!\n");
                continue;
            }

            if(checkIfTaken(student,nonTechnicalList.get(enteredIndex))) break;

        }while (true);

        return nonTechnicalList.get(enteredIndex);

    }

    public boolean checkIfTaken (Student student, NonTechnicalElective nteCourse) {
        for(int i = 0; i < student.getTranscript().length ; i++ ){
            for(int j = 0; j < student.getTranscript()[i].size() ; j++ ) {
                if(student.getTranscript()[i].get(j).getName().equals(nteCourse.getName()) ) {
                    //System.out.println("This course taken before, please select again.");
                    if(student.getTranscript()[i].get(j).isPassed()==false) return true;
                    return false;
                }
            }
        }

        return true;
    }

    public LinkedList<Student> getCouldNotRegisteredQuotaProblem() {
        return couldNotRegisteredQuotaProblem;
    }



}
