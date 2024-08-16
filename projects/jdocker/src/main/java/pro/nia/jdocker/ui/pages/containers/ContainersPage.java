package pro.nia.jdocker.ui.pages.containers;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pro.nia.jdocker.domine.models.ContainerList;

public class ContainersPage extends JPanel {
    ContainersPageVM _vm;

    public ContainersPage(ContainersPageVM vm) {
        _vm = vm;

        setLayout(new BorderLayout());

        add(new JLabel("Containers"), BorderLayout.NORTH);

        // String[] column_names = {
        // "id",
        // };

        // String[][] data = {
        // { "1" },
        // { "2" },
        // };

        // JTable table = new JTable(data, column_names);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        // model.addColumn("Name");
        // model.addColumn("Quantity");
        // model.addColumn("Unit Price");
        // model.addColumn("Price");
        JTable table = new JTable(model);

        // JTableHeader h = new JTableHeader();
        // h.
        // JScrollPane scrollPane = new JScrollPane(table);

        // JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(table.getTableHeader(), BorderLayout.PAGE_START);
        this.add(table, BorderLayout.CENTER);

        // this.add(table, BorderLayout.CENTER);
        // this.add(scrollPane);

        // start
        System.out.println("from view start");
        List<ContainerList> containers = _vm.get_containers();
        containers.stream().forEach(c -> System.out.println(c.id));
        System.out.println("from view end");

        table.clearSelection();
        table.removeAll();
        // table.inse

        for (ContainerList data : containers) {
            model.addRow(new Object[] { data.id });
        }
    }
}
