import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu implements ActionListener {

    JFrame frame;
    JButton b0 = new JButton("Tree");
    JButton b1 = new JButton("Sierpinski Triangle");
    JButton b2 = new JButton("Circle");
    JButton b3 = new JButton("Cantor Line");
    JButton b4 = new JButton("Cantor Circle");

    public Menu() {
        frame = new JFrame("MAIN MENU");

        frame.setPreferredSize(new Dimension(400,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        Label l = new Label();
        l.setText("Pick a Fractal Type");
        l.setFont(new Font("TimesRoman", Font.BOLD, 20));
        l.setVisible(true);
        l.setBounds(75, 50, 200, 40);

        b0.setBounds(75, 100, 200, 40);
        b0.setFocusable(false);
        b0.addActionListener(this);
        b0.setVisible(true);

        b1.setBounds(75, 200, 200, 40);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setVisible(true);

        b2.setBounds(75, 300, 200, 40);
        b2.setFocusable(false);
        b2.addActionListener(this);
        b2.setVisible(true);

        b3.setBounds(75, 400, 200, 40);
        b3.setFocusable(false);
        b3.addActionListener(this);
        b3.setVisible(true);

        b4.setBounds(75, 500, 200, 40);
        b4.setFocusable(false);
        b4.addActionListener(this);
        b4.setVisible(true);

        frame.add(b0);
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(l);

        frame.pack();
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b0){
            frame.dispose();
            ColorPick c = new ColorPick("tree");
        } else if (e.getSource() == b1) {
            frame.dispose();
            ColorPick c = new ColorPick("triangle");
        } else if (e.getSource() == b2) {
            frame.dispose();
            ColorPick c = new ColorPick("circle");
        } else if (e.getSource() == b3) {
            frame.dispose();
            ColorPick c = new ColorPick("cantor-line");
        } else if (e.getSource() == b4) {
            frame.dispose();
            ColorPick c = new ColorPick("cantor-circle");
        }else {
            return;
        }
    }
}
