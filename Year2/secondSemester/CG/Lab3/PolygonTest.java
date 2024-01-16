import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;

class PolygonTest extends JPanel {
    public static void main(String[] args) {
        PolygonTest m = new PolygonTest();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("PolygonTest");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);

        g2.setColor(Color.BLACK);
        plot(g2, 100, 100);
        plot(g2, 500, 500);
        plot(g2, 100, 500);
        plot(g2, 500, 100);
        bezierCurve(g2, 100, 100, 500, 500, 100, 500, 500, 100);
        bresenhamLine(g2, 100, 100, 500, 100);

        int[] xpoly = { 100, 250, 550, 400, 250, 90, 40 };
        int[] ypoly = { 100, 50, 150, 300, 500, 400, 200 };
        Polygon poly = new Polygon(xpoly, ypoly, 7);
        g2.drawPolygon(poly);
        buffer = floodFill(buffer, 480, 110, Color.WHITE, Color.BLUE);
        g.drawImage(buffer, 0, 0, null);

    }

    void coloredPlot(Graphics g, int x, int y, Color c) {
        g.setColor(c);
        g.fillRect(x, y, 1, 1);
        g.setColor(Color.BLACK);
    }

    BufferedImage floodFill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor) {
        Queue<NodeCoordinate> q = new LinkedList<>();
        coloredPlot(m.getGraphics(), x, y, replacementColor);
        q.add(new NodeCoordinate(x, y));
        while (!q.isEmpty()) {
            NodeCoordinate cur = q.poll();
            try {
                // South
                if (m.getRGB(cur.getX(), cur.getY() + 1) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX(), cur.getY() + 1, replacementColor);
                    q.add(new NodeCoordinate(cur.getX(), cur.getY() + 1));
                }
                // North
                if (m.getRGB(cur.getX(), cur.getY() - 1) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX(), cur.getY() - 1, replacementColor);
                    q.add(new NodeCoordinate(cur.getX(), cur.getY() - 1));
                }
                // West
                if (m.getRGB(cur.getX() - 1, cur.getY()) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX() - 1, cur.getY(), replacementColor);
                    q.add(new NodeCoordinate(cur.getX() - 1, cur.getY()));
                }
                // East
                if (m.getRGB(cur.getX() + 1, cur.getY()) == targetColor.getRGB()) {
                    coloredPlot(m.getGraphics(), cur.getX() + 1, cur.getY(), replacementColor);
                    q.add(new NodeCoordinate(cur.getX() + 1, cur.getY()));
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        }
        return m;
    }

    void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (int i = 0; i < 1000; i++) {
            float t = i / 1000.0f;
            plot(
                    g,
                    (int) (Math.pow(1 - t, 3) * x1
                            + 3 * t * Math.pow(1 - t, 2) * x2
                            + 3 * t * t * (1 - t) * x3
                            + Math.pow(t, 3) * x4),
                    (int) (Math.pow(1 - t, 3) * y1
                            + 3 * t * Math.pow(1 - t, 2) * y2
                            + 3 * t * t * (1 - t) * y3
                            + Math.pow(t, 3) * y4));
        }
    }

    void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            int temp = dx;
            dx = dy;
            dy = temp;
            isSwap = true;
        }
        int D = 2 * dy - dx;
        int x = x1;
        int y = y1;

        for (int i = 1; i < dx; i++) {
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

    void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    class NodeCoordinate {
        private int x;
        private int y;

        NodeCoordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}