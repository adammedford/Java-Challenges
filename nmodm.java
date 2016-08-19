import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//Given two integers N and M, calculate N Mod M (without using any inbuilt modulus operator).
public class Main {
        public static void main(final String[] args) throws IOException {
                final BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
                String line;
                while ((line = reader.readLine()) != null) {
                final int a = parseInt(line.substring(0,line.indexOf(",")));
                int b = parseInt(line.substring(line.indexOf(",")+1, line.length()));
                int c = a / b;
                c = c * b;
                b = a - c;
                System.out.println(b);
                }
                reader.close();
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