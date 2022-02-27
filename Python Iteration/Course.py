import sys

from Lecture import Lecture


class Course(Lecture):

    #               name   code,   lecturer, credit,schedule, semester, prerequisite
    def __init__(self, name, code, lecturer, credit, schedule, semester, prerequisite, grade=None):
        # name, code, lecturer, credit, schedule ,semester
        Lecture.__init__(self, name, code, lecturer, credit, schedule, semester, grade)
        self.prerequisite = prerequisite

    def register(self, student, semester):
        if not super(Course, self).register(student, semester):
            return False
        if str(self.code) == "CSE4197" or str(self.code) == "CSE4198":
            if getattr(student, "credit_completed") < 165:
                print(f"{student.name} cannot register {self.name} because total credit completed is less than 165 credits", file=sys.stderr)
                return False

        ##check collision by super's function(returns true,false)

        ## register succesfully
        self.registered_students[semester].append(student)
        student.transcript[semester].append(self)
        return True

    #name, code, lecturer, credit, schedule, semester, prerequisite, grade

