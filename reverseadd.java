import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//The problem is as follows: choose a number, reverse its digits and add it to the original. 
//If the sum is not a palindrome (which means, it is not the same number from left to right and right to left), repeat this procedure.

//Your program should accept as its first argument a path to a filename. Each line in this file is one test case. 
//Each test case will contain an integer n < 10,000. 
//Assume each test case will always have an answer and that it is computable with less than 100 iterations (additions).

//For each line of input, generate a line of output which is the number of iterations (additions) to compute the palindrome and the resulting palindrome. 
//(they should be on one line and separated by a single space character).

public class Main {
        public static void main(final String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
        int count = 0;
        int num = parseInt(line);
        while(!isPal(num))
        {
            num += revNum(num);
            count++;
        }
        System.out.println(count + " " + num);
    }
    reader.close();
}

public final static int parseInt( final String s )
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

private final static int revNum(int n)
{
    final String temp = Integer.toString(n);
    char[] ar = temp.toCharArray();
    char tmp;
    for (int i = 0; i < ar.length/2; i++)
    {
        tmp = ar[i];
        ar[i] = ar[ar.length-1-i];
        ar[ar.length-1-i] = tmp;
    }
    return parseInt(new String(ar));
}

private final static boolean isPal(int n)
{
  char[] array = Integer.toString(n).toCharArray();
        for (int i = 0; i < array.length/2; i++) {
            if (array[i] != array[array.length-i-1]) {
                return false;
            }
        }
        return true;
}

}