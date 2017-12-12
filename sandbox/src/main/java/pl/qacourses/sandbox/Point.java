package pl.qacourses.sandbox;

/**
 * Created by Maciej.Florys on 11/12/2017.
 */
public class Point {

    double x;
    double y;

    public double distance(Point p2) {

        return Math.sqrt(Math.pow((this.x - p2.x),2) + Math.pow(this.y-p2.y,2));

    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}
