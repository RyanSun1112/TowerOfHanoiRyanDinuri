import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Level6x6 extends JFrame{
    private JPanel Level6x6; //program doesn't run unless this line is present :0
    private JFrame frame = new JFrame("The Towers of Hanoi.");
    private JLabel First;
    private JLabel Second;
    private JLabel Third;
    private JLabel Fourth;
    private JLabel Fifth;
    private JLabel Sixth;
    private JButton Back;
    private JLabel Moves;
    private boolean drag1 = false;
    private boolean drag2 = false;

    private boolean drag3 = false;

    private boolean drag4 = false;
    private boolean drag5 = false;
    private boolean drag6 = false;
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

    public JLabel makeImage(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(fileName);
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);
        return background;
    }

    public Level6x6() {

        JLayeredPane pane = new JLayeredPane();
        JLabel background = makeImage("towersOfHanoi_gamePage.png");
        First = makeImage("towersOfHanoi_HanoiRing1.png");
        Second = makeImage("towersOfHanoi_HanoiRing2.png");
        Third = makeImage("towersOfHanoi_HanoiRing3.png");
        Fourth = makeImage("towersOfHanoi_HanoiRing4.png");
        Fifth = makeImage("towersOfHanoi_HanoiRing5.png");
        Sixth = makeImage("towersOfHanoi_HanoiRing6.png");

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(drag1 == true){
                    First.setBounds(e.getX(), e.getY(), 207,64);
                    drag1 = false;
                    check();
                }else if(drag2 == true){
                    Second.setBounds(e.getX(), e.getY(), 227,64);
                    drag2 = false;
                    check();

                }else if(drag3 == true){
                    Third.setBounds(e.getX(), e.getY(), 245,64);
                    drag3 = false;
                    check();

                } else if(drag4 == true){
                    Fourth.setBounds(e.getX(), e.getY(), 269,64);
                    drag4 = false;
                    check();

                } else if(drag5 == true){
                    Fifth.setBounds(e.getX(), e.getY(), 289,64);
                    drag5 = false;
                    check();

                }else if(drag6 == true){
                    Sixth.setBounds(e.getX(), e.getY(), 314,65);
                    drag6 = false;
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
                drag6 = false;
                drag5 = false;
                //fasfsf

            }
        });
        First.setBounds(120, 264, 207,64);
        pane.add(First);

        Second.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;
                drag2 = true;
                drag3 = false;
                drag4 = false;
                drag5 = false;
                drag6 = false;



            }
        });
        Second.setBounds(110, 328, 227,64);
        pane.add(Second);

        Third.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag3 = true;
                drag2 = false;
                drag4 = false;
                drag5 = false;
                drag6 = false;



            }
        });
        Third.setBounds(100, 391, 245,64);
        pane.add(Third);

        Fourth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag4 = true;
                drag2 = false;
                drag3 = false;
                drag5 = false;
                drag6 = false;



            }
        });
        Fourth.setBounds(90, 455, 269,64);
        pane.add(Fourth);

        Fifth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag5 = true;
                drag2 = false;
                drag3 = false;
                drag4 = false;
                drag6 = false;



            }
        });
        Fifth.setBounds(80, 518, 289,64);
        pane.add(Fifth);

        Sixth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag5 = false;
                drag2 = false;
                drag3 = false;
                drag4 = false;
                drag6 = true;
            }
        });
        Sixth.setBounds(70, 579, 314,65);
        pane.add(Sixth);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Options cool = new Options();
            }
        });
        Back.setBounds(300, 0, 50,50);
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
