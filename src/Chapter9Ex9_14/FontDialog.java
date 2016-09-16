package Chapter9Ex9_14;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FontDialog {
    public static void main(String[] args) {

    }
}

/**
 * Фрейм. в котором диспетчер компоновки GridBagLayout
 * использован для выравнивания компонентов,
 * предназначенных для выбора шрифта.
 */
class FontDialogFrame extends JFrame{

    public FontDialogFrame(){
//        setTitle("FontDialog");
//        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//
//        GridBagLayout layout = new GridBagLayout();
//        setLayout(layout);
//
//        ActionListener listener = new FontAction();
//
//        //Создание компонентов.
//        JLabel faceLabel = new JLabel("Face: ");
//        face = new JComboBox(new String[]{
//                "Serif", "SansSerif", "Monospaced",
//                "Dialog", "DialogInput"
//        });
//
//        face.addActionListener(listener);
//        JLabel sizeLabel = new JLabel("Size: ");
//        size = new JComboBox(new String[]{
//                "8", "10", "12", "15", "18", "24", "36", "48"
//        });
//        size.addActionListener(listener);
//
//        bold = new JCheckBox("Bold");
//        bold.addActionListener(listener);
//
//        italic = new JCheckBox("Italic");
//        italic.addActionListener(listener);
//
//        sample = new JTextArea();
//        sample.setText("the quick brown fox jumps over the lazy dog");
//        sample.setEditable(false);
//        sample.setLineWrap(true);
//        sample.setBorder(BorderFactory.createEtchedBorder());
//        //Размещение компонентов с помощью класса GBC.
//        add(faceLabel, new GridBagConstraints(0,0).setAnchor(GridBagConstraints.EAST));
//        add(face, new GridBagConstraints(1,0).setFill(GridBagConstraints.HORIZONTAL).setWeight(100,1).setInsets(1));
//        add(sizeLabel, new GridBagConstraints(0,1).setAnchor(GridBagConstraints.EAST));
//        add(size, new GridBagConstraints(1,1).setFill(GridBagConstraints.HORIZONTAL).setWeight(100,0).setInsets(1));
//        add(bold, new GridBagConstraints(0,2,2,1).setAnchor(GridBagConstraints.CENTER).setWeight(100,100));
//        add(sample, new GridBagConstraints(2,0,1,4).setFill(GridBagConstraints.BOTH).setWeight(100,100));

    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    private JComboBox face;
    private JComboBox size;
    private JCheckBox bold;
    private JCheckBox italic;
    private JTextArea sample;

}


