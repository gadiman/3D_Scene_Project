package Elements;

import Primitives.Point3D;

import java.awt.Color;

public class AmbientLight extends Light {
    private final double Ka = 1.0;

    //****************************constructors****************************************//
    public AmbientLight() {
        super(new Color(255, 255, 255));
    }

    public AmbientLight(AmbientLight ambientLight) {
        super(ambientLight._color);
    }

    public AmbientLight(int r, int g, int b) {
        super(new Color(r, g, b));
    }

    // ***************** Getters/Setters ********************** //

    public Color getColor() {
        return _color;
    }

    public void setColor(Color color) {
        _color = color;
    }

    public double getKa() {
        return Ka;
    }

    @Override
    public Color getIntensity(Point3D p) {
        return new Color((int) (_color.getRed() * Ka), (int) (_color.getGreen() * Ka), (int) (_color.getBlue() * Ka));
    }
}
