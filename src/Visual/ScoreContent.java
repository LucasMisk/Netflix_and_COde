package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
public class ScoreContent {
    public static Image getImageToScale(String filename, int width, int height) {
        BufferedImage bimg=null;
        try{
            bimg = ImageIO.read(new File(filename));
        } catch (IOException e){
            e.printStackTrace();
        }
        return bimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    public JComponent createScoreContent(int score, JComponent back, JFrame frame) {
        JComponent panel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        JLabel title = new JLabel("Your Score is:",SwingConstants.CENTER);
        JLabel scoreLabel = new JLabel(String.valueOf(score), SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        scoreLabel.setForeground(Color.WHITE);
        mainPanel.add(title, BorderLayout.CENTER);
        mainPanel.add(scoreLabel, BorderLayout.CENTER);
        mainPanel.setBackground(Color.BLACK);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel backButton = new JLabel(new ImageIcon(getImageToScale("Resources/back2.png", 100, 100)), SwingConstants.LEFT);
        backButton.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                frame.setContentPane(back);
            }
        });
        bottomPanel.add(backButton);
        bottomPanel.setBackground(Color.BLACK);
        panel.setSize(1200, 800);
        panel.add(mainPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        panel.setBackground(Color.BLACK);
        return panel;
    }
}
