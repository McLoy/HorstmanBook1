package Chapter7Ex7_7;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageTest {
    public static void main(String[] args) {

        ImageFrame frame = new ImageFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

class ImageFrame extends JFrame{

    public ImageFrame(){

        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ImagePanel panel = new ImagePanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 600;
}

class ImagePanel extends JPanel{

    public ImagePanel(){

        try{
            image = ImageIO.read(new File("blue-ball.gif"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        if (image == null) return;

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        g.drawImage(image, 0, 0, null);

        for (int i = 0; i*imageWidth <= getWidth() ; i++)
            for (int j = 0; j*imageHeight <= getHeight(); j++)
                if (i + j > 0)
                    g.copyArea(0, 0, imageWidth, imageHeight, i*imageWidth, j*imageHeight);
    }

    private Image image;
}
