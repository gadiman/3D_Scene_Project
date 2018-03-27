package Primitives;

public class Point2D  implements Comparable<Point2D>{
    protected Coordinate _x;
    protected Coordinate _y;

    //***************************************constructors***************************//
    public Point2D(Coordinate x, Coordinate y) {
        this._x = new Coordinate(x);
        this._y = new Coordinate(y);
    }

    ///default constructor
    public Point2D() {
        _x = new Coordinate(0);
        _y = new Coordinate(0);
    }

    ///copy constructors
    public Point2D(Point2D point2d){
        _x=new Coordinate(point2d._x);
        _y=new Coordinate(point2d._y);
    }
//*****************************getters and srtters********************************//
    public Coordinate getX() {
        return new Coordinate(_x);
    }

    public void setX(Coordinate x) {
        this._x = new Coordinate(x);
    }

    public Coordinate getY() {
        return new Coordinate(_y);
    }

    public void setY(Coordinate y) {
        this._y = new Coordinate(y);
    }


//************************************fuctions************************************//
    @Override
    public int compareTo(Point2D point2D) {
        if (this._x.compareTo(point2D._x) == 0 &&
                this._y.compareTo(point2D._y) == 0)
            return 0;
        return 1;
    }

    @Override
    public String toString() {
        System.out.println("point2d: ");
        _x.toString();
        _y.toString();
        return "";
    }
}
