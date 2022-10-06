package com.gw;

import javax.swing.*;
import java.awt.*;

public class HeroPlane extends Thread{
    int x = 240, y = 800;
    int width = 100, height = 100;
    int speed = 5;
    Image image = new ImageIcon("leiting/img/10011.png").getImage();

    boolean left, up, right, down;

    public HeroPlane() {
    }

    public HeroPlane(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void run() {
        while (true) {
            if (left) {
                x -= speed;
            }
            if (right) {
                x += speed;
            }
            if (up) {
                y -= speed;
            }
            if (down) {
                y += speed;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
