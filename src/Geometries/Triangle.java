package Geometries;

import Primitives.Point3D;
import Primitives.Vector;
import Primitives.Ray;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Geometry implements Comparable<Triangle>, FlatGeometry {
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

    //************************constructors******************************//
    //default constructor
    public Triangle() {
        _p1 = new Point3D();
        _p2 = new Point3D();
        _p3 = new Point3D();
    }

    //copy constructor
    public Triangle(Triangle triangle) {
        _p1 = triangle.getP1();
        _p2 = triangle.getP2();
        _p3 = triangle.getP3();
    }

    public Triangle(Point3D p1, Point3D p2, Point3D p3) {
        _p1 = new Point3D(p1);
        _p2 = new Point3D(p2);
        _p3 = new Point3D(p3);
    }

    //***************************getters and setters***************************************//
    public Point3D getP1() {
        return new Point3D(_p1);
    }

    public Point3D getP2() {
        return new Point3D(_p2);
    }

    public Point3D getP3() {
        return new Point3D(_p3);
    }

    public void setP1(Point3D p1) {
        this._p1 = new Point3D(p1);
    }

    public void setP2(Point3D p2) {
        this._p2 = new Point3D(p2);
    }

    public void setP3(Point3D p3) {
        this._p3 = new Point3D(p3);
    }

    //********************************functions**************************************//
    @Override
    public int compareTo(Triangle triangle) {
        if (this._p1.compareTo(triangle.getP1()) == 0 && this._p2.compareTo(triangle.getP2()) == 0 && this._p3.compareTo(triangle.getP3()) == 0)
            return 0;
        return 1;
    }

    @Override
    public String toString(){
        System.out.println("P1: "+_p1.toString()+"P2: "+_p2.toString()+"P3: "+_p3.toString());
        return "";
    }

    @Override
    public Vector getNormal(Point3D P) {
        Vector FirstVec = new Vector(_p1, _p2);
        Vector SecondVec = new Vector(_p1, _p3);
        Vector NormalVec = new Vector(FirstVec.crossProduct(SecondVec));

        try {
            NormalVec.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        NormalVec.multInScalar(-1.0);
        return NormalVec;
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List<Point3D> intersectionPoints = new ArrayList<Point3D>(1);

        // Intersecting the triangular plane
        Point3D P0 = ray.getPoint3D();
        Vector N = getNormal(null);
        Plane plane = new Plane(_p3,N);

        if (plane.FindIntersections(ray).isEmpty())
            return intersectionPoints;

        Point3D intersectionPlane = plane.FindIntersections(ray).get(0);

        // Checking if the interseculating point is bounded by the triangle
        Vector P_P0 = new Vector(P0, intersectionPlane);
        // Checking 1/3 triangular side
        Double Side1=Chacking_Side(P_P0,ray,P0,this._p1,this._p2);
        // Checking 2/3 triangular side
        Double Side2=Chacking_Side(P_P0,ray,P0,this._p2,this._p3);
        // Checking 1/3 triangular side
        Double Side3=Chacking_Side(P_P0,ray,P0,this._p3,this._p1);
        if (((Side1 > 0) && (Side2 > 0) && (Side3 > 0)) ||
                ((Side1 < 0) && (Side2 < 0) && (Side3 < 0))){
            intersectionPoints.add(intersectionPlane);
        }
        return intersectionPoints;
    }

    private Double Chacking_Side( Vector V, Ray R,Point3D P0, Point3D x, Point3D y){

        Vector V1_1 = new Vector(P0, x);
        Vector V2_1 = new Vector(P0, y);
        Vector N1 = V1_1.crossProduct(V2_1);
        try {
            N1.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        double Side = -V.dotProduct(N1);
        return Side;
    }
}
