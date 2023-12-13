import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame {
    private JPanel options;
    private JFrame frame = new JFrame("The Towers of Hanoi...");
    private JButton Level4x4;
    private JButton Level5x5;
    private JButton Level6x6;
    private JButton Back;

    public Options() {

        JLayeredPane pane = new JLayeredPane();
        Icon backgroundIcon = new ImageIcon("C:\\Users\\Dinuri\\Downloads\\artPortfolio\\Digital\\towersOfHanoi_optionsPage.png");
        JLabel background = new JLabel(backgroundIcon);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //uhihiiojpk
                frame.setVisible(false);
                StartPage cool = new StartPage();
                cool.homePage();
            }
        });
        Back.setBounds(0,0,50,50);
        pane.add(Back);

        Level4x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level4x4 cool = new Level4x4();
            }
        });
        Level4x4.setBounds(50,0,50,50);
        pane.add(Level4x4);

        Level5x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level5x5 cool = new Level5x5();
            }
        });
        Level5x5.setBounds(100,0,50,50);
        pane.add(Level5x5);

        Level6x6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level6x6 cool = new Level6x6();
            }
        });
        Level6x6.setBounds(150,0,50,50);
        pane.add(Level6x6);

        background.setBounds(0,0,1344,756);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1344,776);
        frame.setVisible(true);
    }
}
