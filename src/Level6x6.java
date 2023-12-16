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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Level6x6 extends JFrame{

    //INSTANCE VARIABLES
    private JPanel Level6x6; //program doesn't run unless this line is present :0
    private JFrame frame = new JFrame("The Towers of Hanoi...");
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
    private boolean first = true;
    private Stack<JLabel> stack1 = new Stack();
    private Stack<JLabel> stack2 = new Stack();
    private Stack<JLabel> stack3 = new Stack();
    private Color white = new Color(255,255,255);

    //MOVEMENT METHODS
    private void movement1(JLabel cool ){
        if(stack1.size() - stack1.search(cool) == 5)
            cool.setLocation(120, 210);
        if(stack1.size() - stack1.search(cool) == 4)
            cool.setLocation(115, 280);
        if(stack1.size() - stack1.search(cool) == 3)
            cool.setLocation(110, 350);
        if(stack1.size() - stack1.search(cool) == 2)
            cool.setLocation(100, 420);
        if(stack1.size() - stack1.search(cool) == 1)
            cool.setLocation(85, 490);
        if(stack1.size() - stack1.search(cool) == 0)
            cool.setLocation(70, 560);
    }

    private void movement2(JLabel cool ){
        if(stack2.size() - stack2.search(cool) == 5)
            cool.setLocation(510, 210);
        if(stack2.size() - stack2.search(cool) == 4)
            cool.setLocation(505, 280);
        if(stack2.size() - stack2.search(cool) == 3)
            cool.setLocation(500, 350);
        if(stack2.size() - stack2.search(cool) == 2)
            cool.setLocation(490, 420);
        if(stack2.size() - stack2.search(cool) == 1)
            cool.setLocation(475, 490);
        if(stack2.size() - stack2.search(cool) == 0)
            cool.setLocation(460, 560);
    }

    private void movement3(JLabel cool ){
        if(stack3.size() - stack3.search(cool) == 5)
            cool.setLocation(855, 210);
        if(stack3.size() - stack3.search(cool) == 4)
            cool.setLocation(850, 280);
        if(stack3.size() - stack3.search(cool) == 3)
            cool.setLocation(845, 350);
        if(stack3.size() - stack3.search(cool) == 2)
            cool.setLocation(835, 420);
        if(stack3.size() - stack3.search(cool) == 1)
            cool.setLocation(830, 490);
        if(stack3.size() - stack3.search(cool) == 0)
            cool.setLocation(805, 560);
    }

    //HIGH SCORE METHODS
    public String updateHighScore() throws FileNotFoundException {
        Options.f3 = new File("highScore6x6.txt");
        Scanner input = new Scanner(Options.f3);
        return input.nextLine();
    }

    public void setHighScore() {
        try {
            FileWriter fileWriter= new FileWriter("highScore6x6.txt");
            fileWriter.write(String.valueOf(getCurrentScore()));
            fileWriter.close();
        } catch(FileNotFoundException e) {
            System.out.println("Yikes! It seems the file doesn't exist!");
        } catch(IOException i) {
            System.out.println("Uh oh! An error of some sort has arisen!");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,i);
        }
    }

    public int getCurrentScore() {
        String data = "";
        try{
            Scanner myReader = new Scanner(Options.myObj);
            data = myReader.nextLine();
            myReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
        } catch (IOException i) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,i);
        }
        Double dVal = Double.parseDouble(data);
        return dVal.intValue();
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
            if (stack3.elementAt(0).equals(Sixth) && stack3.elementAt(1).equals(Fifth)&& stack3.elementAt(2).equals(Fourth) && stack3.elementAt(3).equals(Third) && stack3.elementAt(4).equals(Second)&& stack3.elementAt(5).equals(First)) {
                String number = updateHighScore();
                int highest6x6= Integer.parseInt(number);
                int score = getCurrentScore();
                boolean highestAchieved = false;

                if(highest6x6>score) {
                    System.out.println("\nHighest: "+highest6x6+"\nCurrent: "+score);
                    highestAchieved=true;
                    setHighScore();
                }

                frame.setVisible(false);
                EndPage doesThisWork = new EndPage();
                doesThisWork.conquerorPage("6x6",highestAchieved);
            }
        }catch(Exception ex){
            System.out.print("");
        }
    }

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

    //GAME CODE
    public Level6x6() {

        if(first == true){
            stack1.push(Sixth);

            stack1.push(Fifth);
            stack1.push(Fourth);
            stack1.push(Third);
            stack1.push(Second);
            stack1.push(First);
            first = false;
        }

        JLayeredPane pane = new JLayeredPane();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_gamePage.png");
        Icon backgroundIcon = new ImageIcon(url);
        JLabel background = new JLabel(backgroundIcon);

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
                                if(stack2.elementAt(stack2.size()-1).equals(First)){
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
                                if (stack3.elementAt(stack3.size()-1).equals(First)) {
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
                                if (stack3.elementAt(stack3.size()-1).equals(First)) {
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
                                if (stack1.elementAt(stack1.size()-1).equals(First)) {
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
                                if(stack2.elementAt(stack2.size()-1).equals(First)){
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
                                if (stack1.elementAt(stack1.size()-1).equals(First)) {
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
                                if(stack2.elementAt(stack2.size()-1).equals(First)||stack2.elementAt(stack2.size()-1).equals(Second)){
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
                                if (stack3.elementAt(stack3.size()-1).equals(First)||stack3.elementAt(stack3.size()-1).equals(Second)) {
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
                                if (stack3.elementAt(stack3.size()-1).equals(First)||stack3.elementAt(stack3.size()-1).equals(Second)) {
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
                                if (stack1.elementAt(stack1.size()-1).equals(First) || stack1.elementAt(stack1.size()-1).equals(Second) ) {
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
                                if(stack2.elementAt(stack2.size()-1).equals(First) || stack2.elementAt(stack2.size()-1).equals(Second) ){
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
                                if (stack1.elementAt(stack1.size()-1).equals(First)||stack1.elementAt(stack1.size()-1).equals(Second)) {
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
                                if(stack2.elementAt(stack2.size()-1).equals(First)||stack2.elementAt(stack2.size()-1).equals(Second)||stack2.elementAt(stack2.size()-1).equals(Third)){
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
                                if (stack3.elementAt(stack3.size()-1).equals(First)||stack3.elementAt(stack3.size()-1).equals(Second)||stack3.elementAt(stack3.size()-1).equals(Third)) {
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
                                if (stack3.elementAt(stack3.size()-1).equals(First)||stack3.elementAt(stack3.size()-1).equals(Second)||stack3.elementAt(stack3.size()-1).equals(Third)) {
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
                                if (stack1.elementAt(stack1.size()-1).equals(First) || stack1.elementAt(stack1.size()-1).equals(Second) || stack1.elementAt(stack1.size()-1).equals(Third)) {
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
                                if(stack2.elementAt(stack2.size()-1).equals(First) || stack2.elementAt(stack2.size()-1).equals(Second) || stack2.elementAt(stack2.size()-1).equals(Third)){
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
                                if (stack1.elementAt(stack1.size()-1).equals(First)||stack1.elementAt(stack1.size()-1).equals(Second)||stack1.elementAt(stack1.size()-1).equals(Third)) {
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

                }else if(drag5 == true){
                    if(stack1.search(Fifth) == 1){

                        if(e.getX()< 700 && e.getX()> 500){
                            try{
                                if(stack2.elementAt(stack2.size()-1).equals(First)||stack2.elementAt(stack2.size()-1).equals(Second)||stack2.elementAt(stack2.size()-1).equals(Third) || stack2.elementAt(stack2.size()-1).equals(Fourth)){
                                    System.out.print("");
                                }else{
                                    stack1.pop();
                                    stack2.push(Fifth);
                                    movement2(Fifth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack2.push(Fifth);
                                movement2(Fifth);

                                check();
                            }

                        }
                        else if( e.getX()< 1050 && e.getX()> 850) {
                            try{
                                if (stack3.elementAt(stack3.size()-1).equals(First)||stack3.elementAt(stack3.size()-1).equals(Second)||stack3.elementAt(stack3.size()-1).equals(Third) || stack3.elementAt(stack3.size()-1).equals(Fourth)) {
                                    System.out.print("");
                                } else {
                                    stack1.pop();
                                    stack3.push(Fifth);
                                    movement3(Fifth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack3.push(Fifth);
                                movement3(Fifth);

                                check();
                            }
                        }

                        drag5 = false;
                    }else if(stack2.search(Fifth) == 1){

                        if( e.getX()< 1050 && e.getX()> 850){
                            try{
                                if (stack3.elementAt(stack3.size()-1).equals(First)||stack3.elementAt(stack3.size()-1).equals(Second)||stack3.elementAt(stack3.size()-1).equals(Third)|| stack3.elementAt(stack3.size()-1).equals(Fourth)) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack3.push(Fifth);
                                    movement3(Fifth);

                                    check();
                                }
                            }catch(Exception ex) {
                                stack2.pop();
                                stack3.push(Fifth);
                                movement3(Fifth);

                                check();
                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                                if (stack1.elementAt(stack1.size()-1).equals(First) || stack1.elementAt(stack1.size()-1).equals(Second) || stack1.elementAt(stack1.size()-1).equals(Third)|| stack1.elementAt(stack1.size()-1).equals(Fourth)) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack1.push(Fifth);
                                    movement1(Fifth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack2.pop();
                                stack1.push(Fifth);
                                movement1(Fifth);

                                check();
                            }
                        }
                        drag5 = false;
                    }
                    else if(stack3.search(Fifth) == 1){

                        if(e.getX()< 700 && e.getX()> 500){
                            try{
                                if(stack2.elementAt(stack2.size()-1).equals(First) || stack2.elementAt(stack2.size()-1).equals(Second) || stack2.elementAt(stack2.size()-1).equals(Third)|| stack2.elementAt(stack2.size()-1).equals(Fourth)){
                                    System.out.print("");
                                }else{
                                    stack3.pop();
                                    stack2.push(Fifth);
                                    movement2(Fifth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack2.push(Fifth);
                                movement2(Fifth);

                                check();
                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                                if (stack1.elementAt(stack1.size()-1).equals(First)||stack1.elementAt(stack1.size()-1).equals(Second)||stack1.elementAt(stack1.size()-1).equals(Third)| stack1.elementAt(stack1.size()-1).equals(Fourth)) {
                                    System.out.print("");
                                } else {
                                    stack3.pop();
                                    stack1.push(Fifth);
                                    movement1(Fifth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack1.push(Fifth);
                                movement1(Fifth);

                                check();
                            }
                        }
                        drag5 = false;
                    }
                }else if(drag6 == true){
                    if(stack1.search(Sixth) == 1){

                        if(e.getX()< 700 && e.getX()> 500){
                            try{
                                if(stack2.elementAt(stack2.size()-1).equals(First)||stack2.elementAt(stack2.size()-1).equals(Second)||stack2.elementAt(stack2.size()-1).equals(Third) || stack2.elementAt(stack2.size()-1).equals(Fourth)||stack2.elementAt(stack2.size()-1).equals(Fifth)){
                                    System.out.print("");
                                }else{
                                    stack1.pop();
                                    stack2.push(Sixth);
                                    movement2(Sixth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack2.push(Sixth);
                                movement2(Sixth);

                                check();
                            }
                        }
                        else if( e.getX()< 1050 && e.getX()> 850) {
                            try{
                                if (stack3.elementAt(stack3.size()-1).equals(First)||stack3.elementAt(stack3.size()-1).equals(Second)||stack3.elementAt(stack3.size()-1).equals(Third) || stack3.elementAt(stack3.size()-1).equals(Fourth)||stack3.elementAt(stack3.size()-1).equals(Fifth)) {
                                    System.out.print("");
                                } else {
                                    stack1.pop();
                                    stack3.push(Sixth);
                                    movement3(Sixth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack1.pop();
                                stack3.push(Sixth);
                                movement3(Sixth);

                                check();
                            }
                        }

                        drag6 = false;
                    }else if(stack2.search(Sixth) == 1){

                        if( e.getX()< 1050 && e.getX()> 850){
                            try{
                                if (stack3.elementAt(stack3.size()-1).equals(First)||stack3.elementAt(stack3.size()-1).equals(Second)||stack3.elementAt(stack3.size()-1).equals(Third)|| stack3.elementAt(stack3.size()-1).equals(Fourth)||stack3.elementAt(stack3.size()-1).equals(Fifth)) {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack3.push(Sixth);
                                    movement3(Sixth);

                                    check();
                                }
                            }catch(Exception ex) {
                                stack2.pop();
                                stack3.push(Sixth);
                                movement3(Sixth);

                                check();
                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){
                            try{
                                if (stack1.elementAt(stack1.size()-1).equals(First) || stack1.elementAt(stack1.size()-1).equals(Second) || stack1.elementAt(stack1.size()-1).equals(Third)|| stack1.elementAt(stack1.size()-1).equals(Fourth)||stack1.elementAt(stack1.size()-1).equals(Fifth))  {
                                    System.out.print("");
                                } else {
                                    stack2.pop();
                                    stack1.push(Sixth);
                                    movement1(Sixth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack2.pop();
                                stack1.push(Sixth);
                                movement1(Sixth);

                                check();
                            }
                        }
                        drag6 = false;
                    }
                    else if(stack3.search(Sixth) == 1){

                        if(e.getX()< 700 && e.getX()> 500){

                            try{
                                if(stack2.elementAt(stack2.size()-1).equals(First) || stack2.elementAt(stack2.size()-1).equals(Second) || stack2.elementAt(stack2.size()-1).equals(Third)|| stack2.elementAt(stack2.size()-1).equals(Fourth) || stack2.elementAt(stack2.size()-1).equals(Fifth) ) {
                                    System.out.print("");
                                }else{
                                    stack3.pop();
                                    stack2.push(Sixth);
                                    movement2(Sixth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack2.push(Sixth);
                                movement2(Sixth);

                                check();
                            }
                        }
                        else if( e.getX()< 300 && e.getX()> 150){

                            try{
                                if (stack1.elementAt(stack1.size()-1).equals(First)||stack1.elementAt(stack1.size()-1).equals(Second)||stack1.elementAt(stack1.size()-1).equals(Third)|| stack1.elementAt(stack1.size()-1).equals(Fourth)||stack1.elementAt(stack1.size()-1).equals(Fifth)) {
                                    System.out.print("");
                                } else {
                                    stack3.pop();
                                    stack1.push(Sixth);
                                    movement1(Sixth);

                                    check();
                                }
                            }catch(Exception ex){
                                stack3.pop();
                                stack1.push(Sixth);
                                movement1(Sixth);

                                check();
                            }
                        }
                        drag6 = false;
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
                drag6 = false;
                drag5 = false;
            }
        });
        First.setBounds(120, 210, 207,70);
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
        Second.setBounds(115, 280, 227,70);
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
        Third.setBounds(110, 350, 245,70);
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
        Fourth.setBounds(100, 420, 269,70);
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
        Fifth.setBounds(85, 490, 289,70);
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
        Sixth.setBounds(70, 560, 314,65);
        pane.add(Sixth);

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

                try{
                    FileWriter myWriter = new FileWriter("filename.txt");
                    myWriter.write("0");
                    myWriter.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("An error occurred.");
                    ex.printStackTrace();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                frame.setVisible(false);
                dispose();
                Level6x6 restarted = new Level6x6();
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

    private void createUIComponents() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("towersOfHanoi_HanoiRing1.png");
        Icon newIcon = new ImageIcon(url);
        First = new JLabel(newIcon);
        classloader = Thread.currentThread().getContextClassLoader();
        url = classloader.getResource("towersOfHanoi_HanoiRing2.png");
        newIcon = new ImageIcon(url);
        Second = new JLabel(newIcon);
        classloader = Thread.currentThread().getContextClassLoader();
        url = classloader.getResource("towersOfHanoi_HanoiRing3.png");
        newIcon = new ImageIcon(url);
        Third = new JLabel(newIcon);
        classloader = Thread.currentThread().getContextClassLoader();
        url = classloader.getResource("towersOfHanoi_HanoiRing4.png");
        newIcon = new ImageIcon(url);
        Fourth = new JLabel(newIcon);
        classloader = Thread.currentThread().getContextClassLoader();
        url = classloader.getResource("towersOfHanoi_HanoiRing5.png");
        newIcon = new ImageIcon(url);
        Fifth = new JLabel(newIcon);
        classloader = Thread.currentThread().getContextClassLoader();
        url = classloader.getResource("towersOfHanoi_HanoiRing6.png");
        newIcon = new ImageIcon(url);
        Sixth = new JLabel(newIcon);
    }
}
