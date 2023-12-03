package view;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * SignupView class representing the user interface for signup operations.
 * It extends JPanel and implements ActionListener and PropertyChangeListener for handling UI events.
 */
public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final RoundedTextField usernameInputField = new RoundedTextField(10);
    private final RoundedPasswordField passwordInputField = new RoundedPasswordField(10);
    private final RoundedPasswordField repeatPasswordInputField = new RoundedPasswordField(10);
    private final SignupController signupController;
    private final JButton guestSignUp;
    private final JButton sellerSignUp;
    private final JButton buyerSignUp;
    private final JButton switchToLogIn;

    /**
     * Constructor for SignupView.
     * Initializes the view components and sets up event listeners.
     *
     * @param controller        The controller handling signup operations.
     * @param signupViewModel   The ViewModel associated with signup.
     */
    public SignupView(SignupController controller, @NotNull SignupViewModel signupViewModel) {
        this.signupController = controller;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);
        Color graphite = new Color(60, 60, 60);
        Color lightBlue = new Color(173, 216, 230);

        this.setBackground(graphite);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBackground(graphite);

        // Title setup
        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(Color.ORANGE);
        title.setBorder(paddingBorder);
        title.setOpaque(true);
        title.setBackground(graphite);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        this.add(title, gbc);

        // Username input field setup
        JLabel usernameLabel = new JLabel(SignupViewModel.USERNAME_LABEL);
        usernameLabel.setForeground(Color.ORANGE);
        LabelTextPanel usernameInfo = new LabelTextPanel(usernameLabel, usernameInputField);
        usernameInfo.setBackground(graphite);
        gbc.gridy++;
        this.add(usernameInfo, gbc);

        // Password input field setup
        JLabel passwordLabel = new JLabel(SignupViewModel.PASSWORD_LABEL);
        passwordLabel.setForeground(Color.ORANGE);
        LabelTextPanel passwordInfo = new LabelTextPanel(passwordLabel, passwordInputField);
        passwordInfo.setBackground(graphite);
        gbc.gridy++;
        this.add(passwordInfo, gbc);

        // Repeat password input field setup
        JLabel repeatPasswordLabel = new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL);
        repeatPasswordLabel.setForeground(Color.ORANGE);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(repeatPasswordLabel, repeatPasswordInputField);
        repeatPasswordInfo.setBackground(graphite);
        gbc.gridy++;
        this.add(repeatPasswordInfo, gbc);

        // Button panel setup
        JPanel buttons = new JPanel(new GridLayout(1, 4, 10, 0));
        buttons.setBorder(paddingBorder);
        buttons.setOpaque(true);
        buttons.setBackground(graphite);

        guestSignUp = new JButton(SignupViewModel.GUEST_SIGNUP_BUTTON_LABEL);
        sellerSignUp = new JButton(SignupViewModel.SELLER_SIGNUP_BUTTON_LABEL);
        buyerSignUp = new JButton(SignupViewModel.BUYER_SIGNUP_BUTTON_LABEL);
        switchToLogIn = new JButton(SignupViewModel.SWITCH_TO_LOGIN);

        // Button styling
        styleButton(guestSignUp, Color.GRAY, Color.BLACK);
        styleButton(sellerSignUp, Color.GRAY, Color.BLACK);
        styleButton(buyerSignUp, Color.GRAY, Color.BLACK);
        styleButton(switchToLogIn, new Color(144, 238, 144), Color.BLACK);

        buttons.add(guestSignUp);
        buttons.add(sellerSignUp);
        buttons.add(buyerSignUp);
        buttons.add(switchToLogIn);

        gbc.gridwidth = 2;
        gbc.gridy++;
        this.add(buttons, gbc);

        // Adding action listeners to buttons
        guestSignUp.addActionListener(this);
        sellerSignUp.addActionListener(this);
        buyerSignUp.addActionListener(this);
        switchToLogIn.addActionListener(this);

        // Adding key listeners to input fields for real-time state updating
        usernameInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                updateState();
            }
        });

        passwordInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                updateState();
            }
        });

        repeatPasswordInputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
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
    private void styleButton(@NotNull JButton button, Color bgColor, Color fgColor) {
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
     * Updates the SignupViewModel's state based on the current input field values.
     */
    private void updateState() {
        SignupState currentState = signupViewModel.getState();
        currentState.setUsername(usernameInputField.getText());
        currentState.setPassword(new String(passwordInputField.getPassword()));
        currentState.setRepeatPassword(new String(repeatPasswordInputField.getPassword()));
        signupViewModel.setState(currentState);
    }

    /**
     * Handles action events from buttons in this view.
     *
     * @param evt The action event.
     */
    @Override
    public void actionPerformed(@NotNull ActionEvent evt) {
        updateState();
        Object source = evt.getSource();
        SignupState currentState = signupViewModel.getState();
        if (source.equals(guestSignUp)) {
            signupController.execute(
                    currentState.getUsername(),
                    currentState.getPassword(),
                    currentState.getRepeatPassword(),
                    "guest"
            );
        } else if (source.equals(sellerSignUp)) {
            signupController.execute(
                    currentState.getUsername(),
                    currentState.getPassword(),
                    currentState.getRepeatPassword(),
                    "seller"
            );
        } else if (source.equals(buyerSignUp)) {
            signupController.execute(
                    currentState.getUsername(),
                    currentState.getPassword(),
                    currentState.getRepeatPassword(),
                    "buyer"
            );
        } else if (source.equals(switchToLogIn)) {
            signupController.switchPage();
        }
    }

    /**
     * Listens for property changes in the SignupViewModel and updates the view accordingly.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(@NotNull PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
        else if (state.getPasswordError() != null) {
            JOptionPane.showMessageDialog(this, state.getPasswordError());
        }
        else if (state.getRepeatPasswordError() != null) {
            JOptionPane.showMessageDialog(this, state.getRepeatPasswordError());
        }
    }
}