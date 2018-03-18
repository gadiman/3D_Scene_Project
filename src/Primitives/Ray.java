package Primitives;

public class Ray {
    private Point3D point3D;
    private Vector vector;

    ///constractor
    public Ray(Point3D p, Vector v) {
        this.point3D = p;
        this.vector = v;
    }

    ///defolt constractor
    public Ray() {
        point3D = new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0));
        vector=new Vector(new Point3D(new Coordinate(0), new Coordinate(0), new Coordinate(0)));
    }

    ///copy constractor
    public Ray(Ray ray){
        point3D=new Point3D(ray.point3D);
        vector=new Vector(ray.vector);
    }

    public Point3D getPoint3D() {
        return point3D;
    }

    public void setPoint3D(Point3D point3D) {
        this.point3D = point3D;
    }

    public Vector getVector() {
        return vector;
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ray)
            return ((Ray)obj).vector.equals(this.vector)&&((Ray)obj).point3D.equals(this.point3D);
        return false;
    }

    @Override
    public String toString() {
        System.out.println("ray: ");
        vector.toString();
        point3D.toString();
        return "";
    }
}
