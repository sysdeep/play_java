package pro.comcon.nui.views.lamp;

import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Color;

public class Oval extends JComponent {
    protected void paintComponent(Graphics g) {
        // Call paintComponent from parent class
        super.paintComponent(g);

        // Draw a circle
        g.setColor(Color.RED);
        g.fillOval(90, 20, 50, 50);
        g.setColor(Color.BLACK);
        g.drawString("Circle", 200, 200);

    }
}
