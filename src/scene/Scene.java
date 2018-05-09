package scene;

import Elements.AmbientLight;
import Elements.Camera;
import Geometries.Geometry;

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


    //**********************constructors***********************************//

    public Scene(){
            BackgroundColor = new Color(0, 0, 0);
            _ambientLight = new AmbientLight();
            set_camera(new Camera());
            ScreenDistance = 100;
            SceneName=" scene";
    }

    public Scene (Scene scene){
        BackgroundColor= scene.getBackgroundColor();
        _ambientLight = scene.get_ambientLight();
        Geometreis = scene.Geometreis;
        _camera = scene.get_camera();
        ScreenDistance = scene.ScreenDistance;
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

    public void setScreenDistance(double screenDistance) {
        ScreenDistance = screenDistance;
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
}
