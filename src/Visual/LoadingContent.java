package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class LoadingContent {
    public static Image getImageToScale(String filename, int width, int height)
    {
        BufferedImage bimg=null;
        try{
            bimg = ImageIO.read(new File(filename));
        } catch (IOException e){
            e.printStackTrace();
        }
        return bimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    public JComponent createLoadingPage()
    {
        JComponent panel = new JPanel(new BorderLayout());
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel secondPanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Benching your marks...", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        ImageIcon gif = new ImageIcon("Resources/load.gif");
        //Image gifImage = gif.getImage();
        //Image resizedImage = gifImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        //ImageIcon resizedGif = new ImageIcon(resizedImage);
        JLabel gifLabel = new JLabel(gif);
        mainPanel.setBackground(Color.BLACK);
        secondPanel.setBackground(Color.BLACK);
        mainPanel.add(title, BorderLayout.NORTH);
        secondPanel.add(gifLabel, BorderLayout.CENTER);
        panel.setSize(1200, 800);
        panel.add(mainPanel, BorderLayout.NORTH);
        panel.add(secondPanel, BorderLayout.CENTER);
        return panel;
    }
}
