import unittest

from Course import Course
from NE import NE
from Student import Student


class TestRegisterMethods(unittest.TestCase):

    def test_overlapping(self):
        student = Student("sena", None, ["Murat Can Ganiz"], True)
        student.transcript[0].append(Course("math", None, None, None, "Salı 08:30-10:20 Perşembe 08:30-10:20", 0, None))
        student.transcript[0].append(
            Course("chem", None, None, None, "Pazartesi 09:00-11:00 Cuma 09:00-11:00", 0, None))

        course = Course("tr", None, None, None, "Pazartesi 09:00-11:00 Cuma 09:00-11:00", 0, None)
        register = course.register(student, 0)
        self.assertEqual(register, False)

    def test_registerInCourse(self):
        student = Student("sena", None, ["Murat Can Ganiz"], True)
        student.credit_completed = 150
        student.transcript[0].append(Course("math", None, None, None, "Salı 08:30-10:20 Perşembe 08:30-10:20", 0, None))
        course = Course("tr", "CSE4197", None, None, "Pazartesi 09:00-11:00 Cuma 09:00-11:00", 0, None)
        register = course.register(student, 0)
        self.assertEqual(register, True)

    def test_checkQuota(self):
        student = Student("sena", None, ["Murat Can Ganiz"], True)
        student.credit_completed = 150
        student.transcript[0].append(Course("math", None, None, None, "Salı 08:30-10:20 Perşembe 08:30-10:20", 0, None))
        ne = NE("tr", None, None, None, 0, "Pazartesi 09:00-11:00 Cuma 09:00-11:00", 20)
        ne.registered_students = [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]]
        register = ne.register(student, 0)
        self.assertEqual(register, False)


if __name__ == '__main__':
    unittest.main()
