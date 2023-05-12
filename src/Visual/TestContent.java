package Visual;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Tests.*;


import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class TestContent {
    JComponent MainPage;
    public static Image getImageToScale(String filename, int width, int height) {
        BufferedImage bimg=null;
        try{
            bimg = ImageIO.read(new File(filename));
        } catch (IOException e){
            e.printStackTrace();
        }
        return bimg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    public void getMainPage(JComponent MainPage)
    {
        this.MainPage = MainPage;
    }
    public static JComponent createStartContent(int option, JFrame frame) {
        // Create main frame with consistent color scheme
        JComponent panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.BLACK);
        JComponent back = (JComponent) frame.getContentPane();
        // Create top panel with logo and title
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBackground(Color.BLACK);
        JLabel title = null;
        JLabel photo = null;
        switch (option) {
            case 1 -> {
                title = new JLabel("Integer Operations Benchmark", SwingConstants.CENTER);
                photo = new JLabel(new ImageIcon(getImageToScale("Resources/int.png", 300, 300)));
            }
            case 2 -> {
                title = new JLabel("Floating Point Operations Benchmark", SwingConstants.CENTER);
                photo = new JLabel(new ImageIcon(getImageToScale("Resources/float.png", 300, 300)));
            }
            case 3 -> {
                title = new JLabel("Single Core Benchmark", SwingConstants.CENTER);
                photo = new JLabel(new ImageIcon(getImageToScale("Resources/single_core.png", 300, 300)));
            }
            case 4 -> {
                title = new JLabel("Multi Core Benchmark", SwingConstants.CENTER);
                photo = new JLabel(new ImageIcon(getImageToScale("Resources/multi_core.png", 300, 300)));
            }
            case 5 -> {
                title = new JLabel("Cache Memory Benchmark", SwingConstants.CENTER);
                photo = new JLabel(new ImageIcon(getImageToScale("Resources/cache.png", 300, 300)));
            }
            default -> {
            }
        }
        JLabel logo = new JLabel(new ImageIcon(getImageToScale("Resources/netflix_logo.png", 256, 144)), SwingConstants.LEFT);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        topPanel.add(logo);
        topPanel.add(title);
        topPanel.setBackground(Color.BLACK);

        // Create main panel with photo and button
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        mainPanel.setBackground(Color.WHITE);
        JLabel button = new JLabel(new ImageIcon(getImageToScale("Resources/button.png", 169, 69)));
        button.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                try {
                    switch (option) {
                        case 1 -> {
                            TestInt.main(null);
                        }
                        case 2 -> {
                            TestFloat.main(null);
                        }
                        case 3 -> {
                            TestSingleCore.main(null);
                        }
                        case 4 -> {
                            TestMultiCore.main(null);
                        }
                        case 5 -> {
                            TestCache.main(null);
                        }
                        default -> {
                        }
                    }
                } catch (Exception ee) {
                    ee.printStackTrace(); // good fall back if logging not implemented
                }
            }
        });
        photo.setHorizontalAlignment(SwingConstants.CENTER);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(photo);
        mainPanel.add(button);
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
        // Add panels to main frame and set size
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(mainPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        panel.setSize(1200, 800);
        return panel;
    }
}
