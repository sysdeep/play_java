package pro.comcon.ddraw.items;

import java.awt.Graphics2D;

public interface GItem {

    // loop
    public void update();

    // loop
    public void draw(Graphics2D g2);

    // settings
    public void setPos(int x, int y);
}