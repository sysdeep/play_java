package pro.nia.jdocker.utils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;

public class DockerClientBuilder {

  public static DockerClient build_docker_client() {
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
