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
        trendingLabel.setForeground(Color.decode("#E50914"));
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
        JLabel movie1Text = new JLabel("Integer Operations Benchmark");
        movie1Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie1Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie1Text.setForeground(Color.WHITE);
        movie1Text.setBackground(Color.BLACK);
        JPanel movie1Panel = new JPanel(new BorderLayout());
        movie1Panel.setBackground(Color.BLACK);
        movie1Panel.add(movie1Text, BorderLayout.NORTH);
        movie1Panel.add(movie1, BorderLayout.CENTER);

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
        JLabel movie2Text = new JLabel("Floating Point Benchmark");
        movie2Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie2Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie2Text.setForeground(Color.WHITE);
        movie2Text.setBackground(Color.BLACK);
        JPanel movie2Panel = new JPanel(new BorderLayout());
        movie2Panel.setBackground(Color.BLACK);
        movie2Panel.add(movie2Text, BorderLayout.NORTH);
        movie2Panel.add(movie2, BorderLayout.CENTER);

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
        JLabel movie3Text = new JLabel("Single Core Benchmark");
        movie3Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie3Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie3Text.setForeground(Color.WHITE);
        movie3Text.setBackground(Color.BLACK);
        JPanel movie3Panel = new JPanel(new BorderLayout());
        movie3Panel.setBackground(Color.BLACK);
        movie3Panel.add(movie3Text, BorderLayout.NORTH);
        movie3Panel.add(movie3, BorderLayout.CENTER);

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
        JLabel movie4Text = new JLabel("Multi-Core Benchmark");
        movie4Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie4Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie4Text.setForeground(Color.WHITE);
        movie4Text.setBackground(Color.BLACK);
        JPanel movie4Panel = new JPanel(new BorderLayout());
        movie4Panel.setBackground(Color.BLACK);
        movie4Panel.add(movie4Text, BorderLayout.NORTH);
        movie4Panel.add(movie4, BorderLayout.CENTER);

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
        JLabel movie5Text = new JLabel("Cache Benchmark");
        movie5Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie5Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie5Text.setForeground(Color.WHITE);
        movie5Text.setBackground(Color.BLACK);
        JPanel movie5Panel = new JPanel(new BorderLayout());
        movie5Panel.setBackground(Color.BLACK);
        movie5Panel.add(movie5Text, BorderLayout.NORTH);
        movie5Panel.add(movie5, BorderLayout.CENTER);

        JLabel movie6 = new JLabel(new ImageIcon(getImageToScale("Resources/full_cpu.png", 300, 300)));
        movie6.setPreferredSize(new Dimension(300, 300));
        movie6.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(6, frame);
                frame.setContentPane(start);
            }
        });
        JLabel movie6Text = new JLabel("Full CPU Benchmark");
        movie6Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie6Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie6Text.setForeground(Color.WHITE);
        movie6Text.setBackground(Color.BLACK);
        JPanel movie6Panel = new JPanel(new BorderLayout());
        movie6Panel.setBackground(Color.BLACK);
        movie6Panel.add(movie6Text, BorderLayout.NORTH);
        movie6Panel.add(movie6, BorderLayout.CENTER);

        trendingMovies.add(movie1Panel);
        trendingMovies.add(movie2Panel);
        trendingMovies.add(movie3Panel);
        trendingMovies.add(movie4Panel);
        trendingMovies.add(movie5Panel);
        trendingMovies.add(movie6Panel);

        // Create popular movies/shows section
        JPanel popularBox = new JPanel(new BorderLayout());
        popularBox.setBackground(Color.BLACK);
        popularBox.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel popularLabel = new JLabel("RAM Benchmark");
        popularLabel.setFont(new Font("Arial", Font.BOLD, 20));
        popularLabel.setForeground(Color.decode("#E50914"));
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
        JLabel movie7Text = new JLabel("RAM Memory Bandwidth Benchmark");
        movie7Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie7Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie7Text.setForeground(Color.WHITE);
        movie7Text.setBackground(Color.BLACK);
        JPanel movie7Panel = new JPanel(new BorderLayout());
        movie7Panel.setBackground(Color.BLACK);
        movie7Panel.add(movie7Text, BorderLayout.NORTH);
        movie7Panel.add(movie7, BorderLayout.CENTER);
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
        JLabel movie8Text = new JLabel("RAM Random Access Benchmark");
        movie8Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie8Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie8Text.setForeground(Color.WHITE);
        movie8Text.setBackground(Color.BLACK);
        JPanel movie8Panel = new JPanel(new BorderLayout());
        movie8Panel.setBackground(Color.BLACK);
        movie8Panel.add(movie8Text, BorderLayout.NORTH);
        movie8Panel.add(movie8, BorderLayout.CENTER);
        JLabel movie9 = new JLabel(new ImageIcon(getImageToScale("Resources/ram3.png", 300, 300)));
        movie9.setPreferredSize(new Dimension(300, 300));
        movie9.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                JComponent start = testContent.createStartContent(9, frame);
                frame.setContentPane(start);
            }
        });
        JLabel movie9Text = new JLabel("Full RAM Benchmark");
        movie9Text.setFont(new Font("Arial", Font.PLAIN, 18));
        movie9Text.setHorizontalAlignment(SwingConstants.CENTER);
        movie9Text.setForeground(Color.WHITE);
        movie9Text.setBackground(Color.BLACK);
        JPanel movie9Panel = new JPanel(new BorderLayout());
        movie9Panel.setBackground(Color.BLACK);
        movie9Panel.add(movie9Text, BorderLayout.NORTH);
        movie9Panel.add(movie9, BorderLayout.CENTER);
        popularMovies.add(movie7Panel);
        popularMovies.add(movie8Panel);
        popularMovies.add(movie9Panel);

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
