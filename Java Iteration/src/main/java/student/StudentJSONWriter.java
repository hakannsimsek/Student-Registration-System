package student;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class StudentJSONWriter {

    public void writeJson() {
        //First Student
        JSONObject studentDetails = new JSONObject();
        studentDetails.put("name", "Ahmet Hakan Şimşek");
        studentDetails.put("id", "150117060");

        JSONObject studentObject = new JSONObject();
        studentObject.put("student", studentDetails);

        //Second Student
        JSONObject studentDetails2 = new JSONObject();
        studentDetails2.put("name", "Sena Dilara Yangöz");
        studentDetails2.put("id", "150119706");

        JSONObject studentObject2 = new JSONObject();
        studentObject2.put("student", studentDetails2);

        //Third Student
        JSONObject studentDetails3 = new JSONObject();
        studentDetails3.put("name", "Metehan Kurucu");
        studentDetails3.put("id", "150117016");

        JSONObject studentObject3 = new JSONObject();
        studentObject3.put("student", studentDetails3);

        //4 Student
        JSONObject studentDetails4 = new JSONObject();
        studentDetails4.put("name", "Erdem Açıldı");
        studentDetails4.put("id", "150118510");

        JSONObject studentObject4 = new JSONObject();
        studentObject4.put("student", studentDetails4);

        //5 Student
        JSONObject studentDetails5 = new JSONObject();
        studentDetails5.put("name", "Arda Yiğit Kaynar");
        studentDetails5.put("id", "150117006");

        JSONObject studentObject5 = new JSONObject();
        studentObject5.put("student", studentDetails5);

        //6 Student
        JSONObject studentDetails6 = new JSONObject();
        studentDetails6.put("name", "Oğuzhan Karabudak");
        studentDetails6.put("id", "150118005");

        JSONObject studentObject6 = new JSONObject();
        studentObject6.put("student", studentDetails6);

        //7 Student
        JSONObject studentDetails7 = new JSONObject();
        studentDetails7.put("name", "Mevlüt Eren Topal");
        studentDetails7.put("id", "150117025");

        JSONObject studentObject7 = new JSONObject();
        studentObject7.put("student", studentDetails7);

        //8 Student
        JSONObject studentDetails8 = new JSONObject();
        studentDetails8.put("name", "Elif Gülay");
        studentDetails8.put("id", "150119732");

        JSONObject studentObject8 = new JSONObject();
        studentObject8.put("student", studentDetails8);

        //Add employees to list
        JSONArray studentList = new JSONArray();
        studentList.add(studentObject);
        studentList.add(studentObject2);
        studentList.add(studentObject3);
        studentList.add(studentObject4);
        studentList.add(studentObject5);
        studentList.add(studentObject6);
        studentList.add(studentObject7);
        studentList.add(studentObject8);

        //Write JSON file
        try (FileWriter file = new FileWriter("students.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(studentList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
