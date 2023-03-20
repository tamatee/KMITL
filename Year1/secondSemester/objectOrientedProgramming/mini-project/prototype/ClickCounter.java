import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCounter extends JFrame {
    private int count = 0;
    private JLabel countLabel;

    public ClickCounter() {
        // Set up the window
        setTitle("Click Counter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add the count label
        countLabel = new JLabel("Clicks: 0");
        countLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(countLabel, BorderLayout.CENTER);
        
        // Add the button
        JButton button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                countLabel.setText("Clicks: " + count);
            }
        });
        add(button, BorderLayout.SOUTH);
        
        // Display the window
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new ClickCounter();
    }
}
