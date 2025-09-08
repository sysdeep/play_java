package pro.nia.jdocker.services.docker;

import com.github.dockerjava.api.DockerClient;

public class DockerService implements DockerServiceInterface {
  // ContainersController _containers;
  ImagesService _images;

  public DockerService(DockerClient docker_client) {
    // _containers = new ContainersController(docker_client);
    _images = new ImagesService(docker_client);
  }

  // public ContainersController get_containers_controller() {
  // return _containers;
  // }

  public ImagesService get_images_service() {
    return _images;
  }
}
