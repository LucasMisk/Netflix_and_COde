package Visual;
import javax.swing.*;

public class NetflixApp extends JFrame{


    public NetflixApp() {
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
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NetflixApp();
    }
}