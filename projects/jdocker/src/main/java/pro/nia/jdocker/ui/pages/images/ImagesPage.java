package pro.nia.jdocker.ui.pages.images;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagesPage extends JPanel {
    public ImagesPage() {

        setLayout(new BorderLayout());

        add(new JLabel("Images"), BorderLayout.NORTH);
    }
}
