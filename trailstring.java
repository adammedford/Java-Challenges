import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//There are two strings: A and B. Print 1 if string B occurs at the end of string A. Otherwise, print 0.
public class Main {
        public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
        final int index = line.indexOf(",");
        if (line.substring(0, index).endsWith(line.substring(index+1, line.length())))
        System.out.println("1");
        else System.out.println("0");
    }
}
}