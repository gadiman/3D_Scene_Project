package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public class DirectionalLight extends Light {
    Vector direction;

    //****************************constructors****************************************//
    public DirectionalLight() {
        super(new Color(255, 255, 255));
        direction = new Vector(0, 0, -1);
    }

    public DirectionalLight(Color _color, Vector direction) {
        super(_color);
        setDirection(direction);
    }

    public DirectionalLight(DirectionalLight d) {
        super(d._color);
        setDirection(d.direction);
    }

    //*******************************getters and setters****************************//
    public Vector getDirection() {
        return new Vector(direction);
    }

    public void setDirection(Vector direction) {
        this.direction = new Vector(direction);
    }
    //********************************functions**************************************//

    @Override
    public Color getIntensity(Point3D p) {
        return super.getIntensity(p);
    }

}
