import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//The Fibonacci series is defined as: F(0) = 0; F(1) = 1; F(n) = F(n–1) + F(n–2) when n>1. Given an integer n≥0, print out the F(n).
public class Main {
        public static void main(final String[] args) throws IOException {
                if (args.length < 1) {
                        throw new RuntimeException("Must specify input file path.");
                } else if (args.length > 1) {
                        throw new RuntimeException("Illegal input arguments specified.");
                }

                final BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
                String line;
                while ((line = reader.readLine()) != null) {
                                final int n = Integer.parseInt(line);
                                if (n>0){
                                System.out.println(fib(n - 1));}
                                else {System.out.println(0);}
                }
        }
        
                private static int fib(final int n) {
                if (n == 1 || n == 0) {
                        return 1;
                } else {
                        return fib(n - 1) + fib(n - 2);
                }
        }
}