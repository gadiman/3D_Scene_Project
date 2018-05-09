package Unitest;

import org.junit.jupiter.api.Test;
import Elements.Camera;
import Geometries.Plane;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

class PlaneTest {

    @Test
    void findIntersectionsPlane() {
        final int W  = 3;
        final int H = 3;

        Ray[][] rays = new Ray [H][W];


        List<Point3D> intersectionPointsPlane = new ArrayList<Point3D>();
        List<Point3D> intersectionPointsPlane2 = new ArrayList<Point3D>();


        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector (0.0, 0.0, -1.0));

        // plane orthogonal to the view plane
        Plane plane  = new Plane( new Point3D(0.0, 0.0, -3.0),new Vector(0.0, 0.0, -1.0));

        // 45 degrees to the view plane
        Plane plane2 = new Plane( new Point3D(0.0, 0.0, -3.0),new Vector(0.0, 0.25, -1.0));


        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){

                rays[i][j] = camera.constructRayThroughPixel(
                        W, H, j, i, 1, 3 * W, 3 * H);

                List<Point3D> rayIntersectionPoints   = plane. FindIntersections(rays[i][j]);
                List<Point3D> rayIntersectionPoints2  = plane2.FindIntersections(rays[i][j]);

                for (Point3D iPoint: rayIntersectionPoints)
                    intersectionPointsPlane.add(iPoint);

                for (Point3D iPoint: rayIntersectionPoints2)
                    intersectionPointsPlane2.add(iPoint);
            }
        }

        assertTrue(intersectionPointsPlane. size() == 9);
        assertTrue(intersectionPointsPlane2.size() == 9);



    }
}