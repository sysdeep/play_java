package pro.nia.jdocker.controller;

import com.github.dockerjava.api.DockerClient;

public class AppController {
    ContainersController _containers;
    ImagesController _images;

    public AppController(DockerClient docker_client) {
        _containers = new ContainersController(docker_client);
        _images = new ImagesController(docker_client);
    }

    public ContainersController get_containers_controller() {
        return _containers;
    }

    public ImagesController get_images_controller() {
        return _images;
    }
}
