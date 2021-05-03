package PatternishApp.domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Polygon implements Shape{
    int[] pointsX;
    int[] pointsY;
    int size;
    List<Point> pointsList;

    public Polygon(List<Point> points) {
        Point[] pointArray = new Point[points.size()];

        for (int i=0; i<points.size(); i++){
            pointArray[i] = points.get(i);
        }

        points = convexHull(pointArray,points.size());

        pointsList = points;
        size = points.size();
        pointsX = new int[size];
        pointsY = new int[size];

        for (int i=0; i<size;i++){
            pointsX[i] = (int) points.get(i).getX();
            pointsY[i] = (int) points.get(i).getY();
        }
    }

    @Override
    public int[] getX() {
        return pointsX;
    }

    @Override
    public int[] getY() {
        return pointsY;
    }

    @Override
    public int getSize() {
        return size;
    }

    //Following code has been found on https://www.geeksforgeeks.org/convex-hull-set-1-jarviss-algorithm-or-wrapping/
    public static int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;  // collinear
        return (val > 0)? 1: 2; // clock or counterclock wise
    }

    //Following code has been found on https://www.geeksforgeeks.org/convex-hull-set-1-jarviss-algorithm-or-wrapping/
    public static List<Point> convexHull(Point points[], int n) {

        // There must be at least 3 points
        if (n < 3) return null;

        // Initialize Result
        Vector<Point> hull = new Vector<Point>();

        // Find the leftmost point
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;

        // Start from leftmost point, keep moving
        // counterclockwise until reach the start point
        // again. This loop runs O(h) times where h is
        // number of points in result or output.
        int p = l, q;
        do {
            // Add current point to result
            hull.add(points[p]);

            // Search for a point 'q' such that
            // orientation(p, q, x) is counterclockwise
            // for all points 'x'. The idea is to keep
            // track of last visited most counterclock-
            // wise point in q. If any point 'i' is more
            // counterclock-wise than q, then update q.
            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                // If i is more counterclockwise than
                // current q, then update q
                if (orientation(points[p], points[i], points[q])
                        == 2)
                    q = i;
            }

            // Now q is the most counterclockwise with
            // respect to p. Set p as q for next iteration,
            // so that q is added to result 'hull'
            p = q;

        } while (p != l);  // While we don't come to first
        // point

        // Print Result
        List<Point> pointsList = new ArrayList<>();
        for (Point temp : hull) {
            pointsList.add(temp);
        }
        return pointsList;
    }
}
