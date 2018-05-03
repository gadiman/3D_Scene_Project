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
    public Camera(){

        _center = new Point3D(0, 0, 10);
        Vup = new Vector(new Point3D(1.0, 0.0, 0.0));
        Vto = new Vector(new Point3D(0.0, 0.0, -1.0));

        Vright = Vup.crossProduct(Vto);
    }
//Copy constructor
    public Camera (Camera camera){
        _center = camera.get_center();
        Vup = camera.get_Vup();
        Vto = camera.get_Vto();
        Vright = camera.get_Vright();
    }

    public Camera (Point3D P0, Vector vUp, Vector vTo){
        _center = new Point3D(P0);
        Vup = new Vector(vUp);
        Vto = new Vector(vTo);
        Vright = Vup.crossProduct(Vto);
        Vup = Vto.crossProduct(Vright);

        try {
            Vup.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Vto.normalize();
        } catch (Exception e) {
            e.printStackTrace();e.printStackTrace();
        }
        try {
            Vright.normalize();
        } catch (Exception e) {

        }

    }
    //********************************getters and setters**********************//
    public Vector get_Vup() { return new Vector(Vup);}
    public Vector get_Vto() { return new Vector(Vto);}
    public Point3D get_center() { return new Point3D(_center);}
    public Vector get_Vright(){ return new Vector(Vright);}

    public void set_Vup(Vector _Vup) { this.Vup = new Vector(_Vup);}
    public void set_Vto(Vector _Vto){ this.Vto = new Vector(_Vto);}
    public void set_center(Point3D center) { this._center  = new Point3D(center);}


    //********************************functions**************************************//
    public Ray constructRayThroughPixel(int Nx, int Ny, double x, double y, double screenDist,
                                 double screenWidth, double screenHeight){

        return null;
    }




}
