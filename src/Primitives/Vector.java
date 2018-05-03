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
        _head = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0));
    }

    ///copy constructor
    public Vector(Vector vector) {
        _head = new Point3D(vector._head);
    }

    public Vector(Point3D p1, Point3D p2){

        this(new Point3D(p2.getX().getCoordinate() - p1.getX().getCoordinate(),
                p2.getY().getCoordinate() - p1.getY().getCoordinate(),
                p2.getZ().getCoordinate() - p1.getZ().getCoordinate()));


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
        return this._head.compareTo(vector._head);
    }

    @Override
    public String toString() {
        System.out.println("vector: ");
        _head.toString();
        return "";
    }

    public void add(Vector v) {
        this._head.addVectorToPoint(v);
    }

    public void subtract(Vector v) {
        this._head.subvector(v);
    }

    public Vector multInScalar(Double d) {
        _head.getX().setCoordinate(_head.getX().getCoordinate() * d);
        _head.getY().setCoordinate(_head.getY().getCoordinate() * d);
        _head.getZ().setCoordinate(_head.getZ().getCoordinate() * d);
        return null;
    }

    double X = _head.getX().getCoordinate();
    double Y = _head.getY().getCoordinate();
    double Z = _head.getZ().getCoordinate();

    public double dotProduct(Vector v) {
        return X * v.getHead().getX().getCoordinate() + Y * v.getHead().getY().getCoordinate() + Z * v.getHead().getZ().getCoordinate();
    }

    public Vector crossProduct(Vector v) {
        double XV = v.getHead().getX().getCoordinate();
        double YV = v.getHead().getY().getCoordinate();
        double ZV = v.getHead().getZ().getCoordinate();
        return new Vector(new Point3D(Y * ZV - YV * Z, Z * XV - ZV * X, X * YV - XV * Y));
    }

    public double length() {
        return Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2) + Math.pow(Z, 2));
    }

    public void normalize() throws Exception {
        if (length() == 0)
            throw new Exception("size of the vector his 0");
        setHead(new Point3D(X / length(), Y / length(), Z / length()));
    }


}
