import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Level5x5 extends JFrame{
    private JPanel Level5x5; //program doesn't run unless this line is present :0
    private JFrame frame = new JFrame("The Towers of Hanoi.");
    private JLabel Fourth;
    private JLabel First;
    private JLabel Second;
    private JLabel Third;
    private JLabel Fifth;
    private JButton Back;
    private JLabel Moves;
    private boolean drag1 = false;
    private boolean drag2 = false;
    private boolean drag3 = false;
    private boolean drag4 = false;
    private boolean drag5 = false;
    private Color white = new Color(255,255,255);

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

    private Font theNormalFont(int size)  {

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("CaviarDreams/CaviarDreams.ttf");
        File fontFile = null;
        try {
            fontFile = new File(url.toURI());
        } catch(Exception e) {
            System.out.println("Something");
        }

        Font caviarDreams = null;

        try {
            caviarDreams = Font.createFont(Font.TRUETYPE_FONT,fontFile).deriveFont(Font.BOLD,size);
            graphics.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));
            return caviarDreams;
        } catch (IOException | FontFormatException e) {
            System.out.println("ERROR! Code in 'e.printStackTrace()' to print stack trace: ");
        }

        return caviarDreams;
    }

    private void formatLabel(JLabel button) {
        button.setFont(theNormalFont(35));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setForeground(white);

    }
    private void formatButton(JButton button) {
        button.setFont(theNormalFont(35));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(white);

    }

    public JLabel makeImage(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(fileName);
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);
        return background;
    }

    public Level5x5(){

        JLayeredPane pane = new JLayeredPane();
        JLabel background = makeImage("towersOfHanoi_gamePage.png");
        First = makeImage("towersOfHanoi_HanoiRing1.png");
        Second = makeImage("towersOfHanoi_HanoiRing2.png");
        Third = makeImage("towersOfHanoi_HanoiRing3.png");
        Fourth = makeImage("towersOfHanoi_HanoiRing4.png");
        Fifth = makeImage("towersOfHanoi_HanoiRing5.png");

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
                drag5 = false;

            }
        });
        First.setBounds(120, 328, 207,64);
        pane.add(First);

        Second.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;
                drag2 = true;
                drag3 = false;
                drag4 = false;
                drag5 = false;



            }
        });
        Second.setBounds(110, 391, 227,64);
        pane.add(Second);

        Third.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag3 = true;
                drag2 = false;
                drag4 = false;
                drag5 = false;



            }
        });
        Third.setBounds(100, 455, 245,64);
        pane.add(Third);

        Fourth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag4 = true;
                drag2 = false;
                drag3 = false;
                drag5 = false;



            }
        });
        Fourth.setBounds(90, 518, 269,64);
        pane.add(Fourth);

        Fifth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drag1 = false;

                drag5 = true;
                drag2 = false;
                drag3 = false;
                drag4 = false;



            }
        });
        Fifth.setBounds(80, 580, 289,64);
        pane.add(Fifth);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Options cool = new Options();
            }
        });
        Back.setBounds(305, 65, 232,80);
        Back.setText("<   back!");
        formatButton(Back);
        pane.add(Back);
        Moves.setBounds(100,65, 232, 80);
        formatLabel(Moves);
        pane.add(Moves);
        background.setBounds(0,0,1152,648);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1152,678);
        frame.setVisible(true);
    }
}
