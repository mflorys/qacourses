package pl.qacourses.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public static void shouldReturnDistanceEqualTo_2(){
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,-1);

        Assert.assertEquals(p1.distance(p2),2.0);
    }

    @Test
    public static void shouldReturnDistanceEqualTo_3Pi(){
        Point p1 = new Point(-2*Math.PI,0);
        Point p2 = new Point(Math.PI,0);

        Assert.assertEquals(p1.distance(p2),3*Math.PI);
    }

    @Test
    public static void shouldReturnDistanceEqualTo_4(){
        Point p1 = new Point(-2,2);
        Point p2 = new Point(-2,-2);

        Assert.assertEquals(p1.distance(p2),4.0);
    }

    @Test
    public static void shouldReturnDistanceEqualTo_SqrtOf140_04(){
        Point p1 = new Point(-4.2,5);
        Point p2 = new Point(6,-1);

        Assert.assertEquals(p1.distance(p2),Math.sqrt(140.04));
    }
}
