package Elements;

import Primitives.Point3D;
import Primitives.Vector;
import Primitives.Ray;

public class Camera {
    Point3D _center;
    Vector Vup;
    Vector Vto;

    Vector Vright;

    //****************************constructors****************************************//
    // default constructor
    public Camera() {

        _center = new Point3D(0, 0, 10);
        Vup = new Vector(new Point3D(1.0, 0.0, 0.0));
        Vto = new Vector(new Point3D(0.0, 0.0, -1.0));
        Vright = Vup.crossProduct(Vto);
    }

    //Copy constructor
    public Camera(Camera camera) {
        _center = camera.get_center();
        Vup = camera.get_Vup();
        Vto = camera.get_Vto();
        Vright = camera.get_Vright();
    }

    public Camera(Point3D P0, Vector vUp, Vector vTo) {
        _center = new Point3D(P0);
        Vup = new Vector(vUp);
        Vto = new Vector(vTo);
        Vright = Vup.crossProduct(Vto);
        Vup = Vto.crossProduct(Vright);//////?????????????????

        try {
            Vup.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Vto.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Vright.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //********************************getters and setters**********************//
    public Vector get_Vup() {
        return new Vector(Vup);
    }

    public Vector get_Vto() {
        return new Vector(Vto);
    }

    public Point3D get_center() {
        return new Point3D(_center);
    }

    public Vector get_Vright() {
        return new Vector(Vright);
    }

    public void set_Vup(Vector _Vup) {
        this.Vup = new Vector(_Vup);
    }

    public void set_Vto(Vector _Vto) {
        this.Vto = new Vector(_Vto);
    }

    public void set_center(Point3D center) {
        this._center = new Point3D(center);
    }

    //********************************functions**************************************//
    public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist,
                                        double screenWidth, double screenHeight) {
        //Calculating Pc point
        Point3D Pc = new Point3D(Calculat_Pc(screenDist));
        //Calculating P point
        Point3D P = new Point3D(Calculat_P(Nx, Ny, x, y, screenDist, screenWidth, screenHeight, Pc));
        // constructing ray between P0 and the intersection point
        Vector ray = new Vector(_center, P);
        try {
            ray.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // returning the constructed ray
        return new Ray(P, ray);
    }

    // Calculating the image center
    private Point3D Calculat_Pc(double screenDist) {
        // Calculating the image center
        Vector vToward = new Vector(Vto);
        vToward.multInScalar(screenDist);

        Point3D Pc = new Point3D(_center);
        Pc.addVectorToPoint(vToward);
        return Pc;
    }

    //Calculating the intarsaction Point
    private Point3D Calculat_P(int Nx, int Ny, double x, double y, double screenDist,
                               double screenWidth, double screenHeight, Point3D Pc) {
        // Calculating x-y ratios
        double Rx = screenWidth / Nx;
        double Ry = screenHeight / Ny;

        // Calculating P - the intersection point
        Vector vRight = new Vector(Vright);
        Vector vUp = new Vector(Vup);

        vRight.multInScalar(((x - (Nx / 2)) * Rx + 0.5 * Rx));
        vUp.multInScalar(((y - (Ny / 2)) * Ry + 0.5 * Ry));
        vRight.subtract(vUp);
        Pc.addVectorToPoint(vRight);
        Point3D P = new Point3D(Pc);
        return P;
    }

    public String toString() {
        return "Vto: " + Vto + "\n" + "Vup: " + Vup + "\n" + "Vright:" + Vright + ".";
    }
}