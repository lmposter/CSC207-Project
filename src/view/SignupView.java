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


public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final RoundedTextField usernameInputField = new RoundedTextField(15);
    private final RoundedPasswordField passwordInputField = new RoundedPasswordField (15);
    private final RoundedPasswordField repeatPasswordInputField = new RoundedPasswordField (15);
    private final SignupController signupController;
    private final JButton guestSignUp;
    private final JButton sellerSignUp;
    private final JButton buyerSignUp;
    private final JButton switchToLogIn;

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

        JLabel usernameLabel = new JLabel(SignupViewModel.USERNAME_LABEL);
        usernameLabel.setForeground(Color.ORANGE);
        LabelTextPanel usernameInfo = new LabelTextPanel(usernameLabel, usernameInputField);
        usernameInfo.setBackground(graphite);
        gbc.gridy++;
        this.add(usernameInfo, gbc);

        JLabel passwordLabel = new JLabel(SignupViewModel.PASSWORD_LABEL);
        passwordLabel.setForeground(Color.ORANGE);
        LabelTextPanel passwordInfo = new LabelTextPanel(passwordLabel, passwordInputField);
        passwordInfo.setBackground(graphite);
        gbc.gridy++;
        this.add(passwordInfo, gbc);

        JLabel repeatPasswordLabel = new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL);
        repeatPasswordLabel.setForeground(Color.ORANGE);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(repeatPasswordLabel, repeatPasswordInputField);
        repeatPasswordInfo.setBackground(graphite);
        gbc.gridy++;
        this.add(repeatPasswordInfo, gbc);



        JPanel buttons = new JPanel(new GridLayout(1, 4, 10, 0));
        buttons.setBorder(paddingBorder);
        buttons.setOpaque(true);
        buttons.setBackground(graphite);
        usernameInfo.setBackground(graphite);
        passwordInfo.setBackground(graphite);
        repeatPasswordInfo.setBackground(graphite);

        // Set the background for each text field
        usernameInputField.setBackground(Color.white.brighter());
        passwordInputField.setBackground(Color.white.brighter());
        repeatPasswordInputField.setBackground(Color.white.brighter());

        guestSignUp = new JButton(SignupViewModel.GUEST_SIGNUP_BUTTON_LABEL);
        sellerSignUp = new JButton(SignupViewModel.SELLER_SIGNUP_BUTTON_LABEL);
        buyerSignUp = new JButton(SignupViewModel.BUYER_SIGNUP_BUTTON_LABEL);
        switchToLogIn = new JButton(SignupViewModel.SWITCH_TO_LOGIN);

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

        guestSignUp.addActionListener(this);
        sellerSignUp.addActionListener(this);
        buyerSignUp.addActionListener(this);
        switchToLogIn.addActionListener(this);

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

    private void styleButton(@NotNull JButton button, Color bgColor, Color fgColor) {
        Color lightBlue = new Color(173, 216, 230);
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


    private void updateState() {
        SignupState currentState = signupViewModel.getState();
        currentState.setUsername(usernameInputField.getText());
        currentState.setPassword(new String(passwordInputField.getPassword()));
        currentState.setRepeatPassword(new String(repeatPasswordInputField.getPassword()));
        signupViewModel.setState(currentState);
    }

    public void actionPerformed(@NotNull ActionEvent evt) {
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