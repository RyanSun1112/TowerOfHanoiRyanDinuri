import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class EndPage {
    //INSTANCE VARIABLES
    JFrame frame = new JFrame("This is the epic-est name of all time.");
    Color white = new Color(255,255,255);


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
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setForeground(white);

    }


    //PAGE METHODS
    public void conquerorPage() {
        int numOfSteps = 0; //save temp score to this variable
        JLayeredPane pane = new JLayeredPane();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_endPage.png");
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);

        //JLabel conquered = new JLabel("You solved the puzzle in " + numOfSteps + " steps!");
        JLabel conquered = new JLabel("You solved the puzzle in ## steps!");
        conquered.setFont(theNormalFont(35));
        conquered.setFocusable(false);
        conquered.setBorder(BorderFactory.createEmptyBorder());
        conquered.setOpaque(false);
        conquered.setForeground(white);

        conquered.setBounds(0,SwingConstants.CENTER+85,1152,678);
        conquered.setHorizontalAlignment(SwingConstants.CENTER);
        pane.add(conquered);

        JButton goAgain = new JButton("go again!");
        goAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                StartPage merryChristmas = new StartPage();
                merryChristmas.homePage();
            }
        });
        formatButton(goAgain);
        goAgain.setBounds(461,480,232,80);
        pane.add(goAgain);

        background.setBounds(0,0,1152,648);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1152,678);
        frame.setVisible(true);
    }

}
