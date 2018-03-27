package Geometries;

public abstract class RadialGeometry extends Geometry {

    protected double _radius;

//**********************constructors***********************************//
//default constructor
    public RadialGeometry(){ this._radius = 0.0;}

    public RadialGeometry(double _radius) { this._radius = _radius; }

//**************************getters and setters************************//
    public double getRadius(){ return _radius;	    }
    public void   setRadius(double _radius) { this._radius = _radius; }

}