package Chapter8Ex8_6;

import java.awt.event.*;
import javax.swing.*;

public class MultiCastTest {
    public static void main(String[] args) {

        MulticastFrame frame = new MulticastFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

class MulticastFrame extends JFrame{

    public MulticastFrame(){

        setTitle("MulticastTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        MulticastPanel panel = new MulticastPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

}

class MulticastPanel extends JPanel{

    public MulticastPanel(){

    JButton newButton = new JButton("New");
    add(newButton);
    final JButton closeAllButton = new JButton("Close all");
    add(closeAllButton);

        ActionListener newListener = new ActionListener(){
            public void actionPerformed(ActionEvent event){

            BlankFrame frame = new BlankFrame(closeAllButton);
            frame.setVisible(true);
            }

        };
        newButton.addActionListener(newListener);

    }
}

class BlankFrame extends JFrame{

    public BlankFrame(final JButton closeButton){

        counter++;
        setTitle("Frame " + counter);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocation(SPACING*counter, SPACING* counter);

        closeListener = new ActionListener(){
            public void actionPerformed(ActionEvent event){

            closeButton.removeActionListener(closeListener);
            dispose();

        }

    };

        closeButton.addActionListener(closeListener);
    }
    private ActionListener closeListener;
    public static final int DEFAULT_WIDTH = 200;
    public static final int DEFAULT_HEIGHT= 150;
    public static final int SPACING= 200;
    private static int counter = 0;

}
