package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;

public class Sphere extends RadialGeometry implements Comparable<Sphere>{

    private Point3D _center;

    //*****************************constructors***************************//
    ///default constructor
    public Sphere() {
        super(0.0);
        _center = new Point3D();
    }

    //copy constructor
    public Sphere(Sphere sphere) {
        super(sphere._radius);
        _center = sphere.getCenter();
    }

    public Sphere(double radius, Point3D center) {
        super(radius);
        _center = new Point3D(center);
    }

    //********************************getters and setters**********************//
    public Point3D getCenter() {
        return new Point3D(_center);
    }

    public void setCenter(Point3D center) {
        this._center = new Point3D(_center);
    }

    //********************************functions**************************************//
    @Override
    public int compareTo(Sphere sphere){
        if (_radius==sphere._radius&&_center.compareTo(sphere._center)==0)
            return 0;
        return 1;
    }

    @Override
    public String toString(){
        System.out.println("radius: "+_radius+"\n center: ");
        _center.toString();
        return "";
    }

    public Vector getNormal(Point3D p){
        Vector Normal= new Vector(_center, p);
        try {
            Normal.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Normal;

    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {

        List<Point3D> intersectionPoints= new ArrayList<Point3D>(2);

        Vector L = new Vector(ray.getPoint3D(), this.getCenter());
        double tm = L.dotProduct(ray.getVector());
        double d = Math.sqrt(Math.pow(L.length(), 2) - Math.pow(tm, 2));

        if (d > this.getRadius())
            return intersectionPoints;

        double th = Math.sqrt(Math.pow(this.getRadius(), 2) - Math.pow(d, 2));

        double t1 = tm - th;
        double t2 = tm + th;

        if (t1 >= 0){
            Vector V = ray.getVector();
            V.multInScalar(t1);
            Point3D P1 = ray.getPoint3D();
            P1.addVectorToPoint(V);
            intersectionPoints.add(P1);
        }

        if (t2 >= 0){
            Vector V = ray.getVector();
            V.multInScalar(t2);
            Point3D P2 = ray.getPoint3D();
            P2.addVectorToPoint(V);
            intersectionPoints.add(P2);
        }

        return intersectionPoints;
    }
}