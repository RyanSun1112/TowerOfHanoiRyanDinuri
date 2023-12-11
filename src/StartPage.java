import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame {
    private JPanel Start;
    private JButton instructionsButton;
    private JButton playButton;
    public StartPage(){
        setContentPane(Start);
        setTitle("eTransfer");
        setSize(800,600);
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
    }
}
