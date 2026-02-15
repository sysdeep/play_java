package pro.comcon.ddraw.items;

import java.awt.Color;
import java.awt.Graphics2D;

public class LampView implements GItem {
    int x;
    int y;
    int loopCounter = 0;
    Boolean state = false;

    public LampView() {
        x = 20;
        y = 20;
    }

    @Override
    public void update() {
        loopCounter++;
        if (loopCounter > 10) {
            state = !state;
            loopCounter = 0;
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        Color color = state ? Color.red : Color.green;

        g2.setColor(color);
        g2.fillRect(x, y, 10, 10);

        g2.dispose();
    }

}
