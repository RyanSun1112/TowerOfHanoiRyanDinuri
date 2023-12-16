import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Options extends JFrame {

    //INSTANCE VARIABLES
    private JPanel options;
    public static File myObj;
    public static File f1;
    public static File f2;
    public static File f3;
    private JFrame frame = new JFrame("The Towers of Hanoi...");
    private JButton Level4x4;
    private JButton Level5x5;
    private JButton Level6x6;
    private JButton Back;
    private Color white = new Color(255,255,255);

    //FORMATTING METHODS
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

    private void formatButton(JButton button) {
        button.setFont(theNormalFont(35));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setForeground(white);

    }

    private void formatLabel(JLabel button) {
        button.setFont(theNormalFont(30));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setForeground(white);

    }

    //HIGH SCORE METHODS
    public String updateHighScore4x4() throws FileNotFoundException {
        Options.f1 = new File("highScore4x4.txt");
        Scanner input = new Scanner(Options.f1);
        return input.nextLine();
    }

    public String updateHighScore5x5() throws FileNotFoundException {
        Options.f2 = new File("highScore5x5.txt");
        Scanner input = new Scanner(Options.f2);
        return input.nextLine();
    }

    public String updateHighScore6x6() throws FileNotFoundException {
        Options.f3 = new File("highScore6x6.txt");
        Scanner input = new Scanner(Options.f3);
        return input.nextLine();
    }

    //GAME CODE
    public Options() {
        myObj = new File("filename.txt"); // Specify the filename

        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("0");


            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        JLayeredPane pane = new JLayeredPane();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_optionsPage.png");
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //uhihiiojpk
                frame.setVisible(false);
                StartPage cool = new StartPage();
                cool.homePage();
            }
        });
        Back.setBounds(148, 85, 228, 80);
        formatButton(Back);
        Back.setText("<   back");
        pane.add(Back);

        Level4x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame.setVisible(false);
                Level4x4 cool = new Level4x4();
            }
        });
        Level4x4.setBounds(215, 390, 230, 80);
        formatButton(Level4x4);
        pane.add(Level4x4);

        Level5x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame.setVisible(false);
                Level5x5 cool = new Level5x5();
            }
        });
        Level5x5.setBounds(465, 390, 230, 80);
        formatButton(Level5x5);
        pane.add(Level5x5);

        Level6x6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                frame.setVisible(false);
                Level6x6 cool = new Level6x6();
            }
        });
        Level6x6.setBounds(715, 390, 230, 80);
        formatButton(Level6x6);
        pane.add(Level6x6);

        JLabel highest4x4 = new JLabel();
        JLabel highest5x5 = new JLabel();
        JLabel highest6x6 = new JLabel();
        try {
            highest4x4.setText("high score: " + updateHighScore4x4());
        } catch(Exception e) {
            System.out.println("\nERROR(S) GALORE! Something has gone terribly awry, it seems! (4x4)");
        } try {
            highest5x5.setText("high score: " + updateHighScore5x5());
        } catch(Exception e) {
            System.out.println("\nERROR(S) GALORE! Something has gone terribly awry, it seems! (5x5)");
        } try {
            highest6x6.setText("high score: " + updateHighScore6x6());
        } catch(Exception e) {
            System.out.println("\nERROR(S) GALORE! Something has gone terribly awry, it seems! (6x6)");
        }

        formatLabel(highest4x4);
        highest4x4.setBounds(215, 460, 230, 80);
        pane.add(highest4x4);
        formatLabel(highest5x5);
        highest5x5.setBounds(465, 460, 230, 80);
        pane.add(highest5x5);
        formatLabel(highest6x6);
        highest6x6.setBounds(715, 460, 230, 80);
        pane.add(highest6x6);

        background.setBounds(0,0,1152,648);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1152,678);
        frame.setVisible(true);
    }
}
