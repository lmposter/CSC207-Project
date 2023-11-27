package use_case.switch_page;

public class SwitchPageInteractor implements SwitchPageInputboundary
{

    private final SwitchPageOutputBoundary switchPresenter;

    public SwitchPageInteractor(SwitchPageOutputBoundary switchPresenter)
    {
        this.switchPresenter = switchPresenter;
    }


    @Override
    public void switchPage(SwitchPageInputData switchPageInputData)
    {
        switchPresenter.switchPage(switchPageInputData.getToPage());
    }
}
