package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public class SpotLight extends PointLight {
    private Vector direction;
//****************************constructors****************************************//

    public SpotLight(Color color, Point3D position, Double kc, Double kl, Double kq, Vector direction) {
        super(color, position, kc, kl, kq);
        this.direction = new Vector(direction);
    }

    public SpotLight(SpotLight _spotLight) {
        super(_spotLight._color, _spotLight.position, _spotLight.Kc, _spotLight.Kl, _spotLight.Kq);
        this.direction = new Vector(_spotLight.direction);
    }

    //********************************functions**************************************//

    public Color getIntensity(Point3D p3d) {
        Vector L0 = new Vector(p3d, position);
        L0.normalize();
        Double dotprodact = Math.abs(L0.dotProduct(direction));
        if (dotprodact > 1) dotprodact = 1.0;
        Color pointColor = super.getIntensity(p3d);
        return new Color((int) (pointColor.getRed() * dotprodact), (int) (pointColor.getGreen() * dotprodact),
                (int) (pointColor.getBlue() * dotprodact));
    }

}
