package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
public class TempLabelTextPanel extends JPanel {
    public TempLabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}