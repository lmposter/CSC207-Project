package use_case.orders;

import entity.Product;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import java.util.ArrayList;
import java.util.List;

public interface OrderDAO {
    List<String[]> getProducts(String username);

    void execute(OrderInputData orderInputData);
}
