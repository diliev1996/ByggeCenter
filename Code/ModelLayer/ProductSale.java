package ModelLayer;
import java.util.ArrayList;
public class ProductSale extends Trade {
    private ArrayList products;
    public ProductSale(double price,int discount, String custID, String empID, String id) {
        super(0,discount,custID,empID,id);
    }

}
