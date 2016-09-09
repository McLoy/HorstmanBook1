package Chapter8Ex8_3;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class Sketch {
    public static void main(String[] args) {

        SketchFrame frame = new SketchFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class SketchFrame extends JFrame{

    public SketchFrame(){
        setTitle("Sketch");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        SketchPanel panel = new SketchPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 300;
}

class SketchPanel extends JPanel{

    public SketchPanel(){
        last = new Point2D.Double(100, 100);
        lines = new ArrayList<Line2D>();
        KeyHandler listener = new KeyHandler();
        addKeyListener(listener);
        setFocusable(true);
    }

    public void add(int dx, int dy){
        Point2D end = new Point2D.Double(last.getX() + dx, last.getY() + dy);

        Line2D line = new Line2D.Double(last, end);
        lines.add(line);
        repaint();

        last = end;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for (Line2D l : lines)
            g2.draw(l);
    }

    private Point2D last;
    private ArrayList<Line2D> lines;

    public static final int SMALL_INCREMENT = 1;
    public static final int LARGE_INCREMENT = 5;

    private class KeyHandler implements KeyListener{

        public void keyPressed(KeyEvent event){

            int keyCode = event.getKeyCode();

            int d;
            if (event.isShiftDown())
                d = LARGE_INCREMENT;
            else
                d = SMALL_INCREMENT;

            if (keyCode == KeyEvent.VK_LEFT) add(-d, 0);
            else if (keyCode == KeyEvent.VK_RIGHT) add(d, 0);
            else if (keyCode == KeyEvent.VK_UP) add(0, -d);
            else if (keyCode == KeyEvent.VK_DOWN) add(0, d);
         }

        public void keyReleased(KeyEvent event){}

        public void keyTyped(KeyEvent event){

            char keyChar = event.getKeyChar();

            int d;
            if (Character.isUpperCase(keyChar)){
                d = LARGE_INCREMENT;
                keyChar = Character.toLowerCase(keyChar);
            } else d = SMALL_INCREMENT;

            if (keyChar == 'h') add(-d, 0);
            else if (keyChar == 'l') add(d,0);
            else if (keyChar == 'k') add(0,-d);
            else if (keyChar == 'j') add(0,d);

        }
    }

}
