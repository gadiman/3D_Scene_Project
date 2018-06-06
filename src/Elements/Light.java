package Elements;

import java.awt.*;

public abstract class Light {
    protected Color _color;

    //********************************constructors************************************//

    public Light() {
        _color = null;
    }

    public Light(Color color) {
        _color = color;
    }

    //***********************************functions************************************//
    protected Color getIntensity(){return _color;}

}
