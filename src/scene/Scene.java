package scene;

import Elements.AmbientLight;
import Elements.Camera;
import Elements.LightSource;
import Geometries.Geometry;
import Primitives.Coordinate;
import Primitives.Point3D;
import Primitives.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Scene {

    private String SceneName;
    private Color BackgroundColor;
    private List<Geometry> Geometreis = new ArrayList<Geometry>();
    private Camera _camera;
    private double ScreenDistance;
    private AmbientLight _ambientLight;
    private List<LightSource> _lights = new ArrayList<LightSource>();

    //**********************constructors***********************************//

    public Scene(){
            BackgroundColor = new Color(0, 0, 0);
            _ambientLight = new AmbientLight();
            set_camera(new Camera());
            ScreenDistance = 50;
            SceneName=" scene";
    }

    public Scene (Scene scene){
        BackgroundColor= scene.getBackgroundColor();
        _ambientLight = scene.get_ambientLight();
        Geometreis = scene.getGeometreis();
        _camera = scene.get_camera();
        ScreenDistance = scene.ScreenDistance;
        _lights=scene._lights;
    }

    public Scene(AmbientLight aLight, Color background,
                 Camera camera, double screenDistance){
        BackgroundColor = background;
        _ambientLight = new AmbientLight(aLight);
        set_camera(new Camera(camera));
        ScreenDistance = screenDistance;
    }
//***************************Getters and Setters*********************************//
    public String getSceneName() {
        return SceneName;
    }

    public void setSceneName(String sceneName) {
        SceneName = sceneName;
    }

    public Color getBackgroundColor() {
        return  BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
    }

    public List<Geometry> getGeometreis() {
        return Geometreis;
    }

    public void setGeometreis(List<Geometry> geometreis) {
        Geometreis = geometreis;
    }

    public Camera get_camera() {
        return new Camera(_camera);
    }

    public void set_camera(Camera _camera) {
        this._camera = new Camera(_camera);
    }

    public double getScreenDistance() {
        return ScreenDistance;
    }

    public void setScreenDistance(double screenDistance_) {
        ScreenDistance = screenDistance_;
    }

    public AmbientLight get_ambientLight() {
        return new AmbientLight( _ambientLight);
    }

    public void set_ambientLight(AmbientLight _ambientLight) {
        this._ambientLight = new AmbientLight(_ambientLight);
    }


//************************************ Functions *********************************** //

    public void addGeometry(Geometry geometry){
        Geometreis.add(geometry);
    }
    public Iterator<Geometry> getGeometriesIterator(){

        return Geometreis.iterator();
    }
    public Iterator<LightSource> getLightsIterator(){
        return _lights.iterator();
    }

    public void addLight(LightSource light){
        _lights.add(light);
    }




    public void RoutinX(Vector src ,double radians) {
        float cos, sin;

        cos = (float) Math.cos(radians);
        sin = (float) Math.sin(radians);
        Vector dst = new Vector();

        double y = src.getHead().getY().getCoordinate() , z = src.getHead().getZ().getCoordinate();
        dst= new Vector(new Point3D(src.getHead().getX(),
        new Coordinate( cos * y - sin * z),
        new Coordinate(sin * y + cos * z)));
        dst.normalize();
       this._camera.set_Vright(new Vector(dst));
      RoutinZ(_camera.get_Vup(),radians);
       RoutinY(_camera.get_Vto(),radians);
    }

    public void RoutinY(Vector src ,double radians) {
        float cos, sin;

        cos = (float) Math.cos(radians);
        sin = (float) Math.sin(radians);
        Vector dst = new Vector();

        double x = src.getHead().getX().getCoordinate(),y=src.getHead().getY().getCoordinate(), z = src.getHead().getZ().getCoordinate();
        dst=new Vector(new Point3D(new Coordinate(cos * x - sin * z),new Coordinate( cos * y - sin * z),new Coordinate(sin * y + cos * z)));
        dst.normalize();
        this._camera.set_Vto(new Vector(dst));


    }

    public void RoutinZ(Vector src ,double radians) {

        Vector dst = new Vector();

        dst = _camera.get_Vup().crossProduct(_camera.get_Vto());


        dst.normalize();
        this._camera.set_Vup(new Vector(dst));



    }


}
