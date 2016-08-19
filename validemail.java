import java.io.*;
import java.util.regex.Pattern;


//You are given several strings that may/may not be valid emails. 
//You should write a regular expression that determines if the email id is a valid email id or not. 
//You may assume all characters are from the english language.
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        String patternString = "^[_A-Za-z0-9-\\.\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$|" + "^\"[_A-Za-z0-9-\\.\\+@]+(\\.[_A-Za-z0-9-]+)*\"@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(patternString);
while ((line = in.readLine()) != null) {
            System.out.println(pattern.matcher(line.trim()).matches());
        }
    }
}