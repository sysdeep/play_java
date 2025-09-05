package pro.nia.jdocker.ui.pages.images;

public interface RequestHandler {
  void do_remove_image(String image_id);

  void do_show_image(String image_id);
}
