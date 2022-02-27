import json
import traceback

from Course import Course
from NE import NE
from TE import TE


class CourseJSONReader:

    def readJson(self):

        try:
            with open('courses.json') as json_file:
                data = json.load(json_file)['employees']
                technicalList= [[],[]]
                nonTechnicalList= []
                courseList = [[], [], [], [], [], [], [], []]

                for i in data:
                    """print(i["CourseName"])"""
                    """{
                        "CourseName": "Calculus 1",
                        "CourseCode": "MATH1001",
                        "Credit": "6",
                        "Lecturer": "Mustafa Cem \u00c7elik",
                        "Semestr": "1",
                        "Prerequisite": "",
                        "Schedule": "Sal\u0131 08:30-10:20 Per\u015fembe 08:30-10:20"
                    },"""
                    """print( i["CourseCode"])
                    print( i["CourseCode"].startswith("TE"))"""
                    if i["CourseCode"].startswith("TE"):
                        # name, code, credit,lecturer,semester, prerequisite, schedule,quota):

                        # name, code,lecturer, credit,schedule, semester, prerequisite
                        te_course = TE(i["CourseName"], i["CourseCode"], i["Credit"], i["Lecturer"], i["Semestr"], i["Prerequisite"], i["Schedule"], i["Quota"])

                        if int(te_course.semester)==7:
                            technicalList[0].append(te_course)
                        else:
                            technicalList[1].append(te_course)


                    elif i["CourseCode"].startswith("NTE"):
                        """{
                            "CourseName": "The Culture of Radiation Safety",
                            "CourseCode": "NTE1003",
                            "Credit": "3",
                            "Lecturer": "Deniz \u00d6ner",
                            "Semestr": "2",
                            "Prerequisite": "",
                            "Schedule": "Sal\u0131 17:00-19:00",
                            "Quota": "20"
                        },"""


                        nte_course = NE(i["CourseName"], i["CourseCode"], i["Credit"], i["Lecturer"], i["Semestr"], i["Schedule"], i["Quota"])
                        nonTechnicalList.append(nte_course)
                    else:

                        """{
                            "CourseName": "Calculus 1",
                            "CourseCode": "MATH1001",
                            "Credit": "6",
                            "Lecturer": "Mustafa Cem \u00c7elik",
                            "Semestr": "1",
                            "Prerequisite": "",
                            "Schedule": "Sal\u0131 08:30-10:20 Per\u015fembe 08:30-10:20"
                        },"""


                        semester = int(i["Semestr"])-1
                        #                   name,           code,           lecturer,      credit,      schedule, semester,     prerequisite
                        course = Course(i["CourseName"], i["CourseCode"],i["Lecturer"], i["Credit"], i["Schedule"],semester, i["Prerequisite"] )
                        if course.code in ["CSE1141","CSE1142","CSE1142"]:
                            course.passed = True
                        courseList[semester].append(course)


            return courseList,nonTechnicalList,technicalList


        except FileNotFoundError:
            traceback.print_exc()
        except IOError:
            traceback.print_exc()


