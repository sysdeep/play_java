package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;

public class StatusPanelExample extends JPanel {
    JButton close_btn;

    public StatusPanelExample() {

        close_btn = new JButton("close");
        close_btn.setBounds(130, 100, 100, 40);
        close_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("exit");
            }
        });

        this.add(close_btn);
        this.setSize(60, 60);

    }

    public void set_exit_action(ActionListener action) {
        close_btn.addActionListener(action);
    }

    // for debug
    public static void main(String[] args) {
        JFrame f = new JFrame();

        Container c = f.getContentPane(); // клиентская область окна
        c.setLayout(new BorderLayout()); // выбираем компоновщик

        StatusPanelExample sp = new StatusPanelExample();
        sp.set_exit_action(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        StatusPanelExample sp2 = new StatusPanelExample();
        sp2.set_exit_action(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        c.add(sp, BorderLayout.SOUTH);
        c.add(sp2, BorderLayout.WEST);
        f.setSize(400, 500);// 400 width and 500 height
        // f.setLayout(null);// using no layout managers
        f.pack();
        f.setVisible(true);// making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}