import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Options extends JFrame {

    //INSTANCE VARIABLES
    private JPanel options;
    public static File myObj;

    private JFrame frame = new JFrame("The Towers of Hanoi...");
    private JButton Level4x4;
    private JButton Level5x5;
    private JButton Level6x6;
    private JButton Back;
    private Color white = new Color(255,255,255);

    //FORMAT METHODS
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

    //OTHER METHODS
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
        Back.setBounds(148,85,228,80);
        formatButton(Back);
        Back.setText("<   back");
        pane.add(Back);

        Level4x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level4x4 cool = new Level4x4();
            }
        });
        Level4x4.setBounds(215,390,230,80);
        formatButton(Level4x4);
        pane.add(Level4x4);

        Level5x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level5x5 cool = new Level5x5();
            }
        });
        Level5x5.setBounds(465,390,230,80);
        formatButton(Level5x5);
        pane.add(Level5x5);

        Level6x6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Level6x6 cool = new Level6x6();
            }
        });
        Level6x6.setBounds(715,390,230,80);
        formatButton(Level6x6);
        pane.add(Level6x6);

        background.setBounds(0,0,1152,648);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1152,648);
        frame.setVisible(true);
    }
}
