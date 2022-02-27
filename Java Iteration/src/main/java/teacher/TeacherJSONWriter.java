package teacher;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class TeacherJSONWriter {

    public void writeJson() {
        //First Teacher
        JSONObject teacherDetails = new JSONObject();
        teacherDetails.put("name", "Haluk Rahmi Topçuoğlu");

        JSONObject teacherObject = new JSONObject();
        teacherObject.put("teacher", teacherDetails);

        //Second Teacher
        JSONObject teacherDetails2 = new JSONObject();
        teacherDetails2.put("name", "Çiğdem Eroğlu Erdem");

        JSONObject teacherObject2 = new JSONObject();
        teacherObject2.put("teacher", teacherDetails2);

        //Third Teacher
        JSONObject teacherDetails3 = new JSONObject();
        teacherDetails3.put("name", "Ali Fuat Alkaya");

        JSONObject teacherObject3 = new JSONObject();
        teacherObject3.put("teacher", teacherDetails3);

        //4 Teacher
        JSONObject teacherDetails4 = new JSONObject();
        teacherDetails4.put("name", "Murat Can Ganiz");

        JSONObject teacherObject4 = new JSONObject();
        teacherObject4.put("teacher", teacherDetails4);

        //5 Teacher
        JSONObject teacherDetails5 = new JSONObject();
        teacherDetails5.put("name", "Müjdat Soytürk");

        JSONObject teacherObject5 = new JSONObject();
        teacherObject5.put("teacher", teacherDetails5);

        //6 Teacher
        JSONObject teacherDetails6 = new JSONObject();
        teacherDetails6.put("name", "Borahan Tümer");

        JSONObject teacherObject6 = new JSONObject();
        teacherObject6.put("teacher", teacherDetails6);

        //7 Teacher
        JSONObject teacherDetails7 = new JSONObject();
        teacherDetails7.put("name", "Mustafa Ağaoğlu");

        JSONObject teacherObject7 = new JSONObject();
        teacherObject7.put("teacher", teacherDetails7);

        //8 Teacher
        JSONObject teacherDetails8 = new JSONObject();
        teacherDetails8.put("name", "Mehmet Kadir Baran");

        JSONObject teacherObject8 = new JSONObject();
        teacherObject8.put("teacher", teacherDetails8);

        //9 Teacher
        JSONObject teacherDetails9 = new JSONObject();
        teacherDetails9.put("name", "Betül Demiröz Boz");

        JSONObject teacherObject9 = new JSONObject();
        teacherObject9.put("teacher", teacherDetails9);

        //10 Teacher
        JSONObject teacherDetails10 = new JSONObject();
        teacherDetails10.put("name", "Fatma Corut Ergin");

        JSONObject teacherObject10 = new JSONObject();
        teacherObject10.put("teacher", teacherDetails10);

        //11 Teacher
        JSONObject teacherDetails11 = new JSONObject();
        teacherDetails11.put("name", "Ömer Korçak");

        JSONObject teacherObject11 = new JSONObject();
        teacherObject11.put("teacher", teacherDetails11);

        //12 Teacher
        JSONObject teacherDetails12 = new JSONObject();
        teacherDetails12.put("name", "Ali Haydar Özer");

        JSONObject teacherObject12 = new JSONObject();
        teacherObject12.put("teacher", teacherDetails12);

        //13 Teacher
        JSONObject teacherDetails13 = new JSONObject();
        teacherDetails13.put("name", "Sanem Arslan");

        JSONObject teacherObject13 = new JSONObject();
        teacherObject13.put("teacher", teacherDetails13);


        //Add teachers to list
        JSONArray teacherList = new JSONArray();
        teacherList.add(teacherObject);
        teacherList.add(teacherObject2);
        teacherList.add(teacherObject3);
        teacherList.add(teacherObject4);
        teacherList.add(teacherObject5);
        teacherList.add(teacherObject6);
        teacherList.add(teacherObject7);
        teacherList.add(teacherObject8);
        teacherList.add(teacherObject9);
        teacherList.add(teacherObject10);
        teacherList.add(teacherObject11);
        teacherList.add(teacherObject12);
        teacherList.add(teacherObject13);

        //Write JSON file
        try (FileWriter file = new FileWriter("teachers.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(teacherList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
