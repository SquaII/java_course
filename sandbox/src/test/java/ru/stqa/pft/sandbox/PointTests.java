package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Squall on 30.10.2016.
 */
public class PointTests {

    @Test
    public void testDistanceTo1(){
        Point p1 = new Point(1, 1);
        Point p2 = new Point(4, 5);
        Assert.assertEquals(p1.distanceTo(p2), 5.0);
    }

    @Test
    public void testDistanceTo2(){
        Point p1 = new Point(2, 0);
        Point p2 = new Point(7, 12);
        Assert.assertEquals(p1.distanceTo(p2), 13.0);
    }

    @Test
    public void testDistanceTo3(){
        Point p1 = new Point(-1, 5);
        Point p2 = new Point(7, 20);
        Assert.assertEquals(p1.distanceTo(p2), 17.0);
    }

}
