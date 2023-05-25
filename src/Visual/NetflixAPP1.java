package Visual;
import javax.swing.*;

public class NetflixAPP1 extends JFrame{


    public NetflixAPP1() {
        MainContent mainContent = new MainContent();
        JComponent MainContents = mainContent.createMainContent(this);
        setTitle("Netflix and COde");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(MainContents);
        setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        NetflixAPP1 app = new NetflixAPP1();
    }
}