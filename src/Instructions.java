import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Instructions extends JFrame{
    private JPanel instructions;
    private Color white = new Color(255,255,255);

    private JFrame frame = new JFrame("The Towers of Hanoi...");
    private JButton Back;

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

    public Instructions(){

        JLayeredPane pane = new JLayeredPane();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_instructionsPage.png");
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);

        String instructionText = new String("<HTML>" +
                "GOAL: shift ALL the rings to another peg of snowmen (in the same order)." +
                "<BR>" +
                "<BR>RULES:" +
                "<BR>   * Bigger rings cannot be placed on top of smaller rings" +
                "<BR>   * Only one ring can be moved at a time (a stack of rings can't be moved together)" +
                "<BR>   * Only the ring at the top of any stack can be moved (none from the middle/bottom)" +
                "<BR>" +
                "<BR>TIP: Try to do it in as few moves as possible! Good luck, player!" +
                "</HTML>");

        JLabel instructionsToShow = new JLabel(instructionText);
        instructionsToShow.setFont(theNormalFont(18));
        instructionsToShow.setFocusable(false);
        instructionsToShow.setBorder(BorderFactory.createEmptyBorder());
        instructionsToShow.setOpaque(false);
        instructionsToShow.setForeground(white);
        instructionsToShow.setBounds(320,300,760,400);
        pane.add(instructionsToShow);

        JLabel instructionsShadow = new JLabel(instructionText);
        instructionsShadow.setFont(theNormalFont(18));
        instructionsShadow.setFocusable(false);
        instructionsShadow.setBorder(BorderFactory.createEmptyBorder());
        instructionsShadow.setOpaque(false);
        instructionsShadow.setForeground(new Color(54, 68, 65));
        instructionsShadow.setBounds(322,301,760,400);
        pane.add(instructionsShadow);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                dispose();
                StartPage cool = new StartPage();
                cool.homePage();
            }
        });
        Back.setBounds(150,85,230,80);
        Back.setText("<   back!");
        formatButton(Back);
        pane.add(Back);

        background.setBounds(0,0,1152,648);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1152,678);
        frame.setVisible(true);

    }
}
