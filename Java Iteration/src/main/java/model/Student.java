package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Student extends Person{

    private Teacher advisor;
    private int semester;
    private LinkedList<Lecture> coursesTaken;
    private LinkedList<Lecture>[] transcript;
    private LinkedList<Lecture> courseFailed;
    private LinkedList<Lecture> coursesCouldNotTaken;
    private LinkedList<Lecture> coursesCanBeTakenThisSemester;
    String transcriptRelatedInformations;

    int totalCreditCompleted;
    double successRate;

    public Student(String departmentName, String name, String id, Teacher advisor, int semester, double successRate) {
        super(departmentName,name, id);
        this.advisor = advisor;
        this.semester = semester;
        coursesTaken = new LinkedList<>();
        courseFailed = new LinkedList<>();
        coursesCouldNotTaken = new LinkedList<>();
        coursesCanBeTakenThisSemester = new LinkedList<>();
        transcript = new LinkedList[8];
        this.successRate = successRate;
        for (int i = 0 ; i < 8 ; i++){
            transcript[i] = new LinkedList<>();
        }
        totalCreditCompleted = 0;
        transcriptRelatedInformations="";
    }
    @Override
    public String toString(){
        return "[Id: " + this.getId() + " Name: " + this.getName() + " SuccessRate: " + this.getSuccessRate() + "\n\tAdvisor: " + this.advisor + "]";
    }
    public Teacher getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Teacher advisor) {
        this.advisor = advisor;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCoursesTaken(LinkedList<Lecture> coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public LinkedList<Lecture>[] getTranscript() {
        return transcript;
    }

    public void setTranscript(LinkedList<Lecture>[] transcript) {
        this.transcript = transcript;
    }

    public LinkedList<Lecture> getCourseFailed() {
        return courseFailed;
    }

    public void setCourseFailed(LinkedList<Lecture> courseFailed) {
        this.courseFailed = courseFailed;
    }

    public LinkedList<Lecture> getCoursesCouldNotTaken() {
        return coursesCouldNotTaken;
    }

    public void setCoursesCouldNotTaken(LinkedList<Lecture> coursesCouldNotTaken) {
        this.coursesCouldNotTaken = coursesCouldNotTaken;
    }

    public LinkedList<Lecture> getCoursesCanBeTakenThisSemester() {
        return coursesCanBeTakenThisSemester;
    }

    public void setCoursesCanBeTakenThisSemester(LinkedList<Lecture> coursesCanBeTakenThisSemester) {
        this.coursesCanBeTakenThisSemester = coursesCanBeTakenThisSemester;
    }

    public String getTranscriptRelatedInformations() {
        return transcriptRelatedInformations;
    }

    public String printTranscipt() {
        for(int i = 0; i < this.semester -1 ; i++ ) {
            System.out.println("Semester " + (i+1) + " -> ");
            for(int j = 0; j < this.transcript[i].size() ; j++ ) {
                Lecture lecture = transcript[i].get(j);
                System.out.println("\t" + lecture.getCode() + " " + lecture.getName() + ". Passes = " + lecture.isPassed() + ". Grade : " + lecture.getGrade());
            }
        }
                return "";
    }

    public void setTranscriptRelatedInformations(String transcriptRelatedInformations) {
        this.transcriptRelatedInformations = transcriptRelatedInformations;
    }

    public int getTotalCreditCompleted() {
        return totalCreditCompleted;
    }

    public void setTotalCreditCompleted(int totalCreditCompleted) {
        this.totalCreditCompleted = totalCreditCompleted;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public void addToCoursesTaken(Lecture course){
        this.coursesTaken.add(course);
    }

    public LinkedList<Lecture> getCoursesTaken() {
        return coursesTaken;
    }

    public void printCoursesTaken(Student student) {
        int i = 1;
        for(Lecture lecture : coursesTaken){
            System.out.println(i + ". " +lecture.getName());
            i++;
        }
    }

    private boolean addToTranscript(Lecture course, int semester, LinkedList<NonTechnicalElective> nonTechnicalList, LinkedList<TechnicalElective>[] technicalList, String semestrInput) {
        if(course instanceof NonTechnicalElective){
            Random random = new Random();
            int rand = random.nextInt(nonTechnicalList.size());
            while ( !nonTechnicalList.get(rand).checkIfTaken(this,nonTechnicalList.get(rand)) ){
                rand = random.nextInt(nonTechnicalList.size());
            }
            this.transcript[semester].add(nonTechnicalList.get(rand));
            return true;
        } else if(course instanceof TechnicalElective){
            Random random = new Random();
            int rand;
            if( semestrInput.equalsIgnoreCase("Spring") ){
                rand = random.nextInt(technicalList[1].size());
                while ( !technicalList[1].get(rand).checkIfTaken(this,technicalList[1].get(rand)) ){
                    rand = random.nextInt(technicalList[1].size());
                }
                technicalList[1].get(rand).setPassed(course.isPassed());
                TechnicalElective randomlySelectedTE = technicalList[1].get(rand);
                TechnicalElective te = new TechnicalElective( randomlySelectedTE.getName(),randomlySelectedTE.getCode(),randomlySelectedTE.getLecturer(),randomlySelectedTE.getCredit(),randomlySelectedTE.getQuota(),null , randomlySelectedTE.getSchedule(),randomlySelectedTE.getGrade());
                if ( this.successRate > random.nextDouble() )
                    te.setPassed(random.nextBoolean());
                this.transcript[semester].add(te);
            } else {
                rand = random.nextInt(technicalList[0].size());
                while ( !technicalList[0].get(rand).checkIfTaken(this,technicalList[0].get(rand)) ){
                    rand = random.nextInt(technicalList[0].size());
                }
                TechnicalElective randomlySelectedTE = technicalList[1].get(rand);
                TechnicalElective te = new TechnicalElective( randomlySelectedTE.getName(),randomlySelectedTE.getCode(),randomlySelectedTE.getLecturer(),randomlySelectedTE.getCredit(),randomlySelectedTE.getQuota(),null,randomlySelectedTE.getSchedule(),randomlySelectedTE.getGrade());
                if ( this.successRate > random.nextDouble() )
                    te.setPassed(random.nextBoolean());
                this.transcript[semester].add(te);
            }
            return true;
        }
        else if(checkPrerequisite(course)){

            this.transcript[semester].add(course);
            return true;
        }
        return false;
    }

    private boolean checkPrerequisite(Lecture course) {
        Lecture prerequisite = course.getPrerequisite();
        if(prerequisite==null)
            return true;
        //find that course from student.transcript
        Lecture prereq = null;
        for(int i = 0; i < this.semester -1 ; i++ ) {
            for(int j = 0; j < this.transcript[i].size() ; j++ ) {
                if( this.transcript[i].get(j).getName().equals(prerequisite.getName()) ){
                    prereq = this.transcript[i].get(j);
                    //this.transcript[i].get(j).setPrerequisite(prereq);
                    course.setPrerequisite(prereq);
                    i=this.semester;
                    break;
                }
            }
        }
        if(prereq!=null && prereq.isPassed()) return true;

        return false;
    }

    private boolean isFailedCourseFitsSemester(Lecture lect, boolean isSpring) {
        if( (lect instanceof Course) ) {
            if ( !isSpring ) { //if current semester is fall
                //if not fall semester, do not take course
                if( ((Course)lect).getSemestr() % 2 == 1 ) {
                    return false;
                }
            } else {
                //if semester input is spring and course semester is fall then do not take course
                if( ((Course)lect).getSemestr() % 2 == 0 ) {
                    return false;
                }
            }
        }
        return true;
    }

    private void regularCoursesToReselect (Lecture lecture) {

        if(checkPrerequisite(lecture))
            coursesCanBeTakenThisSemester.add(lecture);

    }

    private boolean isCourseNotTakenFitsSemester(Lecture lecture, boolean isSpring) {
        if( (lecture instanceof Course) ) {
            if ( !isSpring ) { //if current semester is fall
                //if not fall semester, do not take course
                if( ((Course)lecture).getSemestr() % 2 == 1 ) {
                    return false;
                }
            } else {
                //if semester input is spring and course semester is fall then do not take course
                if( ((Course)lecture).getSemestr() % 2 == 0 ) {
                    return false;
                }
            }
        }
        return true;
    }
    public void generateCoursesCanBeTakenThisSemester(String semesterInput, LinkedList<Lecture>[] courseList){
        boolean isSpring;
        if( semesterInput.equalsIgnoreCase("Fall") ) isSpring=false;
        else isSpring = true;

        //System.out.println("Semester : " + this.semester + " Name : " + this.getName() + " Success rate : " + this.successRate);

        //current semester lectures printed - courses failed printed - coursesCouldNotTakes printed
        for (int i = 0; i < courseList[this.semester -1].size() ; i++) {
            regularCoursesToReselect(courseList[this.semester -1].get(i));
        }

        for (int i = 0 ; i < courseFailed.size() ; i++) {
            Lecture lect = courseFailed.get(i);
            if ( !isFailedCourseFitsSemester(lect,isSpring)
                    && checkPrerequisite(lect) )  continue;

            coursesCanBeTakenThisSemester.add(courseFailed.get(i));
        }

        for (int i = 0 ; i < coursesCouldNotTaken.size() ; i++) {

            Lecture lect = coursesCouldNotTaken.get(i);
            if( isCourseNotTakenFitsSemester(lect,isSpring)
                    && checkPrerequisite(lect) ) continue;
            coursesCanBeTakenThisSemester.add(coursesCouldNotTaken.get(i));
        }
    }
    public void seeCourses( LinkedList<Lecture>[] courseList, String semesterInput,LinkedList<NonTechnicalElective> nonTechnicalList,LinkedList<TechnicalElective>[] technicalList) {
        boolean isSpring;
        if( semesterInput.equalsIgnoreCase("Fall") ) isSpring=false;
        else isSpring = true;
        List<Course> courses = new LinkedList<>();

        Scanner scanner= new Scanner(System.in);    //System.in is a standard input stream

        index = 0;
        int enteredIndex;
        int exitIndex;
        Lecture selectedLecture = null;
        while ( true ) {

            for (int i = 0; i < coursesCanBeTakenThisSemester.size() ; i++ ) {
                System.out.println("Course name press(" + i + ") : " + coursesCanBeTakenThisSemester.get(i).getName());
            }
            exitIndex = coursesCanBeTakenThisSemester.size();
            System.out.println("To exit press(" + exitIndex + ") ");


            System.out.print("Enter number to take course ");
            enteredIndex = scanner.nextInt();
            if( exitIndex == enteredIndex ) {
                for (int i = 0 ; i < coursesTaken.size() ; i++ ) {
                    System.out.println("Taken course : (" + (i+1) + ") : " + coursesTaken.get(i).getName());
                }
                break;
            }

            selectedLecture = coursesCanBeTakenThisSemester.get(enteredIndex);
            System.out.println("Selected lecture name " + selectedLecture.getName());

            if(selectedLecture instanceof TechnicalElective ){
                if( !((TechnicalElective)selectedLecture).register(this,isSpring,technicalList) ){
                    continue;
                }
            }
            else if(selectedLecture instanceof NonTechnicalElective){
                if( !((NonTechnicalElective)selectedLecture).register(this,nonTechnicalList) ){
                    continue;
                }
            }
            else if( !((Course)selectedLecture).register(this) ){
                continue;
            }


            coursesCanBeTakenThisSemester.remove(selectedLecture);
        }

    }

    public void writeBeforeTranscriptJson() {

        JSONArray studentList = new JSONArray();
        for(int i = 0; i < this.transcript.length ; i++ ) {
            for (int j = 0; j < this.transcript[i].size() ; j++ ){

                JSONObject studentDetails = new JSONObject();
                studentDetails.put(transcript[i].get(j).getName(), transcript[i].get(j).getGrade());

                String semester = "Semester " + (i+1);
                JSONObject studentObject = new JSONObject();
                studentObject.put(semester, studentDetails);

                studentList.add(studentObject);

            }

        }
        String fileName = this.getId() + " - " + this.getName() + " - before.json";
        //Write JSON file
        try (FileWriter file = new FileWriter("transcripts/" + fileName)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(studentList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAfterTranscriptJson() {

        JSONArray studentList = new JSONArray();
        for(int i = 0; i < this.transcript.length ; i++ ) {
            for (int j = 0; j < this.transcript[i].size() ; j++ ){

                JSONObject studentDetails = new JSONObject();
                studentDetails.put(transcript[i].get(j).getName(), transcript[i].get(j).getGrade());

                String semester = "Semester " + (i+1);
                JSONObject studentObject = new JSONObject();
                studentObject.put(semester, studentDetails);

                studentList.add(studentObject);

            }
        }

        for(int i = 0 ; i < this.coursesTaken.size() ; i++ ) {
            JSONObject studentDetails = new JSONObject();
            studentDetails.put(coursesTaken.get(i).getName(), "ongoing");

            String semester = "Semester " + this.semester;
            JSONObject studentObject = new JSONObject();
            studentObject.put(semester, studentDetails);

            studentList.add(studentObject);
        }

        String fileName = this.getId() + " - " + this.getName() + " - after.json";
        //Write JSON file
        try (FileWriter file = new FileWriter("transcripts/" + fileName)) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(studentList.toJSONString());
            file.write(this.transcriptRelatedInformations);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }










    private void assignSuccessRate( LinkedList<Lecture>[] courseList ) {
        for(int i = 0; i < this.semester -1 ; i++ ) {
            for(int j = 0 ; j < courseList[i].size() ; j++ ) {
                if( new Random().nextDouble() < this.successRate ){
                    courseList[i].get(j).setPassed(true);
                }
                else{
                    courseList[i].get(j).setPassed(false);
                }
            }
        }
    }

    private void courseFailed ( LinkedList<Lecture> courseFailed,int pointingSemestr,LinkedList<NonTechnicalElective> nonTechnicalList,LinkedList<TechnicalElective>[] technicalList,String semestrInput ) {
        for(int k = 0; k < courseFailed.size() ; k++ ) {
            if(transcript[pointingSemestr].size() >= 10) break;

            Lecture lect = courseFailed.get(k);

            Lecture createdLect;
            if( lect instanceof NonTechnicalElective ){
                createdLect = new NonTechnicalElective( lect.getName(),lect.getCode(),lect.getLecturer(),
                        lect.getCredit(),((NonTechnicalElective) lect).getQuota(), lect.getSchedule(), lect.getGrade());;
            } else if ( lect instanceof TechnicalElective ) {
                createdLect = new TechnicalElective( lect.getName(),lect.getCode(),lect.getLecturer(),
                        lect.getCredit(),((TechnicalElective) lect).getQuota(),lect.getPrerequisite(),lect.getSchedule(),lect.getGrade());
            } else {
                if ( pointingSemestr % 2 == 0 ) { //if current semester is fall
                    //if not fall semester, do not take course
                    if( ((Course)lect).getSemestr() % 2 == 1 ) {
                        continue;
                    }
                } else {
                    //if semester input is spring and course semester is fall then do not take course
                    if( ((Course)lect).getSemestr() % 2 == 0 ) {
                        continue;
                    }
                }
                createdLect = new Course( lect.getName(),lect.getCode(),lect.getLecturer(),lect.getCredit(),
                        lect.getECTS(),lect.getPrerequisite(),((Course)lect).getSemestr(),lect.getSchedule(),lect.getGrade() );
            }
            boolean passedLect = new Random().nextBoolean();
            createdLect.setPassed(passedLect);
            if( this.addToTranscript(createdLect,pointingSemestr,nonTechnicalList,technicalList,semestrInput) && createdLect.isPassed() ) {
                this.totalCreditCompleted += createdLect.getCredit();
                courseFailed.remove(k);
                k--;
            }
        }
    }

    Lecture assignGrade (Lecture lecture) {

        if( lecture.isPassed() ){
            int random = new Random().nextInt(5);
            if(random == 0) lecture.setGrade("AA");
            else if(random == 1) lecture.setGrade("BA");
            else if(random == 2) lecture.setGrade("BB");
            else if(random == 3) lecture.setGrade("CB");
            else if(random == 4) lecture.setGrade("CC");
        }
        else{
            int random = new Random().nextInt(2);
            if(random==0) lecture.setGrade("FF");
            else lecture.setGrade("FG");
        }

        return lecture;
    }

    private Lecture createLectureIfSemesterFits(Lecture lect, int pointingSemester) {

        Lecture createdLect;
        if( lect instanceof NonTechnicalElective ){
            createdLect = new NonTechnicalElective( lect.getName(),lect.getCode(),lect.getLecturer(),
                    lect.getCredit(),((NonTechnicalElective) lect).getQuota(),lect.getSchedule(), lect.getGrade());
        } else if ( lect instanceof TechnicalElective ) {
            createdLect = new TechnicalElective( lect.getName(),lect.getCode(),lect.getLecturer(),
                    lect.getCredit(),((TechnicalElective) lect).getQuota(),lect.getPrerequisite(),lect.getSchedule(),lect.getGrade());
        } else {
            if ( pointingSemester % 2 == 0 ) { //if current semester is fall
                //if not fall semester, do not take course
                if( ((Course)lect).getSemestr() % 2 == 1 ) {
                    return null;
                }
            } else {
                //if semester input is spring and course semester is fall then do not take course
                if( ((Course)lect).getSemestr() % 2 == 0 ) {
                    return null;
                }
            }
            createdLect = new Course( lect.getName(),lect.getCode(),lect.getLecturer(),lect.getCredit(),
                    lect.getECTS(),lect.getPrerequisite(),((Course)lect).getSemestr(),lect.getSchedule(), lect.getGrade());
        }
        boolean passedLect = new Random().nextBoolean();
        createdLect.setPassed(passedLect);
        return createdLect;
    }

    private void courseNotTaken ( LinkedList<Lecture> coursesCouldNotTaken, int pointingSemestr,LinkedList<NonTechnicalElective> nonTechnicalList,LinkedList<TechnicalElective>[] technicalList,String semestrInput ) {
        for(int k = 0; k < coursesCouldNotTaken.size() ; k++ ) {
            if(transcript[pointingSemestr].size() >= 10) break;

            Lecture lect = coursesCouldNotTaken.get(k);

            Lecture createdLect  = createLectureIfSemesterFits(lect,pointingSemestr);

            if( createdLect!=null && this.addToTranscript(createdLect,pointingSemestr,nonTechnicalList,technicalList,semestrInput) ) {
                coursesCouldNotTaken.remove(k);
                if( !createdLect.isPassed() ){
                    courseFailed.add(lect);
                }
                else {
                    this.totalCreditCompleted += createdLect.getCredit();
                }
                k--;
            }


        }
    }static int index = 0;

    private void regularCourses ( LinkedList<Lecture>[] courseList, int semester,LinkedList<NonTechnicalElective> nonTechnicalList,LinkedList<TechnicalElective>[] technicalList,String semestrInput) {
        for (int i = 0 ; i < courseList[semester].size() ; i++) {

            Lecture lecture = courseList[semester].get(i);

            if(transcript[semester].size() >= 10) {
                coursesCouldNotTaken.add(lecture);
                continue;
            }

            Lecture createdLecture = createLecture(lecture);

            if( this.addToTranscript(createdLecture,semester,nonTechnicalList,technicalList,semestrInput)  ) {
                if( !createdLecture.isPassed() ){
                    this.courseFailed.add(createdLecture);
                }
                else {
                    this.totalCreditCompleted += createdLecture.getCredit();
                }
            }

        }


    }

    private Lecture createLecture (Lecture lecture) {
        Lecture createdLecture;
        if( lecture instanceof NonTechnicalElective ){
            createdLecture = new NonTechnicalElective( lecture.getName(),lecture.getCode(),lecture.getLecturer(),
                    lecture.getCredit(),((NonTechnicalElective) lecture).getQuota(), lecture.getSchedule(), lecture.getGrade());
        } else if ( lecture instanceof TechnicalElective ) {
            createdLecture = new TechnicalElective( lecture.getName(),lecture.getCode(),lecture.getLecturer(),
                    lecture.getCredit(),((TechnicalElective) lecture).getQuota(),lecture.getPrerequisite(),lecture.getSchedule(), lecture.getGrade());
        } else {
            createdLecture = new Course( lecture.getName(),lecture.getCode(),lecture.getLecturer(),lecture.getCredit(),
                    lecture.getECTS(),lecture.getPrerequisite(),((Course)lecture).getSemestr(),lecture.getSchedule(), lecture.getGrade() );
        }
        createdLecture.setPassed(lecture.isPassed());
        return createdLecture;
    }


    public void modifyTranscript(LinkedList<Lecture>[] courseList, LinkedList<NonTechnicalElective> nonTechnicalList, LinkedList<TechnicalElective>[] technicalList, String semesterInput) {

        assignSuccessRate(courseList);

        for (int j = 0; j < this.semester -1 ; j++ ) {

            courseFailed( courseFailed, j,nonTechnicalList,technicalList,semesterInput);

            courseNotTaken(coursesCouldNotTaken,j,nonTechnicalList,technicalList,semesterInput);

            regularCourses( courseList, j,nonTechnicalList,technicalList,semesterInput);

            //System.out.println(this.transcript[j].size());
            for (int i = 0; i < this.transcript[j].size()  ; i++ ){
                assignGrade(this.transcript[j].get(i));
            }

        }



    }








}
