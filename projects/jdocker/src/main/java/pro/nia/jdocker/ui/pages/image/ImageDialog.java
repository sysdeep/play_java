package pro.nia.jdocker.ui.pages.image;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import pro.nia.jdocker.domine.models.Image;

public class ImageDialog extends JDialog {
  private ImageFrame _image_frame;

  public ImageDialog(Frame owner, String title, boolean modal) {
    super(owner, title, modal);

    // Add components to the dialog

    setPreferredSize(new Dimension(800, 600));

    Image image = new Image();

    // image frame ----------------------------------------
    _image_frame = new ImageFrame(image);
    add(_image_frame, BorderLayout.CENTER);

    // toolbar --------------------------------------------
    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(e -> dispose()); // Close the dialog on button click
    add(closeButton, BorderLayout.SOUTH);
    pack();
    setLocationRelativeTo(owner); // Center relative to owner
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
  }

  public static void main(String[] args) {
    // enable anti-aliased text:
    System.setProperty("awt.useSystemAAFontSettings", "on");
    JFrame frame = new JFrame("Main Application Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLayout(new FlowLayout());

    JButton openDialogButton = new JButton("Open Modal Dialog");
    openDialogButton.addActionListener(e -> {
      ImageDialog dialog = new ImageDialog(frame, "Modal Dialog Example", true);
      dialog.setVisible(true); // Show the modal dialog
    });
    frame.add(openDialogButton);

    frame.setVisible(true);
  }
}
