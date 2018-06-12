package Geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.*;

public class Square extends Geometry implements FlatGeometry {
    private Triangle T1;
    private  Triangle T2;

    public Square(Point3D p1, Point3D p2, Point3D p3, Point3D p4){
        T1 = new Triangle(p1,p2,p4);
        T2 = new Triangle(p2,p3,p4);
    }
    public Square(){
        T1 = new Triangle();
        T2 = new Triangle();
    }

    public Square(Square quadrilateral){
        T1 = new Triangle(quadrilateral.T1);
        T2 = new Triangle(quadrilateral.T2);    }

    @Override
    public List<Point3D> FindIntersections(Ray ray) {
        List <Point3D> temp1 = T1.FindIntersections(ray);
        List <Point3D> temp2 = T2.FindIntersections(ray);

        temp1.addAll(temp2);
        Set<Point3D> set = new HashSet<Point3D>(temp1);
        List<Point3D> result = new ArrayList<Point3D>();
        result.addAll(set);
        return result;
    }
// ***************** Getters/Setters ********************** //

    public Point3D getP1() { return new Point3D(T1.getP1()); }
    public Point3D getP2() { return new Point3D(T1.getP2());}
    public Point3D getP3() { return new Point3D(T2.getP2()); }
    public Point3D getP4() { return new Point3D(T1.getP3()); }

    public void setP1(Point3D p1) {	this.T1.setP1(new Point3D(p1)); }
    public void setP2(Point3D p2) {	this.T1.setP2(new Point3D(p2));this.T2.setP1(new Point3D(p2));	}
    public void setP3(Point3D p3) {	this.T2.setP2(new Point3D(p3));}
    public void setP4(Point3D p4) {	this.T1.setP3(new Point3D(p4));this.T2.setP3(new Point3D(p4));}

    public Square(Map<String, String> attributes){

        Point3D _p1,_p2,_p3,_p4;
        String[] P0coordinates = attributes
                .get("P0" ).split("\\s+");

        _p1 = new Point3D(Double.valueOf(P0coordinates[0]),
                Double.valueOf(P0coordinates[1]),
                Double.valueOf(P0coordinates[2]));

        String[] P1coordinates = attributes
                .get("P1" ).split("\\s+");

        _p2 = new Point3D(Double.valueOf(P1coordinates[0]),
                Double.valueOf(P1coordinates[1]),
                Double.valueOf(P1coordinates[2]));

        String[] P2coordinates = attributes
                .get("P2" ).split("\\s+");

        _p3 = new Point3D(Double.valueOf(P2coordinates[0]),
                Double.valueOf(P2coordinates[1]),
                Double.valueOf(P2coordinates[2]));

        String[] P3coordinates = attributes
                .get("P3" ).split("\\s+");

        _p4 = new Point3D(Double.valueOf(P2coordinates[0]),
                Double.valueOf(P2coordinates[1]),
                Double.valueOf(P2coordinates[2]));

        T1 = new Triangle(_p1,_p2,_p4); //clockwise direction
        T2 = new Triangle(_p2,_p3,_p4); //clockwise direction
    }


    @Override
    public Vector getNormal(Point3D point) {
        return T1.getNormal(point);
    }
}
