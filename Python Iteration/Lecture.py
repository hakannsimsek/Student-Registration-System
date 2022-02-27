import sys
from abc import abstractmethod, ABC


class Lecture(ABC):

    def __init__(self, name, code, lecturer, credit, schedule, semester, grade=None):
        self.name = name
        self.code = code
        self.lecturer = lecturer
        self.credit = credit
        self.schedule = schedule
        self.semester = semester
        self.grade = grade
        self.passed = False
        self.registered_students = [[], [], [], [], [], [], [], []]

    @abstractmethod
    def register(self, student, semester):
        overlap = True
        studentsCourses = student.transcript[semester]
        days = self.parseDays(self.schedule)
        time = self.parseTime(self.schedule)
        for i in studentsCourses:
            days1 = self.parseDays(i.schedule)
            time1 = self.parseTime(i.schedule)
            if len(days) >= len(days1):
                overlap = self.checkOverlap(days1, days, time1, time)
            else:
                overlap = self.checkOverlap(days, days1, time, time1)
            if not overlap:
                print(f"Advisor didn't approve {self.name} because of a collision with { i.name} in schedule ", file=sys.stderr)
                return False
        return True

    def checkOverlap(self, smallSize, bigSize, time, time1):
        for i in range(len(smallSize)):
            for j in range(len(bigSize)):
                if smallSize[i] == bigSize[j]:
                    if self.isOverlapping([time[i], time1[j]]):
                        return False
        return True

    def parseDays(self, schedule):
        tokens = schedule.split()
        days = [tokens[i] for i in range(0, len(tokens), 2)]
        return days

    def parseTime(self, schedule):
        tokens = schedule.split()
        time = [tokens[i].split("-") for i in range(1, len(tokens), 2)]
        return time

    def isOverlapping(self, intervals):
        overlapping = [[x, y] for x in intervals for y in intervals if
                       x is not y and x[1] > y[0] > x[0] or x[0] == y[0] and x[1] == y[1] and x is not y]
        return not not overlapping
