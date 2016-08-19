import java.io.*;
import java.util.*;


//A Pascals triangle row is constructed by looking at the previous row and adding the numbers to its left and right to arrive at the new value. 
//If either the number to its left/right is not present, substitute a zero in it's place. 
//More details can be found here: http://en.wikipedia.org/wiki/Pascal's_triangle . E.g. a Pascal's triangle upto a depth of 6 can be shown as:
//            1
//          1   1
//        1   2   1
//       1  3   3   1
//     1  4   6   4   1
//    1  5  10  10  5   1

//Your program should accept as its first argument a path to a filename. Each line in this file contains a positive integer which indicates the depth of the triangle (1 based). E.g.

//6

//OUTPUT SAMPLE:
//Print out the resulting pascal triangle up to the requested depth in row major form. E.g.
//1 1 1 1 2 1 1 3 3 1 1 4 6 4 1 1 5 10 10 5 1
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        final BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            final int rows = Integer.parseInt(line);
            printPascalsTriangle(rows);
        }
        in.close();
    }

    public static void printPascalsTriangle(final int rows)
    {
        int[] previous = new int[Math.max(2, rows)];
        int[] current = new int[Math.max(2, rows)];
        previous[0] = 1;
        current[0] = 1;
        current[1] = 1;
        boolean firstPrinted = false;
        for (int i = 0; i < rows; i++)
        {
            int[] tmp = current;
            current = previous;
            previous = tmp;
            for (int j = 1; j <= i; j++) {
                current[j] = previous[j-1] + previous[j];
            }
            for (int c : current) {
                if (c == 0) {
                    break;
                }
                if (firstPrinted) {
                    System.out.print(" ");
                } else {
                    firstPrinted = true;
                }
                System.out.print(c);
            }
        }

        System.out.println();
    }
}