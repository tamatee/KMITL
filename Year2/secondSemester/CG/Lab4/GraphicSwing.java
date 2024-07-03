import javax.swing.*;
import java.awt.*;

public class GraphicSwing extends JPanel {

    public static void main(String[] args) {
        GraphicSwing m = new GraphicSwing();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Second Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // midpointCircle(g, 300, 300, 100);
        midpointEllipe(g, 300, 300, 200, 100);
    }

    public void midpointCircle(Graphics g, int xc, int yc, int r) {
        int x = 0;
        int y = r;
        int d = 1 - r;
        int dx = 2 * x;
        int dy = 2 * y;

        while (x <= y) {
            plot(g, x + xc, y + yc, 3);
            plot(g, -x + xc, y + yc, 3);
            plot(g, x + xc, -y + yc, 3);
            plot(g, -x + xc, -y + yc, 3);
            plot(g, y + xc, x + yc, 3);
            plot(g, -y + xc, x + yc, 3);
            plot(g, y + xc, -x + yc, 3);
            plot(g, -y + xc, -x + yc, 3);

            x++;
            dx += 2;
            d += dx + 1;

            if (d > 0) {
                y--;
                dy -= 2;
                d -= dy;
            }
        }

    }

    public void midpointEllipe(Graphics g, int xc, int yc, int a, int b) {
        int a2 = a * a;
        int b2 = b * b;
        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;
        // Region1
        int x = 0;
        int y = b;
        int d = Math.round(b2 - a2 * b + a2 / 4);
        int dx = 0;
        int dy = twoA2 * y;

        while (dx <= dy) {
            plot(g, x + xc, y + yc, 3);
            plot(g, -x + xc, y + yc, 3);
            plot(g, x + xc, -y + yc, 3);
            plot(g, -x + xc, -y + yc, 3);

            x++;
            dx += twoB2;
            d += dx + b2;

            if (d >= 0) {
                y--;
                dy -= twoA2;
                d -= dy;
            }
        }

        // Region2
        x = a;
        y = 0;
        d = Math.round(a2 - b2 * a + b2 / 4);
        dx = twoB2 * x;
        dy = 0;

        while (dx >= dy) {
            plot(g, x + xc, y + yc, 3);
            plot(g, -x + xc, y + yc, 3);
            plot(g, x + xc, -y + yc, 3);
            plot(g, -x + xc, -y + yc, 3);

            y++;
            dy += twoA2;
            d += dy + a2;

            if (d >= 0) {
                x--;
                dx -= twoB2;
                d -= dx;
            }
        }
    }

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    public void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

}
