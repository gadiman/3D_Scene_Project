package Primitives.Tests;

import Primitives.Coordinate;
import Primitives.Point3D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {
Point3D tmp=new Point3D(new Coordinate(2.2),new Coordinate(1),new Coordinate(3.3));

    @Test
    void getZ() {
        assertTrue(tmp.getZ().compareTo(new Coordinate(3.3))==0);
    }

    @Test
    void setZ() {
        tmp.setZ(new Coordinate(4.4));
        assertTrue(tmp.getZ().compareTo(new Coordinate(4.4))==0);
    }

    @Test
    void compareTo() {
        assertTrue(tmp.compareTo(new Point3D(new Coordinate(2.2)
                ,new Coordinate(1),new Coordinate(3.3)))==0);
    }
}