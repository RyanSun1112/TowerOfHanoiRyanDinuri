import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;


public class Level4x4 extends JFrame {
    private JPanel Level4x4;
    private JLabel First;
    private boolean drag = false;
    private int mouseX = 200;
    private int mouseY = 100;

    public Level4x4() {
        setContentPane(Level4x4);
        setTitle("eTransfer");
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        First.setBounds(mouseX, mouseY, 50, 50);

        First.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                JComponent jc = (JComponent)e.getSource();
                jc.setLocation(jc.getX()+e.getX(), jc.getY()+e.getY());
            }
        });

        First.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == First) {
                    drag = true;
                }
            }
        });
        First.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                drag = false;

            }
        });
    }
}
