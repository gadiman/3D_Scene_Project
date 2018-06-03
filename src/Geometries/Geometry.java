package Geometries;

import Primitives.Material;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import java.awt.*;
import java.util.List;

public abstract class Geometry {

    private Color _emmission = new Color(0, 0, 0);
    private Material material;

    //***********************************constructors********************************//
    ///default constructor
    public Geometry() {
    }

    //copy constructor
    public Geometry(Geometry geometry) {
    }

    //***************************Getters and Setters*********************************//

    public Material getMaterial() {
        return material;
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

    //********************************functions**************************************//
    public abstract Vector getNormal(Point3D p);
    public abstract List<Point3D> FindIntersections (Ray ray);

}
