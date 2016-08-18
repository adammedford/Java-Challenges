import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//You are given a sorted list of numbers with duplicates. Print out the sorted list with duplicates removed.
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
                        final String[] elements = line.split(",");
                        final StringBuilder lists = new StringBuilder();
                        Integer previousElement = null;
                        for (int i = 0; i < elements.length; i++) {
                                try {
                 final int currentElement = Integer.parseInt(elements[i]);
                if (previousElement == null || currentElement > previousElement) {
                                                lists.append(currentElement);
                                                previousElement = currentElement;
                         if (!elements[i].equals(elements[elements.length - 1])) {
                                                        lists.append(",");
                                                }
                                        }
                                } catch (final NumberFormatException e) {
                                        throw new RuntimeException("Input file contained non-numeric arguments.");
                                }
                        }
                        System.out.println(lists.toString());
                }
        }
}