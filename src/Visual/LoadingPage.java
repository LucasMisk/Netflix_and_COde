package Visual;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;
public class LoadingPage {
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
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        JLabel title = new JLabel("Benching your marks...", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        URL url = this.getClass().getResource("jetbrains://idea/navigate/reference?project=Nextflix_and_COde&path=out/production/Nextflix_and_COde/load.gif");
        ImageIcon imageIcon = new ImageIcon(url);
        JLabel gif = new JLabel(imageIcon);
        //JLabel gif = new JLabel(new ImageIcon(getImageToScale("Resources/load.gif", 600, 300)), SwingConstants.CENTER);
        gif.setPreferredSize(new Dimension(600,300));
        mainPanel.setBackground(Color.BLACK);
        mainPanel.add(title);
        mainPanel.add(gif);
        panel.setSize(1200, 800);
        panel.add(mainPanel);
        return panel;
    }
}
