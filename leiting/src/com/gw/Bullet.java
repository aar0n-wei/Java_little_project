package com.gw;

import javax.swing.*;
import java.awt.*;

public class Bullet {
    int x;
    int y;
    int width=40;
    int height=80;

    int speed = 10;

    Image image = new ImageIcon("leiting/img/30021.png").getImage();

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
