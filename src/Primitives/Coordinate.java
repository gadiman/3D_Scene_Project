package Primitives;

public class Coordinate {
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
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate)
            return ((Coordinate)obj).coordinate==this.coordinate;
        return false;
    }

    @Override
    public String toString() {
        System.out.println("coordinate: "+coordinate);
        return "";
    }
}
