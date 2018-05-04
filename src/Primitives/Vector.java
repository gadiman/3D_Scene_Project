package Primitives;

import java.lang.Exception;

public class Vector implements Comparable<Vector> {
    private Point3D _head;

    //*************************************constructors******************************************//
    public Vector(Point3D head) {
        this._head = head;
    }

    ///default constructor
    public Vector() {
        this._head = new Point3D();
    }

    ///copy constructor
    public Vector(Vector vector) {
        this._head = new Point3D(vector.getHead());
    }

    public Vector(Point3D p1, Point3D p2){

        this(new Point3D(p2.getX().getCoordinate() - p1.getX().getCoordinate(),
                p2.getY().getCoordinate() - p1.getY().getCoordinate(),
                p2.getZ().getCoordinate() - p1.getZ().getCoordinate()));
    }

    public Vector(double x,  double y, double z){
        this._head =  new Point3D(new Coordinate(x),
                new Coordinate(y),
                new Coordinate(z));
    }


    //************************************getters and setters****************************************//
    public Point3D getHead() {
        return new Point3D(_head);
    }

    public void setHead(Point3D head) {
        this._head = new Point3D(head);
    }


    //**************************************functions************************************************//
    @Override
    public int compareTo(Vector vector) {
        return this.getHead().compareTo(new Vector(vector).getHead());
    }

    @Override
    public String toString() {
        System.out.println("vector: ");
        getHead().toString();
        return "";
    }

    public void add(Vector v) {
        this._head.addVectorToPoint(v);
    }

    public void subtract(Vector v) {
        this._head.subvector(v);
    }

    public void multInScalar(Double d) {
        this._head.setX(new Coordinate(_head.getX().getCoordinate() * d));
        this._head.setY(new Coordinate(_head.getY().getCoordinate() * d));
        this._head.setZ(new Coordinate(_head.getZ().getCoordinate() * d));
    }


    public double dotProduct(Vector v) {

        double X = _head.getX().getCoordinate();
        double Y = _head.getY().getCoordinate();
        double Z = _head.getZ().getCoordinate();
        return X * v.getHead().getX().getCoordinate() + Y * v.getHead().getY().getCoordinate() + Z * v.getHead().getZ().getCoordinate();
    }

    public Vector crossProduct(Vector v) {

        double X = _head.getX().getCoordinate();
        double Y = _head.getY().getCoordinate();
        double Z = _head.getZ().getCoordinate();
        double XV = v.getHead().getX().getCoordinate();
        double YV = v.getHead().getY().getCoordinate();
        double ZV = v.getHead().getZ().getCoordinate();
        return new Vector(new Point3D((Y * ZV) - (YV * Z), -((X * ZV) - (Z * XV)), (X * YV) - (XV * Y)));
    }

    public double length() {

        double X = getHead().getX().getCoordinate();
        double Y = getHead().getY().getCoordinate();
        double Z = getHead().getZ().getCoordinate();
        return Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2) + Math.pow(Z, 2));
    }

    public void normalize() throws Exception {

        double X = getHead().getX().getCoordinate();
        double Y = getHead().getY().getCoordinate();
        double Z = getHead().getZ().getCoordinate();
        double L = this.length();
        if (L == 0)
            throw new Exception("divide by zero exception!");
        this.setHead(new Point3D(X / L, Y / L, Z /L));
    }


}
