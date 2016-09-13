package Chapter9Ex9_12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToolBarTest {
    public static void main(String[] args) {

        ToolBarFrame frame = new ToolBarFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/**
 * Фрейм с панелью инструментов и меню для изменения цвета.
 */
class ToolBarFrame extends JFrame{

    public ToolBarFrame(){
        setTitle("ToolBarTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Добавление панели с изменяемым цветом

        panel = new JPanel();

        // Создание объектов

        Action blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
        Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);

        Action exitAction = new AbstractAction("Exit", new ImageIcon("exit.gif")){
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");

        //Заполнение панели инструментов
        JToolBar bar = new JToolBar();
        bar.add(blueAction);
        bar.add(yellowAction);
        bar.add(redAction);
        bar.addSeparator();
        bar.add(exitAction);
        add(bar, BorderLayout.NORTH);

        //Заполнение меню
        JMenu menu = new JMenu();
        menu.add(yellowAction);
        menu.add(blueAction);
        menu.add(redAction);
        menu.add(exitAction);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    private JPanel panel;

    /**
     * ColorAction устанавливает требуемый цвет фона.
     */
    class ColorAction extends AbstractAction{

        public ColorAction(String name, Icon icon, Color c){
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, name + " background");
            putValue("Color", c);
        }

        public void actionPerformed(ActionEvent event){
            Color c = (Color)getValue("Color");
            panel.setBackground(c);
        }
    }

}

