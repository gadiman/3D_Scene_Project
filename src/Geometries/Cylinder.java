package Geometries;

import Primitives.Point3D;
import Primitives.Vector;

public class Cylinder  extends RadialGeometry  {
    private Point3D _axisPoint;
    private Vector _axisDirection;

//*****************************constructors********************************//
    //default constructor
    public Cylinder(){
        super(0.0);
        _axisPoint = new Point3D();
        _axisDirection = new Vector();
    }
    //copy constructor
    public Cylinder(Cylinder cylinder){
        super(cylinder._radius);
        _axisPoint = cylinder.getAxisPoint();
        _axisDirection = cylinder.getAxisDirection();
    }

    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection){
        super(radius);
        _axisPoint = new Point3D(axisPoint);
        _axisDirection = new Vector(axisDirection);
    }

//************************************getters and setters*********************** //

    public Point3D getAxisPoint(){ return new Point3D(_axisPoint);	  }
    public Vector getAxisDirection() { return new Vector(_axisDirection); }

    public void setAxisPoint(Point3D axisPoint) { this._axisPoint = new Point3D(axisPoint); }
    public void setAxisDirection(Vector axisDirection) { this._axisDirection = new Vector(axisDirection); }



}
