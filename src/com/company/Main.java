package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main  {

    public static void main(String[] args) {
        //int maxWidth = 640, maxHeight = 320;
        //BufferedImage img = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);
        BufferedImage img1 = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);


       /* for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < maxWidth; j++) {
                PixelThread pt = new PixelThread(i,j,img);
                Thread thread = new Thread(pt);
                thread.start();

            }
        }

        */

       /* for (int y = 0; y < 600 ; y++) {
            for (int x = 0; x < 800; x++) {
                MandelbrotThread mbt = new MandelbrotThread(img1,x,y);
                Thread t = new Thread(mbt);
                t.start();

            }

        }

        */

            MandelbrotThread mbt = new MandelbrotThread(img1,600/2,0, 800/2,0);
            MandelbrotThread mbt2 = new MandelbrotThread(img1,600,600/2,800/2,0);
            MandelbrotThread mbt3 = new MandelbrotThread(img1,600/2,0,800,800/2);
            MandelbrotThread mbt4= new MandelbrotThread(img1,600,600/2,800,800/2);

            Thread th1 = new Thread(mbt);
            Thread th2 = new Thread(mbt2);
            Thread th3 = new Thread(mbt3);
            Thread th4 = new Thread(mbt4);
            th1.start();
            th2.start();
            th3.start();
            th4.start();


        //Generate image
      /*  try
        {
          File f = new File("/Users/marcjensen/documents/skole/mandelbrot30.03.22/lol.png");
            ImageIO.write(img, "png", f);
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }

       */

        try
        {
            File g = new File("/Users/marcjensen/documents/skole/mandelbrot30.03.22/lol1.png");
            ImageIO.write(img1, "png", g);
        }
        catch(IOException e)
        {
            System.out.println("Error: " + e);
        }

    }

}
