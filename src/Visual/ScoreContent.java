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
    GenerateMovie generator = new GenerateMovie();
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
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        JLabel scoreLabel = new JLabel("Your Score: " + String.valueOf(score), SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        scoreLabel.setForeground(Color.WHITE);
        JLabel movietitle = new JLabel("The series matching your score is: " + '\n' + generator.getMovietite(score),SwingConstants.CENTER);
        movietitle.setFont(new Font("Arial", Font.BOLD, 30));
        movietitle.setForeground(Color.WHITE);
        JLabel movie = new JLabel(new ImageIcon(getImageToScale(generator.getMovie(score), 400, 200)), SwingConstants.CENTER);
        mainPanel.add(scoreLabel, BorderLayout.CENTER);
        mainPanel.add(movietitle, BorderLayout.CENTER);
        mainPanel.add(movie, BorderLayout.CENTER);
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
