package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class Plane extends Geometry implements Comparable<Plane> {

    protected Point3D point;
    protected Vector normal;

    //****************************constructors****************************************//
    ///default constructor
    public Plane() {
        point = new Point3D();
        normal = new Vector();
    }

    public Plane(Point3D point, Vector normal_) {
        this.point = new Point3D(point);
        this.normal = new Vector(normal_);
        try {
            this.normal.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //copy constructor
    public Plane(Plane plane) {
        point = plane.getPoint();
        normal = plane.getNormal(null);
    }

    //***************************getters and setters***********************************//
    public Point3D getPoint() {
        return new Point3D(point);
    }

    public void setPoint(Point3D point) {
        this.point = new Point3D(point);
    }

    public Vector getNormal() {
        return new Vector(normal);
    }

    public void setNormal(Vector normal_) {
        this.normal = new Vector(normal_);
    }

    //********************************functions***************************************//
    @Override
    public int compareTo(Plane plane) {
        if (point.compareTo(plane.point) == 0 && normal.compareTo(plane.normal) == 0)
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        System.out.println("point: " + point.toString() + "normal: " + normal.toString());
        return "";
    }

    @Override
    public Vector getNormal(Point3D p) {
        try {
            normal.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return normal;
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersectionPoint = new ArrayList<Point3D>(1);

        Point3D P0 = ray.getPoint3D();
        Point3D Q0 = this.getPoint();
        Vector N = this.getNormal(null);
        Vector V = ray.getVector();

        Vector v = new Vector(Q0, P0);
        double t = (N.dotProduct(v) * -1) / N.dotProduct(V);

        if (t >= 0) {
            V.multInScalar(t);
            P0.addVectorToPoint(V);
            intersectionPoint.add(P0);
        }
        return intersectionPoint;

    }
}

