package Visual;
import javax.swing.*;

public class NetflixApp extends JFrame{
    private static final long serialVersionUID = 1L;


    public NetflixApp() {
        JComponent MainContents = MainContent.createMainContent(this);
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