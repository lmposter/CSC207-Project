package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * LoginView class representing the user interface for login operations.
 * It extends JPanel and implements ActionListener and PropertyChangeListener for handling UI events.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener
{
    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    private final RoundedTextField usernameInputField = new RoundedTextField(10);
    private final RoundedPasswordField passwordInputField = new RoundedPasswordField(10);
    private final JButton logInButton;
    private final JButton cancelButton;
    private final JButton deactivateButton;
    private final LoginController loginController;

    /**
     * Constructor for LoginView.
     * Initializes the view components and sets up event listeners.
     *
     * @param loginViewModel The ViewModel associated with login.
     * @param controller     The controller handling login operations.
     */
    public LoginView(@NotNull LoginViewModel loginViewModel, LoginController controller)
    {
        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);
        Color graphite = new Color(60, 60, 60);
        Color lightBlue = new Color(173, 216, 230);

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBackground(graphite);

        JLabel title = createLabel(LoginViewModel.TITLE_LABEL, graphite, Color.ORANGE, 24);
        title.setBorder(paddingBorder);

        // Layout configuration for title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(title, gbc);

        // Username input field setup
        JLabel usernameLabel = new JLabel(LoginViewModel.USERNAME_LABEL);
        usernameLabel.setForeground(Color.ORANGE);
        LabelTextPanel usernameInfo = new LabelTextPanel(usernameLabel, usernameInputField);
        usernameInfo.setBackground(graphite);
        gbc.gridy++;
        this.add(usernameInfo, gbc);

        // Password input field setup
        JLabel passwordLabel = new JLabel(LoginViewModel.PASSWORD_LABEL);
        passwordLabel.setForeground(Color.ORANGE);
        LabelTextPanel passwordInfo = new LabelTextPanel(passwordLabel, passwordInputField);
        passwordInfo.setBackground(graphite);
        gbc.gridy++;
        this.add(passwordInfo, gbc);

        // Button panel setup
        JPanel buttons = new JPanel(new GridLayout(1, 3, 10, 0));
        buttons.setBorder(paddingBorder);
        buttons.setBackground(graphite);

        logInButton = new JButton(loginViewModel.LOGIN_BUTTON_LABEL);
        cancelButton = new JButton(loginViewModel.CANCEL_BUTTON_LABEL);
        deactivateButton = new JButton(loginViewModel.DEACTIVATE_BUTTON_LABEL);

        styleButton(logInButton, lightBlue, Color.BLACK);
        styleButton(cancelButton, Color.GRAY, Color.BLACK);
        styleButton(deactivateButton, new Color(255, 102, 102), Color.BLACK);

        buttons.add(logInButton);
        buttons.add(cancelButton);
        buttons.add(deactivateButton);

        gbc.gridwidth = 2;
        gbc.gridy++;
        this.add(buttons, gbc);

        // Adding action listeners to buttons
        logInButton.addActionListener(this);
        cancelButton.addActionListener(this);
        deactivateButton.addActionListener(this);

        // Adding key listeners to input fields for real-time state updating
        usernameInputField.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                updateState();
            }
        });

        passwordInputField.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
                updateState();
            }
        });
    }

    /**
     * Styles a JButton with specified colors and fonts.
     *
     * @param button  The JButton to style.
     * @param bgColor Background color of the button.
     * @param fgColor Foreground (text) color of the button.
     */
    private void styleButton(@NotNull JButton button, Color bgColor, Color fgColor)
    {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        Border line = BorderFactory.createLineBorder(Color.ORANGE, 1);
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
        button.setBorder(BorderFactory.createCompoundBorder(line, compound));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
    }

    /**
     * Creates a JLabel with specified text, background, foreground color, and font size.
     *
     * @param text     The text for the label.
     * @param bg       The background color of the label.
     * @param fg       The foreground (text) color of the label.
     * @param fontSize The font size of the label.
     * @return The styled JLabel.
     */
    @NotNull
    private JLabel createLabel(String text, Color bg, Color fg, int fontSize)
    {
        JLabel label = new JLabel(text);
        label.setForeground(fg);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        if (bg != null)
        {
            label.setOpaque(true);
            label.setBackground(bg);
        }
        return label;
    }

    /**
     * Updates the LoginViewModel's state based on the current input field values.
     */
    private void updateState()
    {
        LoginState currentState = loginViewModel.getState();
        currentState.setUsername(usernameInputField.getText());
        currentState.setPassword(new String(passwordInputField.getPassword()));
        loginViewModel.setState(currentState);
    }

    /**
     * Handles action events from buttons in this view.
     *
     * @param evt The action event.
     */
    @Override
    public void actionPerformed(@NotNull ActionEvent evt)
    {
        updateState();
        Object source = evt.getSource();
        if (source.equals(logInButton))
        {
            loginController.execute(loginViewModel.getState().getUsername(), loginViewModel.getState().getPassword());
        } else if (source.equals(cancelButton))
        {
            loginController.switchPage();
        } else if (source.equals(deactivateButton))
        {
            loginController.deactivate(loginViewModel.getState().getUsername(), loginViewModel.getState().getPassword());
        }
    }

    /**
     * Listens for property changes in the LoginViewModel and updates the view accordingly.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(@NotNull PropertyChangeEvent evt)
    {
        LoginState state = (LoginState) evt.getNewValue();
        if (state != null)
        {
            usernameInputField.setText(state.getUsername());
        }
    }
}
