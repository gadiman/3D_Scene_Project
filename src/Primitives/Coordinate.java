package Primitives;

public class Coordinate implements Comparable<Coordinate>{
    private double coordinate;

    ///constractor
    public Coordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    ///defolt constractor
    public Coordinate() {
        coordinate = 0;
    }

    ///copy constractor
    public Coordinate(Coordinate c) {
        this.coordinate = c.coordinate;
    }

    public double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }


@Override
    public int compareTo(Coordinate coordinate) {
        return Double.compare(this.coordinate, coordinate.coordinate);
    }


    @Override
    public String toString() {
        System.out.println("coordinate: "+coordinate);
        return "";
    }
}
