package pro.nia.jdocker.ui.pages.images;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

/**
 * A mouse listener for a JTable component.
 */
public class _TableMouseListener extends MouseAdapter {

  private JTable table;

  public _TableMouseListener(JTable table) {
    this.table = table;
  }

  @Override
  public void mousePressed(MouseEvent event) {
    System.out.println("pressed");
    // selects the row at which point the mouse is clicked
    Point point = event.getPoint();
    int currentRow = table.rowAtPoint(point);
    System.out.println(currentRow);
    table.setRowSelectionInterval(currentRow, currentRow);

  }

  // public void mouseClicked(MouseEvent event) {
  // System.out.println("clicked");
  // }

}
