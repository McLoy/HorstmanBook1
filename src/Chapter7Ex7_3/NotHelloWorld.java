package Chapter7Ex7_3;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {

    public static void main(String[] args) {

        NotHelloWorldFrame frame = new NotHelloWorldFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

class NotHelloWorldFrame extends JFrame{

    public NotHelloWorldFrame(){
        setTitle("NotHelloWorld");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        NotHelloWorldPanel panel = new NotHelloWorldPanel();
        add(panel);
    }

    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 500;
}

class NotHelloWorldPanel extends JPanel{

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Hi! How are you?", MESSAGE_X, MESSAGE_Y);
    }
    private static final int MESSAGE_X = 75;
    private static final int MESSAGE_Y = 100;

}
