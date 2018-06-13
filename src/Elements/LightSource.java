package Elements;

import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;

public interface LightSource{//interface

    public  Color getIntensity(Point3D point);
    public  Vector getL(Point3D point);

}