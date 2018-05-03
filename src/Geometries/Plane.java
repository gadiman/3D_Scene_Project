package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

public class Plane extends Geometry implements Comparable<Plane>{

    protected Point3D point;
    protected Vector normal;

    //****************************constructors****************************************//
    ///default constructor
    public Plane() {
        point = new Point3D();
        normal = new Vector();
    }

    public Plane(Point3D point, Vector normal) {
        this.point = new Point3D(point);
        this.normal = new Vector(normal);
    }

    //copy constructor
    public Plane(Plane plane) {
        point = plane.getPoint();
        normal = plane.getNormal();
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

    public void setNormal(Vector normal) {
        this.normal = new Vector(normal);
    }

    //********************************functions***************************************//
    @Override
    public int compareTo(Plane plane){
        if (point.compareTo(plane.point)==0&&normal.compareTo(plane.normal)==0)
            return 0;
        return 1;
    }

    @Override
    public String toString(){
        System.out.println("point: "+point.toString()+"normal: "+normal.toString());
        return "";
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}

