import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import src.MemoryGame;
import src.srcForEasy.easyMemoryGame;

public class GameMainMenu extends JFrame {
    private JButton startButton;
    private JButton exitButton;

    public GameMainMenu() {
        setTitle("Game Main Menu");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 50, 10));
        mainPanel.setBackground(new Color(0x222222));

        startButton = new JButton("Start Game (Easy mode)");
        startButton.setBackground(Color.white);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new easyMemoryGame();
            }
        });
        mainPanel.add(startButton);

        startButton = new JButton("Start Game (Hard mode)");
        startButton.setBackground(Color.white);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MemoryGame();
            }
        });
        mainPanel.add(startButton);

        exitButton = new JButton("Exit");
        exitButton.setBackground(Color.white);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mainPanel.add(exitButton);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GameMainMenu();
    }
}