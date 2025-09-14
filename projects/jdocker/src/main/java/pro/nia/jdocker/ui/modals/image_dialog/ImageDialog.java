package pro.nia.jdocker.ui.modals.image_dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.dockerjava.api.command.InspectImageResponse;

import pro.nia.jdocker.domine.models.Image;
import pro.nia.jdocker.domine.models.ImageList;
import pro.nia.jdocker.services.docker.DockerService;
import pro.nia.jdocker.services.docker.DockerServiceInterface;
import pro.nia.jdocker.ui.components.image_frame.ImageFrame;
import pro.nia.jdocker.utils.DockerClientBuilder;

public class ImageDialog extends JDialog {
  private final ImageFrame _image_frame;
  private final DockerServiceInterface _docker_service;
  private final String _image_id;

  public ImageDialog(Frame owner, DockerServiceInterface docker_service, String image_id) {
    super(owner, "Image modal", false);

    _docker_service = docker_service;
    _image_id = image_id;

    // Add components to the dialog

    setPreferredSize(new Dimension(800, 600));

    Image image = new Image();

    // image frame ----------------------------------------
    _image_frame = new ImageFrame(image);
    add(_image_frame, BorderLayout.CENTER);

    // toolbar --------------------------------------------
    JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    add(toolbar, BorderLayout.SOUTH);

    JButton closeButton = new JButton("Close");
    closeButton.addActionListener(e -> dispose()); // Close the dialog on button click
    toolbar.add(closeButton);

    //
    pack();
    setLocationRelativeTo(owner); // Center relative to owner
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    // start ----------------------------------------------
    InspectImageResponse doimage = _docker_service.get_images_service().get_image(image_id);
    System.out.println("===========================");
    System.out.println(doimage);
    System.out.println(doimage.getConfig());
    System.out.println(doimage.getRawValues());
    System.out.println("===========================");
    _image_frame.set_image(doimage);
  }

  public static void main(String[] args) {
    // enable anti-aliased text:
    System.setProperty("awt.useSystemAAFontSettings", "on");
    JFrame frame = new JFrame("Main Application Frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLayout(new FlowLayout());

    // service ----------------------------------------------------------------
    DockerService docker_service = new DockerService(DockerClientBuilder.build_docker_client());
    List<ImageList> images = docker_service.get_images_service().get_images();
    // if (images.isEmpty()) {
    //
    // }

    JButton openDialogButton = new JButton("Open Modal Dialog");
    openDialogButton.addActionListener(e -> {
      ImageDialog dialog = new ImageDialog(frame, docker_service, images.get(0).id);
      dialog.setVisible(true); // Show the modal dialog
    });
    frame.add(openDialogButton);

    frame.setVisible(true);

    openDialogButton.doClick();
  }
}
