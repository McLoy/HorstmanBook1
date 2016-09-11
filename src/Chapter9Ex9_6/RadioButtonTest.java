package Chapter9Ex9_6;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonTest {
    public static void main(String[] args) {
        RadioButtonFrame frame = new RadioButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/**
 * Фрейм с текстовой меткой и переключателями,
 * предназначенными для выбора размера шрифта.
 */
class RadioButtonFrame extends JFrame{

    public RadioButtonFrame(){
        setTitle("RadioButtonTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Добавление метки
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //Добавление переключателей
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", 18);
        addRadioButton("Extra large", 36);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Добавление переключателей, устанавливающих размер шрифта
     * для отображения текстовой метки
     * @param name Строка, которой помечается кнопка
     * @param size Размер шрифта для кнопки
     */

    public void addRadioButton(String name, final int size){

        boolean selected = size == DEFAULT_SIZE;
        JRadioButton button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        //Обработчик, устанавливающий размер шрифта для метки
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent event){
                //Размер соответствует последнему параметру
                //метода addRadioButton()
                label.setFont(new Font("Serif", Font.PLAIN, size));
            }
        };
        button.addActionListener(listener);
    }

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 200;

    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;

    public static final int DEFAULT_SIZE = 12;

}
