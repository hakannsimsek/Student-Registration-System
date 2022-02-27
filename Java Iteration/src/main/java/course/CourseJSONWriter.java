package course;

import model.Lecture;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CourseJSONWriter {


    LinkedList<Lecture>[] courseList;


    public void writeJSON() {

        courseList = new LinkedList[8];
        for (int i = 0 ; i < 8 ; i++){
            courseList[i] = new LinkedList<Lecture>();
        }

//First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("CourseName", "Calculus 1");
        employeeDetails.put("CourseCode", "MATH1001");
        employeeDetails.put("Credit", "6");
        employeeDetails.put("Lecturer", "Mustafa Cem Çelik");
        employeeDetails.put("Semestr", "1");
        employeeDetails.put("Prerequisite", "");
        employeeDetails.put("Schedule", "Salı 08:30-10:20 Perşembe 08:30-10:20");


        JSONObject employeeObject = new JSONObject();
        employeeObject.put("Course", employeeDetails);

        //Second Employee
        JSONObject employeeDetails2 = new JSONObject();
        employeeDetails2.put("CourseName", "Basic Chemistry");
        employeeDetails2.put("CourseCode", "CHEM1007");
        employeeDetails2.put("Credit", "6");
        employeeDetails2.put("Lecturer", "Kimyacı");
        employeeDetails2.put("Semestr", "1");
        employeeDetails2.put("Prerequisite", "");
        employeeDetails2.put("Schedule", "Pazartesi 09:00-11:00 Cuma 09:00-11:00");

        JSONObject employeeObject2 = new JSONObject();
        employeeObject2.put("Course", employeeDetails2);

        //Third Employee
        JSONObject employeeDetails3 = new JSONObject();
        employeeDetails3.put("CourseName", "Computer Programming 1");
        employeeDetails3.put("CourseCode", "CSE1141");
        employeeDetails3.put("Credit", "6");
        employeeDetails3.put("Lecturer", "Sanem Arslan");
        employeeDetails3.put("Semestr", "1");
        employeeDetails3.put("Prerequisite", "");
        employeeDetails3.put("Schedule", "Pazartesi 10:30-11:20 Çarşamba 14:00-15:00");

        JSONObject employeeObject3 = new JSONObject();
        employeeObject3.put("Course", employeeDetails3);

        //4 Employee
        JSONObject employeeDetails4 = new JSONObject();
        employeeDetails4.put("CourseName", "Physics 1");
        employeeDetails4.put("CourseCode", "PHYS1101");
        employeeDetails4.put("Credit", "4");
        employeeDetails4.put("Lecturer", "Mustafa Alevli");
        employeeDetails4.put("Semestr", "1");
        employeeDetails4.put("Prerequisite", "");
        employeeDetails4.put("Schedule", "Salı 15:00-16:00 Perşembe 14:00-16:00");

        JSONObject employeeObject4 = new JSONObject();
        employeeObject4.put("Course", employeeDetails4);

        //5 Employee
        JSONObject employeeDetails5 = new JSONObject();
        employeeDetails5.put("CourseName", "Physics Lab 1");
        employeeDetails5.put("CourseCode", "PHYS1103");
        employeeDetails5.put("Credit", "2");
        employeeDetails5.put("Lecturer", "Mustafa Alevli");
        employeeDetails5.put("Semestr", "1");
        employeeDetails5.put("Prerequisite", "");
        employeeDetails5.put("Schedule", "Pazartesi 08:30-10:20");

        JSONObject employeeObject5 = new JSONObject();
        employeeObject5.put("Course", employeeDetails5);

        //6 Employee
        JSONObject employeeDetails6 = new JSONObject();
        employeeDetails6.put("CourseName", "Atatürk's Prin. & History 1");
        employeeDetails6.put("CourseCode", "ATA121");
        employeeDetails6.put("Credit", "2");
        employeeDetails6.put("Lecturer", "UZEM");
        employeeDetails6.put("Semestr", "1");
        employeeDetails6.put("Prerequisite", "");
        employeeDetails6.put("Schedule", "Salı 22:00-23:50");

        JSONObject employeeObject6 = new JSONObject();
        employeeObject6.put("Course", employeeDetails6);

        //7 Employee
        JSONObject employeeDetails7 = new JSONObject();
        employeeDetails7.put("CourseName", "Introduction to Computer Engineering");
        employeeDetails7.put("CourseCode", "CSE1100");
        employeeDetails7.put("Credit", "2");
        employeeDetails7.put("Lecturer", "Fatma Corut Ergin");
        employeeDetails7.put("Semestr", "1");
        employeeDetails7.put("Prerequisite", "");
        employeeDetails7.put("Schedule", "Çarşamba 13:00-14:00 Cuma 09:30-11:20");

        JSONObject employeeObject7 = new JSONObject();
        employeeObject7.put("Course", employeeDetails7);

        //8 Employee
        JSONObject employeeDetails8 = new JSONObject();
        employeeDetails8.put("CourseName", "Turkish Language 1");
        employeeDetails8.put("CourseCode", "TRD121");
        employeeDetails8.put("Credit", "2");
        employeeDetails8.put("Lecturer", "UZEM");
        employeeDetails8.put("Semestr", "1");
        employeeDetails8.put("Prerequisite", "");
        employeeDetails8.put("Schedule", "Pazar 15:00-17:00");

        JSONObject employeeObject8 = new JSONObject();
        employeeObject8.put("Course", employeeDetails8);

        //9 Employee
        JSONObject employeeDetails9 = new JSONObject();
        employeeDetails9.put("CourseName", "Calculus 2");
        employeeDetails9.put("CourseCode", "MATH1002");
        employeeDetails9.put("Credit", "6");
        employeeDetails9.put("Lecturer", "Mustafa Cem Çelik");
        employeeDetails9.put("Semestr", "2");
        employeeDetails9.put("Prerequisite", "");
        employeeDetails9.put("Schedule", "Salı 17:00-19:00 Perşembe 17:00-19:00");

        JSONObject employeeObject9 = new JSONObject();
        employeeObject9.put("Course", employeeDetails9);

        //10 Employee
        JSONObject employeeDetails10 = new JSONObject();
        employeeDetails10.put("CourseName", "Physics Lab 2");
        employeeDetails10.put("CourseCode", "PHYS1104");
        employeeDetails10.put("Credit", "2");
        employeeDetails10.put("Lecturer", "Mustafa Alevli");
        employeeDetails10.put("Semestr", "2");
        employeeDetails10.put("Prerequisite", "");
        employeeDetails10.put("Schedule", "Cumartesi 10:00-12:00");

        JSONObject employeeObject10 = new JSONObject();
        employeeObject10.put("Course", employeeDetails10);

        //11 Employee
        JSONObject employeeDetails11 = new JSONObject();
        employeeDetails11.put("CourseName", "Computer Programming 2");
        employeeDetails11.put("CourseCode", "CSE1142");
        employeeDetails11.put("Credit", "7");
        employeeDetails11.put("Lecturer", "Sanem Arslan");
        employeeDetails11.put("Semestr", "2");
        employeeDetails11.put("Prerequisite", "CSE1141");
        employeeDetails11.put("Schedule", "Pazartesi 15:00-16:00 Çarşamba 16:00-18:00");

        JSONObject employeeObject11 = new JSONObject();
        employeeObject11.put("Course", employeeDetails11);

        //12 Employee
        JSONObject employeeDetails12 = new JSONObject();
        employeeDetails12.put("CourseName", "Physics 2");
        employeeDetails12.put("CourseCode", "PHYS1102");
        employeeDetails12.put("Credit", "4");
        employeeDetails12.put("Lecturer", "Mustafa Alevli");
        employeeDetails12.put("Semestr", "2");
        employeeDetails12.put("Prerequisite", "");
        employeeDetails12.put("Schedule", "Pazartesi 13:00-16:00");

        JSONObject employeeObject12 = new JSONObject();
        employeeObject12.put("Course", employeeDetails12);


        //13 Employee
        JSONObject employeeDetails13 = new JSONObject();
        employeeDetails13.put("CourseName", "Atatürk's Prin. & History 2");
        employeeDetails13.put("CourseCode", "ATA122");
        employeeDetails13.put("Credit", "2");
        employeeDetails13.put("Lecturer", "UZEM");
        employeeDetails13.put("Semestr", "2");
        employeeDetails13.put("Prerequisite", "");
        employeeDetails13.put("Schedule", "Cuma 22:00-23:50");


        JSONObject employeeObject13 = new JSONObject();
        employeeObject13.put("Course", employeeDetails13);


        //14 Employee
        JSONObject employeeDetails14 = new JSONObject();
        employeeDetails14.put("CourseName", "Linear Algebra");
        employeeDetails14.put("CourseCode", "MATH2056");
        employeeDetails14.put("Credit", "4");
        employeeDetails14.put("Lecturer", "Taylan Şengül");
        employeeDetails14.put("Semestr", "2");
        employeeDetails14.put("Prerequisite", "");
        employeeDetails14.put("Schedule", "Pazartesi 16:00-18:00 Perşembe 16:00-18:00");

        JSONObject employeeObject14 = new JSONObject();
        employeeObject14.put("Course", employeeDetails14);


        //15 Employee
        JSONObject employeeDetails15 = new JSONObject();
        employeeDetails15.put("CourseName", "Turkish Language 2");
        employeeDetails15.put("CourseCode", "TRD122");
        employeeDetails15.put("Credit", "2");
        employeeDetails15.put("Lecturer", "UZEM");
        employeeDetails15.put("Semestr", "2");
        employeeDetails15.put("Prerequisite", "");
        employeeDetails15.put("Schedule", "Pazar 15:00-17:00");

        JSONObject employeeObject15 = new JSONObject();
        employeeObject15.put("Course", employeeDetails15);


        //16 Employee
        JSONObject employeeDetails16 = new JSONObject();
        employeeDetails16.put("CourseName", "Differential Equations");
        employeeDetails16.put("CourseCode", "MATH2055");
        employeeDetails16.put("Credit", "4");
        employeeDetails16.put("Lecturer", "Mustafa Cem Çelik");
        employeeDetails16.put("Semestr", "3");
        employeeDetails16.put("Prerequisite", "MATH1001");
        employeeDetails16.put("Schedule", "Pazartesi 09:30-10:20 Çarşamba 08:30-10:20");

        JSONObject employeeObject16 = new JSONObject();
        employeeObject16.put("Course", employeeDetails16);


        //17 Employee
        JSONObject employeeDetails17 = new JSONObject();
        employeeDetails17.put("CourseName", "Data Structures");
        employeeDetails17.put("CourseCode", "CSE2025");
        employeeDetails17.put("Credit", "8");
        employeeDetails17.put("Lecturer", "Borahan Tümer");
        employeeDetails17.put("Semestr", "3");
        employeeDetails17.put("Prerequisite", "CSE1142");
        employeeDetails17.put("Schedule", "Pazartesi 15:00-16:00 Çarşamba 14:00-16:00");

        JSONObject employeeObject17 = new JSONObject();
        employeeObject17.put("Course", employeeDetails17);


        //18 Employee
        JSONObject employeeDetails18 = new JSONObject();
        employeeDetails18.put("CourseName", "Discrete Comp. Structures");
        employeeDetails18.put("CourseCode", "CSE2023");
        employeeDetails18.put("Credit", "6");
        employeeDetails18.put("Lecturer", "Ali Fuat Alkaya");
        employeeDetails18.put("Semestr", "3");
        employeeDetails18.put("Prerequisite", "");
        employeeDetails18.put("Schedule", "Pazartesi 13:00-15:00 Çarşamba 16:00-17:00");

        JSONObject employeeObject18 = new JSONObject();
        employeeObject18.put("Course", employeeDetails18);


        //19 Employee
        JSONObject employeeDetails19 = new JSONObject();
        employeeDetails19.put("CourseName", "Electric Circuits");
        employeeDetails19.put("CourseCode", "EE2031");
        employeeDetails19.put("Credit", "5");
        employeeDetails19.put("Lecturer", "Fulya Çallıalp");
        employeeDetails19.put("Semestr", "3");
        employeeDetails19.put("Prerequisite", "");
        employeeDetails19.put("Schedule", "Salı 13:00-15:00 Perşembe 14:00-15:00");

        JSONObject employeeObject19 = new JSONObject();
        employeeObject19.put("Course", employeeDetails19);

        //20 Employee
        JSONObject employeeDetails20 = new JSONObject();
        employeeDetails20.put("CourseName", "Introduction to Economics");
        employeeDetails20.put("CourseCode", "ECON2003");
        employeeDetails20.put("Credit", "4");
        employeeDetails20.put("Lecturer", "Eren Geyhan");
        employeeDetails20.put("Semestr", "3");
        employeeDetails20.put("Prerequisite", "");
        employeeDetails20.put("Schedule", "Perşembe 22:00-23:50");

        JSONObject employeeObject20 = new JSONObject();
        employeeObject20.put("Course", employeeDetails20);


        //21 Employee
        JSONObject employeeDetails21 = new JSONObject();
        employeeDetails21.put("CourseName", "Numerical Methods");
        employeeDetails21.put("CourseCode", "MATH2059");
        employeeDetails21.put("Credit", "4");
        employeeDetails21.put("Lecturer", "Çiğdem Eroğlu Erdem");
        employeeDetails21.put("Semestr", "4");
        employeeDetails21.put("Prerequisite", "MATH1001");
        employeeDetails21.put("Schedule", "Salı 15:00-17:00 Perşembe 15:00-16:00");

        JSONObject employeeObject21 = new JSONObject();
        employeeObject21.put("Course", employeeDetails21);

        //22 Employee
        JSONObject employeeDetails22 = new JSONObject();
        employeeDetails22.put("CourseName", "Analysis of Algorithms");
        employeeDetails22.put("CourseCode", "CSE2046");
        employeeDetails22.put("Credit", "6");
        employeeDetails22.put("Lecturer", "Ömer Korçak");
        employeeDetails22.put("Semestr", "4");
        employeeDetails22.put("Prerequisite", "CSE2025");
        employeeDetails22.put("Schedule", "Pazartesi 15:00-16:00 Çarşamba 14:00-16:00");

        JSONObject employeeObject22 = new JSONObject();
        employeeObject22.put("Course", employeeDetails22);

        //23 Employee
        JSONObject employeeDetails23 = new JSONObject();
        employeeDetails23.put("CourseName", "Engineering Economy");
        employeeDetails23.put("CourseCode", "ECON2004");
        employeeDetails23.put("Credit", "4");
        employeeDetails23.put("Lecturer", "Eren Geyhan");
        employeeDetails23.put("Semestr", "4");
        employeeDetails23.put("Prerequisite", "");
        employeeDetails23.put("Schedule", "Perşembe 22:00-24:00");

        JSONObject employeeObject23 = new JSONObject();
        employeeObject23.put("Course", employeeDetails23);

        //24 Employee
        JSONObject employeeDetails24 = new JSONObject();
        employeeDetails24.put("CourseName", "Electronics");
        employeeDetails24.put("CourseCode", "EE2032");
        employeeDetails24.put("Credit", "5");
        employeeDetails24.put("Lecturer", "Ahmet Unutulmaz");
        employeeDetails24.put("Semestr", "4");
        employeeDetails24.put("Prerequisite", "EE2031");
        employeeDetails24.put("Schedule", "Salı 13:00-15:00 Perşembe 14:00-15:00");

        JSONObject employeeObject24 = new JSONObject();
        employeeObject24.put("Course", employeeDetails24);

        //25 Employee
        JSONObject employeeDetails25 = new JSONObject();
        employeeDetails25.put("CourseName", "Systems Programming");
        employeeDetails25.put("CourseCode", "CSE2138");
        employeeDetails25.put("Credit", "7");
        employeeDetails25.put("Lecturer", "Fatma Corut Ergin");
        employeeDetails25.put("Semestr", "4");
        employeeDetails25.put("Prerequisite", "");
        employeeDetails25.put("Schedule", "Pazartesi 16:00-18:00 Cuma 14:00-15:00");

        JSONObject employeeObject25 = new JSONObject();
        employeeObject25.put("Course", employeeDetails25);

        //26 Employee Summer Practice

        //27 Employee
        JSONObject employeeDetails27 = new JSONObject();
        employeeDetails27.put("CourseName", "Database Systems");
        employeeDetails27.put("CourseCode", "CSE3055");
        employeeDetails27.put("Credit", "7");
        employeeDetails27.put("Lecturer", "Mustafa Ağaoğlu");
        employeeDetails27.put("Semestr", "5");
        employeeDetails27.put("Prerequisite", "CSE2025");
        employeeDetails27.put("Schedule", "Çarşamba 10:30-12:20 Cuma 15:00-16:00");

        JSONObject employeeObject27 = new JSONObject();
        employeeObject27.put("Course", employeeDetails27);

        //28 Employee
        JSONObject employeeDetails28 = new JSONObject();
        employeeDetails28.put("CourseName", "Operating Systems");
        employeeDetails28.put("CourseCode", "CSE3033");
        employeeDetails28.put("Credit", "7");
        employeeDetails28.put("Lecturer", "Ali Haydar Özer");
        employeeDetails28.put("Semestr", "5");
        employeeDetails28.put("Prerequisite", "CSE2025");
        employeeDetails28.put("Schedule", "Pazartesi 11:30-12:20 Cuma 10:30-12:20");

        JSONObject employeeObject28 = new JSONObject();
        employeeObject28.put("Course", employeeDetails28);

        //29 Employee
        JSONObject employeeDetails29 = new JSONObject();
        employeeDetails29.put("CourseName", "Object-Oriented Software Desg.");
        employeeDetails29.put("CourseCode", "CSE3033");
        employeeDetails29.put("Credit", "5");
        employeeDetails29.put("Lecturer", "Murat Can Ganiz");
        employeeDetails29.put("Semestr", "5");
        employeeDetails29.put("Prerequisite", "CSE1142");
        employeeDetails29.put("Schedule", "Pazartesi 09:30-11:20 Salı 09:30-10:20");


        JSONObject employeeObject29 = new JSONObject();
        employeeObject29.put("Course", employeeDetails29);

        //30 Employee
        JSONObject employeeDetails30 = new JSONObject();
        employeeDetails30.put("CourseName", "Digital Logic Design");
        employeeDetails30.put("CourseCode", "CSE3015");
        employeeDetails30.put("Credit", "7");
        employeeDetails30.put("Lecturer", "Betül Demiröz Boz");
        employeeDetails30.put("Semestr", "5");
        employeeDetails30.put("Prerequisite", "");
        employeeDetails30.put("Schedule", "Perşembe 14:00-16:00");

        JSONObject employeeObject30 = new JSONObject();
        employeeObject30.put("Course", employeeDetails30);

        //31 Employee
        JSONObject employeeDetails31 = new JSONObject();
        employeeDetails31.put("CourseName", "Modeling and Disc. Simulation");
        employeeDetails31.put("CourseCode", "IE3081");
        employeeDetails31.put("Credit", "4");
        employeeDetails31.put("Lecturer", "Müjdat Soytürk");
        employeeDetails31.put("Semestr", "5");
        employeeDetails31.put("Prerequisite", "STAT2053");
        employeeDetails31.put("Schedule", "Perşembe 10:30-12:20 Cuma 09:30-10:20");

        JSONObject employeeObject31 = new JSONObject();
        employeeObject31.put("Course", employeeDetails31);

        //32 Employee
        JSONObject employeeDetails32 = new JSONObject();
        employeeDetails32.put("CourseName", "Int. to Signals and Systems");
        employeeDetails32.put("CourseCode", "CSE3048");
        employeeDetails32.put("Credit", "5");
        employeeDetails32.put("Lecturer", "Mehmet Kadir Baran");
        employeeDetails32.put("Semestr", "6");
        employeeDetails32.put("Prerequisite", "MATH2055");
        employeeDetails32.put("Schedule", "Pazartesi 09:00-12:00 Salı 09:00-10:00");

        JSONObject employeeObject32 = new JSONObject();
        employeeObject32.put("Course", employeeDetails32);


        //33 Employee
        JSONObject employeeDetails33 = new JSONObject();
        employeeDetails33.put("CourseName", "Software Engineering");
        employeeDetails33.put("CourseCode", "CSE3044");
        employeeDetails33.put("Credit", "7");
        employeeDetails33.put("Lecturer", "Borahan Tümer");
        employeeDetails33.put("Semestr", "6");
        employeeDetails33.put("Prerequisite", "CSE3055");
        employeeDetails33.put("Schedule", "Salı 09:00-12:00 Cuma 09:00-10:00");

        JSONObject employeeObject33 = new JSONObject();
        employeeObject33.put("Course", employeeDetails33);


        //34 Employee
        JSONObject employeeDetails34 = new JSONObject();
        employeeDetails34.put("CourseName", "Formal Lang. & Auto. Theory");
        employeeDetails34.put("CourseCode", "CSE3064");
        employeeDetails34.put("Credit", "6");
        employeeDetails34.put("Lecturer", "Ali Haydar Özer");
        employeeDetails34.put("Semestr", "6");
        employeeDetails34.put("Prerequisite", "CSE2023");
        employeeDetails34.put("Schedule", "Çarşamba 09:00-12:00 Perşembe 09:00-10:00");

        JSONObject employeeObject34 = new JSONObject();
        employeeObject34.put("Course", employeeDetails34);

        //35 Employee
        JSONObject employeeDetails35 = new JSONObject();
        employeeDetails35.put("CourseName", "Computer Organization");
        employeeDetails35.put("CourseCode", "CSE3038");
        employeeDetails35.put("Credit", "7");
        employeeDetails35.put("Lecturer", "Haluk Rahmi Topçuoğlu");
        employeeDetails35.put("Semestr", "6");
        employeeDetails35.put("Prerequisite", "CSE2138");
        employeeDetails35.put("Schedule", "Salı 13:00-15:00 Cuma 16:00-17:00");

        JSONObject employeeObject35 = new JSONObject();
        employeeObject35.put("Course", employeeDetails35);

        //36 Employee
        JSONObject employeeDetails36 = new JSONObject();
        employeeDetails36.put("CourseName", "Operations Research");
        employeeDetails36.put("CourseCode", "IE3035");
        employeeDetails36.put("Credit", "5");
        employeeDetails36.put("Lecturer", "Ali Fuat Alkaya");
        employeeDetails36.put("Semestr", "6");
        employeeDetails36.put("Prerequisite", "MATH2056");
        employeeDetails36.put("Schedule", "Çarşamba 16:00-18:00 Perşembe 18:00-20:00");

        JSONObject employeeObject36 = new JSONObject();
        employeeObject36.put("Course", employeeDetails36);

        //37 Employee
        JSONObject employeeDetails37 = new JSONObject();
        employeeDetails37.put("CourseName", "Engineering Project 1");
        employeeDetails37.put("CourseCode", "CSE4197");
        employeeDetails37.put("Credit", "4");
        employeeDetails37.put("Lecturer", "");
        employeeDetails37.put("Semestr", "7");
        employeeDetails37.put("Prerequisite", "");
        employeeDetails37.put("Schedule", "Cumartesi 08:30-10:20");

        JSONObject employeeObject37 = new JSONObject();
        employeeObject37.put("Course", employeeDetails37);


        //38 Employee
        JSONObject employeeDetails38 = new JSONObject();
        employeeDetails38.put("CourseName", "Computer Networks");
        employeeDetails38.put("CourseCode", "CSE4074");
        employeeDetails38.put("Credit", "5");
        employeeDetails38.put("Lecturer", "Ömer Korçak");
        employeeDetails38.put("Semestr", "7");
        employeeDetails38.put("Prerequisite", "");
        employeeDetails38.put("Schedule", "Pazartesi 15:00-16:00 Perşembe 14:00-16:00");

        JSONObject employeeObject38 = new JSONObject();
        employeeObject38.put("Course", employeeDetails38);

        //39 Employee
        JSONObject employeeDetails39 = new JSONObject();
        employeeDetails39.put("CourseName", "Microprocessors");
        employeeDetails39.put("CourseCode", "CSE4117");
        employeeDetails39.put("Credit", "6");
        employeeDetails39.put("Lecturer", "Mehmet Kadir Baran");
        employeeDetails39.put("Semestr", "7");
        employeeDetails39.put("Prerequisite", "CSE3038");
        employeeDetails39.put("Schedule", "Pazartesi 16:00-18:00 Perşembe 13:00-14:00");

        JSONObject employeeObject39 = new JSONObject();
        employeeObject39.put("Course", employeeDetails39);

        //40 Employee
        JSONObject employeeDetails40 = new JSONObject();
        employeeDetails40.put("CourseName", "Work Safety 1");
        employeeDetails40.put("CourseCode", "ISG121");
        employeeDetails40.put("Credit", "2");
        employeeDetails40.put("Lecturer", "UZEM");
        employeeDetails40.put("Semestr", "7");
        employeeDetails40.put("Prerequisite", "");
        employeeDetails40.put("Schedule", "Cumartesi 13:00-15:00");

        JSONObject employeeObject40 = new JSONObject();
        employeeObject40.put("Course", employeeDetails40);


        //41 Employee Summer Practice

        //42 Employee
        JSONObject employeeDetails42 = new JSONObject();
        employeeDetails42.put("CourseName", "Engineering Project 2");
        employeeDetails42.put("CourseCode", "CSE4198");
        employeeDetails42.put("Credit", "5");
        employeeDetails42.put("Lecturer", "");
        employeeDetails42.put("Semestr", "8");
        employeeDetails42.put("Prerequisite", "CSE4197");
        employeeDetails42.put("Schedule", "Cumartesi 08:30-10:20");

        JSONObject employeeObject42 = new JSONObject();
        employeeObject42.put("Course", employeeDetails42);

        //43 Employee
        JSONObject employeeDetails43 = new JSONObject();
        employeeDetails43.put("CourseName", "Work Safety 2");
        employeeDetails43.put("CourseCode", "ISG122");
        employeeDetails43.put("Credit", "2");
        employeeDetails43.put("Lecturer", "UZEM");
        employeeDetails43.put("Semestr", "8");
        employeeDetails43.put("Prerequisite", "CSE4197");
        employeeDetails43.put("Schedule", "Cumartesi 13:00-15:00");

        JSONObject employeeObject43 = new JSONObject();
        employeeObject43.put("Course", employeeDetails43);

        //44 Employee
        JSONObject employeeDetails44 = new JSONObject();
        employeeDetails44.put("CourseName", "Nontechnical Elective 1");
        employeeDetails44.put("CourseCode", "NTEI");
        employeeDetails44.put("Credit", "3");
        employeeDetails44.put("Lecturer", "");
        employeeDetails44.put("Semestr", "2");
        employeeDetails44.put("Prerequisite", "");
        employeeDetails44.put("Schedule", "");
        employeeDetails44.put("Quota", "20");
        employeeDetails44.put("Selective", "false");

        JSONObject employeeObject44 = new JSONObject();
        employeeObject44.put("Course", employeeDetails44);

        //45 Employee
        JSONObject employeeDetails45 = new JSONObject();
        employeeDetails45.put("CourseName", "Nontechnical Elective 2");
        employeeDetails45.put("CourseCode", "NTE2");
        employeeDetails45.put("Credit", "3");
        employeeDetails45.put("Lecturer", "");
        employeeDetails45.put("Semestr", "3");
        employeeDetails45.put("Prerequisite", "");
        employeeDetails45.put("Schedule", "");
        employeeDetails45.put("Quota", "20");
        employeeDetails45.put("Selective", "false");

        JSONObject employeeObject45 = new JSONObject();
        employeeObject45.put("Course", employeeDetails45);

        //46 Employee
        JSONObject employeeDetails46 = new JSONObject();
        employeeDetails46.put("CourseName", "Nontechnical Elective 3");
        employeeDetails46.put("CourseCode", "NTE3");
        employeeDetails46.put("Credit", "3");
        employeeDetails46.put("Lecturer", "");
        employeeDetails46.put("Semestr", "8");
        employeeDetails46.put("Prerequisite", "");
        employeeDetails46.put("Schedule", "");
        employeeDetails46.put("Quota", "20");
        employeeDetails46.put("Selective", "false");

        JSONObject employeeObject46 = new JSONObject();
        employeeObject46.put("Course", employeeDetails46);

        //47 Employee
        JSONObject employeeDetails47 = new JSONObject();
        employeeDetails47.put("CourseName", "University Elective");
        employeeDetails47.put("CourseCode", "UE");
        employeeDetails47.put("Credit", "3");
        employeeDetails47.put("Lecturer", "");
        employeeDetails47.put("Semestr", "7");
        employeeDetails47.put("Prerequisite", "");
        employeeDetails47.put("Schedule", "");
        employeeDetails47.put("Quota", "20");
        employeeDetails47.put("Selective", "false");

        JSONObject employeeObject47 = new JSONObject();
        employeeObject47.put("Course", employeeDetails47);

        //48 Employee
        JSONObject employeeDetails48 = new JSONObject();
        employeeDetails48.put("CourseName", "Faculty Technical Elective");
        employeeDetails48.put("CourseCode", "FTE");
        employeeDetails48.put("Credit", "5");
        employeeDetails48.put("Lecturer", "");
        employeeDetails48.put("Semestr", "8");
        employeeDetails48.put("Prerequisite", "");
        employeeDetails48.put("Schedule", "");
        employeeDetails48.put("Quota", "20");
        employeeDetails48.put("Selective", "false");

        JSONObject employeeObject48 = new JSONObject();
        employeeObject48.put("Course", employeeDetails48);


        //49 Employee
        JSONObject employeeDetails49 = new JSONObject();
        employeeDetails49.put("CourseName", "Technical Elective I");
        employeeDetails49.put("CourseCode", "TE1");
        employeeDetails49.put("Credit", "5");
        employeeDetails49.put("Lecturer", "");
        employeeDetails49.put("Semestr", "7");
        employeeDetails49.put("Prerequisite", "");
        employeeDetails49.put("Schedule", "");
        employeeDetails49.put("Quota", "50");

        JSONObject employeeObject49 = new JSONObject();
        employeeObject49.put("Course", employeeDetails49);

        //50 Employee
        JSONObject employeeDetails50 = new JSONObject();
        employeeDetails50.put("CourseName", "Technical Elective 2");
        employeeDetails50.put("CourseCode", "TE2");
        employeeDetails50.put("Credit", "5");
        employeeDetails50.put("Lecturer", "");
        employeeDetails50.put("Semestr", "7");
        employeeDetails50.put("Prerequisite", "");
        employeeDetails50.put("Schedule", "");
        employeeDetails50.put("Quota", "50");

        JSONObject employeeObject50 = new JSONObject();
        employeeObject50.put("Course", employeeDetails50);

        //51 Employee
        JSONObject employeeDetails51 = new JSONObject();
        employeeDetails51.put("CourseName", "Technical Elective 3");
        employeeDetails51.put("CourseCode", "TE3");
        employeeDetails51.put("Credit", "5");
        employeeDetails51.put("Lecturer", "");
        employeeDetails51.put("Semestr", "8");
        employeeDetails51.put("Prerequisite", "");
        employeeDetails51.put("Schedule", "");
        employeeDetails51.put("Quota", "50");

        JSONObject employeeObject51 = new JSONObject();
        employeeObject51.put("Course", employeeDetails51);

        //52 Employee
        JSONObject employeeDetails52 = new JSONObject();
        employeeDetails52.put("CourseName", "Technical Elective 4");
        employeeDetails52.put("CourseCode", "TE4");
        employeeDetails52.put("Credit", "5");
        employeeDetails52.put("Lecturer", "");
        employeeDetails52.put("Semestr", "8");
        employeeDetails52.put("Prerequisite", "");
        employeeDetails52.put("Schedule", "");
        employeeDetails52.put("Quota", "50");

        JSONObject employeeObject52 = new JSONObject();
        employeeObject52.put("Course", employeeDetails52);

        //53 Employee
        JSONObject employeeDetails53 = new JSONObject();
        employeeDetails53.put("CourseName", "Technical Elective 5");
        employeeDetails53.put("CourseCode", "TE5");
        employeeDetails53.put("Credit", "5");
        employeeDetails53.put("Lecturer", "");
        employeeDetails53.put("Semestr", "8");
        employeeDetails53.put("Prerequisite", "");
        employeeDetails53.put("Schedule", "");
        employeeDetails53.put("Quota", "50");

        JSONObject employeeObject53 = new JSONObject();
        employeeObject53.put("Course", employeeDetails53);


        //54 Employee
        JSONObject employeeDetails54 = new JSONObject();
        employeeDetails54.put("CourseName", "The Culture of Radiation Safety");
        employeeDetails54.put("CourseCode", "NTE1003");
        employeeDetails54.put("Credit", "3");
        employeeDetails54.put("Lecturer", "Deniz Öner");
        employeeDetails54.put("Semestr", "0");
        employeeDetails54.put("Prerequisite", "");
        employeeDetails54.put("Schedule", "Salı 17:00-19:00");
        employeeDetails54.put("Quota", "20");
        employeeDetails54.put("Selective", "true");

        JSONObject employeeObject54 = new JSONObject();
        employeeObject54.put("Course", employeeDetails54);


        //55 Employee
        JSONObject employeeDetails55 = new JSONObject();
        employeeDetails55.put("CourseName", "Introduction to Strategic Human Resource");
        employeeDetails55.put("CourseCode", "NTE1014");
        employeeDetails55.put("Credit", "3");
        employeeDetails55.put("Lecturer", "Özlem Yılmaz");
        employeeDetails55.put("Semestr", "0");
        employeeDetails55.put("Prerequisite", "");
        employeeDetails55.put("Schedule", "Salı 10:30-12:20");
        employeeDetails55.put("Quota", "20");
        employeeDetails55.put("Selective", "true");

        JSONObject employeeObject55 = new JSONObject();
        employeeObject55.put("Course", employeeDetails55);


        //56 Employee
        JSONObject employeeDetails56 = new JSONObject();
        employeeDetails56.put("CourseName", "Introduction to Leadership and Management");
        employeeDetails56.put("CourseCode", "NTE1015");
        employeeDetails56.put("Credit", "3");
        employeeDetails56.put("Lecturer", "Özlem Yılmaz");
        employeeDetails56.put("Semestr", "0");
        employeeDetails56.put("Prerequisite", "");
        employeeDetails56.put("Schedule", "Salı 13:00-15:00");
        employeeDetails56.put("Quota", "20");
        employeeDetails56.put("Selective", "true");

        JSONObject employeeObject56 = new JSONObject();
        employeeObject56.put("Course", employeeDetails56);


        //57 Employee
        JSONObject employeeDetails57 = new JSONObject();
        employeeDetails57.put("CourseName", "Marketing in a Technology Driven World");
        employeeDetails57.put("CourseCode", "NTE1017");
        employeeDetails57.put("Credit", "3");
        employeeDetails57.put("Lecturer", "Caner Dilmener");
        employeeDetails57.put("Semestr", "0");
        employeeDetails57.put("Prerequisite", "");
        employeeDetails57.put("Schedule", "Çarşamba 13:00-15:00");
        employeeDetails57.put("Quota", "20");
        employeeDetails57.put("Selective", "true");

        JSONObject employeeObject57 = new JSONObject();
        employeeObject57.put("Course", employeeDetails57);

        //58 Employee
        JSONObject employeeDetails58 = new JSONObject();
        employeeDetails58.put("CourseName", "Introduction to Business World for Engineers");
        employeeDetails58.put("CourseCode", "NTE1018");
        employeeDetails58.put("Credit", "3");
        employeeDetails58.put("Lecturer", "Özlem Yılmaz");
        employeeDetails58.put("Semestr", "0");
        employeeDetails58.put("Prerequisite", "");
        employeeDetails58.put("Schedule", "Perşembe 13:00-15:00");
        employeeDetails58.put("Quota", "20");
        employeeDetails58.put("Selective", "true");

        JSONObject employeeObject58 = new JSONObject();
        employeeObject58.put("Course", employeeDetails58);

        //59 Employee
        JSONObject employeeDetails59 = new JSONObject();
        employeeDetails59.put("CourseName", "Introduction to Computer Genomics");
        employeeDetails59.put("CourseCode", "TE");
        employeeDetails59.put("Credit", "5");
        employeeDetails59.put("Lecturer", "Betül Demiröz Boz");
        employeeDetails59.put("Semestr", "7");
        employeeDetails59.put("Prerequisite", "");
        employeeDetails59.put("Schedule", "Salı 13:00-14:00 Çarşamba 13:00-15:00");
        employeeDetails59.put("Quota", "50");
        employeeDetails59.put("Selective", "true");


        JSONObject employeeObject59 = new JSONObject();
        employeeObject59.put("Course", employeeDetails59);

        //60 Employee
        JSONObject employeeDetails60 = new JSONObject();
        employeeDetails60.put("CourseName", "Mobile Device Programming");
        employeeDetails60.put("CourseCode", "TE");
        employeeDetails60.put("Credit", "5");
        employeeDetails60.put("Lecturer", "Ali Fuat Alkaya");
        employeeDetails60.put("Semestr", "7");
        employeeDetails60.put("Prerequisite", "");
        employeeDetails60.put("Schedule", "Çarşamba 10:30-12:20 Pazartesi 09:30-10:20");
        employeeDetails60.put("Quota", "50");
        employeeDetails60.put("Selective", "true");


        JSONObject employeeObject60 = new JSONObject();
        employeeObject60.put("Course", employeeDetails60);

        //61 Employee
        JSONObject employeeDetails61 = new JSONObject();
        employeeDetails61.put("CourseName", "Artificial Intelligence");
        employeeDetails61.put("CourseCode", "TE");
        employeeDetails61.put("Credit", "5");
        employeeDetails61.put("Lecturer", "Ali Haydar Özer");
        employeeDetails61.put("Semestr", "7");
        employeeDetails61.put("Prerequisite", "");
        employeeDetails61.put("Schedule", "Pazartesi 13:00-14:00 Çarşamba 16:00-18:00");
        employeeDetails61.put("Quota", "50");
        employeeDetails61.put("Selective", "true");


        JSONObject employeeObject61 = new JSONObject();
        employeeObject61.put("Course", employeeDetails61);

        //62 Employee
        JSONObject employeeDetails62 = new JSONObject();
        employeeDetails62.put("CourseName", "Machine Learning");
        employeeDetails62.put("CourseCode", "TE");
        employeeDetails62.put("Credit", "5");
        employeeDetails62.put("Lecturer", "Çiğdem Eroğlu Erdem");
        employeeDetails62.put("Semestr", "7");
        employeeDetails62.put("Prerequisite", "");
        employeeDetails62.put("Schedule", "Salı 10:30-12:20 Cuma 16:00-17:00");
        employeeDetails62.put("Quota", "50");
        employeeDetails62.put("Selective", "true");


        JSONObject employeeObject62 = new JSONObject();
        employeeObject62.put("Course", employeeDetails62);

        //63 Employee
        JSONObject employeeDetails63 = new JSONObject();
        employeeDetails63.put("CourseName", "Information System Security");
        employeeDetails63.put("CourseCode", "TE");
        employeeDetails63.put("Credit", "5");
        employeeDetails63.put("Lecturer", "Ömer Korçak");
        employeeDetails63.put("Semestr", "8");
        employeeDetails63.put("Prerequisite", "");
        employeeDetails63.put("Schedule", "Salı 13:00-14:00 Çarşamba 13:00-15:00");
        employeeDetails63.put("Quota", "50");
        employeeDetails63.put("Selective", "true");


        JSONObject employeeObject63 = new JSONObject();
        employeeObject63.put("Course", employeeDetails63);

        //64 Employee
        JSONObject employeeDetails64 = new JSONObject();
        employeeDetails64.put("CourseName", "Compiler Design");
        employeeDetails64.put("CourseCode", "TE");
        employeeDetails64.put("Credit", "5");
        employeeDetails64.put("Lecturer", "Betül Demiröz Boz");
        employeeDetails64.put("Semestr", "8");
        employeeDetails64.put("Prerequisite", "");
        employeeDetails64.put("Schedule", "Pazartesi 13:00-14:00 Çarşamba 16:00-18:00");
        employeeDetails64.put("Quota", "50");
        employeeDetails64.put("Selective", "true");


        JSONObject employeeObject64 = new JSONObject();
        employeeObject64.put("Course", employeeDetails64);

        //65 Employee
        JSONObject employeeDetails65 = new JSONObject();
        employeeDetails65.put("CourseName", "Wireless and Mobile Networks");
        employeeDetails65.put("CourseCode", "TE");
        employeeDetails65.put("Credit", "5");
        employeeDetails65.put("Lecturer", "Müjdat Soytürk");
        employeeDetails65.put("Semestr", "8");
        employeeDetails65.put("Prerequisite", "");
        employeeDetails65.put("Schedule", "Pazartesi 13:00-14:00 Çarşamba 16:00-18:00");
        employeeDetails65.put("Quota", "50");
        employeeDetails65.put("Selective", "true");


        JSONObject employeeObject65 = new JSONObject();
        employeeObject65.put("Course", employeeDetails65);

        //66 Employee
        JSONObject employeeDetails66 = new JSONObject();
        employeeDetails66.put("CourseName", "Advance Unix Programming");
        employeeDetails66.put("CourseCode", "TE");
        employeeDetails66.put("Credit", "5");
        employeeDetails66.put("Lecturer", "Sanem Arslan");
        employeeDetails66.put("Semestr", "8");
        employeeDetails66.put("Prerequisite", "");
        employeeDetails66.put("Schedule", "Çarşamba 13:00-14:00 Cuma 16:00-18:00");
        employeeDetails66.put("Quota", "50");
        employeeDetails66.put("Selective", "true");


        JSONObject employeeObject66 = new JSONObject();
        employeeObject66.put("Course", employeeDetails66);

        //67 Employee
        JSONObject employeeDetails67 = new JSONObject();
        employeeDetails67.put("CourseName", "Fundamentals of Data Mining");
        employeeDetails67.put("CourseCode", "TE");
        employeeDetails67.put("Credit", "5");
        employeeDetails67.put("Lecturer", "Mustafa Ağaoğlu");
        employeeDetails67.put("Semestr", "8");
        employeeDetails67.put("Prerequisite", "");
        employeeDetails67.put("Schedule", "Pazartesi 13:00-14:00 Salı 16:00-18:00");
        employeeDetails67.put("Quota", "50");
        employeeDetails67.put("Selective", "true");


        JSONObject employeeObject67 = new JSONObject();
        employeeObject67.put("Course", employeeDetails67);


        //68 Employee
        JSONObject employeeDetails68 = new JSONObject();
        employeeDetails68.put("CourseName", "Introduction to Career Development");
        employeeDetails68.put("CourseCode", "NTE1016");
        employeeDetails68.put("Credit", "3");
        employeeDetails68.put("Lecturer", "Hande Sinem Ergun");
        employeeDetails68.put("Semestr", "0");
        employeeDetails68.put("Prerequisite", "");
        employeeDetails68.put("Schedule", "Salı 8:30-10:30");
        employeeDetails68.put("Quota", "20");
        employeeDetails68.put("Selective", "true");

        JSONObject employeeObject68 = new JSONObject();
        employeeObject68.put("Course", employeeDetails68);








        //Add employees to list
        JSONArray lectureList = new JSONArray();
        lectureList.add(employeeObject);
        lectureList.add(employeeObject2);
        lectureList.add(employeeObject3);
        lectureList.add(employeeObject4);
        lectureList.add(employeeObject5);
        lectureList.add(employeeObject6);
        lectureList.add(employeeObject7);
        lectureList.add(employeeObject8);
        lectureList.add(employeeObject9);
        lectureList.add(employeeObject10);
        lectureList.add(employeeObject11);
        lectureList.add(employeeObject12);
        lectureList.add(employeeObject13);
        lectureList.add(employeeObject14);
        lectureList.add(employeeObject15);
        lectureList.add(employeeObject16);
        lectureList.add(employeeObject17);
        lectureList.add(employeeObject18);
        lectureList.add(employeeObject19);
        lectureList.add(employeeObject20);
        lectureList.add(employeeObject21);
        lectureList.add(employeeObject22);
        lectureList.add(employeeObject23);
        lectureList.add(employeeObject24);
        lectureList.add(employeeObject25);
        lectureList.add(employeeObject27);
        lectureList.add(employeeObject28);
        lectureList.add(employeeObject29);
        lectureList.add(employeeObject30);
        lectureList.add(employeeObject31);
        lectureList.add(employeeObject32);
        lectureList.add(employeeObject33);
        lectureList.add(employeeObject34);
        lectureList.add(employeeObject35);
        lectureList.add(employeeObject36);
        lectureList.add(employeeObject37);
        lectureList.add(employeeObject38);
        lectureList.add(employeeObject39);
        lectureList.add(employeeObject40);
        lectureList.add(employeeObject42);
        lectureList.add(employeeObject43);
        lectureList.add(employeeObject44);
        lectureList.add(employeeObject45);
        lectureList.add(employeeObject46);
        lectureList.add(employeeObject47);
        lectureList.add(employeeObject48);
        lectureList.add(employeeObject49);
        lectureList.add(employeeObject50);
        lectureList.add(employeeObject51);
        lectureList.add(employeeObject52);
        lectureList.add(employeeObject53);
        lectureList.add(employeeObject54);
        lectureList.add(employeeObject68);
        lectureList.add(employeeObject56);
        lectureList.add(employeeObject57);
        lectureList.add(employeeObject58);
        lectureList.add(employeeObject59);
        lectureList.add(employeeObject60);
        lectureList.add(employeeObject61);
        lectureList.add(employeeObject62);
        lectureList.add(employeeObject63);
        lectureList.add(employeeObject64);
        lectureList.add(employeeObject65);
        lectureList.add(employeeObject66);
        lectureList.add(employeeObject68);

        //Write JSON file
        try (FileWriter file = new FileWriter("courses.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(lectureList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
