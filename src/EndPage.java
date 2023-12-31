import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


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

    private void formatLabel(JLabel button) {
        button.setFont(theNormalFont(35));
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setForeground(white);

    }

    //FILE METHODS
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

    public String currentScore() {

        String data = "";
        try{
            Scanner myReader = new Scanner(Options.myObj);
            data = myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return data;
    }

    //PAGE METHODS
    public void conquerorPage(String type, boolean highestAchieved) {

        String data = currentScore();
        JLayeredPane pane = new JLayeredPane();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_endPage.png");
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);

        JLabel conquered = new JLabel("You solved the puzzle in "+data+" steps!");
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

        if(highestAchieved) {
            try {
                String thisTimeAround = currentScore();
                int now = Integer.parseInt(thisTimeAround);
                switch (type) {
                    case "4x4":
                        String highFour = updateHighScore4x4();
                        int fourInt = Integer.parseInt(highFour);
                        if (now == fourInt) {
                            JLabel yay = new JLabel("H  I  G  H     S  C  O  R  E  !");
                            formatLabel(yay);
                            yay.setBounds(120, 100, 470, 80);
                            pane.add(yay);
                        }
                        break;
                    case "5x5":
                        String highFive = updateHighScore5x5();
                        int fiveInt = Integer.parseInt(highFive);
                        if (now == fiveInt) {
                            JLabel yay = new JLabel("H  I  G  H     S  C  O  R  E  !");
                            formatLabel(yay);
                            yay.setBounds(120, 100, 470, 80);
                            pane.add(yay);
                        }
                        break;
                    case "6x6":
                        String highSix = updateHighScore6x6();
                        int sixInt = Integer.parseInt(highSix);
                        if (now == sixInt) {
                            JLabel yay = new JLabel("H  I  G  H     S  C  O  R  E  !");
                            formatLabel(yay);
                            yay.setBounds(120, 100, 470, 80);
                            pane.add(yay);
                        }
                        break;
                    default:
                        System.out.println("Something went wrong!");
                }
            } catch (Exception e) {
                System.out.println("An error has presented itself!");
            }
        }

        background.setBounds(0,0,1152,648);
        pane.add(background,JLayeredPane.DEFAULT_LAYER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pane);
        frame.setSize(1152,678);
        frame.setVisible(true);
    }
}
