package student;

import model.Counter;
import model.Lecture;
import model.Student;
import model.Teacher;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class StudentJSONReader {

    public void readJson(LinkedList<Student> studentList, LinkedList<Lecture>[] courseList, LinkedList<Teacher> teacherList, String semestrInput) {
        //JSON parser object to parse read file
        JSONParser jsonParserStudent = new JSONParser();

        try (FileReader reader = new FileReader("students.json"))
        {
            //Read JSON file
            Object obj = jsonParserStudent.parse(reader);

            JSONArray students = (JSONArray) obj;
            System.out.println(students);

            //Iterate over employee array
            students.forEach(
                    stu -> parseStudentObject( (JSONObject) stu,studentList,courseList,teacherList,semestrInput )
            );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseStudentObject(JSONObject student,LinkedList<Student> studentList,LinkedList<Lecture>[] courseList,LinkedList<Teacher> teacherList,String semestrInput) {
        if (student == null) {
            return;
        }
        //Get course object within list
        JSONObject studentObject = (JSONObject) student.get("student");

        //Get student name
        String studentName = (String) studentObject.get("name");
        System.out.println("Student name : " + studentName);


        //Get student id
        String studentId = (String) studentObject.get("id");
        System.out.println("Student id : " + studentId);



        Student createdStudent = createStudent(studentName,teacherList,semestrInput,studentId);
        studentList.add(createdStudent);
        System.out.println("-----------------------------------------------");

    }

    private static Student createStudent(String name,LinkedList<Teacher> teacherList,String semestrInput, String studentId) {
        int semestr;
        if("fall".equalsIgnoreCase(semestrInput)){
            int rand = new Random().nextInt(4);
            semestr = rand * 2 + 1 ;
        }
        else{
            int rand = new Random().nextInt(4);
            semestr = rand * 2 + 2 ;
        }

        return new Student("Computer Engineering",name, studentId,teacherList.get(new Random().nextInt(teacherList.size())),semestr,new Random().nextDouble());
    }



}
