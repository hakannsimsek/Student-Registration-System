import json
import traceback

class StudentJSONWriter:

    def writeJson(self):

        student_data = {150117060: "Ahmet Hakan Şimşek", 150119706: "Sena Dilara Yangöz", 150117016: "Metehan Kurucu",
                        150118510: "Erdem Açıldı", 150117006: "Arda Yiğit Kaynar", 150118005: "Oğuzhan Karabudak",
                        150117025: "Mevlüt Eren Topal", 150119732: "Elif Gülay"}

        try:

            json_dump = json.dumps(student_data)

            jsonFile = open("students.json", "w")
            jsonFile.write(json_dump)
            jsonFile.close()

        except IOError:
            traceback.print_exc()

