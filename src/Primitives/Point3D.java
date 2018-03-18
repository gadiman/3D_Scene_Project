package Primitives;

public class Point3D extends Point2D{
    private Coordinate z;

    ///constractor
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.z = z;
    }

    ///defolt constractor
    public Point3D() {
        super(new Coordinate(0), new Coordinate(0));
        z=new Coordinate(0);
    }

    ///copy constractor
    public Point3D(Point3D point3d) {
        super(new Coordinate(point3d.getX()), new Coordinate(point3d.getY()));
        this.z = new Coordinate(point3d.getZ());
    }

    public Coordinate getZ() {
        return z;
    }

    public void setZ(Coordinate z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point3D)
            return ((Point3D)obj).x.equals(this.x)&&((Point3D)obj).y.equals(this.y)&&((Point3D)obj).z.equals(this.y);
        return false;
    }

    @Override
    public String toString() {
        System.out.println("point3d:");
        super.toString();
        z.toString();
        return "";
    }
}
