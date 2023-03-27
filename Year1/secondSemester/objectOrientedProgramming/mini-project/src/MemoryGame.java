package src;

import javax.swing.*;
import javax.swing.Timer;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class MemoryGame extends JFrame implements ActionListener,WindowListener {

    private JButton[] buttons;
    private ImageIcon[] images;
    private ImageIcon tmpImage;
    private Image originalImage;
    private Image scale;

    private int[] cardIndices;
    private int firstCardIndex;
    private int secondCardIndex;
    private JLabel scoreLabel;
    private JLabel timeLabel;
    private Timer timer;
    private Timer clock;
    private int timeLeft;
    private int score;
    public int matchedCount = 0;
    public ArrayList<JButton> pairSuc = new ArrayList<>();

    private AudioInputStream sound;
    private Clip clip;

    public MemoryGame() {
        setTitle("Memory Game");
        setSize(600, 600);
        setResizable(false);
        setDefaultCloseOperation(MemoryGame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(0x222222));
        addWindowListener(this);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0x222222));
        topPanel.setLayout(new GridLayout(1, 2));

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(new Color(0xffffff));
        scoreLabel.setFont(new Font("Helvetica", Font.BOLD, 20));

        timeLabel = new JLabel("Time left: 1:30");
        timeLabel.setForeground(new Color(0xffffff));
        timeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        topPanel.add(scoreLabel);
        topPanel.add(timeLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(6, 6));
        gamePanel.setBackground(new Color(0x444444));
        add(gamePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new Color(0x222222));

        JButton restartButton = new JButton("Restart");
        restartButton.setBackground(new Color(0x0077be));
        restartButton.setForeground(new Color(0xffffff));
        restartButton.setFont(new Font("Helvetica", Font.BOLD, 20));
        restartButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        bottomPanel.add(restartButton);
        add(bottomPanel, BorderLayout.SOUTH);

        buttons = new JButton[36];
        images = new ImageIcon[18];
        cardIndices = new int[36];
        firstCardIndex = -1;
        secondCardIndex = -1;
        score = 0;

        for (int i = 0; i < images.length; i++) {
            tmpImage = new ImageIcon("src/image" + i + ".jpg");
            originalImage = tmpImage.getImage();
            scale = originalImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            images[i] = new ImageIcon(scale);
        }

        for (int i = 0; i < cardIndices.length; i++) {
            cardIndices[i] = i % 18;
        }

        shuffle(cardIndices);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.WHITE);
            gamePanel.add(buttons[i]);
        }

        setVisible(true);

        timeLeft = 90;
        clock = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLeft--;
                int minutes = timeLeft / 60;
                int seconds = timeLeft % 60;
                timeLabel.setText("Time Left: " + String.format("%d:%02d", minutes, seconds));
                if (timeLeft == 0) {
                    clock.stop();
                    JOptionPane.showMessageDialog(MemoryGame.this, "Time's up! You lose.");
                }
            }
        });
        clock.start();

        try {
            sound = AudioSystem.getAudioInputStream(new File("src/srcForEasy/victorySound.wav"));
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception ex) {
            System.out.println("Error playing sound: " + ex.getMessage());
        }
    };

    public void actionPerformed(ActionEvent e) {
        ArrayList<JButton> tmp = new ArrayList<>();
        JButton buttonClicked = (JButton) e.getSource();

        int buttonIndex = -1;
        for (int i = 0; i < buttons.length; i++) {
            if (buttonClicked == buttons[i]) {
                buttonIndex = i;
                break;
            }
        }

        if (buttonIndex == -1) {
            System.out.println("Error: button not found.");
            return;
        }

        if (firstCardIndex == -1 && !(pairSuc.contains(buttonClicked))) {

            // First button clicked
            tmp.add(buttonClicked);
            firstCardIndex = buttonIndex;
            if (pairSuc.contains(buttonClicked)) {
                return;
            }
            buttons[firstCardIndex].setIcon(images[cardIndices[firstCardIndex]]);

        } else if (secondCardIndex == -1 && buttonIndex != firstCardIndex && pairSuc.containsAll(tmp)) {

            // Second button clicked
            secondCardIndex = buttonIndex;
            tmp.add(buttonClicked);
            buttons[secondCardIndex].setIcon(images[cardIndices[secondCardIndex]]);
            if (pairSuc.contains(buttonClicked)) {
                return;
            }

            timer = new Timer(300, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (cardIndices[firstCardIndex] == cardIndices[secondCardIndex]) {
                        buttons[firstCardIndex].setEnabled(false);
                        buttons[secondCardIndex].setEnabled(false);
                        matchedCount += 2;
                        pairSuc.add(buttons[firstCardIndex]);
                        pairSuc.add(buttons[secondCardIndex]);
                        buttons[firstCardIndex].setIcon(images[cardIndices[firstCardIndex]]);
                        buttons[secondCardIndex].setIcon(images[cardIndices[secondCardIndex]]);
                        score++;
                        scoreLabel.setText("Score: " + score);
                        tmp.clear();
                        if (matchedCount == 36) {
                            matchedCount = 0;
                            clip.setFramePosition(0);
                            clip.start();
                            clock.stop();
                            JOptionPane.showMessageDialog(null, "Success!");
                        }
                    } else {
                        buttons[firstCardIndex].setIcon(null);
                        buttons[secondCardIndex].setIcon(null);
                    }
                    firstCardIndex = -1;
                    secondCardIndex = -1;
                    // Reset state for next turn
                    for (JButton button : buttons) {
                        JButton a = button;
                        if (pairSuc.contains(a)) {
                            a.setEnabled(false);
                        } else {
                            button.setEnabled(true);
                        }
                    }
                }
            });
            timer.setRepeats(false);
            timer.start();
        }

    }

    private void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private void restartGame() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setIcon(null);
            buttons[i].setEnabled(true);
        }
        shuffle(cardIndices);
        timeLeft = 90;
        score = 0;
        scoreLabel.setText("Score: " + score);
        timeLabel.setText("Time left: 1:30");
        pairSuc.clear();
        clock.restart();
    }
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
        clock.stop();
        dispose();
    }

    public void windowOpened(WindowEvent e) {
        System.out.println("Window Open");
    }

    public void windowClosed(WindowEvent e) {
        System.out.println("Window Closed");
    }

    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated");
    }

    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated");
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("window Iconified");
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("Window Deiconified");
    }

}
