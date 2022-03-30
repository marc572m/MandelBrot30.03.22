package com.company;

import java.awt.image.BufferedImage;

public class PixelThread implements Runnable {
     int x = 0;
    int y = 0;
    BufferedImage img;

    public PixelThread(int y, int x, BufferedImage img) {
        this.x = x;
        this.y = y;
        this.img = img;
    }

    public void run(){
        // generating values less than 256
        int a = (int) (Math.random() * 256);
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);

        //pixel
        int p = (a << 24) | (r << 16) | (g << 8) | b;
        img.setRGB(x, y, p);

    }




}
