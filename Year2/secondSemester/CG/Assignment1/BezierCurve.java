import java.awt.*;
import java.awt.Graphics;
import java.awt.geom.Path2D;

public class BezierCurve extends GraphicsSwing {

    private static final int NUM_POINTS = 1000;
    private double[][] controlPoints;


    public BezierCurve(double[][] controlPoints) {
        this.controlPoints = controlPoints;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Plot control points
        g2d.setColor(Color.RED);
        for (double[] point : controlPoints) {
            int x = (int) point[0];
            int y = (int) point[1];
            g2d.fillOval(x - 5, y - 5, 2, 2);
        }

        // Plot Bezier curve
        g2d.setColor(Color.BLUE);
        Path2D.Double path = new Path2D.Double();
        path.moveTo(controlPoints[0][0], controlPoints[0][1]);

        for (int i = 1; i < NUM_POINTS; i++) {
            double t = (double) i / (NUM_POINTS - 1);
            double[] position = calculatePosition(t, controlPoints);
            path.lineTo(position[0], position[1]);
        }

        g2d.draw(path);
    }

    private double[] calculatePosition(double t, double[][] controlPoints) {
        double[] position = new double[2];

        for (int i = 0; i < 4; i++) {
            position[0] += binomialCoefficient(3, i) * Math.pow(1 - t, 3 - i) * Math.pow(t, i) * controlPoints[i][0];
            position[1] += binomialCoefficient(3, i) * Math.pow(1 - t, 3 - i) * Math.pow(t, i) * controlPoints[i][1];
        }

        return position;
    }

    private int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }
}
