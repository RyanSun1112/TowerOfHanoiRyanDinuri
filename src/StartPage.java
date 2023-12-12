import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame {
    private JPanel Start;
    private JButton instructionsButton;
    private JButton playButton;
    private JButton exit;

    public StartPage(){
        //Icon backgroundIcon = new ImageIcon("C:\\Users\\Dinuri\\Downloads\\artPortfolio\\Digital\\towersOfHanoi_homePage.png");
        //JLabel background = new JLabel(backgroundIcon);

        setContentPane(Start);
        setTitle("eTransfer");
        setSize(1344,756);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Instructions cool = new Instructions();
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Options cool = new Options();
            }
        });


        //background.setBounds(0,0,1344,756);
        //Start.add(background,JLayeredPane.DEFAULT_LAYER);
    }
}
