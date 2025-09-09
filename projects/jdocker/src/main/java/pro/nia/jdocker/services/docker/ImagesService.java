package pro.nia.jdocker.services.docker;

import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.model.Image;

import pro.nia.jdocker.domine.models.ImageList;

public class ImagesService implements ImagesServiceInterface {
  DockerClient _docker_client;

  public ImagesService(DockerClient docker_client) {
    _docker_client = docker_client;
  }

  @Override
  public List<ImageList> get_images() {
    List<Image> client_images = _docker_client.listImagesCmd().exec();
    return client_images.stream().map(ImagesService::_to_model).toList();
  }

  @Override
  public void remove_image(String image_id, boolean force) {
    _docker_client.removeImageCmd(image_id).withForce(force).exec();
  }

  @Override
  public pro.nia.jdocker.domine.models.Image get_image(String image_id) {
    InspectImageResponse result = _docker_client.inspectImageCmd(image_id).exec();
    System.out.println(result);
    return ImagesService.to_image(result);
  }

  static ImageList _to_model(Image data) {
    ImageList result = new ImageList();
    result.id = data.getId();
    result.created = data.getCreated();
    result.size = data.getSize();
    result.tags = data.getRepoTags();
    return result;
  }

  static pro.nia.jdocker.domine.models.Image to_image(InspectImageResponse r) {
    pro.nia.jdocker.domine.models.Image d = new pro.nia.jdocker.domine.models.Image();
    d.id = r.getId();
    d.created = r.getCreated();
    d.size = r.getSize();

    return d;
  }

}
