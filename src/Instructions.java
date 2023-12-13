import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JFrame{
    private JPanel instructions;
    private JButton Back;

    public Instructions(){
        setContentPane(instructions);
        setTitle("eTransfer");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                testClassTheSecond cool = new testClassTheSecond();
                cool.homePage();
            }
        });
    }
}
