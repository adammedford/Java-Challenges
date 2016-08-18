import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//Write a program which finds the first non-repeated character in a string.
public class Main {
        public static void main(final String[] args) throws IOException {
                BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
        final int MAX = line.length();
        for (int i = 0; i < MAX; i++)
        {
            if (line.lastIndexOf(line.charAt(i)) == i)
            {
                System.out.println(line.charAt(i));
                break;
            }
        }
    }
    reader.close();
}
}