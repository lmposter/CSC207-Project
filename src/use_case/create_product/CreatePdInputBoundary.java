package use_case.create_product;

public interface CreatePdInputBoundary
{
    void execute(CreatePdInputData createPdInputData);

    void switchPage();
}
