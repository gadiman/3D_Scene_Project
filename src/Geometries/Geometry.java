package Geometries;

import java.awt.Color;
import java.util.List;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

public abstract class Geometry {
    //***********************************constructors********************************//
    ///default constructor
    public Geometry() {
    }

    //copy constructor
    public Geometry(Geometry geometry) {

    }

    //********************************functions**************************************//
    public abstract Vector getNormal(Point3D p);


}
