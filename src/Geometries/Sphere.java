package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

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

    public Vector getNormal(Point3D p) {
        return null;
    }
}