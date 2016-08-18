import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


//Given a 2D board and a word, find if the word exists in the grid. 
//The word can be constructed from letters of sequentially adjacent cell, where adjacent cells are those horizontally or vertically neighboring. 
//The same letter cell may not be used more than once.
public class Main
{
    private static final char[][] _grid =
            {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            };

    public static void main (String[] args)
            throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            if (hasMatchingWord(_grid, line.toCharArray())) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }

    private static boolean hasMatchingWord(char[][] grid, char[] word)
    {
        boolean[][] used = new boolean[3][4];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 4; j++) {
                        used[i][j] = false;
                    }
                }

                if (hasMatchingWord(grid, used, word, 0, row, col)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasMatchingWord(char[][] grid, boolean[][] used, char[] word,
                                           int index, int row, int col)
    {
        if (row < 0 || row == 3 || col < 0 || col == 4) {
            return false;
        }

        if (used[row][col]) {
            return false;
        }

        if (grid[row][col] != word[index]) {
            return false;
        }

        used[row][col] = true;

        if (index+1 == word.length) {
            return true;
        }

        return hasMatchingWord(grid, used, word, index+1, row+1, col  ) ||
               hasMatchingWord(grid, used, word, index+1, row-1, col  ) ||
               hasMatchingWord(grid, used, word, index+1, row  , col-1) ||
               hasMatchingWord(grid, used, word, index+1, row  , col+1);
    }
}