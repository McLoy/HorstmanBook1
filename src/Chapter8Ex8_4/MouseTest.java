package Chapter8Ex8_4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;

public class MouseTest {
    public static void main(String[] args) {

        MouseFrame frame = new MouseFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

class MouseFrame extends JFrame{

    public MouseFrame(){

        setTitle("MouseTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        MousePanel panel = new MousePanel();
        add(panel);

    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

class MousePanel extends JPanel{

    public MousePanel(){
        squares = new ArrayList<Rectangle2D>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for (Rectangle2D r : squares)
            g2.draw(r);
    }

    public Rectangle2D find(Point2D p){

        for (Rectangle2D r : squares){
            if (r.contains(p)) return r;
        }
        return null;
    }

    public void add(Point2D p){
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENTH/2, y - SIDELENTH/2, SIDELENTH, SIDELENTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s){
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }

    private static final int SIDELENTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    private class  MouseHandler extends MouseAdapter{

        public void mousePressed(MouseEvent event){

            current = find(event.getPoint());
            if (current == null) add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event){
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2)
                remove(current);
        }
    }
    private class MouseMotionHandler implements MouseMotionListener{

        public void mouseMoved(MouseEvent event){

            if (find(event.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseDragged(MouseEvent event){

            if (current != null){

                int x = event.getX();
                int y = event.getY();

                current.setFrame(x - SIDELENTH/2, y - SIDELENTH/2, SIDELENTH, SIDELENTH);
                repaint();
            }
        }
    }
}
