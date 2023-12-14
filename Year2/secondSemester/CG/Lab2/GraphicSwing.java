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
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        line(g, 0, 0, 200, 200);
    }

    public void line(Graphics g, int x1, int y1, int x2, int y2) {
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

    private Color randomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }
}
