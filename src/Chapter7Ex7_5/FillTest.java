package Chapter7Ex7_5;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class FillTest {
    public static void main(String[] args) {
        FillFrame frame = new FillFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class FillFrame extends JFrame{

    public FillFrame(){
        setTitle("FillTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        FillPanel panel = new FillPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;
}

class FillPanel extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Прямоугольник
        double leftx = 100;
        double topy = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftx, topy, width, height);
        g2.setPaint(Color.RED);
        g2.fill(rect);

        // Эллипс
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.setPaint(new Color(0, 128, 128));
        g2.fill(ellipse);

    }

}
