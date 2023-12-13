import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JFrame{
    private JPanel instructions;
    private JFrame frame = new JFrame("The Towers of Hanoi...");
    private JButton Back;

    public Instructions(){

        JLayeredPane pane = new JLayeredPane();
        Icon backgroundIcon = new ImageIcon("C:\\Users\\Dinuri\\Downloads\\artPortfolio\\Digital\\towersOfHanoi_instructionsPage.png");
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
