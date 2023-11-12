package use_case.signup;

import entity.User;
import entity.SellerFactory;
import entity.BuyerFactory;
public class SignUpInteractor implements SignUpInputBoundary {
    final SignUpDataAccessInterface userDataAccessObject;
    final SignUpOutputBoundary userPresenter;
    final BuyerFactory buyerFactory;

    final SellerFactory sellerFactory;

    public SignUpInteractor(SignUpDataAccessInterface signupDataAccessInterface,
                            SignUpOutputBoundary signupOutputBoundary,
                            BuyerFactory buyerFactory,
                            SellerFactory sellerFactory) {
        this.userDataAccessObject = signupDataAccessInterface;
        this.userPresenter = signupOutputBoundary;
        this.buyerFactory = buyerFactory;
        this.sellerFactory = sellerFactory;
    }

    @Override
    public void execute(SignUpInputData signupInputData) {
        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else if (signupInputData.getSignType().equals("seller")){
            User user = sellerFactory.create(signupInputData.getUsername(), signupInputData.getPassword());
            userDataAccessObject.save(user);
            SignUpOutputData signupOutputData = new SignUpOutputData(user.getName(),  false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
        else {
            User user = buyerFactory.create(signupInputData.getUsername(), signupInputData.getPassword());
            userDataAccessObject.save(user);
            SignUpOutputData signupOutputData = new SignUpOutputData(user.getName(),  false);
            userPresenter.prepareSuccessView(signupOutputData);
        }
    }
}