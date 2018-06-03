package Primitives;

public class Point3D extends Point2D implements Comparable<Point2D> {
    private Coordinate _z;

    //***********************************constructors********************************//
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this._z = new Coordinate(z);
    }

    public Point3D(double x, double y, double z) {
        super(new Coordinate(x), new Coordinate(y));
        _z = new Coordinate(z);
    }

    ///default constructor
    public Point3D() {
        _z = new Coordinate();
    }

    ///copy constructor
    public Point3D(Point3D point3D) {
        super(point3D.getX(), point3D.getY());
        _z = point3D.getZ();
    }

    //*******************************getters and setters****************************//
    public Coordinate getZ() {
        return new Coordinate(_z);
    }

    public void setZ(Coordinate z) {
        this._z = new Coordinate(z);
    }

    //********************************functions**************************************//

    public int compareTo(Point3D P3d) {
        if (((Point2D) this).compareTo((Point2D) P3d) == 0)
            if (this._z.compareTo(P3d._z) == 0)
                return 0;
        return 1;
    }

    @Override
    public String toString() {
        System.out.println("point3d:");
        super.toString();
        _z.toString();
        return "";
    }

    public void subvector(Vector v) {
        _x.substract(v.getHead().getX());
        _y.substract(v.getHead().getY());
        _z.substract(v.getHead().getZ());
    }

    public void addVectorToPoint(Vector v) {
        _x.add(v.getHead().getX());
        _y.add(v.getHead().getY());
        _z.add(v.getHead().getZ());
    }

    public Double distance(Point3D p) {
        return Math.sqrt(Math.pow(_x.getCoordinate() + p.getX().getCoordinate(), 2)
                + Math.pow(_y.getCoordinate() + p.getY().getCoordinate(), 2)
                + Math.pow(_z.getCoordinate() + p.getZ().getCoordinate(), 2));
    }
}
