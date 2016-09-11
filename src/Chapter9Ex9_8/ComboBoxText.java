package Chapter9Ex9_8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxText {
    public static void main(String[] args) {
            ComboBoxFrame frame = new ComboBoxFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/**
 * Фрейм с текстовой меткой и раскрывающимся
 * списком, предназначенным для выбора начертаний
 */
class ComboBoxFrame extends JFrame{

    public ComboBoxFrame(){
        setTitle("ComboBoxTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Добавление текстовой метки
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //Создание раскрывающегося списка и включение
        //в него пунктов, соответствующих начертаниям.

        faceCombo = new JComboBox();
        faceCombo.setEditable(true);
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        //Обаботчик событий, связанных с раскрывающимся
        //списком, изменяет шрифт, которым отображается
        //метка.

        faceCombo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                label.setFont(new Font((String)faceCombo.getSelectedItem(), Font.PLAIN, DEFAULT_SIZE));
            }
        });
        //Включение раскрывающегося списка в состав панели
        //(панель располагается в нижней части фрейма).
        JPanel comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    private JComboBox faceCombo;
    private JLabel label;
    public static final int DEFAULT_SIZE = 12;

}

