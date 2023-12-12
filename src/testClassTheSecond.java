import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class testClassTheSecond {
    JFrame frame = new JFrame("This is the epic-est name of all time.");

    public void someMethod() {
        JLayeredPane pane = new JLayeredPane();
        Icon backgroundIcon = new ImageIcon("C:\\Users\\Dinuri\\Downloads\\artPortfolio\\Digital\\towersOfHanoi_homePage.png");
        JLabel background = new JLabel(backgroundIcon);

        JButton instructionsButton = new JButton();
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Instructions cool = new Instructions();
            }
        });

        JButton exit = new JButton();
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });

        JButton playButton = new JButton("Start!   >");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Options cool = new Options();
            }
        });

        playButton.setBounds(885,475,376,80);
        playButton.setBackground(new Color(255,255,255));
        pane.add(playButton);

        background.setBounds(0,0,1344,756);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1344,756);
        frame.setVisible(true);
    }

}
