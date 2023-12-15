import javax.swing.*;
import java.awt.*;
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
import java.util.Stack;


public class Level4x4 extends JFrame {
    private Color white = new Color(255,255,255);

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
    private boolean first = true;
    private Stack<JLabel> stack1 = new Stack();
    private Stack<JLabel> stack2 = new Stack();
    private Stack<JLabel> stack3 = new Stack();
    private void movement1(JLabel cool ){
        if(stack1.size() - stack1.search(cool) == 3)
            cool.setLocation(200, 200);
        if(stack1.size() - stack1.search(cool) == 2)
            cool.setLocation(200, 250);
        if(stack1.size() - stack1.search(cool) == 1)
            cool.setLocation(200, 300);
        if(stack1.size() - stack1.search(cool) == 0)
            cool.setLocation(200, 350);
    }
    private void movement2(JLabel cool ){
        if(stack2.size() - stack2.search(cool) == 3)
            cool.setLocation(530, 200);
        if(stack2.size() - stack2.search(cool) == 2)
            cool.setLocation(530, 250);
        if(stack2.size() - stack2.search(cool) == 1)
            cool.setLocation(530, 300);
        if(stack2.size() - stack2.search(cool) == 0)
            cool.setLocation(530, 350);
    }
    private void movement3(JLabel cool ){
        if(stack3.size() - stack3.search(cool) == 3)
            cool.setLocation(875, 200);
        if(stack3.size() - stack3.search(cool) == 2)
            cool.setLocation(875, 250);
        if(stack3.size() - stack3.search(cool) == 1)
            cool.setLocation(875, 300);
        if(stack3.size() - stack3.search(cool) == 0)
            cool.setLocation(875, 350);
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
            if (stack3.elementAt(0).equals(Fourth) && stack3.elementAt(1).equals(Third) && stack3.elementAt(2).equals(Second) && stack3.elementAt(3).equals(First)){
                frame.setVisible(false);

                EndPage doesThisWork = new EndPage();
                doesThisWork.conquerorPage();

            }
        }catch(Exception ex){
            System.out.print("");
        }

    }

    public JLabel makeImage(String fileName) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource(fileName);
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);
        return background;
    }

    public Level4x4() {

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
                            movement2(First);
                            check();
                        }
                        else if( e.getX()< 1050 && e.getX()> 850){
                            stack1.pop();
                            stack3.push(First);
                            movement3(First);
                            check();
                        }

                    }else if(stack2.search(First) >= 0){

                        System.out.print(e.getX());
                        if( e.getX()< 300 && e.getX()> 150){
                            stack2.pop();

                            stack1.push(First);
                            movement1(First);
                            check();
                        }
                        else if( e.getX()< 1050 && e.getX()> 850){
                            stack2.pop();
                            stack3.push(First);
                            movement3(First);
                            check();
                        }

                    }
                    else if(stack3.search(First) >= 0){

                        System.out.print(e.getX());
                        if( e.getX()< 300 && e.getX()> 150){
                            stack3.pop();

                            stack1.push(First);

                            movement1(First);
                            check();
                        }
                        else if(e.getX()< 700 && e.getX()> 500){
                            stack3.pop();
                            stack2.push(First);
                            movement2(First);
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
                                    movement2(Second);
                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack2.push(Second);
                                movement2(Second);
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
                                movement3(Second);
                                check();
                            }
                            }catch(Exception ex){
                                stack1.pop();
                                stack3.push(Second);
                                movement3(Second);
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
                                movement3(Second);
                                check();
                            }
                            }catch(Exception ex) {
                                stack2.pop();
                                stack3.push(Second);
                                movement3(Second);
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
                                movement1(Second);
                                check();
                            }
                            }catch(Exception ex){
                                stack2.pop();
                                stack1.push(Second);
                                movement1(Second);
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
                                movement2(Second);
                                check();
                            }
                            }catch(Exception ex){
                                stack3.pop();
                                stack2.push(Second);
                                movement2(Second);
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
                                movement1(Second);
                                check();
                            }
                            }catch(Exception ex){
                                stack3.pop();
                                stack1.push(Second);
                                movement1(Second);
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
                                    movement2(Third);
                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack2.push(Third);
                                movement2(Third);

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
                                    movement3(Third);

                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack3.push(Third);
                                movement3(Third);

                                check();

                            }
                        }

                        drag3 = false;
                    }else if(stack2.search(Third) == 1){



                        if( e.getX()< 1050 && e.getX()> 850){
                            try{
                                if (stack3.firstElement()  == First||stack3.firstElement()  == Second) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack3.push(Third);
                                    movement3(Third);

                                    check();
                                }
                            }catch(Exception ex) {
                                stack2.pop();
                                stack3.push(Third);
                                movement3(Third);

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
                                    movement1(Third);

                                    check();
                                }
                            }catch(Exception ex){
                                stack2.pop();
                                stack1.push(Third);
                                movement1(Third);

                                check();

                            }
                        }
                        drag3 = false;

                    }
                    else if(stack3.search(Third) == 1){


                        if(e.getX()< 700 && e.getX()> 500){
                            try{


                                if(stack2.firstElement()  == First || stack2.firstElement()  == Second ){
                                    System.out.print("");
                                }else{
                                    stack3.pop();
                                    stack2.push(Third);
                                    movement2(Third);

                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack2.push(Third);
                                movement2(Third);

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
                                    movement1(Third);

                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack1.push(Third);
                                movement1(Third);

                                check();

                            }
                        }
                        drag3 = false;

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
                                    movement2(Fourth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack2.push(Fourth);
                                movement2(Fourth);

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
                                    movement3(Fourth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack3.push(Fourth);
                                movement3(Fourth);

                                check();

                            }
                        }

                        drag4 = false;
                    }else if(stack2.search(Fourth) == 1){



                        if( e.getX()< 1050 && e.getX()> 850){
                            try{
                                if (stack3.firstElement()  == First||stack3.firstElement()  == Second||stack3.firstElement()  == Third) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack3.push(Fourth);
                                    movement3(Fourth);

                                    check();
                                }
                            }catch(Exception ex) {
                                stack2.pop();
                                stack3.push(Fourth);
                                movement3(Fourth);

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
                                    movement1(Fourth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack2.pop();
                                stack1.push(Fourth);
                                movement1(Fourth);

                                check();

                            }
                        }
                        drag4 = false;

                    }
                    else if(stack3.search(Fourth) == 1){


                        if(e.getX()< 700 && e.getX()> 500){
                            try{


                                if(stack2.firstElement()  == First || stack2.firstElement()  == Second || stack2.firstElement()  == Third){
                                    System.out.print("");
                                }else{
                                    stack3.pop();
                                    stack2.push(Fourth);
                                    movement2(Fourth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack2.push(Fourth);
                                movement2(Fourth);

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
                                    movement1(Fourth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack1.push(Fourth);
                                movement1(Fourth);

                                check();

                            }
                        }
                        drag4 = false;

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
        First.setBounds(200, 200, 207,64);
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
        Second.setBounds(200, 250, 227,64);
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
        Third.setBounds(200, 300, 245,64);
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
        Fourth.setBounds(200, 350, 269,64);
        formatLabel(Fourth);
        pane.add(Fourth);


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
                Level4x4 restarted = new Level4x4();
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
