package com.gw;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

public class GameFrame extends JFrame {

    HeroPlane heroPlane;
    Vector<Bullet> bullets = new Vector<>();

    Vector<EnemyPlane> eps = new Vector<>();
    GameFrame frame;
    public GameFrame() {
        frame = this;
        this.setSize(480,1000);
        this.setTitle("雷霆战机");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //创建战机，启动线程
        heroPlane = new HeroPlane();
        heroPlane.start();


        //不断刷新画面
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

        new Thread(new Runnable() {
            Random r = new Random();
            @Override
            public void run() {
                while (true) {
                    //增加敌机
                    EnemyPlane ep = new EnemyPlane(r.nextInt(480), 0, frame);
                    ep.start();
                    eps.add(ep);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
//        System.out.println("绘制图形");
        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width, this.getSize().height);
        Graphics bi = image.getGraphics();
        bi.drawImage(new ImageIcon("leiting/img/MAP.png").getImage(),0,0,null);
        //画战机
        bi.drawImage(heroPlane.image, heroPlane.x, heroPlane.y,heroPlane.width,heroPlane.height, null);
        //画子弹
        for (int i = 0; i < bullets.size(); i++) {
            System.out.println(bullets);
            Bullet bullet = bullets.get(i);
            if (bullet.y > 0) {
                bi.drawImage(bullet.image, bullet.x, bullet.y -= bullet.speed, bullet.width, bullet.height, null);
            }
            else{
                bullets.remove(bullet);
            }
        }

        //画敌机
        for (int i = 0; i < eps.size(); i++) {
            System.out.println(eps);
            EnemyPlane ep = eps.get(i);
            if (ep.y < 1000) {
                bi.drawImage(ep.image, ep.x, ep.y += ep.speed, ep.width, ep.height, null);
            } else {
                eps.remove(ep);
            }
        }

        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        Player player = new Player(gameFrame);
        gameFrame.addKeyListener(player);
    }
}
