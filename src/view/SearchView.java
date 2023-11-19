package view;

import interface_adapter.search.SearchViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search";

    private final SearchViewModel searchViewModel;
    private final JTextField searchInputField = new JTextField(100);
    private final SearchController searchController;

    private final JButton goSearch;


    public SearchView(SearchController controller, SearchViewModel searchViewModel) {
//TODO:add Product pages showing all the products found
        this.searchController = controller;
        this.searchViewModel = searchViewModel;
        searchViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(SearchViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel contentToSearch = new LabelTextPanel(
                new JLabel(SearchViewModel.SEARCH_LABEL), searchInputField);

        JPanel buttons = new JPanel();
        goSearch = new JButton(SearchViewModel.SEARCH_BUTTON_LABEL);
        buttons.add(goSearch);


        goSearch.addActionListener(
               new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(goSearch)) {
                            SearchState currentState = searchViewModel.getState();

                            searchController.execute(currentState.getContent());
                        }
                    }
                }
        );

        searchInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SearchState currentState = searchViewModel.getState();
                        String text = searchInputField.getText() + e.getKeyChar();
                        currentState.setContent(text);
                        searchViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(contentToSearch);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SearchState state = (SearchState) evt.getNewValue();
        if (state.getProductsError() == null){

        }
    }
}
