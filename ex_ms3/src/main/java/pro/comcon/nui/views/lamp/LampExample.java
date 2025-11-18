package pro.comcon.nui.views.lamp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LampExample {

    public static void main(String[] args) {
        // enable anti-aliased text: - не очень помогает...
        System.setProperty("awt.useSystemAAFontSettings", "on");

        SwingUtilities.invokeLater(() -> {

            JFrame f = new JFrame();

            Container container = f.getContentPane();
            container.setLayout(new BorderLayout());

            Lamp sensor_1 = new Lamp(10);
            f.add(sensor_1, BorderLayout.CENTER);

            // Rect rect = new Rect();
            // f.add(rect, BorderLayout.CENTER);

            // Lamp sensor_2 = new Lamp(40);
            // f.add(sensor_2);

            JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JButton exitBtn = new JButton("Exit");
            exitBtn.addActionListener(e -> {
                f.dispose();
            });

            JButton colorButton = new JButton("Color");
            // colorButton.addActionListener(e -> sensor_1.set_color("null"));

            controls.add(colorButton);
            controls.add(new JButton("State"));
            controls.add(exitBtn);

            f.add(controls, BorderLayout.SOUTH);
            f.setPreferredSize(new Dimension(800, 600));
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);// making the frame visible
        });
    }
}
