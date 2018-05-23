package Unitest;

import Renderer.ImageWriter;
import org.junit.jupiter.api.Test;


class ImageWriterTest {
    @Test
    public void writeImageTest(){


            ImageWriter imageWriter = new ImageWriter("Test_Of_Imege_Writer", 500, 500, 1, 1);

            for (int i = 0; i < imageWriter.getHeight(); i++){
                for (int j = 0; j < imageWriter.getWidth(); j++){

                    if (i % 50 == 0 || j % 50 == 0)
                        imageWriter.writePixel(j, i, 127, 127, 127);

                }
            }

            imageWriter.writeToimage();

        }





}