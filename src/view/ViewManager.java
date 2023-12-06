package view;

import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private ViewManagerModel viewManagerModel;

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();
            if (viewModelName.equals("Store Page")) {
                Component activeComponent = views.getComponent(6); // Assuming Store Page is the sixth component
                if (activeComponent instanceof StorePageView) {
                    ((StorePageView) activeComponent).refreshView();
                }
            }
            if (viewModelName.equals("Order")) {
                Component activeComponent = views.getComponent(8); // Assuming Store Page is the sixth component
                if (activeComponent instanceof OrderView) {
                    ((OrderView) activeComponent).initComponents(true);
                }
            }
            cardLayout.show(views, viewModelName);
        }

    }
}
