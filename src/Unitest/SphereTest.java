package Unitest;

import Elements.Camera;
import Geometries.Sphere;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

class SphereTest {

    @Test
    void findIntersectionsSphere() {
        final int W = 3;
        final int H = 3;

        Ray[][] rays = new Ray [H][W];

        // Only the center ray intersect the sphere in two locations
        List<Point3D> SphereIntersection = new ArrayList<Point3D>();

        // The sphere encapsulates the view plane - all rays intersect with the sphere once
        List<Point3D> SphereIntersection_ = new ArrayList<Point3D>();


        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector(0.0, 0.0, -1.0));

        Sphere sphere  = new Sphere(1, new Point3D(0.0, 0.0, -3.0));
        Sphere sphere2 = new Sphere(10, new Point3D(0.0, 0.0, -3.0));


        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        W, H, j, i, 1, 3 * W, 3 * H);

                List<Point3D> rayIntersectionPoints  = sphere. FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2 = sphere2.FindIntersections(rays[i][j]);

                for (Point3D it: rayIntersectionPoints)
                    SphereIntersection.add(it);


                for (Point3D it: rayIntersectionPoints2)
                    SphereIntersection_.add(it);

            }
        }

        assertTrue(SphereIntersection. size() == 2);
        assertTrue(SphereIntersection_.size() == 9);


    }
}