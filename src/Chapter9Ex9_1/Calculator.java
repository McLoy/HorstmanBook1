package Chapter9Ex9_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {
    public static void main(String[] args) {

        CalculatorsFrame frame = new CalculatorsFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

/**
 * Фрейм с панелью, содержащей кнопки калькулятора
 */

class CalculatorsFrame extends JFrame{

    public CalculatorsFrame(){
        setTitle("Calculator");
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);
        pack();
    }
}

/**
 * Панель с кнопками калькулятора и элементом
 * для отображения результатов вычислений
 */
class CalculatorPanel extends JPanel{

    public CalculatorPanel(){

        setLayout(new BorderLayout());
        result = 0;
        lastCommand = "=";
        start = true;
        //Включение элемента для отражения результатов
        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        //Размещение кнопок в виде сетки 4х4

        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    /**
     * Включение кнопки в центральную панель.
     * @param label Надпись на кнопке
     * @param listener Обработчик активизации кнопки
     */

    private void addButton(String label, ActionListener listener){

        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);

    }

    /**
     * При обработке события строка, связанная с кнопкой,
     * помещается в конец отображаемого текста.
     */

    private class InsertAction implements ActionListener{

        public void actionPerformed(ActionEvent event){
            String input = event.getActionCommand();
            if (start){
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }

    }

    /**
     * При обработке события выполняется команда,
     * которая определяется строкой, связанной с кнопкой
     */

    private class CommandAction implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String command = event.getActionCommand();
            if (start){
                if (command.equals("-")){
                    display.setText(command);
                    start = false;
                } else lastCommand = command;
                } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    /**
     * Выполнение вычислений
     * @param x Значение, накапливающее предыдущие результаты
     */

    public void calculate(double x){

        if (lastCommand.equals("+")) result += x;
        else if (lastCommand.equals("-")) result -=x;
        else if (lastCommand.equals("*")) result *=x;
        else if (lastCommand.equals("/")) result /=x;
        else if (lastCommand.equals("=")) result =x;
        display.setText(" " + result);
    }

    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;

}
