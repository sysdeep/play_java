package pro.nia.jdocker.controller;

import com.github.dockerjava.api.DockerClient;

public class AppController {
    ContainersController _containers;

    public AppController(DockerClient docker_client) {
        _containers = new ContainersController(docker_client);
    }

    public ContainersController get_containers_controller() {
        return _containers;
    }
}
