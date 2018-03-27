package Primitives;

public class Coordinate implements Comparable<Coordinate>{
    private double _coordinate;

    //******************************constructors************************//
    public Coordinate(double coordinate) {
        this._coordinate = coordinate;
    }

    //default constructor
    public Coordinate() {
        _coordinate = 0;
    }

    ///copy constructor
    public Coordinate(Coordinate c) {
        this._coordinate = c._coordinate;
    }

//********************Getters and seters**************************************************//
    public double getCoordinate() {
        return _coordinate;
    }

    public void setCoordinate(double coordinate) {
        this._coordinate = coordinate;
    }

//******************************functions************************************************//
    @Override
    public int compareTo(Coordinate coordinate) {
        return Double.compare(this._coordinate, coordinate._coordinate);
    }


    @Override
    public String toString() {
        System.out.println("coordinate: "+ _coordinate);
        return "";
    }
}
