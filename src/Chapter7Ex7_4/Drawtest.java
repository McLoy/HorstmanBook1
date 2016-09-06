package Chapter7Ex7_4;

import  java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Drawtest {
    public static void main(String[] args) {
        DrawFrame frame = new DrawFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class DrawFrame extends JFrame{

    public DrawFrame(){
        setTitle("DrawTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        DrawPanel panel = new DrawPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;
}

class DrawPanel extends JPanel{

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Прямоугольник
        double leftx = 100;
        double topy = 100;
        double width = 200;
        double height = 150;

        Rectangle2D rect = new Rectangle2D.Double(leftx, topy, width, height);
        g2.draw(rect);

        // Эллипс
        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        // Диагональ
        g2.draw(new Line2D.Double(leftx, topy, leftx + width, topy + height));

        // Окружность центр которой совпадает с центром прямоугольника

        double centerx = rect.getCenterX();
        double centery = rect.getCenterY();
        double radius = 150;

        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerx, centery, centerx + radius, centery + radius);
        g2.draw(circle);


    }

}
