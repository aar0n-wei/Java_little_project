package com.gw;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameFrame extends JFrame {

    HeroPlane heroPlane;
    public GameFrame() {
        this.setSize(480,1000);
        this.setTitle("雷霆战机");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        heroPlane = new HeroPlane();
        heroPlane.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("绘制图形");
        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width, this.getSize().height);
        Graphics bi = image.getGraphics();
        bi.drawImage(new ImageIcon("leiting/img/MAP.png").getImage(),0,0,null);

        bi.drawImage(heroPlane.image, heroPlane.x, heroPlane.y,heroPlane.width,heroPlane.height, null);

        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        Player player = new Player(gameFrame.heroPlane);
        gameFrame.addKeyListener(player);
    }
}
