package Primitives.Tests;

import Primitives.Coordinate;
import Primitives.Point2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

class Point2DTest {
 

        Point2D tmp = new Point2D(new Coordinate(3),new Coordinate(2));


        @Test
        void getX() {
            Coordinate t=new Coordinate(tmp.getX());
            assertEquals(t.getCoordinate(),new Coordinate(3).getCoordinate());
        }

        @Test
        void setX() {
            Coordinate t=new Coordinate(1);
            tmp.setX(t);
            assertEquals(tmp.getX().getCoordinate(),1);

        }

        @Test
        void getY() {
            Coordinate t=new Coordinate(tmp.getY());
            assertEquals(t.getCoordinate(),new Coordinate(2).getCoordinate());
        }

        @Test
        void setY() {
            Coordinate t=new Coordinate(1);
            tmp.setY(t);
            assertEquals(tmp.getY().getCoordinate(),1);
        }

        @Test
        void compareTo() {
            Assertions.assertTrue(tmp.compareTo(new Point2D(new Coordinate(3),new Coordinate(2)))==0);
        }

}