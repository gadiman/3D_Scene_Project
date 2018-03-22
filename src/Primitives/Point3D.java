package Primitives;

public class Point3D extends Point2D{
    private Coordinate z;

    //***********************************constructors********************************//
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.z = z;
    }

    ///default constructor
    public Point3D() {
        super(new Coordinate(0), new Coordinate(0));
        z=new Coordinate(0);
    }

    ///copy constructor
    public Point3D(Point3D point3d) {
        super(new Coordinate(point3d.getX()), new Coordinate(point3d.getY()));
        this.z = new Coordinate(point3d.getZ());
    }
 //*******************************getters and setters****************************//
    public Coordinate getZ() {
        return new Coordinate(z);
    }

    public void setZ(Coordinate z) {
        this.z = new Coordinate(z);
    }


//********************************functions**************************************//
    public int compareTo(Point3D point3D) {

        if (((Point2D)this).compareTo((Point2D)point3D) == 0)
            if (this.z.compareTo(point3D.z) == 0)
                return 0;
        return 1;
    }

    @Override
    public String toString() {
        System.out.println("point3d:");
        super.toString();
        z.toString();
        return "";
    }
}
