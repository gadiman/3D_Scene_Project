package Unitest;

import Primitives.Point3D;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {

     Vector FirsVec= new Vector(2.0,2.0,2.0);
     Vector SecondVec = new Vector(-2.0,-2.0,-2.0);



    @Test
    void compareTo() {
        Vector tmp =(new Vector(SecondVec));
        tmp.multInScalar(-1.0);
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
        assertTrue((tmp.compareTo(SecondVec)) == 0);
    }

    @Test
    void dotProduct() {
        Vector tmp= new Vector(FirsVec);
        Vector tmp_= new Vector(SecondVec);
        assertTrue(Double.compare(tmp.dotProduct(tmp_), (-4 + -4 + -4)) == 0);
    }

    @Test
    void crossProduct() {
        Vector tmp= new Vector(FirsVec);
        Vector tmp_= new Vector(SecondVec);
        Double c1,c2,c3;
        c1=((tmp.getHead().getY().getCoordinate()) * (tmp_.getHead().getZ().getCoordinate()) -
                (tmp.getHead().getZ().getCoordinate()) * (tmp_.getHead().getY().getCoordinate()));
        c2=((tmp.getHead().getX().getCoordinate()) * (tmp_.getHead().getZ().getCoordinate()) -
                ( tmp.getHead().getZ().getCoordinate()) * (tmp_.getHead().getX().getCoordinate()));
        c3=((tmp.getHead().getX().getCoordinate()) * (tmp_.getHead().getY().getCoordinate()) -
                ( tmp.getHead().getY().getCoordinate()) * (tmp_.getHead().getX().getCoordinate()));

        c2*=(-1.0);

        Vector T= new Vector(c1,c2,c3);

        Vector U=new Vector(tmp.crossProduct(tmp_));

        assertTrue(U.compareTo(T) == 0);

    }

    @Test
    void length() {
        Vector tmp = new Vector(FirsVec);
        assertTrue(tmp.length() ==
                Math.sqrt(4 + 4 + 4));
    }

    @Test
    void normalize() throws Exception {
        Vector v = new Vector(49.7457, -8276, 150);
        v.normalize();
        assertTrue(v.length()==1);

    }

    }
