import json
import traceback
from random import randrange
import random

from Student import Student
from TeacherJSONReader import TeacherJSONReader


class StudentJSONReader:

    def readJson(self, teacherList, isFall):
        studentList = []
        try:
            f = open('students.json')
            data = json.load(f)

            for i in data:
                #name, id, teacherList, isFall):
                print(i)
                print(data[i])
                student = Student(data[i], i, teacherList, isFall, "Computer Engineering")
                self.addStudentToStudentList(student, studentList)
            return studentList
            f.close()
        except FileNotFoundError:
            traceback.print_exc()
        except IOError:
            traceback.print_exc()

        return studentList



    def addStudentToStudentList(self, student, studentList):
        studentList.append(student)


if __name__ == "__main__":
    tc = TeacherJSONReader()
    teacherlistesi = tc.readJson()
    c = StudentJSONReader()
    studentlisteis = c.readJson(teacherlistesi, True)
    print("a")
    print("a")