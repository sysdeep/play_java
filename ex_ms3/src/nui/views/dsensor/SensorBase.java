package nui.views.dsensor;

import nui.interfaces.IDSensor;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

public class SensorBase extends Canvas implements IDSensor {

    public SensorBase() {

    }

    public void paint(Graphics g) {
        Dimension d = getSize();

        g.drawRect(0, 0, d.width - 10, d.height - 10);

        g.setColor(Color.red);
        g.drawOval(10, 10, 10, 10);

        g.setColor(Color.green);
        g.fillOval(11, 11, 8, 8);
    }

    @Override
    public void set_state(boolean state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set_state'");
    }

    @Override
    public void set_block(boolean state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set_block'");
    }

    @Override
    public void set_control(boolean state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set_control'");
    }

}
