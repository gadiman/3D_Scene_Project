package Primitives.Tests;

import Primitives.Coordinate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.AssertJUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

class CoordinateTest {

    Coordinate tmp= new Coordinate(2.4);

    @Test
    void getCoordinate() {
        assertEquals(tmp.getCoordinate(),2.4);

    }

    @Test
    void setCoordinate() {
        tmp.setCoordinate(7.9);
        assertEquals(tmp.getCoordinate(),7.9);
    }

    @Test
    void compareTo() {
        AssertJUnit.assertTrue(tmp.compareTo(new Coordinate(2.4))==0);
    }


}