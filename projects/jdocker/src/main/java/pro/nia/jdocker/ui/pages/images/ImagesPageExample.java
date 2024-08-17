package pro.nia.jdocker.ui.pages.images;

import java.util.List;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;

import pro.nia.jdocker.domine.models.ImageList;

public class ImagesPageExample {
    public static void main(String[] args) {
        // enable anti-aliased text:
        System.setProperty("awt.useSystemAAFontSettings", "on");

        ImagesVMMock ctrl = new ImagesVMMock();

        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame();
            ImagesPage view = new ImagesPage(ctrl);

            window.add(view);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setPreferredSize(new Dimension(800, 600));
            window.pack();
            window.setVisible(true);

        });
    }
}

class ImagesVMMock implements ImagesPageVM {

    @Override
    public List<ImageList> get_images() {
        List<ImageList> result = new ArrayList<ImageList>();
        for (int i = 0; i < 200; i++) {
            String str_i = Integer.toString(i);

            ImageList image = new ImageList();

            image.id = str_i + ":" + "skdidiwjoi4rjowencosjndcojn";
            image.created = Long.valueOf(i);
            image.size = Long.valueOf(i);
            image.tags = new String[] { "1", "2" };

            result.add(image);
        }

        return result;
    }
}