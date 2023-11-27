package use_case.CheckOut;

import entity.LoginUser;

public interface CheckOutUserDataAccessInterface
{
        //get the user
        LoginUser get(String username);

        void clearCart(String username);

}
