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
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class MainContent {
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
    public JComponent createMainContent( JFrame frame)
    {
        TestContent testContent = new TestContent();
        JComponent Main = new JPanel(new BorderLayout());
        // Set up main content area
        JPanel mainContent = new JPanel(new BorderLayout());

        // Set up top navigation bar
        JPanel topNavBar = new JPanel(new BorderLayout());
        topNavBar.setBackground(Color.BLACK);
        topNavBar.setPreferredSize(new Dimension(1200, 80));

        JLabel logo = new JLabel(new ImageIcon(getImageToScale("Resources/netflix_logo.png", 256, 144)));
        topNavBar.add(logo, BorderLayout.CENTER);
        JPanel navLinks = new JPanel(new FlowLayout());
        navLinks.setOpaque(false);

        // Create trending section
        JPanel trendingBox = new JPanel(new BorderLayout());
        //trendingBox.setPreferredSize(new Dimension(500, 500));
        trendingBox.setBackground(Color.BLACK);
        trendingBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        JLabel trendingLabel = new JLabel("CPU Benchmark");
        trendingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        trendingLabel.setForeground(Color.WHITE);
        trendingBox.add(trendingLabel, BorderLayout.NORTH);
        JPanel trendingMovies = new JPanel(new FlowLayout());
        trendingMovies.setBackground(Color.BLACK);
        JScrollPane trendingScroll = new JScrollPane(trendingMovies);
        trendingScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        trendingScroll.setBorder(BorderFactory.createEmptyBorder());
        JScrollBar horizontalScrollBar = trendingScroll.getHorizontalScrollBar();
        horizontalScrollBar.setUnitIncrement(80);
        horizontalScrollBar.setPreferredSize(new Dimension(0, horizontalScrollBar.getHeight()));
        trendingScroll.getViewport().setOpaque(false);
        trendingBox.add(trendingScroll, BorderLayout.CENTER);


        // Create sample movie/show images for trending section
        JLabel movie1 = new JLabel(new ImageIcon(getImageToScale("Resources/int.png", 300, 300)));
        movie1.setPreferredSize(new Dimension(300, 300));
        movie1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(1, frame);
                frame.setContentPane(start);
            }
        });
        JLabel movie2 = new JLabel(new ImageIcon(getImageToScale("Resources/float.png", 300, 300)));
        movie2.setPreferredSize(new Dimension(300, 300));
        movie2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(2, frame);
                frame.setContentPane(start);
            }
        });
        JLabel movie3 = new JLabel(new ImageIcon(getImageToScale("Resources/single_core.png", 300, 300)));
        movie3.setPreferredSize(new Dimension(300, 300));
        movie3.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(3, frame);
                frame.setContentPane(start);
            }
        });
        JLabel movie4 = new JLabel(new ImageIcon(getImageToScale("Resources/multi_core.png", 300, 300)));
        movie4.setPreferredSize(new Dimension(300, 300));
        movie4.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(4, frame);
                frame.setContentPane(start);
            }
        });
        JLabel movie5 = new JLabel(new ImageIcon(getImageToScale("Resources/cache.png", 300, 300)));
        movie5.setPreferredSize(new Dimension(300, 300));
        movie5.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(5, frame);
                frame.setContentPane(start);
            }
        });
        trendingMovies.add(movie1);
        trendingMovies.add(movie2);
        trendingMovies.add(movie3);
        trendingMovies.add(movie4);
        trendingMovies.add(movie5);

        // Create popular movies/shows section
        JPanel popularBox = new JPanel(new BorderLayout());
        popularBox.setBackground(Color.BLACK);
        popularBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel popularLabel = new JLabel("RAM Benchmark");
        popularLabel.setFont(new Font("Arial", Font.BOLD, 20));
        popularLabel.setForeground(Color.WHITE);
        popularBox.add(popularLabel, BorderLayout.NORTH);
        JPanel popularMovies = new JPanel(new FlowLayout());
        popularMovies.setBackground(Color.BLACK);
        popularBox.add(popularMovies, BorderLayout.CENTER);

        // Create sample movie/show images for popular section
        JLabel movie7 = new JLabel(new ImageIcon(getImageToScale("Resources/ram1.png", 300, 300)));
        movie7.setPreferredSize(new Dimension(300, 300));
        movie7.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(7, frame);
                frame.setContentPane(start);
            }
        });
        JLabel movie8 = new JLabel(new ImageIcon(getImageToScale("Resources/ram2.png", 300, 300)));
        movie8.setPreferredSize(new Dimension(300, 300));
        movie8.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(8, frame);
                frame.setContentPane(start);
            }
        });
        JLabel movie9 = new JLabel(new ImageIcon(getImageToScale("Resources/ram3.png", 300, 300)));
        movie9.setPreferredSize(new Dimension(300, 300));
        popularMovies.add(movie7);
        popularMovies.add(movie8);
        popularMovies.add(movie9);

        // Add trending and popular sections to main content area
        JPanel content = new JPanel(new GridLayout(2, 1));
        content.setBackground(Color.BLACK);
        content.add(trendingBox);
        content.add(popularBox);
        mainContent.add(content, BorderLayout.CENTER);

        // Add top navigation bar and main content area to frame
        Main.add(topNavBar, BorderLayout.NORTH);
        Main.add(mainContent, BorderLayout.CENTER);

        // Set up frame
        Main.setSize(1200, 800);
        return Main;
    }
}
