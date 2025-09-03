package pro.nia.jdocker.ui.pages.images;

import java.util.List;

import pro.nia.jdocker.domine.models.ImageList;

public interface ImagesPageVM {
    public List<ImageList> get_images();

    public void remove_image(String image_id, boolean force);
}
