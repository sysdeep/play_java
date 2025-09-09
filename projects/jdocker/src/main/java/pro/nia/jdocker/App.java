package pro.nia.jdocker;

import javax.swing.SwingUtilities;

import org.tinylog.Logger;

import pro.nia.jdocker.services.docker.DockerService;
import pro.nia.jdocker.ui.MainWindow;
import pro.nia.jdocker.utils.DockerClientBuilder;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Logger.info("Starting application...");

        // setup controllers --------------------------------------------------
        DockerService docker_service = new DockerService(DockerClientBuilder.build_docker_client());

        // setup UI -----------------------------------------------------------
        // enable anti-aliased text:
        System.setProperty("awt.useSystemAAFontSettings", "on");

        SwingUtilities.invokeLater(() -> {
            new MainWindow(docker_service);
        });

        // SwingUtilities.invokeLater(new Runnable() {
        // public void run() {
        // new MainWindow(app_controller);
        // }
        // });
        //

    }

}
