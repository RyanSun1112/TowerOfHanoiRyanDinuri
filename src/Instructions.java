import javax.swing.*;

public class Instructions extends JFrame{
    private JPanel instructions;
    public Instructions(){
        setContentPane(instructions);
        setTitle("eTransfer");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
