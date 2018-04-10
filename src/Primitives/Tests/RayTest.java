package Primitives.Tests;

import Primitives.Coordinate;
import Primitives.Ray;
import Primitives.Vector;
import javafx.geometry.Point3D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

class RayTest {
    Primitives.Point3D tmp=new Primitives.Point3D(new Coordinate(2.2),new Coordinate(1),new Coordinate(3.3));
    Vector tmp1=new Vector(new Primitives.Point3D(new Coordinate(1),
           new Coordinate(2), new Coordinate(3) ));
    Ray tmp3=new Ray(tmp,tmp1);

    @Test
    void getPoint3D() {
        AssertJUnit.assertTrue( tmp3.getPoint3D().compareTo(tmp)==0);
    }

    @Test
    void setPoint3D() {
        tmp3.setPoint3D(new Primitives.Point3D(new Coordinate(3),new Coordinate(2),new Coordinate(1)));
        AssertJUnit.assertTrue(tmp3.getPoint3D().compareTo(new Primitives.Point3D
                (new Coordinate(3),new Coordinate(2),new Coordinate(1)))==0);
    }

    @Test
    void getVector() {
        assertEquals(tmp3.getVector(),tmp1);
    }

    @Test
    void setVector() {
        tmp3.setVector(new Vector(new Primitives.Point3D
                (new Coordinate(3),new Coordinate(2),new Coordinate(1))));
        AssertJUnit.assertTrue(tmp3.getVector().compareTo(new Vector(new Primitives.Point3D
                (new Coordinate(3),new Coordinate(2),new Coordinate(1))))==0);
    }
}