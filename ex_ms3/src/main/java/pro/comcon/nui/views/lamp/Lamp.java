package pro.comcon.nui.views.lamp;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Lamp extends Canvas {
    private int _size;

    public Lamp(int size) {
        _size = size;
    }

    public void paint(Graphics g) {
        Dimension d = getSize();

        g.drawRect(0, 0, d.width - 10, d.height - 10);

        g.setColor(Color.red);
        g.drawOval(_size, _size, _size, _size);

        g.setColor(Color.green);
        g.fillOval(11, 11, 8, 8);
    }

    public void set_state(boolean state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set_state'");
    }

    public void set_color(String color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set_block'");
    }

    public void set_state_and_color(boolean state, String color) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set_control'");
    }

}
