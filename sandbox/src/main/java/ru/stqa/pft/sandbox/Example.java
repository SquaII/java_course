package ru.stqa.pft.sandbox;

public class Example {

    public static void main(String args[]) {
        System.out.println("Hello world!");

        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);

        /* get distance by function */
        System.out.println("Расстояние между точками " + p1.printCoords() + " и " + p2.printCoords() + " равно " + distance(p1, p2));

        /* get distance by method */
        System.out.println("Расстояние между точками " + p1.printCoords() + " и " + p2.printCoords() + " равно " + p1.distanceTo(p2));

    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
    }

}
