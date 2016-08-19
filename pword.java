import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


//Write a program which finds the next-to-last word in a string.
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
                String[] split = line.split(" ");
                System.out.println(split[split.length - 2]);
                }
        }
}
