package Primitives;

public class Point3D extends Point2D implements Comparable<Point2D> {
    private Coordinate _z;

    //***********************************constructors********************************//
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this._z = z;
    }

    public Point3D(double x, double y, double z) {
        super(new Coordinate(x), new Coordinate(y));
        _z = new Coordinate(z);
    }

    ///default constructor
    public Point3D() {
        super(new Coordinate(0), new Coordinate(0));
        _z = new Coordinate(0);
    }

    ///copy constructor
    public Point3D(Point3D point3d) {
        super(new Coordinate(point3d.getX()), new Coordinate(point3d.getY()));
        this._z = new Coordinate(point3d.getZ());
    }

    //*******************************getters and setters****************************//
    public Coordinate getZ() {
        return new Coordinate(_z);
    }

    public void setZ(Coordinate z) {
        this._z = new Coordinate(z);
    }

    //********************************functions**************************************//
    @Override
    public int compareTo(Point2D point2D) {
        if (point2D instanceof Point3D) {
            if (((Point2D) this).compareTo((Point2D) point2D) == 0)
                if (this._z.compareTo(((Point3D)point2D)._z) == 0)
                    return 0;
            return 1;
        }
        throw new ArithmeticException("this not Point3D");
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
