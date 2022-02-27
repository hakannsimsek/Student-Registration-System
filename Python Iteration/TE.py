import sys

from Lecture import Lecture


class TE(Lecture):

    def __init__(self, name, code, credit, lecturer, semester, prerequisite, schedule, quota, grade=None):
        Lecture.__init__(self, name, code, lecturer, credit, schedule, semester, grade)
        self.prerequisite = prerequisite
        self.quota = quota





    def register(self, student, semester):
        if not super(TE, self).register(student, semester):
            return False
        if getattr(student, "credit_completed") < 155:
            print(f"Student {student.name} cannot registered {self.name} beacuse credit completed is less than 155 ", file=sys.stderr)
            return False

        if int(self.quota) < len(self.registered_students[semester]):
            print(f"Student {student.name} cannot registered due to quota {self.name} ", file=sys.stderr)
            return False

        self.registered_students[semester].append(student)
        student.transcript[semester].append(self)
        return True
