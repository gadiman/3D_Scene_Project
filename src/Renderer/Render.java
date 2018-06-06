package Renderer;

import Elements.LightSource;
import Geometries.FlatGeometry;
import Geometries.Geometry;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import scene.Scene;

import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Render {
    private Scene scene;
    private ImageWriter imageWriter;
    private final int RECURSION_LEVEL = 3;

    //**************************constructors**************************************//

    public Render(ImageWriter image, Scene _scene) {
        scene = new Scene(_scene);
        imageWriter = new ImageWriter(image);
    }

    //*****************************getters and setters**************************//

    public Scene getScene() {
        return new Scene(scene);
    }

    public void setScene(Scene scene) {
        this.scene = new Scene(this.scene);
    }

    public ImageWriter getImageWriter() {
        return new ImageWriter(this.imageWriter);
    }

    public void setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = new ImageWriter(imageWriter);
    }

    //******************************functions************************************//

    public void renderImage() {

        for (int i = 0; i < this.imageWriter.getHeight(); i++) {
            for (int j = 0; j < this.imageWriter.getWidth(); j++) {

                Ray ray = this.scene.get_camera().constructRayThroughPixel(this.imageWriter.getNx(), this.imageWriter.getNy(), j, i,
                        scene.getScreenDistance(), this.imageWriter.getWidth(), this.imageWriter.getHeight());

                Entry<Geometry, Point3D> entry = findClosesntIntersection(ray);
                if (entry == null) {
                    imageWriter.writePixel(j, i, scene.getBackgroundColor());
                } else {
                    imageWriter.writePixel(j, i, calcColor(entry.getKey(), entry.getValue(),ray));
                }
            }
        }
    }

    public void printGrid(int interval) {
        int h = this.imageWriter.getHeight();
        int w = this.imageWriter.getWidth();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i % interval == 0 || j % interval == 0)
                    this.imageWriter.writePixel(j, i, 255, 255, 255);
            }
        }
    }

    public void writeToImage() {
        imageWriter.writeToimage();
    }


    private Color calcColor(Geometry geometry, Point3D point, Ray ray){
        return calcColor(geometry, point, ray, 0);
    }


    private Color calcColor(Geometry geometry, Point3D point, Ray inRay, int level) {


        if (level == RECURSION_LEVEL){
            return new Color(0, 0, 0);
        }

        Color ambientLight = scene.get_ambientLight().getIntensity();
        Color emissionLight = geometry.get_emmission();

        Color inherentColors = addColors(ambientLight, emissionLight);

        Iterator<LightSource> lights = scene.getLightsIterator();

        Color lightReflected = new Color(0, 0, 0);

        while (lights.hasNext()){

            LightSource light = lights.next();

            if (!occluded(light, point, geometry)){

                Color lightIntensity = light.getIntensity(point);


                Color lightDiffuse = calcDiffusiveComp(geometry.getMaterial().getKd(),
                        geometry.getNormal(point),
                        light.getL(point),
                        lightIntensity);


                Color lightSpecular = calcSpecularComp(geometry.getMaterial().getKs(),
                        new Vector(point, scene.get_camera().get_center()),
                        geometry.getNormal(point),
                        light.getL(point),
                        geometry.getShininess(),
                        lightIntensity);

                lightReflected = addColors(lightDiffuse, lightSpecular);
            }
        }

        Color I0 = addColors(inherentColors, lightReflected);


        //**// Recursive calls

        // Recursive call for a reflected ray
        Ray reflectedRay = constructReflectedRay(geometry.getNormal(point), point, inRay);
        Entry<Geometry, Point3D> reflectedEntry = findClosesntIntersection(reflectedRay);
        Color reflected = new Color(0, 0, 0);
        if (reflectedEntry != null){
            reflected = calcColor(reflectedEntry.getKey(), reflectedEntry.getValue(), reflectedRay, level + 1);
            double kr = geometry.getMaterial().getKr();
            reflected = new Color ((int)(reflected.getRed() * kr), (int)(reflected.getGreen() * kr),(int)(reflected.getBlue() * kr));
        }

        // Recursive call for a refracted ray
        Ray refractedRay = constructRefractedRay(geometry, point, inRay);
        Entry<Geometry, Point3D> refractedEntry = findClosesntIntersection(refractedRay);
        Color refracted = new Color(0, 0, 0);
        if (refractedEntry != null){
            refracted = calcColor(refractedEntry.getKey(), refractedEntry.getValue(), refractedRay, level + 1);
            double kt = geometry.getMaterial().getKt();
            refracted = new Color ((int)(refracted.getRed() * kt), (int)(refracted.getGreen() * kt),(int)(refracted.getBlue() * kt));
        }


        //**// End of recursive calls

        Color envColors = addColors(reflected, refracted);

        Color finalColor = addColors(envColors, I0);

        return new Color(finalColor.getRGB());
    }

    private Entry<Geometry, Point3D> findClosesntIntersection(Ray ray) {
        Map<Geometry, List<Point3D>> intersectionPoints = getSenceRayIntersections(ray);
        if (intersectionPoints.size() == 0)
            return null;
        Map<Geometry, Point3D> closestPoint = getClosedPoint(intersectionPoints);
        Entry<Geometry, Point3D> entry = closestPoint.entrySet().iterator().next();
        return entry;
    }

    private Map<Geometry, Point3D> getClosedPoint(Map<Geometry, List<Point3D>> listOfPoints) {
        double distance = Double.MAX_VALUE;
        Point3D center = scene.get_camera().get_center();
        Map<Geometry, Point3D> minimum = new HashMap<Geometry, Point3D>();
        for (Entry<Geometry, List<Point3D>> entry : listOfPoints.entrySet()) {
            for (Point3D point : entry.getValue()) {
                if (center.distance(point) < distance) {
                    minimum.clear();
                    minimum.put(entry.getKey(), new Point3D(point));
                    distance = center.distance(point);
                }
            }
        }
        return minimum;
    }


    private Map<Geometry, List<Point3D>> getSenceRayIntersections(Ray _ray) {
        Iterator<Geometry> it = scene.getGeometriesIterator();
        Map<Geometry, List<Point3D>> pointWithRay = new HashMap<Geometry, List<Point3D>>();
        //Geometry temp = null;
        while (it.hasNext()) {
            Geometry temp = it.next();
            List<Point3D> giometryIntersectionPoint = temp.FindIntersections(_ray);
            if (!giometryIntersectionPoint.isEmpty())
                pointWithRay.put(temp, giometryIntersectionPoint);
        }
        return pointWithRay;
    }

    private Color addColors(Color x, Color y) {
        int R = x.getRed() + y.getRed();
        if (R > 255) R = 255;
        int G = x.getGreen() + y.getGreen();
        if (G > 255) G = 255;
        int B = x.getBlue() + y.getBlue();
        if (B > 255) B = 255;
        Color _color = new Color(R, G, B);
        return _color;
    }

    private Color calcDiffusiveComp(double kd, Vector normal,
                                    Vector l, Color lightIntensity) {

        normal.normalize();
        l.normalize();

        double k = Math.abs(kd * normal.dotProduct(l));

        return new Color ((int)(lightIntensity.getRed() * k),
                (int)(lightIntensity.getGreen() * k),
                (int)(lightIntensity.getBlue() * k));
    }

    private Ray constructReflectedRay(Vector normal, Point3D point, Ray inRay) {

        Vector l = inRay.getVector();
        l.normalize();

        normal.multInScalar(-2 * l.dotProduct(normal));
        l.add(normal);

        Vector R = new Vector(l);
        R.normalize();

        point.addVectorToPoint(normal);

        Ray reflectedRay = new Ray(point, R);

        return reflectedRay;
    }

    private boolean occluded(LightSource light, Point3D point, Geometry geometry) {

        Vector lightDirection = light.getL(point);
        lightDirection.multInScalar(-1.0);
        lightDirection.normalize();

        Point3D geometryPoint = new Point3D(point);
        Vector epsVector = new Vector(geometry.getNormal(point));
        epsVector.multInScalar(2.0);
        geometryPoint.addVectorToPoint(epsVector);

        Ray lightRay = new Ray(geometryPoint, lightDirection);
        Map<Geometry, List<Point3D>> intersectionPoints = getSenceRayIntersections(lightRay);

        // Flat geometry cannot self intersect
        if (geometry instanceof FlatGeometry) {
            intersectionPoints.remove(geometry);
        }

        for (Entry<Geometry, List<Point3D>> entry : intersectionPoints.entrySet())
        if (entry.getKey().getMaterial().getKt() == 0)
            return true;

        return false;

    }
    private Color calcSpecularComp(double ks, Vector v, Vector normal,
                                   Vector l, double shininess, Color lightIntensity) {

        v.normalize();
        normal.normalize();
        l.normalize();

        normal.multInScalar(-2 * l.dotProduct(normal));
        l.add(normal);
        Vector R = new Vector(l);
        R.normalize();

        double k = 0;

        if (v.dotProduct(R) > 0) // prevents glowing at edges
            k = ks * Math.pow(v.dotProduct(R), shininess);

        return new Color ((int)(lightIntensity.getRed()  * k),
                (int)(lightIntensity.getGreen() * k),
                (int)(lightIntensity.getBlue()   * k));
    }

    private Ray constructRefractedRay(Geometry geometry, Point3D point, Ray inRay) {

        Vector normal = geometry.getNormal(point);
        normal.multInScalar(-2.0);
        point.addVectorToPoint(normal);

        if (geometry instanceof FlatGeometry){
            return new Ray (point, inRay.getVector());
        } else {
            // Here, Snell's law can be implemented.
            // The refraction index of both materials had to be derived
            return new Ray (point, inRay.getVector());
        }

    }

}
