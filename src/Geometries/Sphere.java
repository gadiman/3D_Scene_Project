package Geometries;

import Primitives.Point3D;

public class Sphere extends RadialGeometry {

    private Point3D _center;

//*****************************constructors***************************//

    public Sphere() {
        super(0.0);
        _center = new Point3D();
    }

    public Sphere(Sphere sphere) {
        super(sphere._radius);
        _center = sphere.getCenter();
    }

    public Sphere(double radius, Point3D center) {
        super(radius);
        _center = new Point3D(center);
    }


//********************************getters and setters**********************//
    //default constructor
    public Point3D getCenter() {
        return new Point3D(_center);
    }
    //copy constructor
    public void setCenter(Point3D center) {
        this._center = new Point3D(_center);
    }


}