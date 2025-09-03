package pro.nia.jdocker;

import javax.swing.SwingUtilities;

import org.tinylog.Logger;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.transport.DockerHttpClient;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;

import pro.nia.jdocker.controller.AppController;
import pro.nia.jdocker.ui.MainWindow;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        Logger.info("Starting application...");

        // setup controllers --------------------------------------------------
        AppController app_controller = new AppController(build_docker_client());

        // setup UI -----------------------------------------------------------
        // enable anti-aliased text:
        System.setProperty("awt.useSystemAAFontSettings", "on");

        SwingUtilities.invokeLater(() -> {
            new MainWindow(app_controller);
        });

        // SwingUtilities.invokeLater(new Runnable() {
        // public void run() {
        // new MainWindow(app_controller);
        // }
        // });
        //

    }

    static DockerClient build_docker_client() {
        DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().build();

        DockerHttpClient httpClient = new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                // .maxConnections(100)
                // .connectionTimeout(Duration.ofSeconds(30))
                // .responseTimeout(Duration.ofSeconds(45))
                .build();

        DockerClient dockerClient = DockerClientImpl.getInstance(config, httpClient);

        dockerClient.pingCmd().exec();
        // List<Container> containers = dockerClient.listContainersCmd().exec();
        //
        // containers.stream().forEach((c) -> System.out.println(c.getId()));
        // for (Container cnt : containers) {
        // System.out.println(cnt.getImage());
        // }

        return dockerClient;
    }
}
