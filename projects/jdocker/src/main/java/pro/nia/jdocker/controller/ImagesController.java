package pro.nia.jdocker.controller;

import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;

import pro.nia.jdocker.domine.models.ImageList;
import pro.nia.jdocker.ui.pages.images.ImagesPageVM;

public class ImagesController implements ImagesPageVM {
    DockerClient _docker_client;

    public ImagesController(DockerClient docker_client) {
        _docker_client = docker_client;
    }

    @Override
    public List<ImageList> get_images() {
        List<Image> client_images = _docker_client.listImagesCmd().exec();
        return client_images.stream().map(i -> _to_model(i)).toList();
    }

    @Override
    public void remove_image(String image_id, boolean force) {
        _docker_client.removeImageCmd(image_id).withForce(force).exec();
    }

    static ImageList _to_model(Image data) {
        ImageList result = new ImageList();
        result.id = data.getId();
        result.created = data.getCreated();
        result.size = data.getSize();
        result.tags = data.getRepoTags();
        return result;
    }

}
