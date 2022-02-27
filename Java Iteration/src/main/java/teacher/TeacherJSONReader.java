package teacher;

import model.Counter;
import model.Teacher;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TeacherJSONReader {

    public void readJson(LinkedList<Teacher> teacherList) {
        //JSON parser object to parse read file
        JSONParser jsonParserTeacher = new JSONParser();

        try (FileReader reader = new FileReader("teachers.json"))
        {
            //Read JSON file
            Object obj = jsonParserTeacher.parse(reader);

            JSONArray teacherListJson = (JSONArray) obj;
            System.out.println(teacherList);

            //Iterate over employee array
            teacherListJson.forEach(
                    teacher -> parseTeacherObject( (JSONObject) teacher ,teacherList)
            );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseTeacherObject(JSONObject teacher,LinkedList<Teacher> teacherList) {
        if (teacher == null) {
            return;
        }
        //Get teacher object within list
        JSONObject studentObject = (JSONObject) teacher.get("teacher");

        //Get teacher name
        String teacherName = (String) studentObject.get("name");
        System.out.println("Teacher name : " + teacherName);

        addTeacherToteacherList(createTeacher(teacherName),teacherList);

    }

    public Teacher createTeacher(String name) {
        return new Teacher("Computer Engineering",name, ""+Counter.id++);
    }

    public void addTeacherToteacherList (Teacher teacher,LinkedList<Teacher> teacherList) {
        teacherList.add(teacher);
    }
}
