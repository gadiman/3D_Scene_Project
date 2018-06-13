package Unitest;

import Elements.PointLight;
import Elements.SpotLight;
import Geometries.Sphere;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import org.junit.jupiter.api.Test;
import scene.Scene;

import java.awt.*;

public class LightTest {

    @Test
    public void chagayTest() {
        Scene scene = new Scene();
        scene.setScreenDistance(150);

        Sphere sphere = new Sphere(100, new Point3D(0.0, 0.0, -200.0));
        sphere.getMaterial().setNshaininess(15);
        sphere.set_emmission(new Color(206, 132, 22));

        Triangle triangle1 = new Triangle(new Point3D(0.0, 0.0, -200),
                new Point3D(160, 100, -200),
                new Point3D(0, 95, -200));
        triangle1.set_emmission(new Color(206, 132, 22));
        triangle1.getMaterial().setNshaininess(15);

        Triangle triangle2 = new Triangle(new Point3D(0.0, 0.0, -200),
                new Point3D(160.0, -100, -200),
                new Point3D(0.0, -95, -200));
        triangle2.set_emmission(new Color(206, 132, 22));
        triangle2.getMaterial().setNshaininess(15);

        Sphere aye1 = new Sphere(15, new Point3D(45, 50, -200));
        aye1.getMaterial().setNshaininess(30);
        aye1.set_emmission(new Color(2, 0, 0));

        Sphere aye2 = new Sphere(15, new Point3D(45, -50, -200));
        aye2.getMaterial().setNshaininess(30);
        aye2.set_emmission(new Color(2, 0, 0));

        Sphere nousespher = new Sphere(10, new Point3D(5, 0, -200));
        nousespher.getMaterial().setNshaininess(15);
        nousespher.set_emmission(new Color(2, 0, 0));

        Triangle nousetriangle1 = new Triangle(new Point3D(5, 12, -200),
                new Point3D(5, -12, -200),
                new Point3D(-8, 0, -200));
        nousetriangle1.set_emmission(new Color(2, 0, 0));
        nousetriangle1.getMaterial().setNshaininess(15);

        Triangle mauth1 = new Triangle(new Point3D(-33, 0, -200),
                new Point3D(-40, 0, -200),
                new Point3D(-30, 65, -200));
        mauth1.set_emmission(new Color(206, 32, 22));
        mauth1.getMaterial().setNshaininess(30);

        Triangle mauth2 = new Triangle(new Point3D(-33, 0, -200),
                new Point3D(-40, 0, -200),
                new Point3D(-30, -65, -200));
        mauth2.set_emmission(new Color(206, 32, 22));
        mauth2.getMaterial().setNshaininess(30);

        Triangle mauth3 = new Triangle(new Point3D(-45, 0, -200),
                new Point3D(-55, 0, -200),
                new Point3D(-30, 65, -200));
        mauth3.set_emmission(new Color(206, 32, 22));
        mauth3.getMaterial().setNshaininess(30);

        Triangle mauth4 = new Triangle(new Point3D(-45, 0, -200),
                new Point3D(-55, 0, -200),
                new Point3D(-30, -65, -200));
        mauth4.set_emmission(new Color(206, 32, 22));
        mauth4.getMaterial().setNshaininess(30);

        Triangle safam1 = new Triangle(new Point3D(-20, 25, -200),
                new Point3D(-5, 120, -200),
                new Point3D(-10, 120, -200));
        safam1.set_emmission(new Color(2, 0, 0));
        safam1.getMaterial().setNshaininess(5);

        Triangle safam2 = new Triangle(new Point3D(-20, -25, -200),
                new Point3D(-5, -120, -200),
                new Point3D(-10, -120, -200));
        safam2.set_emmission(new Color(2, 0, 0));
        safam2.getMaterial().setNshaininess(5);

        Triangle safam3 = new Triangle(new Point3D(-15, 30, -200),
                new Point3D(0, 120, -200),
                new Point3D(-5, 120, -200));
        safam3.set_emmission(new Color(2, 0, 0));
        safam3.getMaterial().setNshaininess(5);

        Triangle safam4 = new Triangle(new Point3D(-15, -30, -200),
                new Point3D(0, -120, -200),
                new Point3D(-5, -120, -200));
        safam4.set_emmission(new Color(2, 0, 0));
        safam4.getMaterial().setNshaininess(5);

        scene.addGeometry(sphere);
        scene.addGeometry(triangle1);
        scene.addGeometry(triangle2);
        scene.addGeometry(aye1);
        scene.addGeometry(aye2);
        scene.addGeometry(nousespher);
        scene.addGeometry(nousetriangle1);
        scene.addGeometry(mauth1);
        scene.addGeometry(mauth2);
        scene.addGeometry(mauth3);
        scene.addGeometry(mauth4);
        scene.addGeometry(safam1);
        scene.addGeometry(safam2);
        scene.addGeometry(safam3);
        scene.addGeometry(safam4);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(150, 0, -50),
                0.1, 0.00001, 0.000005, new Vector(1, 0, -3)));
        ImageWriter imageWriter = new ImageWriter("chagay test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void emmissionTest() {
        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.addGeometry(new Sphere(48, new Point3D(0.0, 0.0, -50)));

        Triangle triangle = new Triangle(new Point3D(100, 0, -51),
                new Point3D(0, 100, -51),
                new Point3D(100, 100, -51));

        Triangle triangle2 = new Triangle(new Point3D(100, 0, -51),
                new Point3D(0, -100, -51),
                new Point3D(100, -100, -51));
        triangle2.set_emmission(new Color(50, 200, 50));

        Triangle triangle3 = new Triangle(new Point3D(-100, 0, -51),
                new Point3D(0, 100, -51),
                new Point3D(-100, 100, -51));
        triangle3.set_emmission(new Color(50, 50, 200));

        Triangle triangle4 = new Triangle(new Point3D(-100, 0, -51),
                new Point3D(0, -100, -51),
                new Point3D(-100, -100, -51));
        triangle4.set_emmission(new Color(200, 50, 50));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);
        scene.addGeometry(triangle3);
        scene.addGeometry(triangle4);
        ImageWriter imageWriter = new ImageWriter("Emmission test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.printGrid(50);
        render.writeToImage();
    }

    @Test
    public void spotLightTest2() {

        Scene scene = new Scene();
        scene.setScreenDistance(200);
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.getMaterial().setNshaininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        Triangle triangle = new Triangle(new Point3D(-125, -225, -260),
                new Point3D(-225, -125, -260),
                new Point3D(-225, -225, -270));
        triangle.set_emmission(new Color(0, 0, 100));
        triangle.getMaterial().setNshaininess(4);
        scene.addGeometry(triangle);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -150),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));
        ImageWriter imageWriter = new ImageWriter("Spot test 2", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }


    @Test
    public void spotLightTest() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(700, new Point3D(0.0, 0.0, -1000));
        sphere.getMaterial().setNshaininess(20);
        sphere.set_emmission(new Color(0, 0, 100));
        scene.addGeometry(sphere);
        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                0.0, 0.00001, 0.000005, new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Spot test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();

    }


    @Test
    public void pointLightTest() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
        sphere.getMaterial().setNshaininess(20);
        sphere.set_emmission(new Color(80, 50, 100));
        scene.addGeometry(sphere);
        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(-200, -200, -100),
                0.0, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("Point test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();


    }

    @Test
    public void spotLightTest3() {


        Scene scene = new Scene();

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0.0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));


        ImageWriter imageWriter = new ImageWriter("Spot test 3", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void pointLightTest2() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(800, new Point3D(0.0, 0.0, -1000));
        sphere.getMaterial().setNshaininess(20);
        sphere.set_emmission(new Color(0, 0, 100));

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new PointLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0.0, 0.000001, 0.0000005));


        ImageWriter imageWriter = new ImageWriter("Point test 2", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

    @Test
    public void shadowTest() {

        Scene scene = new Scene();
        Sphere sphere = new Sphere(500, new Point3D(0.0, 0.0, -1000));
        sphere.getMaterial().setNshaininess(20);
        sphere.set_emmission(new Color(0, 0, 100));

        scene.addGeometry(sphere);

        Triangle triangle = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, -3500, -1000),
                new Point3D(3500, -3500, -2000));

        Triangle triangle2 = new Triangle(new Point3D(3500, 3500, -2000),
                new Point3D(-3500, 3500, -1000),
                new Point3D(-3500, -3500, -1000));

        scene.addGeometry(triangle);
        scene.addGeometry(triangle2);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -100),
                0.0, 0.000001, 0.0000005, new Vector(-2, -2, -3)));


        ImageWriter imageWriter = new ImageWriter("shadow test", 500, 500, 500, 500);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();

    }

}