package Chapter7Ex7_2;

import java.awt.*;
import javax.swing.*;

public class CenteredFrameTest {
    public static void main(String[] args) {

        CenteredFrame frame = new CenteredFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CenteredFrame extends JFrame{

    public CenteredFrame(){

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth/2, screenHeight/2);
        setLocation(screenWidth/4, screenHeight/4);

        Image img = kit.getImage("icon.gif");
        setIconImage(img);
        setTitle("Centered Frame");
    }
}
