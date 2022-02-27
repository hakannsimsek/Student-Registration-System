import copy
import math
from random import random, randrange
import random


class Student():

    def __init__(self, name, id, teacherList, isFall, department="Computer Engineering"):
        self.name = name
        self.id = id
        self.department = "Computer Engineering"
        self.transcript = [[], [], [], [], [], [], [], []]
        self.advisor = teacherList[randrange(len(teacherList))]
        self.credit_completed = 0
        self.success_rate = round(random.uniform(0.6, 1), 2)
        self.failed_courses = []
        randomNumber = randrange(4)
        if isFall == True:
            self.semester = randomNumber * 2 + 1
        else:
            self.semester = randomNumber * 2 + 2

    #__advisor, __credit_completed, __success_rate, __failed_courses, __semester, __department, __id,__name







    def assign_semester(self, current_semester, course_list, isTE):
        if isTE:
            current_semester -= 7
        for lecture in course_list[current_semester]:
            students_lecture = copy.deepcopy(lecture)
            if self.check_prerequisite(students_lecture):
                is_passed = self.if_passed()
                setattr(students_lecture, "passed", is_passed)
                if students_lecture.register(self, current_semester):
                    if is_passed:
                        self.credit_completed += int(getattr(students_lecture, "credit"))
                    else:
                        self.failed_courses.append(students_lecture)

        """i = 0
        while i < current_semester:
            if(i%2 != current_semester%2):
                i+=1
                continue
            semester = self.transcript[i]
            for lec in semester:
                if lec.passed == False:
                    new_lect = copy.deepcopy(lec)
                    setattr(new_lect,"passed",True)
                    self.transcript[current_semester].append(new_lect)

            i += 1"""

    def if_passed(self):
        if round(random.uniform(0, 1), 2) < self.success_rate:
            return True
        else:
            return False

    def try_to_take(self, lecture):
        # eger
        if getattr(lecture, "passed") == False:
            self.check_prerequisite(lecture)

    def check_prerequisite(self, lecture):
        prereq = getattr(lecture, "prerequisite")
        if prereq == "":
            return True
        ever_passed = False
        for semester in self.transcript:
            for lect in semester:
                if prereq == getattr(lect, "code"):
                    if lect.passed:
                        return True
                    # bulucak ve true,
        return False

    def check_if_fits_semester(self, current_semester, lecture):
        if int(lecture.semester) % 2 == current_semester % 2:
            return True
        return False

    def assign_nte_lecture(self, nte_list, semester):
        lecture = None
        for i in nte_list:
            lectr_semester = getattr(i, "semester")
            if int(lectr_semester) == semester:
                # self.transcript[semester].append(i)
                i.register(self, semester)
                # regsiter
                return

    def assign_grade(self):
        for semester in self.transcript:
            for lecture in semester:
                if lecture.passed == True:
                    rand = math.floor(random.random() * 5)
                    if rand == 0:
                        setattr(lecture, "grade", "AA")
                    elif rand == 1:
                        setattr(lecture, "grade", "BA")
                    elif rand == 2:
                        setattr(lecture, "grade", "BB")
                    elif rand == 3:
                        setattr(lecture, "grade", "CB")
                    elif rand == 4:
                        setattr(lecture, "grade", "CC")
                else:
                    rand = math.floor(random.random() * 2)
                    if rand == 0:
                        setattr(lecture, "grade", "FF")
                    elif rand == 1:
                        setattr(lecture, "grade", "FG")

    def modify_transcipt(self, course_list, non_technical_list, technical_list):
        current_semester = 0
        print(f"\n{self.name}, {self.semester} ")
        while current_semester < self.semester:
            print(f"current: {current_semester}")
            self.assign_semester(current_semester, course_list, False)
            if current_semester > 6:
                ##assign te courses
                self.assign_semester(current_semester, technical_list, True)
            if current_semester in [2, 3, 7, 8]:
                self.assign_nte_lecture(non_technical_list, current_semester)

            for lec in self.transcript[current_semester]:
                print(f"| {lec.name},{lec.passed} |", end="")
            current_semester += 1
        self.give_failed()

    def give_failed(self):
        for lecture in self.failed_courses:
            new = copy.deepcopy(lecture)
            setattr(new, "passed", True)
            if self.semester > new.semester + 2:
                self.transcript[new.semester + 2].append(new)
            self.failed_courses.remove(lecture)
