package Unitest;

import Elements.Camera;
import Geometries.Triangle;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

class TriangleTest {

    @Test
    void findIntersectionsTriangle() {

        final int W = 3;
        final int H = 3;

        Ray[][] rays = new Ray[H][W];

        List<Point3D> TriangleIntersection = new ArrayList<Point3D>();
        List<Point3D> TriangleIntersection_ = new ArrayList<Point3D>();

        Camera camera = new Camera(new Point3D(0.0, 0.0, 0.0),
                new Vector(0.0, 1.0, 0.0),
                new Vector(0.0, 0.0, -1.0));

        Triangle triangle = new Triangle(new Point3D(15, 1, -2),
                new Point3D(1, -1, -2),
                new Point3D(-1, -1, -2));

        Triangle triangle2 = new Triangle(new Point3D(0, 10, -2),
                new Point3D(1, -1, -2),
                new Point3D(-1, -1, -2));

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                rays[i][j] = camera.constructRayThroughPixel(
                        W, H, j, i, 1, 3 * W, 3 * H);

                List<Point3D> rayIntersection = triangle.FindIntersections(rays[i][j]);
                List<Point3D> rayIntersection_ = triangle2.FindIntersections(rays[i][j]);

                for (Point3D it : rayIntersection)
                    TriangleIntersection.add(it);

                for (Point3D it : rayIntersection_)
                    TriangleIntersection_.add(it);
            }
        }

        assertTrue(TriangleIntersection.size() == 0);
        assertTrue(TriangleIntersection_.size() == 2);


    }
}