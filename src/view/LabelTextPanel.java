package view;

import javax.swing.*;
import java.awt.*;

public class LabelTextPanel extends JPanel {
    private JLabel label;
    private JTextField textField;

    public LabelTextPanel(JLabel label, JTextField textField) {
        this.label = label;
        this.textField = textField;
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        addComponents();
    }

    private void addComponents() {
        this.add(label);
        this.add(Box.createRigidArea(new Dimension(5, 0)));
        this.add(textField);
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getTextField() {
        return textField;
    }
}