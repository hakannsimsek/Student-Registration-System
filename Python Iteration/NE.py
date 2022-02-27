import sys

from Lecture import Lecture


class NE(Lecture):

    def __init__(self, name, code, credit, lecturer, semester, schedule, quota, grade=None):
        Lecture.__init__(self, name, code, lecturer, credit, schedule, semester, grade)
        self.quota = quota


    def get_quota(self):
        return self.__quota

    def set_quota(self, input):
        self.__quota = input

    def register(self, student, semester):
        if not super(NE, self).register(student, semester):
            return False
        qo = len(self.registered_students[semester])
        if int(self.quota) <= len(self.registered_students[semester]):
            print(f"Student {student.name} cannot registered due to quota {self.name} ", file=sys.stderr)
            return False

        self.registered_students[semester].append(student)
        student.transcript[semester].append(self)
        return True
