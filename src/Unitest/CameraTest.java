package Unitest;

import Elements.Camera;
import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

class CameraTest {

    @Test
    void constructRayThroughPixel() {

        final int W  = 3;
        final int H = 3;

       //chacking the basic case
        Camera camera = new Camera(new Point3D(0.0 ,0.0 ,0.0),
                new Vector (0.0, 1.0, 0.0),
                new Vector(0.0, 0.0, -1.0));


        Point3D[][] ViwePlane = new Point3D [H][W];


        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){

                Ray ray = camera.constructRayThroughPixel(
                        W, H, j, i, 1, 3 * W, 3 * H);

                ViwePlane[i][j] = ray.getPoint3D();

                // Checking z-coordinate
                assertTrue(Double.compare(ViwePlane[i][j].getZ().getCoordinate(), -1.0) == 0);

                // Checking all options
                double x = ViwePlane[i][j].getX().getCoordinate();
                double y = ViwePlane[i][j].getX().getCoordinate();

                if (Double.compare(x, 3) == 0 ||
                        Double.compare(x, 0) == 0 ||
                        Double.compare(x, -3) == 0){
                    if (Double.compare(y, 3) == 0 ||
                            Double.compare(y, 0) == 0 ||
                            Double.compare(y, -3) == 0){
                        assertTrue(true);
                    } else {
                        fail("Wrong y ");
                    }
                } else {
                    fail("Wrong x");
                }

            }
        }

    }
}