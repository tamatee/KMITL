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
        double[][] controlPoints = {{50, 150}, {150, 50}, {250, 250}, {350, 150}};
        BezierCurvePanel be = new BezierCurvePanel(controlPoints);
        be.paintComponent(g);
    }

}
