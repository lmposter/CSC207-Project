package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

// Custom text field with rounded corners
class RoundedTextField extends JTextField {
    private Shape shape;
    private final int borderThickness = 2;

    public RoundedTextField(int size) {
        super(size);
        setOpaque(false); // Makes the background of the text field transparent.
    }

    // Custom painting for the text field's background
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    // Custom painting for the text field's border
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(borderThickness)); // Set the border thickness
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    // Check if a point is within the rounded rectangle shape
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}

// Custom password field with rounded corners
class RoundedPasswordField extends JPasswordField {
    private Shape shape;
    private final int borderThickness = 2;

    public RoundedPasswordField(int size) {
        super(size);
        setOpaque(false); // Makes the background of the password field transparent.
    }

    // Custom painting for the password field's background
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        super.paintComponent(g);
    }

    // Custom painting for the password field's border
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(borderThickness)); // Set the border thickness
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

    // Check if a point is within the rounded rectangle shape
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
        }
        return shape.contains(x, y);
    }
}