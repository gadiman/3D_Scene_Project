package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

public class Cylinder extends RadialGeometry implements Comparable<Cylinder>{
    private Point3D _axisPoint;
    private Vector _axisDirection;

    //*****************************constructors********************************//
    //default constructor
    public Cylinder() {
        super(0.0);
        _axisPoint = new Point3D();
        _axisDirection = new Vector();
    }

    //copy constructor
    public Cylinder(Cylinder cylinder) {
        super(cylinder._radius);
        _axisPoint = cylinder.getAxisPoint();
        _axisDirection = cylinder.getAxisDirection();
    }

    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection) {
        super(radius);
        _axisPoint = new Point3D(axisPoint);
        _axisDirection = new Vector(axisDirection);
    }

//************************************getters and setters*********************** //

    public Point3D getAxisPoint() {
        return new Point3D(_axisPoint);
    }

    public Vector getAxisDirection() {
        return new Vector(_axisDirection);
    }

    public void setAxisPoint(Point3D axisPoint) {
        this._axisPoint = new Point3D(axisPoint);
    }

    public void setAxisDirection(Vector axisDirection) {
        this._axisDirection = new Vector(axisDirection);
    }

    //********************************functions***************************************//
    @Override
    public int compareTo(Cylinder cylinder){
        if (_radius==cylinder._radius&&_axisPoint.compareTo(cylinder.getAxisPoint())==0&&_axisDirection.compareTo(cylinder.getAxisDirection())==0)
            return 0;
        return 1;
    }

    @Override
    public String toString(){
        System.out.println("radius: "+_radius+"\n point: "+_axisPoint.toString()+"direction: "+_axisDirection.toString());
        return "";
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        return null;
    }

}
