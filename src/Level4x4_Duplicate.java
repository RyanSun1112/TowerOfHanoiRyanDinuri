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
import java.util.Stack;


public class Level4x4_Duplicate extends JFrame {
    private Color white = new Color(255,255,255);

    private JPanel Level4x4; //program doesn't run unless this line is present :0
    private JFrame frame = new JFrame("The Towers of Hanoi...");
    private JLabel First;
    private JLabel Fourth;
    private JLabel Second;
    private JLabel Third;
    private JLabel Moves = new JLabel("moves: ");
    private boolean drag1 = false;
    private boolean drag2 = false;

    private boolean drag3 = false;

    private boolean drag4 = false;

    private int mouseX = 200;
    private int mouseY = 100;
    private boolean first = true;
    private Stack<JLabel> stack1 = new Stack();
    private Stack<JLabel> stack2 = new Stack();
    private Stack<JLabel> stack3 = new Stack();

    public JLabel makeImage(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(fileName);
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);
        return background;
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

    public void check(){
        try{
            Scanner myReader = new Scanner(Options.myObj);
            String data = myReader.nextLine();
            int writing = Integer.parseInt(data);
            writing++;
            FileWriter myWriter = new FileWriter("filename.txt");
            Moves.setText("moves: " + Integer.toString(writing));
            myWriter.write(Integer.toString(writing));
            myWriter.close();
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
            ex.printStackTrace();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try{
            if (stack3.elementAt(0).getText().equals("fourth") && stack3.elementAt(1).getText().equals("third") && stack3.elementAt(2).getText().equals(" second")&& stack3.elementAt(3).getText().equals("first")) {
                frame.setVisible(false);
                dispose();
                EndPage end = new EndPage();
                end.conquerorPage();
            }
        }catch(Exception ex){
            System.out.print("");
        }

    }
    public Level4x4_Duplicate() {

        JLayeredPane pane = new JLayeredPane();
        JLabel background = makeImage("towersOfHanoi_gamePage.png");
        First = makeImage("towersOfHanoi_HanoiRing1.png");
        Second = makeImage("towersOfHanoi_HanoiRing2.png");
        Third = makeImage("towersOfHanoi_HanoiRing3.png");
        Fourth = makeImage("towersOfHanoi_HanoiRing4.png");

        if(first == true){
            stack1.push(Fourth);
            stack1.push(Third);
            stack1.push(Second);
            stack1.push(First);
            first = false;
        }

        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(drag1 == true){
                    System.out.println("1 aa"+ stack1.search(First));
                    System.out.println("1 dd" + stack2.search(First));
                    System.out.println("1 cc"+ stack3.search(First));
                    System.out.println(stack1);
                    System.out.println(stack2);

                    if(stack1.search(First) >= 0){

                        System.out.print(e.getX());
                        if(e.getX()< 700 && e.getX()> 500){

                            stack1.pop();

                            stack2.push(First);
                            if(stack2.size() - stack2.search(First) == 3)
                                First.setBounds(530, 200, 207,64);
                            if(stack2.size() - stack2.search(First) == 2)
                                First.setBounds(530, 250, 207,64);
                            if(stack2.size() - stack2.search(First) == 1)
                                First.setBounds(530, 300, 207,64);
                            if(stack2.size() - stack2.search(First) == 0)
                                First.setBounds(530, 350, 207,64);
                            check();
                        }
                        else if( e.getX()< 1050 && e.getX()> 850){
                            stack1.pop();
                            stack3.push(First);
                            if(stack3.size() - stack3.search(First) == 3)
                                First.setBounds(875, 200, 207,64);
                            if(stack3.size() - stack3.search(First) == 2)
                                First.setBounds(875, 250, 207,64);
                            if(stack3.size() - stack3.search(First) == 1)
                                First.setBounds(875, 300, 207,64);
                            if(stack3.size() - stack3.search(First) == 0)
                                First.setBounds(875, 350, 207,64);
                            check();
                        }

                    }else if(stack2.search(First) >= 0){

                        System.out.print(e.getX());
                        if( e.getX()< 300 && e.getX()> 150){
                            stack2.pop();

                            stack1.push(First);
                            if(stack1.size() - stack1.search(First) == 3)
                                First.setBounds(200, 200, 207,64);
                            if(stack1.size() - stack1.search(First) == 2)
                                First.setBounds(200, 250, 207,64);
                            if(stack1.size() - stack1.search(First) == 1)
                                First.setBounds(200, 300, 207,64);
                            if(stack1.size() - stack1.search(First) == 0)
                                First.setBounds(200, 350, 207,64);
                            check();
                        }
                        else if( e.getX()< 1050 && e.getX()> 850){
                            stack2.pop();
                            stack3.push(First);
                            if(stack3.size() - stack3.search(First) == 3)
                                First.setBounds(875, 200, 207,64);
                            if(stack3.size() - stack3.search(First) == 2)
                                First.setBounds(875, 250, 207,64);
                            if(stack3.size() - stack3.search(First) == 1)
                                First.setBounds(875, 300, 207,64);
                            if(stack3.size() - stack3.search(First) == 0)
                                First.setBounds(875, 350, 207,64);
                            check();
                        }

                    }
                    else if(stack3.search(First) >= 0){

                        System.out.print(e.getX());
                        if( e.getX()< 300 && e.getX()> 150){
                            stack3.pop();

                            stack1.push(First);
                            if(stack1.size() - stack1.search(First) == 3)
                                First.setBounds(200, 200, 207,64);
                            if(stack1.size() - stack1.search(First) == 2)
                                First.setBounds(200, 250, 207,64);
                            if(stack1.size() - stack1.search(First) == 1)
                                First.setBounds(200, 300, 207,64);
                            if(stack1.size() - stack1.search(First) == 0)
                                First.setBounds(200, 350, 207,64);
                            check();
                        }
                        else if(e.getX()< 700 && e.getX()> 500){
                            stack3.pop();
                            stack2.push(First);
                            if(stack2.size() - stack2.search(First) == 3)
                                First.setBounds(530, 200, 207,64);
                            if(stack2.size() - stack2.search(First) == 2)
                                First.setBounds(530, 250, 207,64);
                            if(stack2.size() - stack2.search(First) == 1)
                                First.setBounds(530, 300, 207,64);
                            if(stack2.size() - stack2.search(First) == 0)
                                First.setBounds(530, 350, 207,64);
                            check();
                        }

                    }
                    drag1 = false;
                }else if(drag2 == true){
                    if(stack1.search(Second) == 1){


                        if(e.getX()< 700 && e.getX()> 500){
                            try{

                                if(stack2.firstElement()  == First){
                                    System.out.print("");
                                }else{
                                    stack1.pop();
                                    stack2.push(Second);
                                    if(stack2.size() - stack2.search(Second) == 3)
                                        Second.setBounds(530, 200, 227,64);
                                    if(stack2.size() - stack2.search(Second) == 2)
                                        Second.setBounds(530, 250, 227,64);
                                    if(stack2.size() - stack2.search(Second) == 1)
                                        Second.setBounds(530, 300, 227,64);
                                    if(stack2.size() - stack2.search(Second) == 0)
                                        Second.setBounds(530, 350, 227,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack2.push(Second);
                                if(stack2.size() - stack2.search(Second) == 3)
                                    Second.setBounds(530, 200, 227,64);
                                if(stack2.size() - stack2.search(Second) == 2)
                                    Second.setBounds(530, 250, 227,64);
                                if(stack2.size() - stack2.search(Second) == 1)
                                    Second.setBounds(530, 300, 227,64);
                                if(stack2.size() - stack2.search(Second) == 0)
                                    Second.setBounds(530, 350, 227,64);
                                check();

                            }

                        }
                        else if( e.getX()< 1050 && e.getX()> 850) {
                            try{
                            if (stack3.firstElement()  == First) {
                                System.out.print("");
                            } else {
                                stack1.pop();
                                stack3.push(Second);
                                if (stack3.size() - stack3.search(Second) == 3)
                                    Second.setBounds(875, 200, 227,64);
                                if (stack3.size() - stack3.search(Second) == 2)
                                    Second.setBounds(875, 250, 227,64);
                                if (stack3.size() - stack3.search(Second) == 1)
                                    Second.setBounds(875, 300, 227,64);
                                if (stack3.size() - stack3.search(Second) == 0)
                                    Second.setBounds(875, 350, 227,64);
                                check();
                            }
                            }catch(Exception ex){
                                stack1.pop();
                                stack3.push(Second);
                                if (stack3.size() - stack3.search(Second) == 3)
                                    Second.setBounds(875, 200, 227,64);
                                if (stack3.size() - stack3.search(Second) == 2)
                                    Second.setBounds(875, 250, 227,64);
                                if (stack3.size() - stack3.search(Second) == 1)
                                    Second.setBounds(875, 300, 227,64);
                                if (stack3.size() - stack3.search(Second) == 0)
                                    Second.setBounds(875, 350, 227,64);
                                check();

                            }
                        }

                        drag2 = false;
                    }else if(stack2.search(Second) == 1){



                        if( e.getX()< 1050 && e.getX()> 850){
                            try{
                            if (stack3.firstElement()  == First) {
                                System.out.print("");
                            } else {
                                stack2.pop();
                                stack3.push(Second);
                                if (stack3.size() - stack3.search(Second) == 3)
                                    Second.setBounds(875, 200, 227,64);
                                if (stack3.size() - stack3.search(Second) == 2)
                                    Second.setBounds(875, 250, 227,64);
                                if (stack3.size() - stack3.search(Second) == 1)
                                    Second.setBounds(875, 300, 227,64);
                                if (stack3.size() - stack3.search(Second) == 0)
                                    Second.setBounds(875, 350, 227,64);
                                check();
                            }
                            }catch(Exception ex) {
                                stack2.pop();
                                stack3.push(Second);
                                if (stack3.size() - stack3.search(Second) == 3)
                                    Second.setBounds(875, 200, 227,64);
                                if (stack3.size() - stack3.search(Second) == 2)
                                    Second.setBounds(875, 250, 227,64);
                                if (stack3.size() - stack3.search(Second) == 1)
                                    Second.setBounds(875, 300, 227,64);
                                if (stack3.size() - stack3.search(Second) == 0)
                                    Second.setBounds(875, 350, 227,64);
                                check();

                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                            if (stack1.firstElement()  == First) {
                                System.out.print("");
                            } else {
                                stack2.pop();
                                stack1.push(Second);
                                if (stack1.size() - stack1.search(Second) == 3)
                                    Second.setBounds(200, 200, 227,64);
                                if (stack1.size() - stack1.search(Second) == 2)
                                    Second.setBounds(200, 250, 227,64);
                                if (stack1.size() - stack1.search(Second) == 1)
                                    Second.setBounds(200, 300, 227,64);
                                if (stack1.size() - stack1.search(Second) == 0)
                                    Second.setBounds(200, 350, 227,64);
                                check();
                            }
                            }catch(Exception ex){
                                stack2.pop();
                                stack1.push(Second);
                                if (stack1.size() - stack1.search(Second) == 3)
                                    Second.setBounds(200, 200, 227,64);
                                if (stack1.size() - stack1.search(Second) == 2)
                                    Second.setBounds(200, 250, 227,64);
                                if (stack1.size() - stack1.search(Second) == 1)
                                    Second.setBounds(200, 300, 227,64);
                                if (stack1.size() - stack1.search(Second) == 0)
                                    Second.setBounds(200, 350, 227,64);
                                check();

                            }
                        }
                        drag2 = false;

                    }
                    else if(stack3.search(Second) == 1){


                        if(e.getX()< 700 && e.getX()> 500){
                            try{


                            if(stack2.firstElement()  == First){
                                System.out.print("");
                            }else{
                                stack3.pop();
                                stack2.push(Second);
                                if(stack2.size() - stack2.search(Second) == 3)
                                    Second.setBounds(530, 200, 227,64);
                                if(stack2.size() - stack2.search(Second) == 2)
                                    Second.setBounds(530, 250, 227,64);
                                if(stack2.size() - stack2.search(Second) == 1)
                                    Second.setBounds(530, 300, 227,64);
                                if(stack2.size() - stack2.search(Second) == 0)
                                    Second.setBounds(530, 350, 227,64);
                                check();
                            }
                            }catch(Exception ex){
                                stack3.pop();
                                stack2.push(Second);
                                if(stack2.size() - stack2.search(Second) == 3)
                                    Second.setBounds(530, 200, 227,64);
                                if(stack2.size() - stack2.search(Second) == 2)
                                    Second.setBounds(530, 250, 227,64);
                                if(stack2.size() - stack2.search(Second) == 1)
                                    Second.setBounds(530, 300, 227,64);
                                if(stack2.size() - stack2.search(Second) == 0)
                                    Second.setBounds(530, 350, 227,64);
                                check();

                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                            if (stack1.firstElement()  == First) {
                                System.out.print("");
                            } else {
                                stack3.pop();
                                stack1.push(Second);
                                if (stack1.size() - stack1.search(Second) == 3)
                                    Second.setBounds(200, 200, 227,64);
                                if (stack1.size() - stack1.search(Second) == 2)
                                    Second.setBounds(200, 250, 227,64);
                                if (stack1.size() - stack1.search(Second) == 1)
                                    Second.setBounds(200, 300, 227,64);
                                if (stack1.size() - stack1.search(Second) == 0)
                                    Second.setBounds(200, 350, 227,64);
                                check();
                            }
                            }catch(Exception ex){
                                stack3.pop();
                                stack1.push(Second);
                                if (stack1.size() - stack1.search(Second) == 3)
                                    Second.setBounds(200, 200, 227,64);
                                if (stack1.size() - stack1.search(Second) == 2)
                                    Second.setBounds(200, 250, 227,64);
                                if (stack1.size() - stack1.search(Second) == 1)
                                    Second.setBounds(200, 300, 227,64);
                                if (stack1.size() - stack1.search(Second) == 0)
                                    Second.setBounds(200, 350, 227,64);
                                check();

                            }
                        }
                        drag2 = false;

                    }

                }else if(drag3 == true){
                    if(stack1.search(Third) == 1){


                        if(e.getX()< 700 && e.getX()> 500){
                            try{

                                if(stack2.firstElement()  == First||stack2.firstElement()  == Second){
                                    System.out.print("");
                                }else{
                                    stack1.pop();
                                    stack2.push(Third);
                                    if(stack2.size() - stack2.search(Third) == 3)
                                        Third.setBounds(530, 200, 245,64);
                                    if(stack2.size() - stack2.search(Third) == 2)
                                        Third.setBounds(530, 250, 245,64);
                                    if(stack2.size() - stack2.search(Third) == 1)
                                        Third.setBounds(530, 300, 245,64);
                                    if(stack2.size() - stack2.search(Third) == 0)
                                        Third.setBounds(530, 350, 245,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack2.push(Third);
                                if(stack2.size() - stack2.search(Third) == 3)
                                    Third.setBounds(530, 200, 245,64);
                                if(stack2.size() - stack2.search(Third) == 2)
                                    Third.setBounds(530, 250, 245,64);
                                if(stack2.size() - stack2.search(Third) == 1)
                                    Third.setBounds(530, 300, 245,64);
                                if(stack2.size() - stack2.search(Third) == 0)
                                    Third.setBounds(530, 350, 245,64);
                                check();

                            }

                        }
                        else if( e.getX()< 1050 && e.getX()> 850) {
                            try{
                                if (stack3.firstElement()  == First||stack3.firstElement()  == Second) {
                                    System.out.print("");
                                } else {
                                    stack1.pop();
                                    stack3.push(Third);
                                    if (stack3.size() - stack3.search(Third) == 3)
                                        Third.setBounds(875, 200, 245,64);
                                    if (stack3.size() - stack3.search(Third) == 2)
                                        Third.setBounds(875, 250, 245,64);
                                    if (stack3.size() - stack3.search(Third) == 1)
                                        Third.setBounds(875, 300, 245,64);
                                    if (stack3.size() - stack3.search(Third) == 0)
                                        Third.setBounds(875, 350, 245,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack3.push(Third);
                                if (stack3.size() - stack3.search(Third) == 3)
                                    Third.setBounds(875, 200, 245,64);
                                if (stack3.size() - stack3.search(Third) == 2)
                                    Third.setBounds(875, 250, 245,64);
                                if (stack3.size() - stack3.search(Third) == 1)
                                    Third.setBounds(875, 300, 245,64);
                                if (stack3.size() - stack3.search(Third) == 0)
                                    Third.setBounds(875, 350, 245,64);
                                check();

                            }
                        }

                        drag2 = false;
                    }else if(stack2.search(Third) == 1){



                        if( e.getX()< 1050 && e.getX()> 850){
                            try{
                                if (stack3.firstElement()  == First||stack3.firstElement()  == Second) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack3.push(Third);
                                    if (stack3.size() - stack3.search(Third) == 3)
                                        Third.setBounds(875, 200, 245,64);
                                    if (stack3.size() - stack3.search(Third) == 2)
                                        Third.setBounds(875, 250, 245,64);
                                    if (stack3.size() - stack3.search(Third) == 1)
                                        Third.setBounds(875, 300, 245,64);
                                    if (stack3.size() - stack3.search(Third) == 0)
                                        Third.setBounds(875, 350, 245,64);
                                    check();
                                }
                            }catch(Exception ex) {
                                stack2.pop();
                                stack3.push(Third);
                                if (stack3.size() - stack3.search(Third) == 3)
                                    Third.setBounds(875, 200, 245,64);
                                if (stack3.size() - stack3.search(Third) == 2)
                                    Third.setBounds(875, 250, 245,64);
                                if (stack3.size() - stack3.search(Third) == 1)
                                    Third.setBounds(875, 300, 245,64);
                                if (stack3.size() - stack3.search(Third) == 0)
                                    Third.setBounds(875, 350, 245,64);
                                check();

                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                                if (stack1.firstElement()  == First || stack1.firstElement()  == Second ) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack1.push(Third);
                                    if (stack1.size() - stack1.search(Third) == 3)
                                        Third.setBounds(200, 200, 245,64);
                                    if (stack1.size() - stack1.search(Third) == 2)
                                        Third.setBounds(200, 250, 245,64);
                                    if (stack1.size() - stack1.search(Third) == 1)
                                        Third.setBounds(200, 300, 245,64);
                                    if (stack1.size() - stack1.search(Third) == 0)
                                        Third.setBounds(200, 350, 245,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack2.pop();
                                stack1.push(Third);
                                if (stack1.size() - stack1.search(Third) == 3)
                                    Third.setBounds(200, 200, 245,64);
                                if (stack1.size() - stack1.search(Third) == 2)
                                    Third.setBounds(200, 250, 245,64);
                                if (stack1.size() - stack1.search(Third) == 1)
                                    Third.setBounds(200, 300, 245,64);
                                if (stack1.size() - stack1.search(Third) == 0)
                                    Third.setBounds(200, 350, 245,64);
                                check();

                            }
                        }
                        drag2 = false;

                    }
                    else if(stack3.search(Third) == 1){


                        if(e.getX()< 700 && e.getX()> 500){
                            try{


                                if(stack2.firstElement()  == First || stack2.firstElement()  == Second ){
                                    System.out.print("");
                                }else{
                                    stack3.pop();
                                    stack2.push(Third);
                                    if(stack2.size() - stack2.search(Third) == 3)
                                        Third.setBounds(530, 200, 245,64);
                                    if(stack2.size() - stack2.search(Third) == 2)
                                        Third.setBounds(530, 250, 245,64);
                                    if(stack2.size() - stack2.search(Third) == 1)
                                        Third.setBounds(530, 300, 245,64);
                                    if(stack2.size() - stack2.search(Third) == 0)
                                        Third.setBounds(530, 350, 245,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack2.push(Third);
                                if(stack2.size() - stack2.search(Third) == 3)
                                    Third.setBounds(530, 200, 245,64);
                                if(stack2.size() - stack2.search(Third) == 2)
                                    Third.setBounds(530, 250, 245,64);
                                if(stack2.size() - stack2.search(Third) == 1)
                                    Third.setBounds(530, 300, 245,64);
                                if(stack2.size() - stack2.search(Third) == 0)
                                    Third.setBounds(530, 350, 245,64);
                                check();

                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                                if (stack1.firstElement()  == First||stack1.firstElement()  == Second) {
                                    System.out.print("");
                                } else {
                                    stack3.pop();
                                    stack1.push(Third);
                                    if (stack1.size() - stack1.search(Third) == 3)
                                        Third.setBounds(200, 200, 245,64);
                                    if (stack1.size() - stack1.search(Third) == 2)
                                        Third.setBounds(200, 250, 245,64);
                                    if (stack1.size() - stack1.search(Third) == 1)
                                        Third.setBounds(200, 300, 245,64);
                                    if (stack1.size() - stack1.search(Third) == 0)
                                        Third.setBounds(200, 350, 245,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack1.push(Third);
                                if (stack1.size() - stack1.search(Third) == 3)
                                    Third.setBounds(200, 200, 245,64);
                                if (stack1.size() - stack1.search(Third) == 2)
                                    Third.setBounds(200, 250, 245,64);
                                if (stack1.size() - stack1.search(Third) == 1)
                                    Third.setBounds(200, 300, 245,64);
                                if (stack1.size() - stack1.search(Third) == 0)
                                    Third.setBounds(200, 350, 245,64);
                                check();

                            }
                        }
                        drag2 = false;

                    }

                } else if(drag4 == true){
                    if(stack1.search(Fourth) == 1){


                        if(e.getX()< 700 && e.getX()> 500){
                            try{

                                if(stack2.firstElement()  == First||stack2.firstElement()  == Second||stack2.firstElement()  == Third){
                                    System.out.print("");
                                }else{
                                    stack1.pop();
                                    stack2.push(Fourth);
                                    if(stack2.size() - stack2.search(Fourth) == 3)
                                        Fourth.setBounds(530, 200, 269,64);
                                    if(stack2.size() - stack2.search(Fourth) == 2)
                                        Fourth.setBounds(530, 250, 269,64);
                                    if(stack2.size() - stack2.search(Fourth) == 1)
                                        Fourth.setBounds(530, 300, 269,64);
                                    if(stack2.size() - stack2.search(Fourth) == 0)
                                        Fourth.setBounds(530, 350, 269,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack2.push(Fourth);
                                if(stack2.size() - stack2.search(Fourth) == 3)
                                    Fourth.setBounds(530, 200, 269,64);
                                if(stack2.size() - stack2.search(Fourth) == 2)
                                    Fourth.setBounds(530, 250, 269,64);
                                if(stack2.size() - stack2.search(Fourth) == 1)
                                    Fourth.setBounds(530, 300, 269,64);
                                if(stack2.size() - stack2.search(Fourth) == 0)
                                    Fourth.setBounds(530, 350, 269,64);
                                check();

                            }

                        }
                        else if( e.getX()< 1050 && e.getX()> 850) {
                            try{
                                if (stack3.firstElement()  == First||stack3.firstElement()  == Second||stack3.firstElement()  == Third) {
                                    System.out.print("");
                                } else {
                                    stack1.pop();
                                    stack3.push(Fourth);
                                    if (stack3.size() - stack3.search(Fourth) == 3)
                                        Fourth.setBounds(875, 200, 269,64);
                                    if (stack3.size() - stack3.search(Fourth) == 2)
                                        Fourth.setBounds(875, 250, 269,64);
                                    if (stack3.size() - stack3.search(Fourth) == 1)
                                        Fourth.setBounds(875, 300, 269,64);
                                    if (stack3.size() - stack3.search(Fourth) == 0)
                                        Fourth.setBounds(875, 350, 269,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack3.push(Fourth);
                                if (stack3.size() - stack3.search(Fourth) == 3)
                                    Fourth.setBounds(875, 200, 269,64);
                                if (stack3.size() - stack3.search(Fourth) == 2)
                                    Fourth.setBounds(875, 250, 269,64);
                                if (stack3.size() - stack3.search(Fourth) == 1)
                                    Fourth.setBounds(875, 300, 269,64);
                                if (stack3.size() - stack3.search(Fourth) == 0)
                                    Fourth.setBounds(875, 350, 269,64);
                                check();

                            }
                        }

                        drag2 = false;
                    }else if(stack2.search(Fourth) == 1){



                        if( e.getX()< 1050 && e.getX()> 850){
                            try{
                                if (stack3.firstElement()  == First||stack3.firstElement()  == Second||stack3.firstElement()  == Third) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack3.push(Fourth);
                                    if (stack3.size() - stack3.search(Fourth) == 3)
                                        Fourth.setBounds(875, 200, 269,64);
                                    if (stack3.size() - stack3.search(Fourth) == 2)
                                        Fourth.setBounds(875, 250, 269,64);
                                    if (stack3.size() - stack3.search(Fourth) == 1)
                                        Fourth.setBounds(875, 300, 269,64);
                                    if (stack3.size() - stack3.search(Fourth) == 0)
                                        Fourth.setBounds(875, 350, 269,64);
                                    check();
                                }
                            }catch(Exception ex) {
                                stack2.pop();
                                stack3.push(Fourth);
                                if (stack3.size() - stack3.search(Fourth) == 3)
                                    Fourth.setBounds(875, 200, 269,64);
                                if (stack3.size() - stack3.search(Fourth) == 2)
                                    Fourth.setBounds(875, 250, 269,64);
                                if (stack3.size() - stack3.search(Fourth) == 1)
                                    Fourth.setBounds(875, 300, 269,64);
                                if (stack3.size() - stack3.search(Fourth) == 0)
                                    Fourth.setBounds(875, 350, 269,64);
                                check();

                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                                if (stack1.firstElement()  == First || stack1.firstElement()  == Second || stack1.firstElement()  == Third) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack1.push(Fourth);
                                    if (stack1.size() - stack1.search(Fourth) == 3)
                                        Fourth.setBounds(200, 200, 269,64);
                                    if (stack1.size() - stack1.search(Fourth) == 2)
                                        Fourth.setBounds(200, 250, 269,64);
                                    if (stack1.size() - stack1.search(Fourth) == 1)
                                        Fourth.setBounds(200, 300, 269,64);
                                    if (stack1.size() - stack1.search(Fourth) == 0)
                                        Fourth.setBounds(200, 350, 269,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack2.pop();
                                stack1.push(Fourth);
                                if (stack1.size() - stack1.search(Fourth) == 3)
                                    Fourth.setBounds(200, 200, 269,64);
                                if (stack1.size() - stack1.search(Fourth) == 2)
                                    Fourth.setBounds(200, 250, 269,64);
                                if (stack1.size() - stack1.search(Fourth) == 1)
                                    Fourth.setBounds(200, 300, 269,64);
                                if (stack1.size() - stack1.search(Fourth) == 0)
                                    Fourth.setBounds(200, 350, 269,64);
                                check();

                            }
                        }
                        drag2 = false;

                    }
                    else if(stack3.search(Fourth) == 1){


                        if(e.getX()< 700 && e.getX()> 500){
                            try{


                                if(stack2.firstElement()  == First || stack2.firstElement()  == Second || stack2.firstElement()  == Third){
                                    System.out.print("");
                                }else{
                                    stack3.pop();
                                    stack2.push(Fourth);
                                    if(stack2.size() - stack2.search(Fourth) == 3)
                                        Fourth.setBounds(530, 200, 269,64);
                                    if(stack2.size() - stack2.search(Fourth) == 2)
                                        Fourth.setBounds(530, 250, 269,64);
                                    if(stack2.size() - stack2.search(Fourth) == 1)
                                        Fourth.setBounds(530, 300, 269,64);
                                    if(stack2.size() - stack2.search(Fourth) == 0)
                                        Fourth.setBounds(530, 350, 269,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack2.push(Fourth);
                                if(stack2.size() - stack2.search(Fourth) == 3)
                                    Fourth.setBounds(530, 200, 269,64);
                                if(stack2.size() - stack2.search(Fourth) == 2)
                                    Fourth.setBounds(530, 250, 269,64);
                                if(stack2.size() - stack2.search(Fourth) == 1)
                                    Fourth.setBounds(530, 300, 269,64);
                                if(stack2.size() - stack2.search(Fourth) == 0)
                                    Fourth.setBounds(530, 350, 269,64);
                                check();

                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                                if (stack1.firstElement()  == First||stack1.firstElement()  == Second||stack1.firstElement()  == Third) {
                                    System.out.print("");
                                } else {
                                    stack3.pop();
                                    stack1.push(Fourth);
                                    if (stack1.size() - stack1.search(Fourth) == 3)
                                        Fourth.setBounds(200, 200, 269,64);
                                    if (stack1.size() - stack1.search(Fourth) == 2)
                                        Fourth.setBounds(200, 250, 269,64);
                                    if (stack1.size() - stack1.search(Fourth) == 1)
                                        Fourth.setBounds(200, 300, 269,64);
                                    if (stack1.size() - stack1.search(Fourth) == 0)
                                        Fourth.setBounds(200, 350, 269,64);
                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack1.push(Fourth);
                                if (stack1.size() - stack1.search(Fourth) == 3)
                                    Fourth.setBounds(200, 200, 269,64);
                                if (stack1.size() - stack1.search(Fourth) == 2)
                                    Fourth.setBounds(200, 250, 269,64);
                                if (stack1.size() - stack1.search(Fourth) == 1)
                                    Fourth.setBounds(200, 300, 269,64);
                                if (stack1.size() - stack1.search(Fourth) == 0)
                                    Fourth.setBounds(200, 350, 269,64);
                                check();

                            }
                        }
                        drag2 = false;

                    }

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
        First.setBounds(120, 391, 207,64);
        formatLabel(First);
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
        Second.setBounds(110, 455, 227,64);
        formatLabel(Second);
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
        Third.setBounds(100, 518, 245,64);
        formatLabel(Third);
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
        Fourth.setBounds(90, 580, 269,64);
        formatLabel(Fourth);
        pane.add(Fourth);

        JButton Back = new JButton();
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                dispose();
                Options cool = new Options();
            }
        });
        Back.setBounds(305, 65, 232,80);
        Back.setText("<   back!");
        formatButton(Back);
        pane.add(Back);

        JButton restart = new JButton("restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                dispose();
                Level4x4_Duplicate restarted = new Level4x4_Duplicate();
            }
        });
        restart.setBounds(545,63,232,80);
        formatButton(restart);
        pane.add(restart);

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
