package app;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class InitializeProject {

    private final JWindow window;

    public InitializeProject(String imagePath) {
        window = new JWindow();
        window.getContentPane().add(
                new JLabel("", new ImageIcon(imagePath), SwingConstants.CENTER));
        window.setBounds(300, 150, 700, 350);
    }

    public void load(int durationInMilliseconds) {
        window.setVisible(true);
        try {
            Thread.sleep(durationInMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        window.dispose();
    }
}
