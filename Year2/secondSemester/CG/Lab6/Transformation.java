import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Transformation extends JPanel {
    public static void main(String[] args) {
        Transformation m = new Transformation();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Sixth Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setTransform(new AffineTransform(1, 0, 0, 1, 100, 100));
        drawRect(g2, 200, 200, 200, 200);

        g2.setColor(Color.RED);
        g2.setTransform(new AffineTransform(Math.cos(Math.toRadians(30)),-Math.sin(Math.toRadians(30)),Math.sin(Math.toRadians(30)),Math.cos(Math.toRadians(30)),0, 0));
        drawRect(g2, 200, 200, 200, 200);

        g2.setColor(Color.BLUE);
        g2.setTransform(new AffineTransform(2, 0, 0 , 2, -50, 50));
        drawRect(g2, 200, 200, 200, 200);
    }

    public void drawRect(Graphics2D g2, int x, int y, int width, int height) {
        if ((width < 0) || (height < 0)) {
            return;
        }

        if (height == 0 || width == 0) {
            g2.drawLine(x, y, x + width, y + height);
        } else {
            g2.drawLine(x, y, x + width - 1, y);
            g2.drawLine(x + width, y, x + width, y + height - 1);
            g2.drawLine(x + width, y + height, x + 1, y + height);
            g2.drawLine(x, y + height, x, y + 1);
        }
    }
}