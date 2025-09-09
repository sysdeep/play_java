package pro.nia.jdocker.ui.pages.images;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileUtils;

import pro.nia.jdocker.domine.models.ImageList;
import pro.nia.jdocker.helpers.DockerHelper;

public class ImagesTable extends JPanel {

  private final JTable _table;
  private final DefaultTableModel _table_model;
  private final RequestHandler _request_handler;

  public ImagesTable(RequestHandler request_handler) {
    this._request_handler = request_handler;

    setLayout(new BorderLayout());

    // table
    _table_model = new DefaultTableModel();
    _table_model.addColumn("ID");
    _table_model.addColumn("Tags");
    _table_model.addColumn("Size");
    _table_model.addColumn("Created");

    _table = new JTable(_table_model);
    this.add(_table.getTableHeader(), BorderLayout.PAGE_START);

    // scroll panel
    JScrollPane scrollPane = new JScrollPane(_table);
    _table.setFillsViewportHeight(true);
    this.add(scrollPane, BorderLayout.CENTER);

    // context menu
    _make_cmenu();

  }

  public void set_images(List<ImageList> images) {
    _table.clearSelection();
    _table.removeAll();
    _table_model.setRowCount(0);

    for (ImageList data : images) {
      for (Object[] image_row : _image_to_row(data)) {
        _table_model.addRow(image_row);
      }
    }

  }

  List<Object[]> _image_to_row(ImageList image) {
    List<String> view_tags = new ArrayList<String>();

    if (image.tags.length == 0) {
      view_tags.add("no tags");
    } else {
      view_tags.addAll(Arrays.asList(image.tags));
    }

    List<Object[]> result = new ArrayList<Object[]>();
    for (String tag : view_tags) {
      Object[] row = new Object[] {
          DockerHelper.make_short_id(image.id),
          tag,
          DockerHelper.humanize_size(image.size),
          // Long.toString(image.size),
          DockerHelper.timestamp_2_date(image.created),
          // Long.toString(image.created),
      };
      result.add(row);
    }

    return result;

  }

  /**
   * сначала надо выбрать строку, и именно к этой строке применяются операции
   */
  void _make_cmenu() {
    JPopupMenu menu = new JPopupMenu();

    // remove
    JMenuItem remove = new JMenuItem("remove");
    remove.addActionListener((ActionEvent e) -> {
      System.out.println("remove called");

      int currentRow = _table.getSelectedRow();
      if (currentRow == -1) {
        // Display the warning modal dialog
        JOptionPane.showMessageDialog(
            this, // Parent component (can be null to center on screen)
            "No selected row!", // The message to display
            "Warning", // The title of the dialog
            JOptionPane.WARNING_MESSAGE // The message type (displays a warning icon)
        );
        return;
      }

      String v = _table_model.getValueAt(currentRow, 0).toString();

      _request_handler.do_remove_image(v);

    });
    menu.add(remove);

    // show
    JMenuItem inspect = new JMenuItem("inspect");
    inspect.addActionListener((ActionEvent e) -> {
      System.out.println("inspect called");

      int currentRow = _table.getSelectedRow();
      if (currentRow == -1) {
        // Display the warning modal dialog
        JOptionPane.showMessageDialog(
            this, // Parent component (can be null to center on screen)
            "No selected row!", // The message to display
            "Warning", // The title of the dialog
            JOptionPane.WARNING_MESSAGE // The message type (displays a warning icon)
        );
        return;
      }

      String v = _table_model.getValueAt(currentRow, 0).toString();

      _request_handler.do_show_image(v);

    });
    menu.add(inspect);

    // force remove
    // JMenuItem remove_force = new JMenuItem("remove force");
    // remove_force.addActionListener(e -> {
    // System.out.println("remove force called");
    // });

    // menu.add(remove_force);

    _table.setComponentPopupMenu(menu);

  }

}
