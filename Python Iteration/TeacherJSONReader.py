import json
import traceback

from Teacher import Teacher


class TeacherJSONReader:

    def readJson(self):
        teacherList  = list()
        try:
            f = open('teachers.json')
            data = json.load(f)

            for i in data:
                teacher = self.createTeacher(i, data[i])
                self.addTeacherToTeacherList(teacher, teacherList)
            return teacherList
            f.close()
        except FileNotFoundError:
            traceback.print_exc()
        except IOError:
            traceback.print_exc()

    def createTeacher(self, id, name):
        return  Teacher(name,id)

    def addTeacherToTeacherList(self, teacher, teacherList):
        teacherList.append(teacher)

if __name__ == "__main__":
    tc = TeacherJSONReader()
    teacherlistesi = tc.readJson()