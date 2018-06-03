package Elements;

import Primitives.Point3D;

import java.awt.Color;

public abstract class Light {
    protected Color _color;
    protected Color getIntensity(Point3D p){return _color;}

    //********************************constructors************************************//

    public Light() {
        _color = null;
    }

    public Light(Color color) {
        _color = color;
    }
}
