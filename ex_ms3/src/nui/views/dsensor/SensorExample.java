package nui.views.dsensor;

import java.awt.Frame;
import java.awt.event.*;

public class SensorExample {

    public static void main(String[] args) {
        // enable anti-aliased text: - не очень помогает...
        System.setProperty("awt.useSystemAAFontSettings", "on");

        Frame f = new Frame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setSize(800, 600);
        SensorBase sensor_1 = new SensorBase();
        f.add("Center", sensor_1);

        f.setVisible(true);// making the frame visible
    }
}
