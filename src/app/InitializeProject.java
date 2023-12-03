package app;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 * The InitializeProject class is responsible for displaying a splash screen image during the project initialization.
 */
public class InitializeProject {

    private final JWindow window;

    /**
     * Initializes the InitializeProject object with a specified image path.
     *
     * @param imagePath The path to the image to be displayed in the splash screen.
     */
    public InitializeProject(String imagePath) {
        window = new JWindow();
        window.getContentPane().add(
                new JLabel("", new ImageIcon(imagePath), SwingConstants.CENTER));
        window.setBounds(300, 150, 700, 350);
    }

    /**
     * Displays the splash screen for a specified duration in milliseconds and then closes it.
     *
     * @param durationInMilliseconds The duration for which the splash screen will be displayed.
     */
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