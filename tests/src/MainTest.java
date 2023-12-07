package src;

import app.*;
import data_access.ProductDAO;
import data_access.UserDataAccessObject;
import entity.*;
import interface_adapter.orders.*;
import interface_adapter.AllUserPage.buyerPage.BuyerController;
import interface_adapter.AllUserPage.buyerPage.BuyerPresenter;
import interface_adapter.AllUserPage.buyerPage.BuyerViewModel;
import interface_adapter.AllUserPage.guestPage.GuestController;
import interface_adapter.AllUserPage.guestPage.GuestPresenter;
import interface_adapter.AllUserPage.guestPage.GuestViewModel;
import interface_adapter.AllUserPage.sellerPage.SellerController;
import interface_adapter.AllUserPage.sellerPage.SellerPresenter;
import interface_adapter.AllUserPage.sellerPage.SellerViewModel;
import interface_adapter.Create_product.CreatePdController;
import interface_adapter.Create_product.CreatePdPresenter;
import interface_adapter.Create_product.CreatePdState;
import interface_adapter.Create_product.CreatePdViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.orders.OrderViewModel;
import interface_adapter.product.ProductController;
import interface_adapter.product.ProductPresenter;
import interface_adapter.product.ProductState;
import interface_adapter.product.ProductViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.store_page.StorePageViewModel;
import org.junit.jupiter.api.Test;
import use_case.orders.*;
import use_case.allUser.buyerPage.BuyerInteractor;
import use_case.allUser.buyerPage.BuyerOutputBoundary;
import use_case.allUser.guestPage.GuestInteractor;
import use_case.allUser.guestPage.GuestOutputBoundary;
import use_case.allUser.sellerPage.SellerInteractor;
import use_case.allUser.sellerPage.SellerOutputBoundary;
import use_case.create_product.CreatePdInteractor;
import use_case.create_product.CreatePdOutPutBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.productDetails.ProductInteractor;
import use_case.productDetails.ProductOutPutBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutPutBoundary;
import use_case.signup.SignUpUserInteractor;
import use_case.signup.SignUpUserOutputBoundary;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

public class MainTest {
    @Test
    public void mainTest()
    {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("*Amazoff: Buy-Bye Budget* Your #1 Choice for Shopping! ");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        GuestViewModel guestViewModel = new GuestViewModel();
        BuyerViewModel buyerViewModel = new BuyerViewModel();
        SellerViewModel sellerViewModel = new SellerViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        StorePageViewModel storePageViewModel = new StorePageViewModel();
        CreatePdViewModel createPdViewModel = new CreatePdViewModel();
        OrderViewModel orderViewModel = new OrderViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        SearchViewModel searchViewModel = new SearchViewModel();
        ProductViewModel productViewModel = new ProductViewModel();
        try
        {
            File f = new File("empty.csv");
            if (!(f.exists() && !f.isDirectory())) {
                FileWriter fileWriter = new FileWriter("empty.csv");
                String header = "id,title,inventory,URL,price,reviews,seller";
                fileWriter.write(header);
                fileWriter.close();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        ProductDAO pdDAO = new ProductDAO("empty.csv", new ProductFactory());


        UserDataAccessObject userDataAccessObject;

        try
        {
            userDataAccessObject = new UserDataAccessObject(new BuyerFactory(), new SellerFactory());

        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        InitializeProject screen = new InitializeProject("resources/loading.gif");
        screen.load(5);

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, guestViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, buyerViewModel, sellerViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        GuestView guestView = GuestUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, guestViewModel, searchViewModel, orderViewModel, null, null, userDataAccessObject);
        views.add(guestView, guestView.viewName);

        BuyerView buyerView = BuyerUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, buyerViewModel, searchViewModel, orderViewModel, null, null, userDataAccessObject);
        views.add(buyerView, buyerView.viewName);

        SellerView sellerView = SellerUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, sellerViewModel, searchViewModel, orderViewModel, null, storePageViewModel, userDataAccessObject);
        views.add(sellerView, sellerView.viewName);

        SearchView searchView = SearchUseCaseFactory.create(viewManagerModel, searchViewModel, guestViewModel, buyerViewModel, pdDAO);
        views.add(searchView, searchView.viewName);

        StorePageView storePageView = StoreUseCaseFactory.create(storePageViewModel,sellerViewModel, pdDAO, userDataAccessObject);
        views.add(storePageView, storePageView.viewName);

        CreatePdView createPdView = CreatePdUseCaseFactory.create(viewManagerModel, createPdViewModel, pdDAO, sellerViewModel);
        views.add(createPdView, createPdView.viewName);

        OrderView orderView = OrderUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, buyerViewModel, searchViewModel, orderViewModel, null, storePageViewModel, userDataAccessObject);
        views.add(orderView, orderView.viewName);

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
        ShoppingCart shoppingCart = new ShoppingCart();
        GuestFactory guestFactory = new GuestFactory();
        BuyerFactory buyerFactory = new BuyerFactory();
        SellerFactory sellerFactory = new SellerFactory();

        LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, buyerViewModel, sellerViewModel, loginViewModel, signupViewModel);
        LoginInteractor loginInteractor = new LoginInteractor(userDataAccessObject, loginOutputBoundary);
        LoginController loginController = new LoginController(loginInteractor);
        loginController.deactivate("abcnnnn", "123456A!");
        loginController.deactivate("abcnnn", "123456A!");
        SignUpUserOutputBoundary signUpUserOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel, guestViewModel);
        SignUpUserInteractor signUpUserInteractor = new SignUpUserInteractor(userDataAccessObject, signUpUserOutputBoundary, guestFactory,buyerFactory,sellerFactory);
        SignupController signupController = new SignupController(signUpUserInteractor);
        signupController.execute("abcnnnn", "123456A!", "123456A!", "seller");

        signupController.execute("abcnnn", "123456A!", "123456A!", "buyer");

        signupController.execute("abcnn", "123456A!", "123456A!", "guest");
        signupController.switchPage();


        loginController.execute("abcnnnn", "123456A!");
        loginController.execute("abcnnn", "123456A!");
        loginController.switchPage();

        GuestOutputBoundary guestOutputBoundary = new GuestPresenter(signupViewModel, viewManagerModel, guestViewModel, loginViewModel, searchViewModel);
        GuestInteractor guestInteractor = new GuestInteractor(userDataAccessObject, guestOutputBoundary);
        GuestController guestController = new GuestController(guestInteractor);
        guestController.switchPageSearch("abcnnnn");
        guestController.switchPageLogOut();

        BuyerOutputBoundary buyerOutputBoundary = new BuyerPresenter(signupViewModel, viewManagerModel, buyerViewModel, loginViewModel, searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel);
        BuyerInteractor buyerInteractor = new BuyerInteractor(userDataAccessObject, buyerOutputBoundary);
        BuyerController buyerController = new BuyerController(buyerInteractor);
        buyerController.switchPageSearch("abcnnnn");
//        buyerController.switchPageOrder("abcnnnn");
        buyerController.execute("abcnnnn");
        buyerController.switchPageShoppingCart("abcnnnn");
        buyerController.changePassword("abcnnnn", "123456A!");
        buyerController.switchPageStorePage("abcnnnn");
        buyerController.switchPageLogOut();

        SellerOutputBoundary sellerOutputBoundary = new SellerPresenter(signupViewModel, viewManagerModel, sellerViewModel, loginViewModel, searchViewModel, orderViewModel, shoppingCartViewModel, storePageViewModel);
        SellerInteractor sellerInteractor = new SellerInteractor(userDataAccessObject, sellerOutputBoundary);
        SellerController sellerController = new SellerController(sellerInteractor);
        sellerController.switchPageSearch("abcnnn");
//        sellerController.switchPageOrder("abcnnn");
        sellerController.execute("abcnnn");
        sellerController.switchPageShoppingCart("abcnnn");
        sellerController.changePassword("abcnnn", "123456A!");
        sellerController.switchPageStorePage("abcnnn");
        sellerController.switchPageLogOut();



        SearchOutPutBoundary searchOutputBoundary = new SearchPresenter(searchViewModel, viewManagerModel);
        SearchInteractor searchInteractor = new SearchInteractor(pdDAO, searchOutputBoundary);
        SearchController searchController = new SearchController(searchInteractor);
        searchController.execute("bow", "abcnnn");
        searchController.switchPage();

        CreatePdOutPutBoundary createPdOutputBoundary = new CreatePdPresenter(createPdViewModel, viewManagerModel);
        CreatePdInteractor createPdInteractor = new CreatePdInteractor(pdDAO, createPdOutputBoundary);
        CreatePdController createPdController = new CreatePdController(createPdInteractor);
        createPdController.switchPage();
        createPdController.execute("https://i.stack.imgur.com/GsDIl.jpg", "1.1", "1111", "https://i.stack.imgur.com/GsDIl.jpg", "abcnnn");
        Product product = new Product("https://i.stack.imgur.com/GsDIl.jpg", "https://i.stack.imgur.com/GsDIl.jpg", 1.1, 1111);
        storePageView.addProduct(product);

        ProductOutPutBoundary croductDetailsOutputBoundary = new ProductPresenter(viewManagerModel, productViewModel);
        ProductInteractor croductDetailsInteractor = new ProductInteractor(pdDAO, croductDetailsOutputBoundary);
        ProductController croductDetailsController = new ProductController(croductDetailsInteractor);

        croductDetailsController.execute("1");
        //croductDetailsController.buyProduct("abcnnnn", "1", "https://i.stack.imgur.com/GsDIl.jpg", 1.1);

        OrderOutputBoundary orderOutputBoundary = new OrderPresenter(viewManagerModel, buyerViewModel);
        OrderInteractor orderInteractor = new OrderInteractor(userDataAccessObject, orderOutputBoundary);
        OrderController orderController = new OrderController(orderInteractor);
        orderController.findProducts("abcnnn");
        orderController.switchPage();

        loginController.deactivate("abcnnnn", "123456A!");
        loginController.deactivate("abcnnn", "123456A!");

        CreatePdState createPdState = new CreatePdState();
        assert views != null;
    }
}
