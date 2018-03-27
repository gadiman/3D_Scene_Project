package Primitives;

public class Vector implements Comparable<Vector>{
    private Point3D _head;

    //*************************************constructors*******************************************//
    public Vector(Point3D head) {
        this._head = head;
    }

    ///default constructor
    public Vector() {
        _head =new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
    }

    ///copy constructor
    public Vector(Vector vector){
        _head=new Point3D(vector._head);
    }


//************************************getters and setters****************************************//
    public Point3D getHead() {
        return new Point3D(_head);
    }

    public void setHead(Point3D head) {
        this._head = new Point3D(head);
    }


//**************************************functions**********************************************//
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
}
