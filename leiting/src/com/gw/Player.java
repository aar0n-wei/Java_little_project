package com.gw;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter {
    HeroPlane heroPlane;

    public Player(HeroPlane heroPlane) {
        this.heroPlane = heroPlane;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println(code);
        switch (code) {
            case 37:
                heroPlane.left = true;
                break;
            case 38:
                heroPlane.up = true;
                break;
            case 39:
                heroPlane.right = true;
                break;
            case 40:
                heroPlane.down = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case 37:
                heroPlane.left = false;
                break;
            case 38:
                heroPlane.up = false;
                break;
            case 39:
                heroPlane.right = false;
                break;
            case 40:
                heroPlane.down = false;
                break;
        }
    }
}
