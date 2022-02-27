package model;

import java.util.LinkedList;
import java.util.Scanner;

public class TechnicalElective extends Lecture{

    private int quota;



    private LinkedList<Student> couldNotRegisteredQuotaProblem;


    public TechnicalElective(String name, String code, Teacher lecturer, int credit, int quota, Lecture prerequisite,String schedule,String grade) {
        super(name, code, lecturer,credit,credit,prerequisite,schedule);
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



    public boolean register (Student student,boolean isSpring,LinkedList<TechnicalElective>[] technicalList) {
        if (student.totalCreditCompleted < 155 ){
            System.out.println("Cannot registered. Total credit completed : " + student.totalCreditCompleted + " should be at least 155" );
            student.transcriptRelatedInformations += "Could not registered to " + this.getName() + " Total credit completed is less than 155\n";
            return false;
        }
        //check if more than 2 or 3
        int numberOfTE = numberOfTE(student);
        if(!isSpring){//fall
            if (numberOfTE < 2){
                System.out.println("Cannot register TE course. In this semester max TE can be taken is 2");
                student.transcriptRelatedInformations += "Could not registered to " + this.getName() + " In this semester max TE can be taken is 2\n";
                return false;
            }

        }else{//spring
            if (numberOfTE < 3){
                System.out.println("Cannot register TE course. In this semester max TE can be taken is 3");
                student.transcriptRelatedInformations += "Could not registered to " + this.getName() + " In this semester max TE can be taken is 3\n";
                return false;
            }
        }

        TechnicalElective selectedTECourse;
        if(isSpring) {
            selectedTECourse = selectTECourse(student,technicalList[1]);
        } else {
            selectedTECourse = selectTECourse(student,technicalList[0]);
        }

        if (selectedTECourse.quota < getRegisteredStudentsCount() ){
            System.out.println("Cannot registered because quota is full");
            student.transcriptRelatedInformations += "Could not registered to " + this.getName() + " quota is full\n";
            couldNotRegisteredQuotaProblem.add(student);
            return false;
        }else if(student.totalCreditCompleted < 155){
            System.out.println("Cannot registered. Total credit completed : " + student.totalCreditCompleted + " should be at least 155" );
            student.transcriptRelatedInformations += "Could not registered to " + this.getName() + " Total credit completed is less than 155\n";
            return false;
        }

        selectedTECourse.registeredStudents.add(student);
        student.addToCoursesTaken(selectedTECourse);
        return true;
    }

    private int numberOfTE (Student student) {
        int numberOfTE = 0;
        for (int i  = 0 ; i < student.getCoursesTaken().size() ; i++ ){
            if(student.getCoursesTaken().get(i) instanceof TechnicalElective)
                numberOfTE++;
        }
        return numberOfTE;
    }


    TechnicalElective selectTECourse (Student student,LinkedList<TechnicalElective> technicalList) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0 ; i < technicalList.size() ; i++ ) {
            System.out.println("\t Course name press(" + i + ") : " + technicalList.get(i).getName());
        }
        int enteredIndex;

        do{
            System.out.print("Enter number to take course ");
            enteredIndex = scanner.nextInt();
            if(enteredIndex<0 | enteredIndex>technicalList.size()){
                System.out.print("Please enter a valid number!\n");
                continue;
            }
//            if(enteredIndex==-1){
//                return new TechnicalElective("Could not selected","NTE0000",new Teacher("Computer Enginnering","null",0),0,0,null, "null");
//            }
            if(checkIfTaken(student,technicalList.get(enteredIndex))) break;

        }while (true);

        return technicalList.get(enteredIndex);

    }


    public boolean checkIfTaken (Student student, TechnicalElective teCourse) {
        for(int i = 0; i < student.getTranscript().length ; i++ ){
            for(int j = 0; j < student.getTranscript()[i].size() ; j++ ) {
                if(student.getTranscript()[i].get(j).getName().equals(teCourse.getName()) ) {
                    //System.out.println("This course taken before, please select again.");
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
