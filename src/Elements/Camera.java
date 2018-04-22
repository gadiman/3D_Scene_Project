package Elements;

import Primitives.Point3D;
import Primitives.Vector;
import Primitives.Ray;

public class Camera {
    Point3D _center;
    Vector VUP;
    Vector VRIGHT;
    Vector VTOWORD;

    public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist,
                                 double screenWidth, double screenHeight){
        return null;
    }

}
