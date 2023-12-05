package use_case.create_product;

import entity.Product;
import entity.ProductFactory;
import interface_adapter.API.WalmartAPI;
import use_case.search.SearchDAI;
import use_case.search.SearchInputData;
import use_case.search.SearchOutPutBoundary;
import use_case.search.SearchOutPutData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class CreatePdInteractor implements CreatePdInputBoundary{

    private final CreatePdOutPutBoundary createPdPresenter;
    private final CreatePdDAI createPdDAO;

    public CreatePdInteractor(CreatePdDAI createPdDAO, CreatePdOutPutBoundary createPdPresenter) {
            this.createPdDAO = createPdDAO;
            this.createPdPresenter = createPdPresenter;
        }

        @Override
        public void execute(CreatePdInputData createPdInputData) {
            String username = createPdInputData.getUsername();
            String title = createPdInputData.getTitle();
            String price = createPdInputData.getPrice();
            String inventory = createPdInputData.getInventory();
            String imageUrl = createPdInputData.getImageUrl();
            if (title.isEmpty() || title.length() < 25 || title.length() > 150) {
                createPdPresenter.prepareFailCreateView("Title must be between 25 and 150 characters.");
                return;
            }

            // Validate price
            try {
                Double.parseDouble(price);
            } catch (NumberFormatException e) {
                createPdPresenter.prepareFailCreateView("Price must be a valid number.");
                return;
            }

            // Validate inventory
            try {
                Integer.parseInt(inventory);
            } catch (NumberFormatException e) {
                createPdPresenter.prepareFailCreateView("Inventory must be a valid integer.");
                return;
            }

            // Validate imageURL
            try {
                System.out.println(imageUrl);
                new URL(imageUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                createPdPresenter.prepareFailCreateView("URL not valid.");
                return;
            }
            try {
                ProductFactory pf = new ProductFactory();
                Product pd = pf.create(title, imageUrl, Double.parseDouble(price), Integer.parseInt(inventory));
                createPdDAO.save(pd, username);

                this.createPdPresenter.prepareSuccessCreateView("Created Successfully");
                } catch (RuntimeException e){
                    createPdPresenter.prepareFailCreateView("Creation failed due to unexpected issue.");

        }
}}
