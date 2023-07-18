import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fractal extends JFrame implements ActionListener {

    private JPanel panel;
    private String type;
    private JMenuItem mainMenu;
    private JFrame frame;
    private Color c1;
    private Color c2;
    public Fractal(String type, Color c1, Color c2) throws HeadlessException {
        super(type);
        this.type = type;
        frame = new JFrame(type.substring(0,1).toUpperCase() + type.substring(1));

        JMenuBar menuBar = new JMenuBar();
        JMenu homeMenu = new JMenu("Home");

        mainMenu = new JMenuItem("Main Menu");

        mainMenu.addActionListener(this);

        homeMenu.add(mainMenu);
        menuBar.add(homeMenu);

        frame.setJMenuBar(menuBar);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;

                g2d.setPaint(new GradientPaint(100,100,c1,300,300,c2,true));

                switch (type) {
                    case "triangle" -> drawTriangle(10, (int) Math.sqrt(1280), (int) Math.sqrt(720), 640, g2d);
                    case "tree" -> drawTree(g2d, 640, 720, -90, 11);
                    case "circle" -> drawCircle(g2d, 640, 400, 150);
                    case "cantor-line" -> drawCantorLine(g2d, 0, 300, 1280);
                    case "cantor-circle" -> drawCantorCircle(g2d, 640, 400, 300);
                }

            }
        };

        panel.setPreferredSize(new Dimension(1280,720));


        frame.add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void drawCantorLine(Graphics2D g, int x1, int y1, int len){
        if(len >= 1){
            int x2 = x1 + len;
            g.drawLine(x1, y1,x2,y1);
            drawCantorLine(g, x1, y1+50, len/3);
            drawCantorLine(g, (int)(x1+(len*(2.0/3.0))), y1+50, len/3);
        }

    }
    private void drawCantorCircle(Graphics2D g, double xMid, double yMid, double radius){
        if (radius <= 0)return;
        g.drawOval((int) ((int) xMid - radius), (int) ((int) yMid-radius), (int) (2*radius), (int) (2*radius));
        if (radius >2){
            drawCantorCircle(g,xMid+radius/2, yMid, radius/2);
            drawCantorCircle(g,xMid - radius/2, yMid, radius/2);
        }
    }

    private void drawCircle(Graphics2D g, double xMid, double yMid , double radius){
        if (radius <= 0)return;
        g.drawOval((int) ((int) xMid - radius), (int) ((int) yMid-radius), (int) (2*radius), (int) (2*radius));
        if(radius > 2){
            drawCircle(g,xMid - radius, yMid, radius/2);
            drawCircle(g,xMid, yMid- radius, radius/2);
            drawCircle(g, xMid+ radius, yMid , radius/2);
            drawCircle(g, xMid, yMid+ radius , radius/2);
        }


    }

    private void drawTree(Graphics2D g, int x1, int y1, double angle, int depth) {
        if (depth == 0) return;
        int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
        int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);
        g.drawLine(x1, y1, x2, y2);
        drawTree(g, x2, y2, angle - 20, depth - 1);
        drawTree(g, x2, y2, angle + 20, depth - 1);
    }

    private static void drawTriangle(int level, int x, int y, int size, Graphics2D g) {
        if(level <= 0) return;

        g.drawLine(x, y, x+size, y);
        g.drawLine(x, y, x, y+size);
        g.drawLine(x+size, y, x, y+size);

        drawTriangle(level-1, x, y, size/2, g);
        drawTriangle(level-1, x+size/2, y, size/2, g);
        drawTriangle(level-1, x, y+size/2, size/2, g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == mainMenu){
            frame.dispose();
            Menu m = new Menu();
        }
    }
}
