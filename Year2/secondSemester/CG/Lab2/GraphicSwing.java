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
        g.setColor(Color.RED);
        naive_line(g, 100, 100, 400, 200);
        g.setColor(Color.GREEN);
        naive_line(g, 400, 300, 100, 200);
        g.setColor(Color.BLUE);
        naive_line(g, 100, 100, 200, 400);

        // g.setColor(Color.RED);
        // dda_line(g, 100, 100, 400, 200);
        // g.setColor(Color.GREEN);
        // dda_line(g, 400, 300, 100, 200);
        // g.setColor(Color.BLUE);
        // dda_line(g, 100, 100, 200, 400);

        // g.setColor(Color.RED);
        // bresenham_line(g, 100, 100, 400, 200);
        // g.setColor(Color.GREEN);
        // bresenham_line(g, 400, 300, 100, 200);
        // g.setColor(Color.BLUE);
        // bresenham_line(g, 100, 100, 200, 400);
    }

    public void naive_line(Graphics g, int x1, int y1, int x2, int y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float b = y1 - (dy / dx) * x1;

        for (int x = Math.min(x1, x2); x < Math.max(x1, x2); x++) {
            int y = (Math.round((dy / dx) * x + b));
            plot(g, x, y);
        }
    }

    public void dda_line(Graphics g, int x1, int y1, int x2, int y2) {
        float dx = x2 - x1;
        float dy = y2 - y1;
        float x = x1;
        float y = y1;
        float m = dy / dx;

        if (m <= 1 && m >= 0) {
            y = Math.min(y1, y2);
            for (x = Math.min(x1, x2); x < Math.max(x1, x2); x++) {
                y = y + m;
                plot(g, (int) x, Math.round(y));
            }
        } else if (m <= -1) {
            y = Math.max(y1, y2);
            for (x = Math.max(x1, x2); x > Math.min(x1, x2); x--) {
                y = y + m;
                plot(g, (int) x, Math.round(y));
            }
        } else if (m > 1) {
            x = Math.min(x1, x2);
            for (y = Math.min(y1, y2); y < Math.max(y1, y2); y++) {
                x = x + 1 / m;
                plot(g, Math.round(x), (int) y);
            }
        } else {
            x = Math.max(x1, x2);
            for (y = Math.max(y1, y2); y > Math.min(y1, y2); y--) {
                x = x + 1 / m;
                plot(g, Math.round(x), (int) y);
            }
        }
    }

    public void bresenham_line(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int D = 0;
        int dd = 0;

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            dd = dx;
            dx = dy;
            dy = dd;
            isSwap = true;
        }
        D = 2 * dy - dx;
        int x = x1;
        int y = y1;

        for (int i = 1; i <= dx; i++) {
            plot(g, x, y);
            if (D >= 0) {
                if (isSwap)
                    x += sx;
                else
                    y += sy;

                D -= 2 * dx;
            }

            if (isSwap)
                y += sy;
            else
                x += sx;

            D += 2 * dy;
        }
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}
