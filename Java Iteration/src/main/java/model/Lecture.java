package model;

//import sun.plugin.javascript.navig.Array;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class Lecture {
    private String name;
    private String code;
    private Teacher lecturer;
    private int credit;
    private int ECTS;
    private boolean passed;
    private Lecture prerequisite;
    protected LinkedList<Student> registeredStudents;
    private String schedule;
    private String grade;



    public Lecture(String name, String code, Teacher lecturer, int credit, int ECTS, Lecture prerequisite,String schedule) {
        this.name = name;
        this.code = code;
        this.lecturer = lecturer;
        this.credit = credit;
        this.ECTS = ECTS;
        this.prerequisite = prerequisite;
        registeredStudents = new LinkedList<>();
        this.schedule = schedule;
    }

    @Override
    public String toString(){
        return "[Code:" + this.getCode() + " Name:" + this.getName() + " Lecturer:" +
                this.lecturer.getName() + " Credit:" + this.getCredit();
    }

    public int getCredit() {
        return credit;
    }

    public int getECTS() {
        return ECTS;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Lecture getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Lecture prerequisite) {
        this.prerequisite = prerequisite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public Teacher getLecturer() {
        return lecturer;
    }

    public String getSchedule() {
        return schedule;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<String> parseDays(String schedule){
        List<String> days= new ArrayList<String>();
        List<String> tokens = Arrays.asList(schedule.split(" "));

        for (int i=0; i<tokens.size() ;i+=2){
            days.add(tokens.get(i));
        }

        return days;
    }

    public List<String> parseTime(String schedule){
        List<String> time= new ArrayList<String>();
        List<String> tokens = Arrays.asList(schedule.split(" "));
        List<String> time1= new ArrayList<String>();

        for (int i=1; i<tokens.size() ;i+=2){
            time.add(tokens.get(i));
        }

        for (String s : time) {
            tokens = Arrays.asList(s.split("-"));

            for (String token : tokens) {
                time1.add(token);
            }
        }
        return time1;
    }
}
