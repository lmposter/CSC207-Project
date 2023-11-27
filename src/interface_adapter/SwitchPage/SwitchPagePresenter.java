package interface_adapter.SwitchPage;

import interface_adapter.ViewManagerModel;
import use_case.switch_page.SwitchPageOutputBoundary;

public class SwitchPagePresenter implements SwitchPageOutputBoundary
{
    private final ViewManagerModel viewManagerModel;

    public SwitchPagePresenter(ViewManagerModel viewManagerModel)
    {
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void switchPage(String page)
    {
        viewManagerModel.setActiveView(page);
        viewManagerModel.firePropertyChanged();
    }
}
