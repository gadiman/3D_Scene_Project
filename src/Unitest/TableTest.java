package Unitest;

import Elements.SpotLight;
import Geometries.Quadrilateral;
import Primitives.Point3D;
import Primitives.Vector;
import Renderer.ImageWriter;
import Renderer.Render;
import org.junit.jupiter.api.Test;
import scene.Scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TableTest {

    public List<Quadrilateral> qube(Point3D A, Point3D B, Point3D C, Point3D D, Point3D E, Point3D F, Point3D G, Point3D H) {

        Quadrilateral up = new Quadrilateral(A, B, F, E);
        up.set_emmission(new Color(200, 50, 50));

        Quadrilateral down = new Quadrilateral(D, C, G, H);
        down.set_emmission(new Color(200, 50, 50));

        Quadrilateral right = new Quadrilateral(B, C, G, F);
        right.set_emmission(new Color(200, 50, 50));

        Quadrilateral left = new Quadrilateral(A, D, H, E);
        left.set_emmission(new Color(200, 50, 50));

        Quadrilateral front = new Quadrilateral(A, D, C, B);
        front.set_emmission(new Color(200, 50, 50));

        Quadrilateral beak = new Quadrilateral(E, H, G, F);
        beak.set_emmission(new Color(200, 50, 50));

        List<Quadrilateral> temp = new ArrayList<Quadrilateral>();
        temp.add(up);
        temp.add(down);
        temp.add(right);
        temp.add(left);
        temp.add(front);
        temp.add(beak);

        return temp;
    }


    public Point3D add_point(Point3D point3D, Double x, Double y, Double z) {
        Double X = point3D.getX().getCoordinate() + x;
        Double Y = point3D.getY().getCoordinate() + y;
        Double Z = point3D.getZ().getCoordinate() + z;
        return new Point3D(X,Y,Z);
    }


    @Test
    public void Table_Test() {

        Scene scene = new Scene();
        scene.setScreenDistance(50);
        scene.setBackgroundColor(new Color(2, 0, 0));

        Point3D Tabl_A = new Point3D(-60, -100, -51);
        Point3D Tabl_B = new Point3D(-60, 100, -51);
        Point3D Tabl_C = new Point3D(-80, 100, -51);
        Point3D Tabl_D = new Point3D(-80, -100, -51);
        Point3D Tabl_E = new Point3D(-60, -100, -151);
        Point3D Tabl_F = new Point3D(-60, 100, -151);
        Point3D Tabl_G = new Point3D(-80, 100, -151);
        Point3D Tabl_H = new Point3D(-80, -100, -151);

        List<Quadrilateral> Table = qube(Tabl_A, Tabl_B, Tabl_C, Tabl_D, Tabl_E, Tabl_F, Tabl_G, Tabl_H);

        scene.addGeometry(Table.get(0));
        scene.addGeometry(Table.get(1));
        scene.addGeometry(Table.get(2));
        scene.addGeometry(Table.get(3));
        scene.addGeometry(Table.get(4));
        scene.addGeometry(Table.get(5));

        Point3D Leg_front_left_A = new Point3D(-80, -90, -61);
        Point3D Leg_front_left_B = new Point3D(-80, -75, -61);
        Point3D Leg_front_left_C = new Point3D(-190, -75, -61);
        Point3D Leg_front_left_D = new Point3D(-190, -90, -61);
        Point3D Leg_front_left_E = new Point3D(-80, -90, -76);
        Point3D Leg_front_left_F = new Point3D(-80, -75, -76);
        Point3D Leg_front_left_G = new Point3D(-190, -75, -76);
        Point3D Leg_front_left_H = new Point3D(-190, -90, -76);

        List<Quadrilateral> Leg_front_left = qube(Leg_front_left_A, Leg_front_left_B, Leg_front_left_C,
                Leg_front_left_D, Leg_front_left_E, Leg_front_left_F, Leg_front_left_G, Leg_front_left_H);

        scene.addGeometry(Leg_front_left.get(0));
        scene.addGeometry(Leg_front_left.get(1));
        scene.addGeometry(Leg_front_left.get(2));
        scene.addGeometry(Leg_front_left.get(3));
        scene.addGeometry(Leg_front_left.get(4));
        scene.addGeometry(Leg_front_left.get(5));

        Point3D Leg_front_right_A=new Point3D(-80,75,-61);
        Point3D Leg_front_right_G=new Point3D(-190,90,-76);

        List<Quadrilateral> Leg_frong_right=qube(Leg_front_right_A,add_point(Leg_front_right_A,0.0,15.0,0.0),
                add_point(Leg_front_right_G,0.0,0.0,15.0),add_point(Leg_front_right_A,-110.0,0.0,0.0),
                add_point(Leg_front_right_A,0.0,0.0,-15.0),add_point(Leg_front_right_G,110.0,0.0,0.0),
                Leg_front_right_G,add_point(Leg_front_right_G,-15.0,0.0,0.0));

        scene.addGeometry(Leg_frong_right.get(0));
        scene.addGeometry(Leg_frong_right.get(1));
        scene.addGeometry(Leg_frong_right.get(2));
        scene.addGeometry(Leg_frong_right.get(3));
        scene.addGeometry(Leg_frong_right.get(4));
        scene.addGeometry(Leg_frong_right.get(5));


        scene.addLight(new SpotLight(new Color(255, 100, 100), new Point3D(50, 0, -50),
                0.1, 0.00001, 0.000005, new Vector(2, 2, -3)));

        ImageWriter imageWriter = new ImageWriter("Table test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();

    }
}
