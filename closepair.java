import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

//You will be given the x/y co-ordinates of several locations. You will be laying out 1 cable between two of these locations. 
//In order to minimise the cost, your task is to find the shortest distance between a pair of locations, so that pair can be chosen for the cable installation.
//Your program should accept as its first argument a path to a filename. 
//The input file contains several sets of input. Each set of input starts with an integer N (0<=N<=10000), which denotes the number of points in this set. 
//The next N line contains the coordinates of N two-dimensional points. The first of the two numbers denotes the X-coordinate and the latter denotes the Y-coordinate. 
//The input is terminated by a set whose N=0. 
//This set should not be processed. The value of the coordinates will be less than 40000 and non-negative.
//For each set of input produce a single line of output containing a floating point number (with four digits after the decimal point) which denotes the distance between the closest two points. 
//If there is no such two points in the input whose distance is less than 10000, print the line INFINITY.
public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
        Set<Point> set;
        while (true) {
            set = parseSet(in);
            if (set.size() == 0) break;
            double distance = findMinDistance(set);
            if (distance == Double.POSITIVE_INFINITY) {
                System.out.println("INFINITY");
            } else {
                System.out.println(String.format("%.4f", distance));
            }
        }
    }

    public static Set<Point> parseSet(BufferedReader in)
            throws IOException
    {
        int n = Integer.parseInt(in.readLine());
        HashSet<Point> set = new HashSet<Point>();

        for (int i = 0; i < n; i++) {
            String[] lineArray = in.readLine().split(" ");
            Point p = new Point(
                    Integer.parseInt(lineArray[0]),
                    Integer.parseInt(lineArray[1]));
            set.add(p);
        }

        return set;
    }

    public static double findMinDistance(Set<Point> set)
    {
        double minDistance = Double.POSITIVE_INFINITY;
        for (Point comparator : set) {
            for (Point p : set) {
                if (comparator.equals(p)) {
                    continue;
                }
                double distance = comparator.distanceTo(p);
                if (distance < 10000.0 && distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }

    public static class Point
    {
        private final int _x;
        private final int _y;
        public Point(int x, int y)
        {
            _x = x;
            _y = y;
        }

        public double distanceTo(Point p)
        {
            int x = (_x-p._x)*(_x-p._x);
            int y = (_y-p._y)*(_y-p._y);

            return Math.sqrt(x+y);
        }

        public boolean equals(Point p)
        {
            return _x == p._x && _y == p._y;
        }
    }
}