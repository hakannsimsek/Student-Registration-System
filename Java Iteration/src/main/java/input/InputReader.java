package input;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class InputReader {

    public String takeSemesterInput()  {

        try {
            int ch;

            // check if File exists or not
            FileReader fr=null;
            try
            {
                fr = new FileReader("input.txt");
            }
            catch (FileNotFoundException fe)
            {
                System.out.println("File not found");
            }

            // read from FileReader till the end of file
            while ((ch=fr.read())!=-1)
                System.out.print((char)ch);

            // close the file
            fr.close();


        } catch (Exception e){
            System.out.println("input file bot found");
        }

    return "Fall";
    }

}
