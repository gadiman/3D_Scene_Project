package Primitives.Tests;

import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

class VectorTest {
    Vector tmp1=new Vector(new Primitives.Point3D(new Coordinate(1),
            new Coordinate(2), new Coordinate(3) ));
    @Test
    void getHead() {
        AssertJUnit.assertTrue(tmp1.compareTo(new Primitives.Vector(new Point3D(new Coordinate(1),
                new Coordinate(2), new Coordinate(3))))==0);
    }

    @Test
    void setHead() {
        tmp1.setHead(new Primitives.Point3D(new Coordinate(1),
                new Coordinate(2), new Coordinate(3)));
        AssertJUnit.assertTrue(tmp1.compareTo(new Primitives.Vector(new Point3D(new Coordinate(1),
                new Coordinate(2), new Coordinate(3))))==0);

    }

    @Test
    void compareTo() {
        AssertJUnit.assertTrue(tmp1.compareTo(new Primitives.Vector(new Point3D(new Coordinate(1),
                new Coordinate(2), new Coordinate(3))))==0);
    }
}