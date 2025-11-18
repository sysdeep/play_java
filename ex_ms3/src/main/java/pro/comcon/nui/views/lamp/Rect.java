package pro.comcon.nui.views.lamp;

import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;

public class Rect extends JComponent {
    private Oval _oval;

    public Rect() {

        setLayout(new FlowLayout()); // Use a layout manager
        add(new JButton("Child Button 1"));
        add(new JButton("Child Button 2"));

        this._oval = new Oval();
        this.add(this._oval);
        this._oval.setLocation(30, 40);
    }

    protected void paintComponent(Graphics g) {
        // Call paintComponent from parent class
        super.paintComponent(g);

        // Draw a square
        // g.setColor(Color.BLUE);
        // g.fillRect(20, 20, 50, 50);
        // g.setColor(Color.BLACK);
        // g.drawString("Square", 30, 100);

        // // Draw a circle
        // g.setColor(Color.RED);
        // g.fillOval(90, 20, 50, 50);
        // g.setColor(Color.BLACK);
        // g.drawString("Circle", 100, 100);

        // Draw a triangle
        int xPoints[] = { 150, 200, 250 };
        int yPoints[] = { 20, 70, 20 };
        g.setColor(Color.GREEN);
        g.fillPolygon(xPoints, yPoints, 3);
        g.setColor(Color.BLACK);
        g.drawString("Triangle", 170, 100);
    }
}
