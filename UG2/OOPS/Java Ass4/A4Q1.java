import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class A4Q1 extends JFrame {
    private JPanel bulbsPanel;
    private JTextField inputField;
    private JButton startButton;
    private JLabel roundLabel;
    private int n;
    private boolean[] bulbs;
    private int round;

    public A4Q1() {
        setTitle("Bulb Toggle Simulation");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter number of bulbs (n < 10):"));
        inputField = new JTextField(3);
        topPanel.add(inputField);
        startButton = new JButton("Start");
        topPanel.add(startButton);
        add(topPanel, BorderLayout.NORTH);

        bulbsPanel = new JPanel();
        add(bulbsPanel, BorderLayout.CENTER);

        roundLabel = new JLabel(" ");
        roundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(roundLabel, BorderLayout.SOUTH);

        startButton.addActionListener(e -> startSimulation());

        setSize(500, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startSimulation() {
        try {
            n = Integer.parseInt(inputField.getText());
            if (n < 1 || n >= 10) {
                JOptionPane.showMessageDialog(this, "Please enter n between 1 and 9.");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
            return;
        }
        bulbs = new boolean[n];
        round = 0;
        for (int i = 0; i < n; i++) bulbs[i] = false;
        nextRound();
    }

    private void nextRound() {
        if (round == 0) {
            for (int i = 0; i < n; i++) bulbs[i] = true;
        } else {
            int step = round + 1;
            for (int i = step - 1; i < n; i += step) {
                bulbs[i] = !bulbs[i];
            }
        }
        updateBulbsPanel();
        roundLabel.setText("After round " + (round + 1));
        round++;
        if (round < n) {
            Timer timer = new Timer(1200, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    ((Timer) evt.getSource()).stop();
                    nextRound();
                }
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            roundLabel.setText("Final state after " + n + " rounds.");
        }
    }

    private void updateBulbsPanel() {
        bulbsPanel.removeAll();
        bulbsPanel.setLayout(new GridLayout(1, n, 10, 10));
        for (int i = 0; i < n; i++) {
            JPanel bulb = new JPanel();
            bulb.setPreferredSize(new Dimension(40, 40));
            bulb.setBackground(bulbs[i] ? Color.YELLOW : Color.GRAY);
            bulb.setBorder(BorderFactory.createTitledBorder("Bulb " + (i + 1)));
            bulbsPanel.add(bulb);
        }
        bulbsPanel.revalidate();
        bulbsPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(A4Q1::new);
    }
}