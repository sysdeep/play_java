package pro.comcon.ddraw.items;

import java.awt.Color;
import java.awt.Graphics2D;

public class LampView implements GItem {
    int x;
    int y;
    int loopCounter = 0;
    Boolean state = false;

    public LampView() {
        x = 0;
        y = 0;
    }

    @Override
    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update() {
        loopCounter++;
        if (loopCounter >= 60) {
            state = !state;
            loopCounter = 0;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        Color color = state ? Color.red : Color.green;

        g2.setColor(color);
        g2.fillRect(this.x, this.y, 10, 10);

        // если вызывать, то дальнейшие операции рисования не вызываются
        // g2.dispose();
    }

}
