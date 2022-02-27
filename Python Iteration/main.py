from Course import Course
from CourseJSONReader import CourseJSONReader
from Lecture import Lecture
from StudentJSONReader import StudentJSONReader
from TeacherJSONReader import TeacherJSONReader
import Input
import traceback


def read_txt():
    try:
        f = open("input.txt", "r")
        data = f.readline()
        if data == "Fall":
            return True
        else:
            return False
    except FileNotFoundError:
        traceback.print_exc()
    except IOError:
        traceback.print_exc()



if __name__ == "__main__":
    #name, code,lecturer, credit,schedule, semester, prerequisite

    isFall = read_txt()
    teacherList = TeacherJSONReader().readJson()
    studentList = StudentJSONReader().readJson(teacherList, isFall)
    course_list, nonTechnicalList, technicalList = CourseJSONReader().readJson()


    for student in studentList:
        student.modify_transcipt(course_list,nonTechnicalList,technicalList)
        student.assign_grade()

    for student in studentList:
        print(student.name)
        for semester in student.transcript:
            for lecture_taken in semester:
                print(f"{lecture_taken.name},{lecture_taken.grade} | ",end="")
            print("")

