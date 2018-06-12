package Unitest;

import Elements.SpotLight;
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
        scene.RoutinX(scene.get_camera().get_Vright(),0.75);

        final Point3D Left_A= new Point3D(-100, -200, -73);
        final Point3D Left_B=new Point3D(0, -100, -73);
        final Point3D Right_B=new Point3D(0, 200, -73);
        final Point3D Right_A=new Point3D(-100, 100, -73);

        final Color Color_Of_Table=new Color(205, 133, 63);

//first triangle -left one-Up
        Triangle T1 = new Triangle(new Point3D(Right_A),
                new Point3D(Left_B),
                new Point3D(Right_B));
        T1.set_emmission(Color_Of_Table);
//second triangle -right one-Up
        Triangle T2 = new Triangle(new Point3D(Right_A),
                new Point3D(Left_B),
                new Point3D(Left_A));
        T2.set_emmission(Color_Of_Table);
  //first triangle -left one_Down
        Triangle T3 = new Triangle( AddToPoint(Right_A,new Point3D(0,0,20)),
                AddToPoint(Left_B,new Point3D(0,0,20)),
                AddToPoint(Right_B,new Point3D(0,0,20)));
        T3.set_emmission(new Color(0, 0, 0));
//second triangle -right one_Down
        Triangle T4 = new Triangle(new Point3D(AddToPoint(Right_A,new Point3D(0,0,20))),
                AddToPoint(Left_B,new Point3D(0,0,20)),
                AddToPoint(Left_A,new Point3D(0,0,20)));
        T4.set_emmission(new Color(0, 0, 0));

        // front_1
        Triangle t1= new Triangle(new Point3D(Left_A),
                AddToPoint(Left_A,new Point3D(0,0,20)),
                AddToPoint(Right_A,new Point3D(0,0,20)));
        t1.set_emmission(new Color(0, 0, 0));

        // front_2
        Triangle t2= new Triangle(new Point3D(Right_A),
                AddToPoint(Right_A,new Point3D(0,0,20))
                ,new Point3D(Left_A));
        t2.set_emmission(new Color(0, 0, 0));

        //after_1
        Triangle t3= new Triangle(new Point3D(Left_B),
                AddToPoint(Left_B,new Point3D(0,0,20)),
                AddToPoint(Right_B,new Point3D(0,0,20)));
        t3.set_emmission(new Color(0, 0, 0));
        //after_2
        Triangle t4= new Triangle(new Point3D(Right_B),
                AddToPoint(Right_B,new Point3D(0,0,20)),
                new Point3D(Left_B));
        t4.set_emmission(new Color(0, 0, 0));

        //right_1
        Triangle t5= new Triangle(new Point3D(Right_A),
                AddToPoint(Right_A,new Point3D(0,0,20)),
                new Point3D(Right_B));
        t5.set_emmission(new Color(0, 0, 0));

        //right_2
        Triangle t6= new Triangle(new Point3D(Right_B),
                AddToPoint(Right_B,new Point3D(0,0,20)),
                AddToPoint(Right_A,new Point3D(0,0,20)));
        t6.set_emmission(new Color(0, 0, 0));

        //left_1
        Triangle t7= new Triangle(new Point3D(Left_A),
                AddToPoint(Left_A,new Point3D(0,0,20)),
                AddToPoint(Left_B,new Point3D(0,0,20)));
        t7.set_emmission(new Color(0, 0, 0));

        Triangle t8= new Triangle(new Point3D(Left_B),
                AddToPoint(Left_B,new Point3D(0,0,20)),
                AddToPoint(Left_A,new Point3D(0,0,20)));
        t6.set_emmission(new Color(0, 0, 0));






        scene.addGeometry(T1);
        scene.addGeometry(T2);
        scene.addGeometry(T3);
        scene.addGeometry(T4);
        scene.addGeometry(t1);
        scene.addGeometry(t2);
        scene.addGeometry(t2);
        scene.addGeometry(t4);
        scene.addGeometry(t5);
        scene.addGeometry(t6);
        scene.addGeometry(t7);
        scene.addGeometry(t8);






       // scene.RoutinX(scene.get_camera().get_Vright(),120);

        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(150, 0, -50),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Table test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }

    private Point3D AddToPoint(Point3D p1,Point3D p2) {
        return new Point3D(p1.getX().getCoordinate() + p2.getX().getCoordinate()
                , p1.getY().getCoordinate() + p2.getY().getCoordinate(),
                p1.getZ().getCoordinate() + p2.getZ().getCoordinate());
    }
}
