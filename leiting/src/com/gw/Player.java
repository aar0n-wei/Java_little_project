package com.gw;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends KeyAdapter {
    GameFrame gameFrame;

    public Player(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println(code);
        switch (code) {
            case 37:
                gameFrame.heroPlane.left = true;
                break;
            case 38:
                gameFrame.heroPlane.up = true;
                break;
            case 39:
                gameFrame.heroPlane.right = true;
                break;
            case 40:
                gameFrame.heroPlane.down = true;
                break;
            case 66:
                gameFrame.bullets.add(new Bullet(gameFrame.heroPlane.x,gameFrame.heroPlane.y));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case 37:
                gameFrame.heroPlane.left = false;
                break;
            case 38:
                gameFrame.heroPlane.up = false;
                break;
            case 39:
                gameFrame.heroPlane.right = false;
                break;
            case 40:
                gameFrame.heroPlane.down = false;
                break;
        }
    }
}
