package Geometries;

import Primitives.Point3D;

public class Triangle {
    private Point3D _p1;
    private Point3D _p2;
    private Point3D _p3;

 //************************constructors******************************//
 //default constructor
 public Triangle(){
     _p1 = new Point3D();
     _p2 = new Point3D();
     _p3 = new Point3D();
 }
    //copy constructor
    public Triangle(Triangle triangle){
        _p1 = triangle.getP1();
        _p2 = triangle.getP2();
        _p3 = triangle.getP3();
    }

    public Triangle(Point3D p1, Point3D p2, Point3D p3){
        _p1 = new Point3D(p1);
        _p2 = new Point3D(p2);
        _p3 = new Point3D(p3);
    }

//***************************getters and setters***************************************//
    public Point3D getP1() { return new Point3D(_p1); }
    public Point3D getP2() { return new Point3D(_p2); }
    public Point3D getP3() { return new Point3D(_p3); }

    public void setP1(Point3D p1) {	this._p1 = new Point3D(p1);	}
    public void setP2(Point3D p2) {	this._p2 = new Point3D(p2);	}
    public void setP3(Point3D p3) {	this._p3 = new Point3D(p3);	}


}
