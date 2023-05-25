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
        //JLabel logo = new JLabel(new ImageIcon(getImageToScale("Resources/netflix_logo.png", 256, 144)), SwingConstants.LEFT);
        //logo.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 40));
        //panel.add(logo, BorderLayout.PAGE_START);
        JLabel scoreLabel = new JLabel("<html>Watched for: <font color='#98f5eb'>" + String.valueOf(score) +"</font color>" + " hours" + "</html>", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        scoreLabel.setForeground(Color.decode("#f06007"));
        //JLabel movietitle = new JLabel("The series matching your score is: " + '\n' + generator.getMovietite(score),SwingConstants.CENTER);
        //JLabel movietitle = new JLabel("<html>The series matching your score is:<br/>" + generator.getMovietite(score) + "</html>", SwingConstants.CENTER);
        //JLabel movietitle = new JLabel("<html>The series matching your score is:<br/><center>" + generator.getMovietite(score) + "</center></html>", SwingConstants.CENTER);
        JLabel movietitle = new JLabel("<html>The series matching your score is:<br/><center><font color='#98f5eb'>" + generator.getMovietite(score) + "</font></center></html>", SwingConstants.CENTER);
        movietitle.setFont(new Font("Monospaced", Font.BOLD, 30));
        movietitle.setForeground(Color.decode("#f06007"));
        //JLabel movie = new JLabel(new ImageIcon(getImageToScale(generator.getMovie(score), 400, 400)), SwingConstants.CENTER);
        JLabel movie = new JLabel(new ImageIcon(getImageToScale(generator.getMovie(score), 410, 290)), SwingConstants.CENTER);
        mainPanel.add(scoreLabel, BorderLayout.CENTER);
        mainPanel.add(movietitle, BorderLayout.CENTER);
        mainPanel.add(movie, BorderLayout.CENTER);
        mainPanel.setBackground(Color.BLACK);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel backButton = new JLabel(new ImageIcon(getImageToScale("Resources/back2.png", 80, 80)), SwingConstants.LEFT);
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
