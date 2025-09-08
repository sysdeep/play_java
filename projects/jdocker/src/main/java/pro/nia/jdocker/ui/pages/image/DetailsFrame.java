package pro.nia.jdocker.ui.pages.image;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pro.nia.jdocker.domine.models.Image;

/*

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




*/
public class DetailsFrame extends JPanel {

  public DetailsFrame(Image image) {

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    // setLayout(new FlowLayout(FlowLayout.CENTER));

    add(new JLabel("Details"));

    JPanel _grid = new JPanel();

    GridLayout layout = new GridLayout(0, 2, 5, 5);
    _grid.setLayout(layout);

    // add(new JLabel("Details frame"));
    // add(new JLabel("2"));
    // add(new JLabel("3"));
    // for (int i = 0; i < 10; i++) {
    // add(new JLabel("label: " + i));
    // }

    _grid.add(new JLabel("ID"));
    _grid.add(new JLabel(image.id));

    _grid.add(new JLabel("Created"));
    _grid.add(new JLabel("TODO"));

    _grid.add(new JLabel("Size"));
    _grid.add(new JLabel("TODO"));

    add(_grid);
  }
}
