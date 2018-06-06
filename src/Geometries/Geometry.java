package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.awt.*;
import java.util.List;

public abstract class Geometry {

    private Color _emmission = new Color(0, 0, 0);
    private Material material = new Material();
    private double _nShininess = 1;


    //***************************Getters and Setters*********************************//

    public Material getMaterial() {
        return this.material;
    }

    public double getShininess() {
        return _nShininess;
    }


    public void setShininess(double n) {
        _nShininess = n;
    }


    public void setMaterial(Material material) {
        this.material = material;
    }

    public Color get_emmission() {
        return _emmission;
    }

    public void set_emmission(Color _emmission) {
        this._emmission = _emmission;
    }
    public void setKs(double ks) { material.setKs(ks); }
    public void setKd(double kd) { material.setKd(kd); }
    public void setKr(double Kr) { material.setKr(Kr); }
    public void setKt(double Kt) { material.setKt(Kt); }
    //********************************functions**************************************//
    public abstract Vector getNormal(Point3D p);

    public abstract List<Point3D> FindIntersections(Ray ray);

}
