import java.io.*;
import java.util.*;

//Sudoku is a number-based logic puzzle. 
//It typically comprises of a 9*9 grid with digits so that each column, each row and each of the nine 3*3 sub-grids that compose the grid contains all the digits from 1 to 9. 
//For this challenge, you will be given an N*N grid populated with numbers from 1 through N and you have to determine if it is a valid sudoku solution. 
//You may assume that N will be either 4 or 9. 
//The grid can be divided into square regions of equal size, where the size of a region is equal to the square root of a side of the entire grid. 
//Thus for a 9*9 grid there would be 9 regions of size 3*3 each.
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = in.readLine()) != null) {
            line = line.trim();
            int[][] board = parseSudokuBoardLine(line);
            SudokuBoard sudoku = new SudokuBoard(board);
            if (sudoku.isValidSolution()) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
        in.close();
    }

    private static int[][] parseSudokuBoardLine(String line)
    {
        int width = Integer.parseInt(line.split(";")[0]);
        int[][] result = new int[width][width];
        int counter = 0;
        for (String s : line.split(";")[1].split(",")) {
            result[counter/width][counter%width] = Integer.parseInt(s);
            counter++;
        }

        return result;
    }

    public static class SudokuBoard
    {
        private final int[][] _board;
        private final int _width;
        private final int _sqrt;
        private final int _desiredSum;

        public SudokuBoard(int[][] board)
        {
            _board = board;
            _width = board.length;
            _sqrt = (int) Math.sqrt(_width);
            _desiredSum = _width * (_width + 1) / 2;

            if (!isPerfectSquare(_width)) {
                throw new IllegalArgumentException();
            }
        }

        private static boolean isPerfectSquare(int n)
        {
            return ((int) (Math.sqrt(n) + 0.5) * (int) (Math.sqrt(n) + 0.5)) == n;
        }

        private int getWidth()
        {
            return _width;
        }

        private int getSqrt()
        {
            return _sqrt;
        }

        private int getDesiredSum()
        {
            return _desiredSum;
        }

        private int[][] getBoard()
        {
            return _board;
        }

        public boolean isValidSolution()
        {
            for (int i = 0; i < getWidth(); i++) {
                int sum1 = 0;
                int sum2 = 0;

                for (int j = 0; j < getWidth(); j++) {
                    sum1 += getBoard()[i][j];
                    sum2 += getBoard()[j][i];
                }

                if (sum1 != getDesiredSum() || sum2 != getDesiredSum()) {
                    return false;
                }
            }

            for (int i = 0; i < getSqrt(); i++) {
                for (int j = 0; j < getSqrt(); j++) {
                    int sum = 0;

                    for (int m = 0; m < getSqrt(); m++) {
                        for (int n = 0; n < getSqrt(); n++) {
                            sum += getBoard()[i*getSqrt() + m][j*getSqrt() + n];
                        }
                    }

                    if (sum != getDesiredSum()) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}