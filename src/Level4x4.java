import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.io.File;  // Import the File class
import java.util.Scanner;


public class Level4x4 extends JFrame {
    private JPanel Level4x4; //program doesn't run unless this line is present :0
    private JFrame frame = new JFrame("The Towers of Hanoi...");
    private JLabel First;
    private JLabel Fourth;
    private JLabel Second;
    private JLabel Third;
    private JButton Back;
    private JLabel Moves;
    private boolean drag1 = false;
    private boolean drag2 = false;

    private boolean drag3 = false;

    private boolean drag4 = false;

    private int mouseX = 200;
    private int mouseY = 100;
    public void check(){
        try{
            Scanner myReader = new Scanner(Options.myObj);
            String data = myReader.nextLine();
            int writing = Integer.parseInt(data);
            writing++;
            FileWriter myWriter = new FileWriter("filename.txt");
            Moves.setText("Moves: " + Integer.toString(writing));
            myWriter.write(Integer.toString(writing));
            myWriter.close();
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Level4x4() {
        JLayeredPane pane = new JLayeredPane();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_gamePage.png");
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(drag1 == true){

                    check();
                    First.setBounds(e.getX(), e.getY(), 50,50);
                    drag1 = false;
                }else if(drag2 == true){
                    Second.setBounds(e.getX(), e.getY(), 50,50);
                    drag2 = false;
                    check();

                }else if(drag3 == true){
                    Third.setBounds(e.getX(), e.getY(), 50,50);
                    drag3 = false;
                    check();

                } else if(drag4 == true){
                    Fourth.setBounds(e.getX(), e.getY(), 50,50);
                    drag4 = false;
                    check();

                }
            }
        });

        First.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = true;
                drag2 = false;
                drag3 = false;
                drag4 = false;
            }
        });
        First.setBounds(0, 0, 50,50);
        pane.add(First);

        Second.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;
                drag2 = true;
                drag3 = false;
                drag4 = false;
            }
        });
        Second.setBounds(50, 0, 50,50);
        pane.add(Second);

        Third.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag3 = true;
                drag2 = false;
                drag4 = false;
            }
        });
        Third.setBounds(100, 0, 50,50);
        pane.add(Third);

        Fourth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag4 = true;
                drag2 = false;
                drag3 = false;
            }
        });
        Fourth.setBounds(150, 0, 50,50);
        pane.add(Fourth);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Options cool = new Options();
            }
        });
        Back.setBounds(200, 0, 50,50);
        pane.add(Back);
        Moves.setBounds(100,100, 100, 10);
        pane.add(Moves);

        background.setBounds(0,0,1152,648);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1152,678);
        frame.setVisible(true);
    }
}
