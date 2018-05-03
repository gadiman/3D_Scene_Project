package Unitest;

import Primitives.Point3D;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

 Vector FirsVec= new Vector(new Point3D(2,2,2));
 Vector SecondVec = new Vector(new Point3D(-2,-2,-2));



    @Test
    void compareTo() {
        Vector tmp =new Vector(SecondVec).multInScalar(-1.0);
        assertTrue(FirsVec.compareTo(tmp) == 0);
    }

    @Test
    void add() {
        Vector tmp= new Vector(FirsVec);
        tmp.add(SecondVec);
        assertTrue(tmp.compareTo(new Vector(new Point3D(0,0,0))) == 0);

    }

    @Test
    void subtract() {
        Vector tmp= new Vector(FirsVec);
        tmp.subtract(SecondVec);
        assertTrue(tmp.compareTo(new Vector(new Point3D(4,4,4))) == 0);

    }

    @Test
    void multInScalar() {
        Vector tmp= new Vector(FirsVec);
        tmp.multInScalar(-1.0);
        assertTrue(tmp.compareTo(SecondVec) == 0);
    }

    @Test
    void dotProduct() {
        Vector tmp= new Vector(FirsVec);
        Vector tmp_= new Vector(SecondVec);
        assertTrue(Double.compare(tmp.dotProduct(tmp_), (-4 + -4 + -4)) == 0);
    }

    @Test
    void crossProduct() {
    }

    @Test
    void length() {
        Vector tmp = new Vector(FirsVec);
        assertTrue(tmp.length() ==
                Math.sqrt(4 + 4 + 4));
    }

    @Test
    void normalize() {

    }
}