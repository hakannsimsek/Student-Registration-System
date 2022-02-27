import json
import traceback



class Input:

    def __init__(self):
        pass

    def read_txt(self):
        try:
            f = open("input.txt", "r")
            data = f.readline()
            if data == "Fall":
                return True
            else:
                return False
        except FileNotFoundError:
            traceback.print_exc()
        except IOError:
            traceback.print_exc()


if __name__ == "__main__":
    tc = Input()
    data = tc.read_txt()
    print("")