package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

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
    public abstract List<Point3D> FindIntersections (Ray ray);

}
