package view;

import interface_adapter.AllUserPage.sellerPage.SellerViewModel;
import interface_adapter.Create_product.CreatePdController;
import interface_adapter.Create_product.CreatePdState;
import interface_adapter.Create_product.CreatePdViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import interface_adapter.signup.SignupState;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;

public class CreatePdView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Create Product";
    private final CreatePdController createPdController;
    private final CreatePdViewModel createPdViewModel;

    private final SellerViewModel sellerViewModel;
    private final JPanel mainPanel;
    private JTextField titleField = new JTextField(50);
    private JTextField priceField = new JTextField(50);
    private JTextField inventoryField = new JTextField(50);
    private JTextField imageUrlField = new JTextField(50);
    private JButton createButton;

    public CreatePdView(CreatePdController controller, CreatePdViewModel createPdViewModel, SellerViewModel sellerViewModel) {
        this.createPdController = controller;
        this.createPdViewModel = createPdViewModel;
        this.sellerViewModel = sellerViewModel;
        this.mainPanel = new JPanel();

        createPdViewModel.addPropertyChangeListener(this);
        setSize(400, 300);
        setLayout(new GridLayout(0, 2, 10, 10));

        // Add components
        addComponents(controller);

        priceField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreatePdState currentState = createPdViewModel.getState();
                        String text = priceField.getText() + e.getKeyChar();
                        currentState.setPrice(text);
                        createPdViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        imageUrlField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreatePdState currentState = createPdViewModel.getState();
                        String text = imageUrlField.getText() + e.getKeyChar();
                        currentState.setUrl(text);
                        createPdViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        inventoryField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreatePdState currentState = createPdViewModel.getState();
                        String text = inventoryField.getText() + e.getKeyChar();
                        currentState.setInventory(text);
                        createPdViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
        titleField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        CreatePdState currentState = createPdViewModel.getState();
                        String text = titleField.getText() + e.getKeyChar();
                        currentState.setTitle(text);
                        createPdViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        // Set visible
        setVisible(true);
    }

    private void addComponents(CreatePdController controller) {
        // Labels and TextFields
        add(new JLabel("Product Title:"));
        titleField = new JTextField(20);
        add(titleField);

        add(new JLabel("Price:"));
        priceField = new JTextField(20);
        add(priceField);

        add(new JLabel("Inventory:"));
        inventoryField = new JTextField(20);
        add(inventoryField);

        add(new JLabel("Image URL:"));
        imageUrlField = new JTextField(20);
        add(imageUrlField);

        // Create button
        createButton = new JButton("Create Now");
        createButton.addActionListener(this);

        add(createButton);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        CreatePdState currentState = createPdViewModel.getState();

        if (source.equals(createButton)) {
            createPdController.execute(
                    currentState.getTitle(),
                    currentState.getPrice(),
                    currentState.getInventory(),
                    currentState.getUrl(),
                    sellerViewModel.getState().getUsername()
            );
        }
        JFrame frame = new JFrame(CreatePdViewModel.AFTER_VIEW_PANEL_LABEL);
        frame.setSize(600, 400);
        JLabel message = new JLabel(createPdViewModel.getState().getMessage());
        frame.add(message);
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        CreatePdState state = (CreatePdState) e.getNewValue();
//        if (state.getTitleError() != null) {
//            JOptionPane.showMessageDialog(this, state.getMessage());
//        }
//        else if (state.getPriceError() != null) {
//            JOptionPane.showMessageDialog(this, state.getMessage());
//        }
//        else if (state.getInventoryError() != null) {
//            JOptionPane.showMessageDialog(this, state.getMessage());
//        }else if (state.getUrlError() != null) {
//            JOptionPane.showMessageDialog(this, state.getMessage());
//        }else{
//            JOptionPane.showMessageDialog(this, state.getMessage());
//        }

    }

    //TODO: it saves the product several times instead of just once
}
