package Primitives;

public class Vector implements Comparable<Vector>{
    private Point3D head;

    //*************************************constructors*******************************************//
    public Vector(Point3D head) {
        this.head = head;
    }

    ///default constructor
    public Vector() {
        head =new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
    }

    ///copy constructor
    public Vector(Vector vector){
        head=new Point3D(vector.head);
    }


//************************************getters and setters****************************************//
    public Point3D getHead() {
        return new Point3D(head);
    }

    public void setHead(Point3D head) {
        this.head = new Point3D(head);
    }


//**************************************functions**********************************************//
    @Override
    public int compareTo(Vector vector) {
        return this.head.compareTo(vector.head);
    }

    @Override
    public String toString() {
        System.out.println("vector: ");
        head.toString();
        return "";
    }
}
