package pro.nia.jdocker.ui.pages.images;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import org.tinylog.Logger;

import pro.nia.jdocker.domine.models.ImageList;
// import pro.nia.jdocker.ui.pages.image.ImageDialog;
import pro.nia.jdocker.ui.UiCtx;

public class ImagesPage extends JPanel implements RequestHandler {
    private final ImagesPageVM _vm;
    private final ImagesTable _images_table;
    private final JButton btn_refresh;
    // private final ImageDialog _image_dialog;
    private UiCtx _ui_ctx;

    public ImagesPage(ImagesPageVM vm, UiCtx ui_ctx) {
        _vm = vm;
        _ui_ctx = ui_ctx;

        // ImageDialog _image_dialog = new ImageDialog(this, "Modal Dialog Example",
        // true);
        // _image_dialog.setVisible(true); // Show the modal dialog

        setLayout(new BorderLayout());

        add(new JLabel("Images"), BorderLayout.NORTH);

        _images_table = new ImagesTable(this);
        add(_images_table, BorderLayout.CENTER);

        btn_refresh = new JButton("Refresh");
        // btn_refresh.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // _refresh();
        // }
        // });
        btn_refresh.addActionListener(e -> {
            _refresh();
        });
        add(btn_refresh, BorderLayout.PAGE_END);

        // start
        _refresh();
    }

    void _refresh() {

        Logger.debug("start images refreshing...");
        btn_refresh.setEnabled(false);

        // async update
        SwingWorker<List<ImageList>, Void> worker = new SwingWorker<List<ImageList>, Void>() {
            @Override
            protected List<ImageList> doInBackground() throws Exception {
                System.out.println("start background task");
                // Thread.sleep(3000);
                List<ImageList> images = _vm.get_images();
                System.out.println("end background task");
                return images;
            }

            @Override
            protected void done() {
                // System.out.println("task done!!");
                try {
                    List<ImageList> images = get(); // Get the result from doInBackground()
                    _fill_list(images);
                } catch (Exception ex) {
                    Logger.error("Task Failed: " + ex.getMessage());
                } finally {
                    btn_refresh.setEnabled(true);
                }
            }
        };
        worker.execute();

    }

    void _fill_list(List<ImageList> images) {

        _images_table.set_images(images);
    }

    @Override
    public void do_remove_image(String image_id) {
        Logger.debug("do remove request: " + image_id);
        _vm.remove_image(image_id, true);
        _refresh();
    }

    @Override
    public void do_show_image(String image_id) {
        Logger.debug("do show request: " + image_id);

        _ui_ctx.show_image(image_id);

        // _image_dialog = new ImageDialog(this, "Modal Dialog Example", true);
        // _image_dialog.setVisible(true); // Show the modal dialog
    }

}
