package com.company;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class MandelbrotThread implements Runnable{
    private final int MAX_ITER = 570;
    private final double ZOOM = 150;
    private BufferedImage i;
    private double zx, zy, cX, cY, tmp;
    int x;
    int y;
    int maxHeight , minHeight;
    int maxWidth, minWidth;

    public MandelbrotThread(BufferedImage i, int x, int y) {
        this.i = i;
        this.x = x;
        this.y = y;

    }

    public MandelbrotThread(BufferedImage i, int maxHeight, int minHeight, int maxWidth, int minWidth) {
        this.i = i;
        this.maxHeight = maxHeight;
        this.minHeight = minHeight;
        this.maxWidth = maxWidth;
        this.minWidth = minWidth;
    }

    @Override
    public void run() {
        for (int y = minHeight; y <maxHeight ; y++) {
            for (int x = minWidth; x < maxWidth; x++) {
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter--;
                }
                i.setRGB(x, y, iter | (iter << 8));
            }
        }


        /*
        zx = zy = 0;
        cX = (x - 400) / ZOOM;
        cY = (y - 300) / ZOOM;
        int iter = MAX_ITER;
        while (zx * zx + zy * zy < 4 && iter > 0) {
            tmp = zx * zx - zy * zy + cX;
            zy = 2.0 * zx * zy + cY;
            zx = tmp;
            iter--;
        }

        i.setRGB(x, y, iter | (iter << 8));
*/
    }


}
