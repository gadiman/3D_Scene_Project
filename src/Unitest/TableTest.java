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
        up.set_emmission(new Color(228, 128, 58));

        Quadrilateral down = new Quadrilateral(D, C, G, H);
        down.set_emmission(new Color(228, 128, 58));

        Quadrilateral right = new Quadrilateral(B, C, G, F);
        right.set_emmission(new Color(228, 128, 58));

        Quadrilateral left = new Quadrilateral(A, D, H, E);
        left.set_emmission(new Color(228, 128, 58));

        Quadrilateral front = new Quadrilateral(A, D, C, B);
        front.set_emmission(new Color(228, 128, 58));

        Quadrilateral beak = new Quadrilateral(E, H, G, F);
        beak.set_emmission(new Color(228, 128, 58));

        List<Quadrilateral> temp = new ArrayList<Quadrilateral>();
        temp.add(up);
        temp.add(down);
        temp.add(right);
        temp.add(left);
        temp.add(front);
        temp.add(beak);

        return temp;
    }


    public Point3D add_point(Point3D point3D, double x, double y, double z) {
        double X = point3D.getX().getCoordinate() + x;
        double Y = point3D.getY().getCoordinate() + y;
        double Z = point3D.getZ().getCoordinate() + z;
        Point3D p = new Point3D(X, Y, Z);
        return p;
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
        Point3D Leg_front_left_B = add_point(Leg_front_left_A, 0, 15, 0);//new Point3D(-80, -75, -61);
        Point3D Leg_front_left_C = new Point3D(-240, -75, -61);
        Point3D Leg_front_left_D = new Point3D(-240, -90, -61);
        Point3D Leg_front_left_E = new Point3D(-80, -90, -76);
        Point3D Leg_front_left_F = new Point3D(-80, -75, -76);
        Point3D Leg_front_left_G = new Point3D(-240, -75, -76);
        Point3D Leg_front_left_H = new Point3D(-240, -90, -76);

        List<Quadrilateral> Leg_front_left = qube(Leg_front_left_A, Leg_front_left_B, Leg_front_left_C,
                Leg_front_left_D, Leg_front_left_E, Leg_front_left_F, Leg_front_left_G, Leg_front_left_H);

        scene.addGeometry(Leg_front_left.get(0));
        scene.addGeometry(Leg_front_left.get(1));
        scene.addGeometry(Leg_front_left.get(2));
        scene.addGeometry(Leg_front_left.get(3));
        scene.addGeometry(Leg_front_left.get(4));
        scene.addGeometry(Leg_front_left.get(5));

        Point3D Leg_front_right_A = new Point3D(-80, 75, -61);
        Point3D Leg_front_right_B = new Point3D(-80, 90, -61);
        Point3D Leg_front_right_G = new Point3D(-240, 90, -76);
        Point3D Leg_front_right_C = add_point(Leg_front_right_G, 0, 0, 15);
        Point3D Leg_front_right_D = add_point(Leg_front_right_A, -160, 0, 0);
        Point3D Leg_front_right_E = add_point(Leg_front_right_A, 0.0, 0.0, -15.0);
        Point3D Leg_front_right_F = add_point(Leg_front_right_G, 160, 0.0, 0.0);
        Point3D Leg_front_right_H = add_point(Leg_front_right_G, 0, -15, 0.0);

        List<Quadrilateral> Leg_frong_right = qube(Leg_front_right_A, Leg_front_right_B, Leg_front_right_C, Leg_front_right_D
                , Leg_front_right_E, Leg_front_right_F, Leg_front_right_G, Leg_front_right_H);

        scene.addGeometry(Leg_frong_right.get(0));
        scene.addGeometry(Leg_frong_right.get(1));
        scene.addGeometry(Leg_frong_right.get(2));
        scene.addGeometry(Leg_frong_right.get(3));
        scene.addGeometry(Leg_frong_right.get(4));
        scene.addGeometry(Leg_frong_right.get(5));

        Point3D Leg_back_left_A = new Point3D(-80, -90, -126);
        Point3D Leg_back_left_G = new Point3D(-240, -75, -141);
        Point3D Leg_back_left_B = add_point(Leg_back_left_A, 0, 15, 0);
        Point3D Leg_back_left_C = add_point(Leg_back_left_G, 0, 0, 15);
        Point3D Leg_back_left_D = add_point(Leg_back_left_A, -160, 0, 0);
        Point3D Leg_back_left_E = add_point(Leg_back_left_A, 0, 0, -15);
        Point3D Leg_back_left_F = add_point(Leg_back_left_G, 160, 0.0, 0.0);
        Point3D Leg_back_left_H = add_point(Leg_back_left_G, 0, -15, 0.0);

        List<Quadrilateral> Leg_back_left = qube(Leg_back_left_A, Leg_back_left_B, Leg_back_left_C, Leg_back_left_D,
                Leg_back_left_E, Leg_back_left_F, Leg_back_left_G, Leg_back_left_H);

        scene.addGeometry(Leg_back_left.get(0));
        scene.addGeometry(Leg_back_left.get(1));
        scene.addGeometry(Leg_back_left.get(2));
        scene.addGeometry(Leg_back_left.get(3));
        scene.addGeometry(Leg_back_left.get(4));
        scene.addGeometry(Leg_back_left.get(5));

        Point3D Leg_back_right_A = new Point3D(-80, 75, -126);
        Point3D Leg_back_right_G = new Point3D(-240, 90, -141);
        Point3D Leg_back_right_B = add_point(Leg_back_right_A, 0, 15, 0);
        Point3D Leg_back_right_C = add_point(Leg_back_right_G, 0, 0, 15);
        Point3D Leg_back_right_D = add_point(Leg_back_right_A, -160, 0, 0);
        Point3D Leg_back_right_E = add_point(Leg_back_right_A, 0, 0, -15);
        Point3D Leg_back_right_F = add_point(Leg_back_right_G, 160, 0, 0);
        Point3D Leg_back_right_H = add_point(Leg_back_right_G, 0, -15, 0);

        List<Quadrilateral> Leg_back_right = qube(Leg_back_right_A, Leg_back_right_B, Leg_back_right_C, Leg_back_right_D,
                Leg_back_right_E, Leg_back_right_F, Leg_back_right_G, Leg_back_right_H);

        scene.addGeometry(Leg_back_right.get(0));
        scene.addGeometry(Leg_back_right.get(1));
        scene.addGeometry(Leg_back_right.get(2));
        scene.addGeometry(Leg_back_right.get(3));
        scene.addGeometry(Leg_back_right.get(4));
        scene.addGeometry(Leg_back_right.get(5));


        Quadrilateral background = new Quadrilateral(new Point3D(-250, -250, -51), new Point3D(-250, 250, -51),
                new Point3D(-250, 250, -151), new Point3D(-250, -250, -151));
        background.set_emmission(new Color(2, 0, 0));
        scene.addGeometry(background);

        scene.addLight(new SpotLight(new Color(150, 100, 100), new Point3D(240, 50, -50),
                0.1, 0.00001, 0.000005, new Vector(-2, 0, -3)));

        ImageWriter imageWriter = new ImageWriter("Table test", 500, 500, 500, 500);
        Render render = new Render(imageWriter, scene);
        render.renderImage();
        render.writeToImage();
    }
}