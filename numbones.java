import java.io.*;
import java.util.*;

//Write a program which determines the number of 1 bits in the internal representation of a given integer.
//Print to stdout the number of ones in the binary form of each number.
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) {
                continue;
            }
            int n = Integer.parseInt(line);
            int numberOfOnes = countBits(n);
            System.out.println(numberOfOnes);
        }

        reader.close();
    }

    public static int countBits(int n)
    {
        int count = 0;
        while (n != 0) {
            int lastBit = n & 0x1;

            if (lastBit != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}