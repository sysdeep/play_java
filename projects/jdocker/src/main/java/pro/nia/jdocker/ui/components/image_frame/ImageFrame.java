package pro.nia.jdocker.ui.components.image_frame;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import pro.nia.jdocker.domine.models.Image;

import java.awt.BorderLayout;
import java.awt.Dimension;
import com.github.dockerjava.api.command.InspectImageResponse;

/*
 *
Summary
  Name	172.28.1.1:5000/kaspersky/kata/redis
  Tag	1756111750
  ID	sha256:85062da2a8b628868a1ed00c5e7bf7268d2dc73683d5c9ea2d2e7aa5f79c4958
  Size	496.26 MB
  Age	2 weeks 
 
or Details
ID	sha256:85062da2a8b628868a1ed00c5e7bf7268d2dc73683d5c9ea2d2e7aa5f79c4958
Tags	
172.28.1.1:5000/kaspersky/kata/redis:1756111750
172.28.1.1:5000/kaspersky/kata/redis:latest
172.28.1.1:5000/kaspersky/kata/redis:test
kaspersky/kata/redis:test
Parent	
Comment	buildkit.dockerfile.v0
Size	473.27 MB
Created	2025-08-25 11:49:09


 History

 Inspect

 Containers



Actions:
- remove
- retag
- export
*/
public class ImageFrame extends JPanel {
  private DetailsFrame _details_frame;
  private JTabbedPane _tabs;

  public ImageFrame(Image image) {

    setLayout(new BorderLayout());

    _details_frame = new DetailsFrame(image);

    _tabs = new JTabbedPane();
    add(_tabs, BorderLayout.CENTER);

    _tabs.addTab("Main", _details_frame);
    _tabs.addTab("History", new JLabel("History"));

  }

  public void set_image(InspectImageResponse image) {
    _details_frame.set_image(image);
  }

  public static void main(String[] args) {
    // enable anti-aliased text:
    System.setProperty("awt.useSystemAAFontSettings", "on");

    // ImagesVMMock ctrl = new ImagesVMMock();

    Image image = new Image();
    image.id = "sha256:23wudchwueckj";

    SwingUtilities.invokeLater(() -> {
      JFrame window = new JFrame();
      ImageFrame view = new ImageFrame(image);

      window.add(view);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setPreferredSize(new Dimension(800, 600));
      window.pack();
      window.setVisible(true);

    });
  }

}
