import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


//Write a program which removes specific characters from a string.

//The first argument is a path to a file. The file contains the source strings and the characters that need to be scrubbed. 
//Each source string and characters you need to scrub are delimited by comma.
public class Main {
        public static void main(final String[] args) throws IOException {
                if (args.length < 1) {
                        throw new RuntimeException("Must specify input file path.");
                } else if (args.length > 1) {
                        throw new RuntimeException("Illegal input arguments specified.");
                }

                BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
            String line;
            while ((line = reader.readLine()) != null) {
            String[] values = line.split(",");
            String sent = values[0].trim();
            String removed = values[1].trim();
            for (int r = 0; r < removed.length(); r++)
            {
            sent = sent.replaceAll(removed.substring(r,r+1), "");
            }
            System.out.println(sent);
}
        }

    
}