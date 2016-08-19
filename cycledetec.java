import java.io.*;
import java.util.*;

//Given a sequence, write a program to detect cycles within it.
//Your program should accept as its first argument a path to a filename containing a sequence of numbers (space delimited). 
//The file can have multiple such lines. E.g
//2 0 6 3 1 6 3 1 6 3 1
//3 4 8 0 11 9 7 2 5 6 10 1 49 49 49 49
//1 2 3 1 2 3 1 2 3

//Print to stdout the first cycle you find in each sequence. Ensure that there are no trailing empty spaces on each line you print. E.g.
//6 3 1
//49
//1 2 3

public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lineArray = line.split(" ");
            int[] sequence = new int[lineArray.length];
            for (int i = 0; i < sequence.length; i++) {
                sequence[i] = parseInt(lineArray[i]);
            }
            CycleInformation ci = detectFirstCycle(sequence);
            for (int i = 0; i < ci.cycleLength(); i++) {
                System.out.print(sequence[ci.startingPoint() + i]);
                if (i != ci.cycleLength() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        in.close();
    }

    public static CycleInformation detectFirstCycle(int[] sequence)
    {
        for (int starting = 0; starting < sequence.length-1; starting++) {
            for (int length = 1; length < sequence.length; length++) {
                if (isValidCycle(sequence, starting, length)) {
                    return new CycleInformation(starting, length);
                }
            }
        }

        return new CycleInformation(0, sequence.length);
    }

    private static boolean isValidCycle(int[] sequence, int starting, int length)
    {
        int current = starting + length;
        boolean foundMatch = false;

        while (current < sequence.length) {
            if (!subArraysMatch(sequence, starting, current, length)) {
                return false;
            }

            foundMatch = true;
            current += length;
        }

        return foundMatch;
    }
    
    public static int parseInt( final String s )
{
    int num  = 0;
    int sign = -1;
    final int len  = s.length( );
    final char ch  = s.charAt( 0 );
    if ( ch == '-' )
        sign = 1;
    else
        num = '0' - ch;
    int i = 1;
    while ( i < len )
        num = num*10 + '0' - s.charAt( i++ );
    return sign * num;
} 

    private static boolean subArraysMatch(int[] sequence, int startingA, int startingB,
                                          int length)
    {
        for (int i = 0; i < length; i++) {
            int indexA = startingA + i;
            int indexB = startingB + i;

            if (indexA >= sequence.length || indexB >= sequence.length) {
                return false;
            }

            if (sequence[indexA] != sequence[indexB]) {
                return false;
            }
        }

        return true;
    }

    private static class CycleInformation
    {
        private final int _startingPoint;
        private final int _cycleLength;

        public CycleInformation(int startingPoint, int cycleLength)
        {
            _startingPoint = startingPoint;
            _cycleLength = cycleLength;
        }

        public int startingPoint()
        {
            return _startingPoint;
        }

        public int cycleLength()
        {
            return _cycleLength;
        }
    }
}