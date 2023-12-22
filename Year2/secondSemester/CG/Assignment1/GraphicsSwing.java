import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsSwing extends JPanel {
    int d_size = 1;

    protected Random random = new Random();
    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("NewYear");
        f.setSize(600, 600);
        f.setBackground(Color.BLACK);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.BLUE);
        double [][]controlPoints = {{215, 504}, {230, 473} ,{253, 450},{232, 420}, {232, 400}};
        bresenham_line(g, 215, 504, 208, 504);
        BezierCurve be = new BezierCurve(controlPoints);
        be.paintComponent(g);
    }

    public void genParticle(Graphics g, int x1, int y1, int x2, int y2) {
        bresenham_line(g, 20, 20, 22, 28);
        bresenham_line(g, 22, 23, 24, 34);
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

    private int randomLength(int n)
    {
        return random.nextInt(n);
    }

    private void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, d_size, d_size);
    }
}
