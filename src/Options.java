import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Options extends JFrame {
    private JPanel options;
    private JButton Level4x4;
    private JButton Level5x5;
    private JButton Level6x6;
    private JButton Back;

    public Options() {
        setContentPane(options);
        setTitle("eTransfer");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //uhihiiojpk
                dispose();
                testClassTheSecond cool = new testClassTheSecond();
                cool.homePage();
            }
        });
        Level4x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level4x4 cool = new Level4x4();
            }
        });
        Level5x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level5x5 cool = new Level5x5();
            }
        });
        Level6x6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level6x6 cool = new Level6x6();
            }
        });
    }
}
