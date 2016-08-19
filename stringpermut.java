import java.io.*;
import java.util.*;

//Write a program which prints all the permutations of a string in alphabetical order. 
//We consider that digits < upper case letters < lower case letters. 
//The sorting should be performed in ascending order.
public class Main {
        public static void main(final String[] args) throws IOException {
                if (args.length < 1) {
                        throw new RuntimeException("Must specify input file path.");
                } else if (args.length > 1) {
                        throw new RuntimeException("Illegal input arguments specified.");
                }
                BufferedReader read = new BufferedReader(new FileReader(new File(args[0])));
            String line;
            while ((line = read.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) {
                continue;
            }

            Set<String> result = perm(line);
            Iterator<String> it = result.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext()) {
                    System.out.print(",");
                }
            }
            System.out.println();
        }
        read.close();
    }

    public static Set<String> perm(String str)
    {
        char[] array = str.toCharArray();
        Set<String> result = new TreeSet<String>();
        perm(array, 0, result);
        return result;
    }

    private static void perm(char[] array, int index, Set<String> result)
    {
        if (index == array.length-1) {
            result.add(new String(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, i, index);
            perm(array, index+1, result);
            swap(array, i, index);
        }
    }

    private static void swap(char[] array, int index1, int index2)
    {
        char tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}