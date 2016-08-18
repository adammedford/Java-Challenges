import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


//You are given 3 coins of value 1, 3 and 5. You are also given a total which you have to arrive at. Find the minimum number of coins to arrive at it.
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
                int a = Integer.parseInt(line);
                int count = a / 5;
                count += (a % 5) / 3;
                count += (a % 5) % 3;
                System.out.println(count);
                }
        }
}