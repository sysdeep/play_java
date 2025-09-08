package pro.nia.jdocker.services.docker;

import java.util.List;

import pro.nia.jdocker.domine.models.Image;
import pro.nia.jdocker.domine.models.ImageList;

public interface ImagesServiceInterface {
  List<ImageList> get_images();

  void remove_image(String image_id, boolean force);

  Image get_image(String image_id);

}
