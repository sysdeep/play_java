package pro.nia.jdocker.ui.pages.images;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileUtils;

import pro.nia.jdocker.domine.models.ImageList;

public class ImagesPage extends JPanel {
    ImagesPageVM _vm;
    JTable _table;
    DefaultTableModel _table_model;

    public ImagesPage(ImagesPageVM vm) {
        _vm = vm;

        setLayout(new BorderLayout());

        add(new JLabel("Images"), BorderLayout.NORTH);

        _table_model = new DefaultTableModel();
        _table_model.addColumn("ID");
        _table_model.addColumn("Tags");
        _table_model.addColumn("Size");
        _table_model.addColumn("Created");
        // _table_model.addColumn("Options");
        _table = new JTable(_table_model);

        JScrollPane scrollPane = new JScrollPane(_table);
        _table.setFillsViewportHeight(true);
        this.add(_table.getTableHeader(), BorderLayout.PAGE_START);
        this.add(scrollPane, BorderLayout.CENTER);

        // start
        _refresh();
    }

    void _refresh() {
        List<ImageList> images = _vm.get_images();

        // TODO: remove
        images.stream().forEach(c -> System.out.println(c.created));

        _fill_list(images);
    }

    void _fill_list(List<ImageList> images) {
        _table.clearSelection();
        _table.removeAll();

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
            for (int i = 0; i < image.tags.length; i++) {
                view_tags.add(image.tags[i]);
            }
        }

        List<Object[]> result = new ArrayList<Object[]>();
        for (String tag : view_tags) {
            Object[] row = new Object[] {
                    _make_short_id(image.id),
                    tag,
                    _hum_size(image.size),
                    // Long.toString(image.size),
                    _date(image.created),
                    // Long.toString(image.created),
            };
            result.add(row);
        }

        return result;

    }

    static String _make_short_id(String id) {
        String[] split_result = id.split(":");
        if (split_result.length < 2) {
            return id;
        }

        return split_result[1].substring(0, 12);
    }

    static String _hum_size(Long value) {
        return FileUtils.byteCountToDisplaySize(value);
    }

    static String _date(Long value) {

        // NOTE: multi to 1000 - msec
        java.util.Date time = new java.util.Date(value * 1000);

        // TODO: format
        // LocalDate date = LocalDate.now();
        // System.out.println(date.toString());
        // System.out.println(time.toString());
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        // String text = date.format(formatter);
        // System.out.println(text);

        // DateFormat formatter = DateFormat.getDateTimeInstance();
        // return formatter.format(this);

        // кривой буржуйский формат...
        return time.toString();
    }
}
