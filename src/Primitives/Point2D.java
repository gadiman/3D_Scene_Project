package Primitives;

public class Point2D  implements Comparable<Point2D>{
    protected Coordinate x;
    protected Coordinate y;

    ///constractors
    public Point2D(Coordinate x, Coordinate y) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
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
        return new Coordinate(x);
    }

    public void setX(Coordinate x) {
        this.x = new Coordinate(x);
    }

    public Coordinate getY() {
        return new Coordinate(y);
    }

    public void setY(Coordinate y) {
        this.y = new Coordinate(y);
    }

@Override
    public int compareTo(Point2D point2D) {
        if (this.x.compareTo(point2D.x) == 0 &&
                this.y.compareTo(point2D.y) == 0)
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        System.out.println("point2d: ");
        x.toString();
        y.toString();
        return "";
    }
}
