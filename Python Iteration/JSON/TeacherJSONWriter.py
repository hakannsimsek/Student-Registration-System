import json
import traceback

class TeacherJSONWriter:

    def writeJson(self):

        teacher_data = {1: "Haluk Rahmi Topçuoğlu", 2: "Çiğdem Eroğlu Erdem", 3: "Ali Fuat Alkaya",
                        4: "Murat Can Ganiz", 5: "Müjdat Soytürk", 6:"Borahan Tümer", 7: "Mustafa Ağaoğlu",
                        8: "Mehmet Kadir Baran", 9: "Betül Demiröz Boz", 10: "Fatma Corut Ergin", 11:"Ömer Korçak",
                        12: "Ali Haydar Özer", 13: "Sanem Arslan"}


        try:
            json_dump = json.dumps(teacher_data)

            jsonFile = open("teachers.json", "w")
            jsonFile.write(json_dump)
            jsonFile.close()

        except IOError:
            traceback.print_exc()
