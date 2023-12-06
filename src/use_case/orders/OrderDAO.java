package use_case.orders;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface OrderDAO {
    List<String[]> getProducts(String username);
}
