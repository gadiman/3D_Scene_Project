package Elements;

import Primitives.Point3D;

import java.awt.*;

public class PointLight extends Light {
    protected Point3D position;
    Double Kc, Kl, Kq;

    //****************************constructors****************************************//

    public PointLight(Color color, Point3D position, Double kc, Double kl, Double kq) {
        super(color);
        this.position = new Point3D(position);
        Kc = kc;
        Kl = kl;
        Kq = kq;
    }

    public PointLight(PointLight _pointlight) {
        super(_pointlight._color);
        this.position = new Point3D(_pointlight.position);
        Kc = _pointlight.Kc;
        Kl = _pointlight.Kl;
        Kq = _pointlight.Kq;
    }

    //********************************functions**************************************//
    public Color getIntensity(Point3D p3d) {
        Double distance = position.distance(p3d);
        Double k = 1 / Kc + Kl * distance + Kq * Math.pow(distance, 2);
        if (k > 1) k = 1.0;
        return new Color((int) (_color.getRed() * k), (int) (_color.getGreen() * k), (int) (_color.getBlue() * k));
    }
}
