package pro.nia.jdocker.controller;

import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;

import pro.nia.jdocker.domine.models.ContainerList;
import pro.nia.jdocker.ui.pages.containers.ContainersPageVM;

public class ContainersController implements ContainersPageVM {
    DockerClient _docker_client;

    public ContainersController(DockerClient docker_client) {
        _docker_client = docker_client;
    }

    @Override
    public List<ContainerList> get_containers() {

        List<Container> containers = _docker_client.listContainersCmd().exec();

        // // containers.stream().forEach((c) -> System.out.println(c.getId()));
        // for (Container cnt : containers) {
        // System.out.println(cnt.getImage());
        // }

        List<ContainerList> result = containers.stream().map(c -> _to_model(c)).toList();

        return result;
    }

    static ContainerList _to_model(Container data) {
        ContainerList result = new ContainerList();
        result.id = data.getId();
        return result;
    }

}
