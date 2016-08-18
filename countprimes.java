import java.io.*;
import java.util.*;

//Given two integers N and M, count the number of prime numbers between N and M (both inclusive)
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        LinkedList<IntegerRange> ranges = new LinkedList<IntegerRange>();
        int largestMax = 0;
        while ((line = reader.readLine()) != null) {
            final String[] array = line.split(",");
            final int min = parseInt(array[0]);
            final int max = parseInt(array[1]);
            ranges.add(new IntegerRange(min, max));
            if (max > largestMax) {
                largestMax = max;
            }
        }

        boolean[] isComposite = computeIsCompositeTable(largestMax+1);
        for (IntegerRange r : ranges) {
            int primeCount = 0;
            for (int i = r.getMin(); i <= r.getMax(); i++) {
                if (!isComposite[i]) {
                    primeCount++;
                }
            }
            System.out.println(primeCount);
        }

        reader.close();
    }

    public static class IntegerRange
    {
        private final int _min;
        private final int _max;

        public IntegerRange(int min, int max)
        {
            _min = min;
            _max = max;
        }

        public int getMin()
        {
            return _min;
        }

        public int getMax()
        {
            return _max;
        }
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

    public static boolean[] computeIsCompositeTable(int max)
    {
        boolean[] isComposite = new boolean[max];
        for (int i = 0; i < isComposite.length; i++) {
            isComposite[i] = false;
        }

        int currentPrime = 2;
        while (true) {
            for (int i = currentPrime; i * currentPrime < max; i++) {
                isComposite[i * currentPrime] = true;
            }

            boolean more = false;
            for (int i = currentPrime+1; i < max; i++) {
                if (!isComposite[i]) {
                    currentPrime = i;
                    more = true;
                    break;
                }
            }

            if (!more) {
                break;
            }
        }

        return isComposite;
    }
}