import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartPage {
    //INSTANCE VARIABLES
    JFrame frame = new JFrame("This is the epic-est name of all time.");
    Color white = new Color(255,255,255);


    //FORMATTING METHODS
    private Font theNormalFont(int size) {

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try(InputStream stream = classloader.getResourceAsStream("CaviarDreams.ttf")) {
            Font font = Font.createFont(Font.TRUETYPE_FONT,stream);
        } catch (FontFormatException | IOException x) {
            //Logger.getLogger(FontLoader.class.getName()).log(Level.SEVERE,null,x);
        }

        URL url = classloader.getResource("CaviarDreams/CaviarDreams.ttf");
        File fontFile = new File(String.valueOf(url));
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
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(white);

    }


    //PAGE METHODS
    public void homePage() {
        JLayeredPane pane = new JLayeredPane();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_homePage.png");
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);

        JButton instructionsButton = new JButton("how to play");
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Instructions cool = new Instructions();
            }
        });

        formatButton(instructionsButton);
        instructionsButton.setBounds(315,565,376,80);
        pane.add(instructionsButton);
        JButton exit = new JButton("exit...");

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });

        formatButton(exit);
        exit.setBounds(615,565,376,80);
        pane.add(exit);
        JButton playButton = new JButton("Start!   >");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                Options cool = new Options();
            }
        });

        formatButton(playButton);
        playButton.setBounds(35,565,376,80);
        pane.add(playButton);

        background.setBounds(0,0,1344,756);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1344,756);
        frame.setVisible(true);
    }

}
