package Elements;

import java.awt.*;
import java.util.Map;

public class AmbientLight extends Light {
    private final double Ka = 0.1;

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


    public AmbientLight(Map<String, String> attributes){
        String[] ambientLightColors = attributes
                .get("color" ).split("\\s+");
        _color = new Color((int)(255 * Double.valueOf(ambientLightColors[0])),
                (int)(255 * Double.valueOf(ambientLightColors[1])),
                (int)(255 * Double.valueOf(ambientLightColors[2])));
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
    public Color getIntensity() {
        return new Color((int) (_color.getRed() * Ka), (int) (_color.getGreen() * Ka), (int) (_color.getBlue() * Ka));
    }


}
