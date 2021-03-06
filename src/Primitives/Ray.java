package Primitives;

public class Ray {
    private Point3D _POO;
    private Vector _direction;

    //***********************************constructor***********************************//


    public Ray(Point3D poo, Vector direction){
        this._POO = new Point3D(poo);
        this._direction = new Vector (direction);
        try {
            this._direction.normalize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///default constructor
    public Ray(){
        this._POO = new Point3D();
        this._direction = new Vector(_direction);
    }

    ///copy constructor
    public Ray(Ray ray){
        _POO=ray.getPoint3D();
        _direction=ray.getVector();
    }

//***************************************getters and setters***********************************//
    public Point3D getPoint3D() {
        return new Point3D(_POO);
    }

    public void setPoint3D(Point3D point3D) {
        this._POO = new Point3D(point3D);
    }

    public Vector getVector() {
        return new Vector(_direction);
    }

    public void setVector(Vector vector) {
        this._direction = new Vector(vector);
    }


//**************************************functions**********************************************//
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Ray)
            return ((Ray)obj)._direction.equals(this._direction)&&((Ray)obj)._POO.equals(this._POO);
        return false;
    }

    @Override
    public String toString() {
        System.out.println("ray: ");
        _direction.toString();
        _POO.toString();
        return "";
    }
}
