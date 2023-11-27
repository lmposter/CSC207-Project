package interface_adapter.SwitchPage;

import use_case.switch_page.SwitchPageInputData;
import use_case.switch_page.SwitchPageInputboundary;

public class SwitchPageController
{
    private final SwitchPageInputboundary switchInteractor;

    public SwitchPageController(SwitchPageInputboundary switchInteractor)
    {
        this.switchInteractor = switchInteractor;
    }

    public void switchToStore()
    {
        SwitchPageInputData input = new SwitchPageInputData("Store");
        this.switchInteractor.switchPage(input);
    }

    public void switchToPersonal()
    {
        SwitchPageInputData input = new SwitchPageInputData("Personal Page");
        this.switchInteractor.switchPage(input);
    }

    public void switchToCart()
    {
        SwitchPageInputData input = new SwitchPageInputData("Shopping Cart");
        this.switchInteractor.switchPage(input);
    }
}
