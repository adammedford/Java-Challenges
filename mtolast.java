import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Stack;


//Write a program which determines the Mth to the last element in a list.
//The first argument is a path to a file. The file contains the series of space delimited characters followed by an integer. 
//The integer represents an index in the list (1-based), one per line.

//a b c d 4
//e f g h 2
//becomes
//a
//g
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            line = line.trim();
            if (line.length() > 0) {
                String[] lineArray = line.split(" ");
                int m = parseInt(lineArray[lineArray.length - 1]);
                Stack<String> s = new Stack<String>();
                s.addAll(Arrays.asList(lineArray).subList(0, lineArray.length-1));
                if (m > s.size() || m < 1) {
                    continue;
                }
                String result = s.pop();
                for (int i = 2; i <= m; i++) {
                    result = s.pop();
                }
                System.out.println(result);
            }
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
}