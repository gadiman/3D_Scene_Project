package Primitives;

public class Vector implements Comparable<Vector>{
    private Point3D head;

    ///constractor
    public Vector(Point3D head) {
        this.head = head;
    }

    ///difolt constractor
    public Vector() {
        head =new Point3D(new Coordinate(0),new Coordinate(0),new Coordinate(0));
    }

    ///copy constractor
    public Vector(Vector vector){
        head=new Point3D(vector.head);
    }

    public Point3D getHead() {
        return head;
    }

    public void setHead(Point3D head) {
        this.head = head;
    }

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
