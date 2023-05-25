package Visual;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateMovie {
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
    ArrayList<String> movies = new ArrayList<String>() {
        {
            add("Breaking Bad");
            add("Wednesday");
            add("Lucifer");
            add("The Crown");
            add("Money Heist");
            add("Stranger Things");
            add("Outerbanks");
            add("Prison Break");
            add("The 100");
            add("Elite");
            add("Black Mirror");
            add("Squid Game");
            add("The Flash");
            add("Kaleidoscope");
            add("Riverdale");
        }
    };
    ArrayList<String> movieimgs = new ArrayList<String>() {
        {
            add("Resources/BreakingBad.png");
            add("Resources/Wednesday.png");
            add("Resources/Lucifer.png");
            add("Resources/c.png");
            add("Resources/m.png");
            add("Resources/s.png");
            add("Resources/o.png");
            add("Resources/PrisonBreak.png");
            add("Resources/The100.png");
            add("Resources/e.png");
            add("Resources/BlackMirror.png");
            add("Resources/SquidGame.png");
            add("Resources/TheFlash.png");
            add("Resources/k.png");
            add("Resources/Riverdale.png");
        }
    };
    public String getMovie(int score){
        if(score>35000)
            return movieimgs.get(0);
        else
        {
            return movieimgs.get(15-score/2333);
        }
    }
    public String getMovietite(int score){
        if(score>35000)
            return movies.get(0);
        else
        {
            return movies.get(15-score/2333);
        }
    }
}
