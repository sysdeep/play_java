package pro.nia.jdocker.ui.pages.containers;

import java.util.List;

import pro.nia.jdocker.domine.models.ContainerList;

public interface ContainersPageVM {
    public List<ContainerList> get_containers();
}
