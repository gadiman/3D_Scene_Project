package Unitest;

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

public class Table_Final_Test {
    @Test
    public void Table_Test() {

        Scene scene = new Scene();
        scene.setScreenDistance(50);

        scene.setBackgroundColor(new Color(255,255,255));

        final Point3D Left_A= new Point3D(-100, -150, -51);
        final Point3D Left_B=new Point3D(0, -50, -51);
        final Point3D Right_B=new Point3D(0, 150, -51);
        final Point3D Right_A=new Point3D(-100, 50, -51);

//first triangle -left one
        Triangle T1 = new Triangle(new Point3D(Right_A),
                new Point3D(Left_B),
                new Point3D(Right_B));
        T1.set_emmission(new Color(205, 133, 63));
//second triangle -right one
        Triangle T2 = new Triangle(new Point3D(Right_A),
                new Point3D(Left_B),
                new Point3D(Left_A));
        T2.set_emmission(new Color(205, 133, 63));
//spheres around the table
        Point3D tmp= new Point3D(AddToPoint(Left_A,new Point3D(-10,0,3)));
        Sphere S1 =new Sphere(10,new Point3D(AddToPoint(tmp,new Point3D(0,20,0))));
        S1.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_1 =new Sphere(10,new Point3D(tmp));
        S1_1.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_2 =new Sphere(10,new Point3D(tmp));
        S1_2.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_3 =new Sphere(10,new Point3D(tmp));
        S1_3.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_4 =new Sphere(10,new Point3D(tmp));
        S1_4.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_5 =new Sphere(10,new Point3D(tmp));
        S1_5.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_6 =new Sphere(10,new Point3D(tmp));
        S1_6.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_7 =new Sphere(10,new Point3D(tmp));
        S1_7.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_8 =new Sphere(10,new Point3D(tmp));
        S1_8.set_emmission(new Color(205, 133, 63));
        tmp=AddToPoint(tmp,new Point3D(0,20,0));
        Sphere S1_9 =new Sphere(10,new Point3D(tmp));
        S1_9.set_emmission(new Color(205, 133, 63));


        Sphere S2 = new Sphere(10,new Point3D());
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_1 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_2 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_3 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_4 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_5 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_6 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_7 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_8 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));
        Sphere S2_9 = new Sphere(10,new Point3D(-120,40,-48));
        S2.set_emmission(new Color(200, 50, 50));



        scene.addGeometry(T1);
        scene.addGeometry(T2);

        //side one of the table
        scene.addGeometry(S1);
        scene.addGeometry(S1_1);
        scene.addGeometry(S1_2);
        scene.addGeometry(S1_3);
        scene.addGeometry(S1_4);
        scene.addGeometry(S1_5);
        scene.addGeometry(S1_6);
        scene.addGeometry(S1_7);
        scene.addGeometry(S1_8);
        scene.addGeometry(S1_9);

       //side two of the table
        scene.addGeometry(S2);
        scene.addGeometry(S2_1);
        scene.addGeometry(S2_2);
        scene.addGeometry(S2_3);
        scene.addGeometry(S2_4);
        scene.addGeometry(S2_5);
        scene.addGeometry(S2_6);
        scene.addGeometry(S2_7);
        scene.addGeometry(S2_8);
        scene.addGeometry(S2_9);





        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(150, 0, -50),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Table test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    private Point3D AddToPoint(Point3D p1,Point3D p2)
    {
        return new Point3D(p1.getX().getCoordinate()+p2.getX().getCoordinate()
                ,p1.getY().getCoordinate()+p2.getY().getCoordinate(),
                p1.getZ().getCoordinate()+p2.getZ().getCoordinate());
    }

    private Point3D SubFromPoint(Point3D p1,Point3D p2)
    {
        return new Point3D(p1.getX().getCoordinate()-p2.getX().getCoordinate()
                ,p1.getY().getCoordinate()-p2.getX().getCoordinate(),
                p1.getZ().getCoordinate()-p2.getZ().getCoordinate());
    }
}
