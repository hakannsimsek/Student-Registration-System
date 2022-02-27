package model;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class Course extends Lecture{

    private int semestr;
    private LinkedList<Student> registeredStudents;


    public Course(String name, String code, Teacher lecturer, int credit, int ects, Lecture prerequisite, int semester, String schedule,String grade) {
        super(name,code,lecturer,credit,ects,prerequisite, schedule);
        super.setGrade(grade);
        this.semestr = semester;
        registeredStudents = new LinkedList<>();
    }

    public int getRegisteredStudentsCount() {
        if(this.registeredStudents == null) return 0;
        return this.registeredStudents.size();
    }

    public boolean register ( Student student ) {
        LinkedList<Lecture> courseList = student.getCoursesTaken();
        List<String> days;
        List<String> time;
        String schedule;
        boolean overlaps = true;

        schedule = this.getSchedule();
        if (!schedule.equals("")) {
            days = parseDays(schedule);
            time = parseTime(schedule);
            out:
            for (Lecture lecture : courseList) {
                String schedule1 = lecture.getSchedule();
                List<String> days1 = parseDays(schedule1);
                List<String> time1 = parseTime(schedule1);

                for (int m = 0; m < days1.size() && m < days.size(); m++) {
                    if (days.get(m).equals(days1.get(m))) {
                        if (isOverlapping(LocalTime.parse(time.get(2 * m)), LocalTime.parse(time.get(2 * m + 1)),
                                LocalTime.parse(time1.get(2 * m)), LocalTime.parse(time1.get(2 * m + 1)))) {
                            System.out.println("Advisor didn't approve " + this.getName() + " because of a collision with " + lecture.getName() + " in schedule");
                            student.transcriptRelatedInformations += "Could not registered to " + this.getName() + " because of a collision\n";
                            overlaps = false;
                            break out;
                        }
                    }
                }
            }
        }

        if(!overlaps){
            return false;
        }
        else if( this.getName().startsWith("Engineering Project") && student.totalCreditCompleted < 165 ){
            System.out.println("Cannot registered. Total credit completed : " + student.totalCreditCompleted + " should be at least 165" );
            student.transcriptRelatedInformations += "Could not registered to " + this.getName() + " total credit completed less than 165\n";
            return false;
        }

        registeredStudents.add(student);
        student.addToCoursesTaken(this);
        return true;

    }

    public boolean isOverlapping(LocalTime startTime, LocalTime endTime, LocalTime startTime2, LocalTime endTime2) {
        return startTime.isBefore(endTime2) && startTime2.isBefore(endTime);
    }

    public int getSemestr() {
        return semestr;
    }

}
