package Chapter9Ex9_4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextAreaTest {
    public static void main(String[] args) {

        TextAreaFrame frame = new TextAreaFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

/**
 * Фрейм, содержащий текстовую область и кнопки для редактировнаия
 */
class TextAreaFrame extends JFrame{

    public TextAreaFrame(){
        setTitle("TextAreaTest");
        setSize(DEFAULT_HEIGHT, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        //Добавление кнопки, предназначенной для включения
        //текста в текстовую область

        JButton  insertButton = new JButton("Insert");
        buttonPanel.add(insertButton);
        insertButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                textArea.append("The quick brown fox jumps over the lazy dog");
            }
        });

        //Добавление кнопки, предназначенной для включения
        //и отключения режима переноса.

        wrapButton = new JButton("Wrap");
        buttonPanel.add(wrapButton);
        wrapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                boolean wrap = !textArea.getLineWrap();
                textArea.setLineWrap(wrap);
                scrollPane.revalidate();
                wrapButton.setText(wrap ? "No Wrap" : "Wrap");
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);

        //Связывание текстовой области с полосами прокрутки.

        textArea = new JTextArea(8, 40);
        scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 300;

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JPanel buttonPanel;
    private JButton wrapButton;
}
