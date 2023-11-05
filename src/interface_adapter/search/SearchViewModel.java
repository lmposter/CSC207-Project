package interface_adapter.search;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.awt.*;

public class SearchViewModel extends ViewModel {
    public SearchViewModel(){super("Search");}
    private SearchState state = new SearchState();
    public void setState(SearchState state){this.state = state; }
    public SearchState getState() {return state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("", null, this.state);
    }


    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
