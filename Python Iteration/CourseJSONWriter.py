import json

if __name__ == "__main__":
    data = {
        'employees': [
            {
                'CourseName': 'Calculus 1',
                'CourseCode': 'MATH1001',
                'Credit': '6',
                'Lecturer': 'Mustafa Cem Çelik',
                'Semestr': '1',
                'Prerequisite': '',
                'Schedule': 'Salı 08:30-10:20 Perşembe 08:30-10:20'
            },
            {
                "CourseName": "Basic Chemistry",
                "CourseCode": "CHEM1007",
                "Credit": "6",
                "Lecturer": "Kimyacı",
                "Semestr": "1",
                "Prerequisite": "",
                "Schedule": "Pazartesi 09:00-11:00 Cuma 09:00-11:00"
            },
            {
                "CourseName": "Computer Programming 1",
                "CourseCode": "CSE1141",
                "Credit": "6",
                "Lecturer": "Sanem Arslan",
                "Semestr": "1",
                "Prerequisite": "",
                "Schedule": "Pazartesi 10:30-11:20 Çarşamba 14:00-15:00"
            },
            {
                "CourseName": "Physics 1",
                "CourseCode": "PHYS1101",
                "Credit": "4",
                "Lecturer": "Mustafa Alevli",
                "Semestr": "1",
                "Prerequisite": "",
                "Schedule": "Salı 15:00-16:00 Perşembe 14:00-16:00"
            },
            {
                "CourseName": "Physics Lab 1",
                "CourseCode": "PHYS1103",
                "Credit": "2",
                "Lecturer": "Mustafa Alevli",
                "Semestr": "1",
                "Prerequisite": "",
                "Schedule": "Pazartesi 08:30-10:20"
            },
            {
                "CourseName": "Atatürk's Prin. & History 1",
                "CourseCode": "ATA121",
                "Credit": "2",
                "Lecturer": "UZEM",
                "Semestr": "1",
                "Prerequisite": "",
                "Schedule": "Salı 22:00-23:50"
            },
            {
                "CourseName": "Introduction to Computer Engineering",
                "CourseCode": "CSE1100",
                "Credit": "2",
                "Lecturer": "Fatma Corut Ergin",
                "Semestr": "1",
                "Prerequisite": "",
                "Schedule": "Çarşamba 13:00-14:00 Cuma 09:30-11:20",

            },
            {
                "CourseName": "Turkish Language 1",
                "CourseCode": "TRD121",
                "Credit": "2",
                "Lecturer": "UZEM",
                "Semestr": "1",
                "Prerequisite": "",
                "Schedule": "Pazar 15:00-17:00"
            },
            {
                "CourseName": "Calculus 2",
                "CourseCode": "MATH1002",
                "Credit": "6",
                "Lecturer": "Mustafa Cem Çelik",
                "Semestr": "2",
                "Prerequisite": "",
                "Schedule": "Salı 17:00-19:00 Perşembe 17:00-19:00"

            },
            {
                "CourseName": "Physics Lab 2",
                "CourseCode": "PHYS1104",
                "Credit": "2",
                "Lecturer": "Mustafa Alevli",
                "Semestr": "2",
                "Prerequisite": "",
                "Schedule": "Cumartesi 10:00-12:00"

            },
            {
                "CourseName": "Computer Programming 2",
                "CourseCode": "CSE1142",
                "Credit": "7",
                "Lecturer": "Sanem Arslan",
                "Semestr": "2",
                "Prerequisite": "CSE1141",
                "Schedule": "Pazartesi 15:00-16:00 Çarşamba 16:00-18:00"

            },
            {
                "CourseName": "Physics 2",
                "CourseCode": "PHYS1102",
                "Credit": "4",
                "Lecturer": "Mustafa Alevli",
                "Semestr": "2",
                "Prerequisite": "",
                "Schedule": "Pazartesi 13:00-16:00"
            },
            {
                "CourseName": "Atatürk's Prin. & History 2",
                "CourseCode": "ATA122",
                "Credit": "2",
                "Lecturer": "UZEM",
                "Semestr": "2",
                "Prerequisite": "",
                "Schedule": "Cuma 22:00-23:50"

            },
            {
                "CourseName": "Linear Algebra",
                "CourseCode": "MATH2056",
                "Credit": "4",
                "Lecturer": "Taylan Şengül",
                "Semestr": "2",
                "Prerequisite": "",
                "Schedule": "Pazartesi 16:00-18:00 Perşembe 16:00-18:00"

            },
            {
                "CourseName": "Turkish Language 2",
                "CourseCode": "TRD122",
                "Credit": "2",
                "Lecturer": "UZEM",
                "Semestr": "2",
                "Prerequisite": "",
                "Schedule": "Pazar 15:00-17:00"

            },
            {
                "CourseName": "Differential Equations",
                "CourseCode": "MATH2055",
                "Credit": "4",
                "Lecturer": "Mustafa Cem Çelik",
                "Semestr": "3",
                "Prerequisite": "MATH1001",
                "Schedule": "Pazartesi 09:30-10:20 Çarşamba 08:30-10:20"

            },
            {
                "CourseName": "Data Structures",
                "CourseCode": "CSE2025",
                "Credit": "8",
                "Lecturer": "Borahan Tümer",
                "Semestr": "3",
                "Prerequisite": "CSE1142",
                "Schedule": "Pazartesi 15:00-16:00 Çarşamba 14:00-16:00"

            },
            {
                "CourseName": "Discrete Comp. Structures",
                "CourseCode": "CSE2023",
                "Credit": "6",
                "Lecturer": "Ali Fuat Alkaya",
                "Semestr": "3",
                "Prerequisite": "",
                "Schedule": "Pazartesi 13:00-15:00 Çarşamba 16:00-17:00"

            },
            {
                "CourseName": "Electric Circuits",
                "CourseCode": "EE2031",
                "Credit": "5",
                "Lecturer": "Fulya Çallıalp",
                "Semestr": "3",
                "Prerequisite": "",
                "Schedule": "Salı 13:00-15:00 Perşembe 14:00-15:00"

            },
            {
                "CourseName": "Introduction to Economics",
                "CourseCode": "ECON2003",
                "Credit": "4",
                "Lecturer": "Eren Geyhan",
                "Semestr": "3",
                "Prerequisite": "",
                "Schedule": "Perşembe 22:00-23:50",

            },
            {
                "CourseName": "Numerical Methods",
                "CourseCode": "MATH2059",
                "Credit": "4",
                "Lecturer": "Çiğdem Eroğlu Erdem",
                "Semestr": "4",
                "Prerequisite": "MATH1001",
                "Schedule": "Salı 15:00-17:00 Perşembe 15:00-16:00"

            },
            {
                "CourseName": "Analysis of Algorithms",
                "CourseCode": "CSE2046",
                "Credit": "6",
                "Lecturer": "Ömer Korçak",
                "Semestr": "4",
                "Prerequisite": "CSE2025",
                "Schedule": "Pazartesi 15:00-16:00 Çarşamba 14:00-16:00"

            },
            {
                "CourseName": "Engineering Economy",
                "CourseCode": "ECON2004",
                "Credit": "4",
                "Lecturer": "Eren Geyhan",
                "Semestr": "4",
                "Prerequisite": "",
                "Schedule": "Perşembe 22:00-24:00"

            },
            {
                "CourseName": "Electronics",
                "CourseCode": "EE2032",
                "Credit": "5",
                "Lecturer": "Ahmet Unutulmaz",
                "Semestr": "4",
                "Prerequisite": "EE2031",
                "Schedule": "Salı 13:00-15:00 Perşembe 14:00-15:00"

            },
            {
                "CourseName": "Systems Programming",
                "CourseCode": "CSE2138",
                "Credit": "7",
                "Lecturer": "Fatma Corut Ergin",
                "Semestr": "4",
                "Prerequisite": "",
                "Schedule": "Pazartesi 16:00-18:00 Cuma 14:00-15:00"

            },
            {
                "CourseName": "Database Systems",
                "CourseCode": "CSE3055",
                "Credit": "7",
                "Lecturer": "Mustafa Ağaoğlu",
                "Semestr": "5",
                "Prerequisite": "CSE2025",
                "Schedule": "Çarşamba 10:30-12:20 Cuma 15:00-16:00"

            }, {
                "CourseName": "Operating Systems",
                "CourseCode": "CSE3033",
                "Credit": "7",
                "Lecturer": "Ali Haydar Özer",
                "Semestr": "5",
                "Prerequisite": "CSE2025",
                "Schedule": "Pazartesi 11:30-12:20 Cuma 10:30-12:20"
            }, {
                "CourseName": "Object-Oriented Software Desg.",
                "CourseCode": "CSE3033",
                "Credit": "5",
                "Lecturer": "Murat Can Ganiz",
                "Semestr": "5",
                "Prerequisite": "CSE1142",
                "Schedule": "Pazartesi 09:30-11:20 Salı 09:30-10:20"

            }, {
                "CourseName": "Digital Logic Design",
                "CourseCode": "CSE3015",
                "Credit": "7",
                "Lecturer": "Betül Demiröz Boz",
                "Semestr": "5",
                "Prerequisite": "",
                "Schedule": "Perşembe 14:00-16:00"

            }, {
                "CourseName": "Modeling and Disc. Simulation",
                "CourseCode": "IE3081",
                "Credit": "4",
                "Lecturer": "Müjdat Soytürk",
                "Semestr": "5",
                "Prerequisite": "STAT2053",
                "Schedule": "Perşembe 10:30-12:20 Cuma 09:30-10:20"

            }, {
                "CourseName": "Int. to Signals and Systems",
                "CourseCode": "CSE3048",
                "Credit": "5",
                "Lecturer": "Mehmet Kadir Baran",
                "Semestr": "6",
                "Prerequisite": "MATH2055",
                "Schedule": "Pazartesi 09:00-12:00 Salı 09:00-10:00"

            }, {
                "CourseName": "Software Engineering",
                "CourseCode": "CSE3044",
                "Credit": "7",
                "Lecturer": "Borahan Tümer",
                "Semestr": "6",
                "Prerequisite": "CSE3055",
                "Schedule": "Salı 09:00-12:00 Cuma 09:00-10:00"

            }, {
                "CourseName": "Formal Lang. & Auto. Theory",
                "CourseCode": "CSE3064",
                "Credit": "6",
                "Lecturer": "Ali Haydar Özer",
                "Semestr": "6",
                "Prerequisite": "CSE2023",
                "Schedule": "Çarşamba 09:00-12:00 Perşembe 09:00-10:00"

            }, {
                "CourseName": "Computer Organization",
                "CourseCode": "CSE3038",
                "Credit": "7",
                "Lecturer": "Haluk Rahmi Topçuoğlu",
                "Semestr": "6",
                "Prerequisite": "CSE2138",
                "Schedule": "Salı 13:00-15:00 Cuma 16:00-17:00"

            }, {
                "CourseName": "Operations Research",
                "CourseCode": "IE3035",
                "Credit": "5",
                "Lecturer": "Ali Fuat Alkaya",
                "Semestr": "6",
                "Prerequisite": "MATH2056",
                "Schedule": "Çarşamba 16:00-18:00 Perşembe 18:00-20:00"

            }, {
                "CourseName": "Engineering Project 1",
                "CourseCode": "CSE4197",
                "Credit": "4",
                "Lecturer": "",
                "Semestr": "7",
                "Prerequisite": "",
                "Schedule": "Cumartesi 08:30-10:20"

            }, {
                "CourseName": "Computer Networks",
                "CourseCode": "CSE4074",
                "Credit": "5",
                "Lecturer": "Ömer Korçak",
                "Semestr": "7",
                "Prerequisite": "",
                "Schedule": "Pazartesi 15:00-16:00 Perşembe 14:00-16:00"

            }, {
                "CourseName": "Microprocessors",
                "CourseCode": "CSE4117",
                "Credit": "6",
                "Lecturer": "Mehmet Kadir Baran",
                "Semestr": "7",
                "Prerequisite": "CSE3038",
                "Schedule": "Pazartesi 16:00-18:00 Perşembe 13:00-14:00"

            }, {
                "CourseName": "Work Safety 1",
                "CourseCode": "ISG121",
                "Credit": "2",
                "Lecturer": "UZEM",
                "Semestr": "7",
                "Prerequisite": "",
                "Schedule": "Cumartesi 13:00-15:00"

            }, {
                "CourseName": "Engineering Project 2",
                "CourseCode": "CSE4198",
                "Credit": "5",
                "Lecturer": "",
                "Semestr": "8",
                "Prerequisite": "CSE4197",
                "Schedule": "Cumartesi 08:30-10:20"

            }, {
                "CourseName": "Work Safety 2",
                "CourseCode": "ISG122",
                "Credit": "2",
                "Lecturer": "UZEM",
                "Semestr": "8",
                "Prerequisite": "CSE4197",
                "Schedule": "Cumartesi 13:00-15:00"

            }, {
                "CourseName": "The Culture of Radiation Safety",
                "CourseCode": "NTE1003",
                "Credit": "3",
                "Lecturer": "Deniz Öner",
                "Semestr": "2",
                "Prerequisite": "",
                "Schedule": "Salı 17:00-19:00",
                "Quota": "20"

            }, {
                "CourseName": "Introduction to Strategic Human Resource",
                "CourseCode": "NTE1014",
                "Credit": "3",
                "Lecturer": "Özlem Yılmaz",
                "Semestr": "3",
                "Prerequisite": "",
                "Schedule": "Salı 10:30-12:20",
                "Quota": "20"

            }, {
                "CourseName": "Introduction to Leadership and Management",
                "CourseCode": "NTE1015",
                "Credit": "3",
                "Lecturer": "Özlem Yılmaz",
                "Semestr": "7",
                "Prerequisite": "",
                "Schedule": "Salı 13:00-15:00",
                "Quota": "20"

            }, {
                "CourseName": "Marketing in a Technology Driven World",
                "CourseCode": "NTE1017",
                "Credit": "3",
                "Lecturer": "Caner Dilmener",
                "Semestr": "8",
                "Prerequisite": "",
                "Schedule": "Çarşamba 13:00-15:00",
                "Quota": "20"

            }, {
                "CourseName": "Introduction to Business World for Engineers",
                "CourseCode": "FTE1018",
                "Credit": "5",
                "Lecturer": "Özlem Yılmaz",
                "Semestr": "8",
                "Prerequisite": "",
                "Schedule": "Perşembe 13:00-15:00",
                "Quota": "20"

            }, {
                "CourseName": "Introduction to Computer Genomics",
                "CourseCode": "TE",
                "Credit": "5",
                "Lecturer": "Betül Demiröz Boz",
                "Semestr": "7",
                "Prerequisite": "",
                "Schedule": "Salı 13:00-14:00 Çarşamba 13:00-15:00",
                "Quota": "50"

            }, {
                "CourseName": "Mobile Device Programming",
                "CourseCode": "TE",
                "Credit": "5",
                "Lecturer": "Ali Fuat Alkaya",
                "Semestr": "7",
                "Prerequisite": "",
                "Schedule": "Çarşamba 10:30-12:20 Pazartesi 09:30-10:20",
                "Quota": "50"

            }, {
                "CourseName": "Artificial Intelligence",
                "CourseCode": "TE",
                "Credit": "5",
                "Lecturer": "Ali Haydar Özer",
                "Semestr": "8",
                "Prerequisite": "",
                "Schedule": "Pazartesi 13:00-14:00 Çarşamba 16:00-18:00",
                "Quota": "50"

            }, {
                "CourseName": "Information System Security",
                "CourseCode": "TE",
                "Credit": "5",
                "Lecturer": "Ömer Korçak",
                "Semestr": "8",
                "Prerequisite": "",
                "Schedule": "Salı 13:00-14:00 Çarşamba 13:00-15:00",
                "Quota": "50"

            }, {
                "CourseName": "Advance Unix Programming",
                "CourseCode": "TE",
                "Credit": "5",
                "Lecturer": "Sanem Arslan",
                "Semestr": "8",
                "Prerequisite": "",
                "Schedule": "Çarşamba 13:00-14:00 Cuma 16:00-18:00",
                "Quota": "50"
            }
        ]
    }

    json_string = json.dumps(data, indent=4)
    print(json_string)

    # Using a JSON string
    with open('courses.json', 'w') as outfile:
        outfile.write(json_string)