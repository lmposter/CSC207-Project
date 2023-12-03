package interface_adapter.create_product;


import use_case.create_product.CreatePdInputBoundary;
import use_case.create_product.CreatePdInputData;

public class CreatePdController {
    CreatePdInputBoundary createPdUseCaseInteractor;
    public CreatePdController(CreatePdInputBoundary createPdUseCaseInteractor){
        this.createPdUseCaseInteractor = createPdUseCaseInteractor;
    }

    public void execute(String title, String price, String inventory, String imageUrl) {


        CreatePdInputData createPdInputData = new CreatePdInputData(title, price,
                inventory, imageUrl);
        createPdUseCaseInteractor.execute(createPdInputData);
    }

}
