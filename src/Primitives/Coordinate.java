package Primitives;

public class Coordinate implements Comparable<Coordinate>{
    private double coordinate;

    //******************************constructors************************//
    public Coordinate(double coordinate) {
        this.coordinate = coordinate;
    }

    //default constructor
    public Coordinate() {
        coordinate = 0;
    }

    ///copy constructor
    public Coordinate(Coordinate c) {
        this.coordinate = c.coordinate;
    }

//********************Getters and seters**************************************************//
    public double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }

//******************************functions************************************************//
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
