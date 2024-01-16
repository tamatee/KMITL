package Year2.secondSemester.CG.Lab1;

import java.util.Random;

import javax.swing.*;
import java.awt.*;

public class GraphicSwing extends JPanel {

    private final Random random = new Random();

    public static void main(String[] args) {
        GraphicSwing m = new GraphicSwing();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawString("Hello", 40, 40);
        g.setColor(Color.BLUE);
        g.drawRect(130, 30, 100, 80);
        g.drawOval(30, 130, 50, 60);
        g.setColor(Color.RED);
        g.drawLine(0, 0, 200, 30);
        g.fillOval(130, 130, 50, 60);
        g.drawArc(30, 200, 40, 50, 90, 60);
        g.fillArc(30, 130, 40, 50, 180, 40);
        for (int x = 0; x < 600; x += 60) {
            int y = x;
            g.setColor(randomColor());
            plot(g, x, y);
        }
    }

    private Color randomColor() {
            return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 5, 5);
    }
}
