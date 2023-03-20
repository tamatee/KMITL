import javax.swing.*;
import java.awt.*;

public class CookieInterface extends JFrame {
    public CookieInterface() {
        // Set up the window
        setTitle("Cookie");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add the cookie image
        ImageIcon cookieIcon = new ImageIcon("cookie.jpg");
        JLabel cookieLabel = new JLabel(cookieIcon);
        cookieLabel.setPreferredSize(new Dimension(500, 500));
        add(cookieLabel, BorderLayout.CENTER);
        
        // Display the window
        pack();
        setLocationRelativeTo(null);   
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new CookieInterface();
    }
}
