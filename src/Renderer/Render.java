package Renderer;

import Geometries.Geometry;
import Primitives.Point3D;
import Primitives.Ray;
import scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Render {
    private Scene scene;
    private ImageWriter imageWriter;
    private final int RECURSION_LEVEL = 3;

    //****************************constructors****************************************//
    public Render(ImageWriter image, Scene _scene) {
        scene = new Scene(_scene);
        imageWriter = new ImageWriter(image);
    }

    public Render(Render _render) {
        scene = new Scene(_render.scene);
        imageWriter = new ImageWriter(_render.imageWriter);
    }

    //*******************************getters and setters****************************//

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

    //********************************functions**************************************//

    public void renderImage() {

        for (int i = 0; i < this.imageWriter.getHeight(); i++) {
            for (int j = 0; j < this.imageWriter.getWidth(); j++) {

                Ray ray = this.scene.get_camera().constructRayThroughPixel(this.imageWriter.getNx(), this.imageWriter.getNy(), j, i,
                        scene.getScreenDistance(), this.imageWriter.getWidth(), this.imageWriter.getHeight());

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


    private Color calcColor(Point3D p) {
        return scene.get_ambientLight().getIntensity();
    }

    private Point3D getClosedPoint(List<Point3D> listOfPoints) {
        double distance = Double.MAX_VALUE;
        Point3D center = scene.get_camera().get_center();
        Point3D minimum = null;
        for (Point3D p : listOfPoints) {
            if (center.distance(p) < distance) {
                minimum = new Point3D(p);
                distance = center.distance(p);
            }
        }
        return minimum;
    }

    private List<Point3D> getSenceRayIntersections(Ray _ray) {
        Iterator<Geometry> it = scene.getGeometriesIterator();
        List<Point3D> pointWithRay = new ArrayList<Point3D>();
        Geometry temp = null;
        while (it.hasNext()) {
            temp = it.next();
            List<Point3D> giometryIntersectionPoint = temp.FindIntersections(_ray);
            for (Point3D p : giometryIntersectionPoint)
                pointWithRay.add(p);
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



}