package Chapter5Ex6_5;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

/**
 * часы, выводящие показания времени
 * через определенный интервал
 */

class TalkingClock{
    /**
     * Запуск часов
     * @param interval Интервал времени в миллисекундах
     *                 между сообщениями
     * @param beep Значение true включает звуковой сигнал
     */
    public void start(int interval, final boolean beep){
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
