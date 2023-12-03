package interface_adapter.add_to_cart;

import com.sun.corba.se.spi.ior.iiop.AlternateIIOPAddressComponent;
import use_case.add_to_cart.AddInputBoundary;
import use_case.add_to_cart.AddInputData;

public class AddController
{
    AddInputBoundary addInteractor;

    public AddController(AddInputBoundary addInteractor)
    {
        this.addInteractor = addInteractor;
    }

    public void execute(String username, String id)
    {
        AddInputData input = new AddInputData(username, id);
        addInteractor.execute(input);
    }
}
