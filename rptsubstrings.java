import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//You are to find the longest repeated substring in a given text. 
//Repeated substrings may not overlap. If more than one substring is repeated with the same length, print the first one you find.(starting from the beginning of the text). 
//NOTE: The substrings can't be all spaces.
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.length() > 0) {
                String result = longestRepeatedSubstring(line);
                if (result != null) {
                    System.out.println(result);
                } else {
                    System.out.println("NONE");
                }
            }
        }
        reader.close();
    }

    public static String longestRepeatedSubstring(String str)
    {
        return longestRepeatedSubstring(str.toCharArray());
    }

    private static String longestRepeatedSubstring(char[] str)
    {
        boolean foundRepeatedSubstring = false;
        int bestIndex = 0;
        int bestLength = 0;
        for (int width = 1; width <= str.length/2; width++) {
            for (int offset = 0; offset <= str.length-(2*width); offset++) {
                String base = new String(str, offset, width);
                if (isStringAllWhitespace(base)) continue;
                boolean continueToNextOffset = true;
                for (int current = offset+width; current <= str.length-width; current++) {
                    String compare = new String(str, current, width);
                    if (base.equals(compare)) {
                        foundRepeatedSubstring = true;
                        bestIndex = offset;
                        bestLength = width;
                        continueToNextOffset = false;
                        break;
                    }
                }
                if (!continueToNextOffset) break;
            }
        }

        if (foundRepeatedSubstring) {
            return new String(str, bestIndex, bestLength);
        } else return null;
    }

    private static boolean isStringAllWhitespace(String str)
    {
        for (char c : str.toCharArray()) {
            if (!Character.isWhitespace(c)) return false;
        }
        return true;
    }
}