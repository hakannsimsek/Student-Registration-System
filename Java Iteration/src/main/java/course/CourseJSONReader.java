package course;

import model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CourseJSONReader {


    JSONArray lectureList = new JSONArray();

    public void readJson(LinkedList<Lecture>[] courseList, LinkedList<Teacher> teacherList, LinkedList<NonTechnicalElective> nonTechnicalList, LinkedList<TechnicalElective>[] technicalList, String semesterInput){


        JSONParser jsonParser = new JSONParser();

        try (
                FileReader reader = new FileReader("courses.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            lectureList = (JSONArray) obj;
            System.out.println(lectureList);

            //Iterate over employee array
            lectureList.forEach(
                    emp -> parseCourseObject( (JSONObject) emp ,courseList,teacherList,nonTechnicalList,technicalList, semesterInput)
            );

            for (int j = 0; j < 8 ; j++){
                for (int i = 1 ; i < courseList[j].size() ; i++) {
                    Lecture course =  courseList[j].get(i);
                    course.getName();
                    System.out.println(course.getName() +"-"+ course.getCode() +"-"+ course.getLecturer().getName() );
                }
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (
                ParseException e) {
            e.printStackTrace();
        }

    }




    private void parseCourseObject(JSONObject employee, LinkedList<Lecture>[] courseList, LinkedList<Teacher> teacherList, LinkedList<NonTechnicalElective> nonTechnicalList, LinkedList<TechnicalElective>[] technicalList, String semestrInput)
    {
        if(employee==null){ return; }
        //Get course object within list
        JSONObject courseObject = (JSONObject) employee.get("Course");

        //Get course name
        String courseName = (String) courseObject.get("CourseName");
        System.out.print("Course name : " + courseName);

        //Get course credit
        int credit = Integer.parseInt((String) courseObject.get("Credit"));
        System.out.print(" -- Credit : " + credit);

        //Get course code
        String courseCode = (String) courseObject.get("CourseCode");
        System.out.print(" -- Course code : " + courseCode);

        //Get course lecturer
        String lecturer = (String) courseObject.get("Lecturer");
        System.out.print(" -- Lecturer : " + lecturer);
        Teacher teacher = findTeacher(teacherList ,lecturer);

        //Get course semestr
        int semestr = Integer.parseInt((String) courseObject.get("Semestr"));
        System.out.print(" -- Semestr : " + semestr);

        //Get course prerequisite
        String prerequisite = (String) courseObject.get("Prerequisite");
        System.out.println(" -- Prerequisite : " + prerequisite);

        String schedule = (String) courseObject.get("Schedule");
        System.out.println(" -- Schedule : " + schedule);

        Lecture course = null;
        if( !prerequisite.equals("") ) {
            for( int i = 0 ; i < courseList.length ; i++ ) {
                for( int j = 0 ; j < courseList[i].size() ; j++ ) {
                    if( courseList[i].get(j).getCode().equals(prerequisite) ){
                        course = courseList[i].get(j);
                        break;
                    }
                }
            }
        }




        if(courseCode.startsWith("NTE") || courseCode.startsWith("FTE") || courseCode.startsWith("UE")) {
            //Get if selected
            boolean isSelective = Boolean.parseBoolean((String) courseObject.get("Selective"));
            System.out.print(" -- Selective : " + courseCode);

            if(isSelective){
                nonTechnicalList.add(new NonTechnicalElective(courseName,courseCode,teacher,credit,Integer.parseInt((String)courseObject.get("Quota")),schedule,""));
            }

            else{
                courseList[semestr-1].add(new NonTechnicalElective(courseName,courseCode,teacher,credit,Integer.parseInt((String)courseObject.get("Quota")),schedule,""));
            }
        }
        else if(courseCode.startsWith("TE")) {
            //Get if selected
            boolean isSelective = Boolean.parseBoolean((String) courseObject.get("Selective"));
            System.out.print(" -- Selective : " + courseCode);
            if(isSelective){
                if( semestr==7 ) {
                    technicalList[0].add(new TechnicalElective(courseName,courseCode,teacher,credit,Integer.parseInt((String)courseObject.get("Quota")),course,schedule,""));
                }
                else {
                    technicalList[1].add(new TechnicalElective(courseName,courseCode,teacher,credit,Integer.parseInt((String)courseObject.get("Quota")),course ,schedule,""));
                }
            }
            else {
                courseList[semestr-1].add(new TechnicalElective(courseName,courseCode,teacher,credit,Integer.parseInt((String)courseObject.get("Quota")),course,schedule,"" ));
            }
        }
        else {
            Course crs = new Course(courseName,courseCode,teacher,credit,credit,course,semestr,schedule,"");
            courseList[semestr-1].add(new Course(courseName,courseCode,teacher,credit,credit,course,--semestr,schedule,"")) ;
        }

    }

    private Teacher findTeacher(LinkedList<Teacher> teacherList, String lecturerName) {

        for ( int i = 0 ; i < teacherList.size() ; i++ ) {

            if( teacherList.get(i).getName().equals(lecturerName) ) {
                return teacherList.get(i);
            }

        }

        return new Teacher("Computer Engineering",lecturerName,""+Counter.id++);
    }
}
