package pro.comcon.ddraw.scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import pro.comcon.ddraw.items.GItem;
import pro.comcon.ddraw.items.LampView;

public class Scene extends JPanel implements Runnable {

    Thread loopThread;
    int FPS = 60;

    GItem[] items;

    public Scene() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.black);
        setDoubleBuffered(true);

        items = new GItem[1];

        items[0] = new LampView();

    }

    public void start() {
        loopThread = new Thread(this);
        loopThread.start();
    }

    public void stop() {
        loopThread = null;
    }

    @Override
    public void run() {

        double drawInterval = (1000 * 1000 * 1000) / FPS; // 0.01666 seconds

        // var 1
        double nextDrawTime = System.nanoTime() + drawInterval;
        int drawCount = 0;
        long lastTime = System.nanoTime();

        // var 2
        // double delta = 0;
        // long lastTime = System.nanoTime();
        // long currentTime;
        // long timer = 0;
        // int drawCount = 0;

        while (loopThread != null) {

            // var 2 - use 1 core!!!!
            // currentTime = System.nanoTime();

            // delta += (currentTime - lastTime) / drawInterval;
            // timer += (currentTime - lastTime);
            // lastTime = currentTime;

            // if (delta >= 1) {
            // update();
            // repaint();

            // delta = 0;
            // drawCount++;
            // }

            // if (timer > (1000 * 1000 * 1000)) {
            // System.out.println("FPS: " + drawCount);
            // drawCount = 0;
            // timer = 0;
            // }

            // var 1
            // update
            update();

            // rapaint
            repaint();

            // fps counter
            long now = System.nanoTime();
            if ((now - lastTime) >= 1000 * 1000 * 1000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                lastTime = now;
            } else {
                drawCount++;
            }

            // sleep
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime / (1000 * 1000);

            if (remainingTime > 0) {
                try {
                    Thread.sleep((long) remainingTime);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                nextDrawTime = System.nanoTime() + drawInterval;
            }

        }

    }

    public void update() {

        for (GItem item : items) {
            item.update();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(100, 100, 40, 40);

        for (GItem item : items) {
            item.draw(g2);
        }

        g2.dispose();

    }
}
