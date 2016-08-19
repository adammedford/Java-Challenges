import java.io.*;

//Flavius Josephus was a famous Jewish historian of the first century, at the time of the destruction of the Second Temple. 
//According to legend, during the Jewish-Roman war he was trapped in a cave with a group of soldiers surrounded by Romans. 
//Preferring death to capture, the Jews decided to form a circle and, proceeding around it, to kill every j'th person remaining until no one was left. 
//Josephus found the safe spot in the circle and thus stayed alive. 

//Write a program that returns a list of n people, numbered from 0 to n-1, in the order in which they are executed.


//Your program should accept as its first argument a path to a filename. 
//Each line in this file contains two comma separated positive integers n and m, where n is the number of people and every m'th person will be executed.
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            final String[] split = line.split(",");
            final int total = Integer.parseInt(split[0]);
            final int next = Integer.parseInt(split[1]);
            boolean[] killed = new boolean[total];
            int current = 0;
            for (int i = 0; i < total; i++) {
                int count = 0;
                while (true) {
                    if (!killed[current]) {
                        count++;
                        if (count == next) {
                            break;
                        }
                    }
                    current++;
                    current %= total;
                }
                killed[current] = true;
                System.out.print(current);
                if (i+1 != total) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}