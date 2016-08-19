import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


//You have coordinates of four points on a plane. Check whether they make a square.
//Your program should accept as its first argument a path to a filename. Input example is the following
//(1,6), (6,7), (2,7), (9,1)
//(4,1), (3,4), (0,5), (1,2)
//(4,6), (5,5), (5,6), (4,5)
//All numbers in input are integers between 0 and 10

public class Main
{
    public static void main (String[] args)
            throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(new File(args[0])));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] array = line.split("\\),");
            assert(array.length == 4);
            Point[] points = new Point[4];
            for (int i = 0; i < 4; i++) {
                String pointString = array[i];
                int x = Integer.parseInt(pointString.split(",")[0].split("\\(")[1]);
                int y = Integer.parseInt(pointString.split(",")[1].split("\\)")[0]);
                Point p = new Point(x, y);
                points[i] = p;
            }
            int d1 = points[0].squareDistanceTo(points[1]);
            int d2 = points[0].squareDistanceTo(points[2]);
            int d3 = points[0].squareDistanceTo(points[3]);
            Quadrilateral q;
            if (d1 == d2 && d2 == d3) {
                System.out.println(false);
                continue;
            } else if (d1 == d2) {
                q = new Quadrilateral(points[0], points[1], points[3], points[2]);
            } else if (d2 == d3) {
                q = new Quadrilateral(points[0], points[2], points[1], points[3]);
            } else if (d3 == d1) {
                q = new Quadrilateral(points[0], points[1], points[2], points[3]);
            } else {
                System.out.println(false);
                continue;
            }
            System.out.println(q.isSquare());
        }
        reader.close();
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

        public int getX()
        {
            return _x;
        }

        public int getY()
        {
            return _y;
        }

        public int squareDistanceTo(Point p)
        {
            int xDiff = getX() - p.getX();
            int yDiff = getY() - p.getY();

            return (xDiff*xDiff) + (yDiff*yDiff);
        }

        @Override
        public String toString()
        {
            return "(" + Integer.toString(getX()) + "," + Integer.toString(getY()) + ")";
        }
    }

    public static class LineSegment
    {
        private final Point _p1;
        private final Point _p2;

        public LineSegment(Point p1, Point p2)
        {
            _p1 = p1;
            _p2 = p2;
        }

        public Vector toVector()
        {
            return new Vector(_p1.getX() - _p2.getX(), _p1.getY() - _p2.getY());
        }

        public boolean isPerpendicularTo(LineSegment ls)
        {
            return toVector().dot(ls.toVector()) == 0;
        }
    }

    public static class Vector
    {
        private final int _x;
        private final int _y;

        public Vector(int x, int y)
        {
            _x = x;
            _y = y;
        }

        public int dot(Vector v)
        {
            return _x * v._x + _y * v._y;
        }
    }

    public static class Quadrilateral
    {
        private Point _p1;
        private Point _p2;
        private Point _p3;
        private Point _p4;

        public Quadrilateral(Point p1, Point p2, Point p3, Point p4)
        {
            _p1 = p1;
            _p2 = p2;
            _p3 = p3;
            _p4 = p4;
        }

        public boolean isSquare()
        {
            int d12 = _p1.squareDistanceTo(_p2);
            int d23 = _p2.squareDistanceTo(_p3);
            int d34 = _p3.squareDistanceTo(_p4);
            int d41 = _p4.squareDistanceTo(_p1);
            boolean lengthsAreSameSize = d12 == d23 && d23 == d34 && d34 == d41;
            if (!lengthsAreSameSize) {
                return false;
            }
            LineSegment l12 = new LineSegment(_p1, _p2);
            LineSegment l23 = new LineSegment(_p2, _p3);
            LineSegment l34 = new LineSegment(_p3, _p4);
            LineSegment l41 = new LineSegment(_p4, _p1);
            return l12.isPerpendicularTo(l23) &&
                   l23.isPerpendicularTo(l34) &&
                   l34.isPerpendicularTo(l41) &&
                   l41.isPerpendicularTo(l12);
        }
    }
}