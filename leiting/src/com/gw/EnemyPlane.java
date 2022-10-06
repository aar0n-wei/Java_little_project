package com.gw;

import javax.swing.*;
import java.awt.*;

public class EnemyPlane extends Thread {
    int x;
    int y;
    int width = 80;
    int height = 80;
    int speed = 6;
    Image image = new ImageIcon("leiting/img/10021.png").getImage();

    GameFrame gameFrame;

    public EnemyPlane(int x, int y, int width, int height, GameFrame gameFrame) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameFrame = gameFrame;
    }

    public EnemyPlane(int x, int y, GameFrame gameFrame) {
        this.x = x;
        this.y = y;
        this.gameFrame = gameFrame;
    }

    @Override
    public void run() {
        while (true) {
            if (hit()) {
                this.image = new ImageIcon("leiting/img/300350.png").getImage();
                this.speed=0;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gameFrame.eps.remove(this);
                break;
            }

            if (this.y > 1000) {
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean hit() {
        Rectangle myRect = new Rectangle(this.x, this.y, this.width, this.height);

        Rectangle rect = null;
        for (int i = 0; i < gameFrame.bullets.size(); i++) {
            Bullet bullet = gameFrame.bullets.get(i);
            rect = new Rectangle(bullet.x, bullet.y, bullet.width, bullet.height);
            if (myRect.intersects(rect)) {
                return true;
            }
        }
        return false;
    }
}
