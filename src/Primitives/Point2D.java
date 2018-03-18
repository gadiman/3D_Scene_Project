package Primitives;

public class Point2D {
    protected Coordinate x;
    protected Coordinate y;

    ///constractor
    public Point2D(Coordinate x, Coordinate y) {
        this.x = x;
        this.y = y;
    }

    ///defolt constracyor
    public Point2D() {
        x = new Coordinate(0);
        y = new Coordinate(0);
    }

    ///copy constractor
    public Point2D(Point2D point2d){
        x=new Coordinate(point2d.x);
        y=new Coordinate(point2d.y);
    }

    public Coordinate getX() {
        return x;
    }

    public void setX(Coordinate x) {
        this.x = x;
    }

    public Coordinate getY() {
        return y;
    }

    public void setY(Coordinate y) {
        this.y = y;
    }
//github
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point2D)
            return ((Point2D)obj).x.equals(this.x)&&((Point2D)obj).y.equals(this.y);
        return false;
    }

    @Override
    public String toString() {
        System.out.println("point2d: ");
        x.toString();
        y.toString();
        return "";
    }
}
