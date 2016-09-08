package Chapter8Ex8_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlafTest {
    public static void main(String[] args) {
        PlafFrame frame = new PlafFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/** Фрейм с панелью, содержащей кнопки. С помощью
 * кнопок изменяется стиль окна.
 */

class PlafFrame extends JFrame{

    public PlafFrame(){
        setTitle("PlafTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Добавление панели к фрейму

        PlafPanel panel = new PlafPanel();
        add(panel);

    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

/**
 * Панель с кнопками, преназначенными для изменения стиля
 * */

class PlafPanel extends JPanel {

    public PlafPanel() {
        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos)
            makeButton(info.getName(), info.getClassName());
    }

    /**
     * Создает кнопки, изменяющие стиль отображения.
     *
     * @param name     Имя кнопки
     * @param plafName Имя класса, который описывает стиль
     */

    void makeButton(String name, final String plafName) {

        JButton button = new JButton(name);
        add(button);

        //Связывание обработчика событий с кнопкой

        button.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent event){
                try {
                    UIManager.setLookAndFeel(plafName);
                    SwingUtilities.updateComponentTreeUI(PlafPanel.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    });
}
}
