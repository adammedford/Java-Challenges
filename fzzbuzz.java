import java.io.*;

import java.util.*;


//Players generally sit in a circle. The first player says the number “1”, and each player says next number in turn. 
//However, any number divisible by X (for example, three) is replaced by the word fizz, and any divisible by Y (for example, five) by the word buzz. 
//Numbers divisible by both become fizz buzz. A player who hesitates, or makes a mistake is eliminated from the game.

//Write a program that prints out the final series of numbers where those divisible by X, Y and both are replaced by “F” for fizz, “B” for buzz and “FB” for fizz buzz.


//Your program should accept a file as its first argument. The file contains multiple separated lines; each line contains 3 numbers that are space delimited. 
//The first number is the first divider (X), the second number is the second divider (Y), and the third number is how far you should count (N). 
//You may assume that the input file is formatted correctly and the numbers are valid positive integers.

//Print out the series 1 through N replacing numbers divisible by X with “F”, numbers divisible by Y with “B” and numbers divisible by both with “FB”. 
//Since the input file contains multiple sets of values, your output should print out one line per set. 
//Ensure that there are no trailing empty spaces in each line you print.


public class Main {

    public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] nums = line.split(" ");
            int first = Integer.parseInt(nums[0]);
            int second = Integer.parseInt(nums[1]);
            int third = Integer.parseInt(nums[2]);
            for(int i=1;i<=third;i++){
                if(i%first==0 && i%second==0 ){
                    System.out.printf("FB ");
                }
                else if(i%first==0)
                    System.out.printf("F ");
                else if(i%second==0)
                    System.out.printf("B " );
                else
                    System.out.printf("%d ",i);
            }
            System.out.println();
        }
        reader.close();
    }
}