import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Instructions extends JFrame{
    private JPanel instructions;
    private JFrame frame = new JFrame("The Towers of Hanoi...");
    private JButton Back;

    public Instructions(){

        JLayeredPane pane = new JLayeredPane();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_instructionsPage.png");
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StartPage cool = new StartPage();
                cool.homePage();
            }
        });
        Back.setBounds(0,0,50,50);
        pane.add(Back);

        background.setBounds(0,0,1344,756);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1344,756);
        frame.setVisible(true);

    }
}
