import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class A4Q2 extends JFrame {
    private int[] heights = new int[100];
    private int n = 0;
    private int maxArea = 0;
    private int leftIndex = 0, rightIndex = 0;

    private JTextField nField = new JTextField(5);
    private JButton drawButton = new JButton("Draw");
    private JLabel areaLabel = new JLabel("Max Area: ");
    private JPanel drawPanel = new JPanel() {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (n == 0) return;
            int width = getWidth();
            int height = getHeight();
            int barWidth = width / (n + 2);
            int maxH = Arrays.stream(heights).limit(n).max().orElse(1);

            for (int i = 0; i < n; i++) {
                int barHeight = (int)((heights[i] / (double)maxH) * (height - 40));
                if (i == leftIndex || i == rightIndex) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLUE);
                }
                g.fillRect(20 + i * barWidth, height - barHeight - 20, barWidth - 5, barHeight);
                g.setColor(Color.BLACK);
                g.drawString(String.valueOf(heights[i]), 20 + i * barWidth, height - 5);
            }
        }
    };

    public A4Q2() {
        setTitle("Max Water Container");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 400);
        setLayout(new BorderLayout());
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        try (BufferedReader br = new BufferedReader(new FileReader("heights.txt"))) {
            String line;
            int idx = 0;
            while ((line = br.readLine()) != null && idx < 100) {
                heights[idx++] = Integer.parseInt(line.trim());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading heights.txt", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter n (number of lines, n < 100):"));
        topPanel.add(nField);
        topPanel.add(drawButton);
        topPanel.add(areaLabel);

        add(topPanel, BorderLayout.NORTH);
        add(drawPanel, BorderLayout.CENTER);

        drawButton.addActionListener(e -> {
            try {
                n = Integer.parseInt(nField.getText());
                if (n <= 1 || n > 100) throw new NumberFormatException();
                findMaxArea();
                areaLabel.setText("Max Area: " + maxArea);
                drawPanel.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid n (2 <= n <= 100)", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void findMaxArea() {
        maxArea = 0;
        leftIndex = 0;
        rightIndex = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            if (area > maxArea) {
                maxArea = area;
                leftIndex = l;
                rightIndex = r;
            }
            if (heights[l] < heights[r]) l++;
            else r--;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new A4Q2().setVisible(true));
    }
}