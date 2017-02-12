package UILayer;
import ControlLayer.*;
public class OrderUI extends UIInputClass{
    private OrderCtrl ordCtrl;
    private EmployeeUI empUI;
    private CustomerCtrl custCtrl;
    /**
     * Constructor for objects of class OrderUI
     */
    OrderUI(){
        ordCtrl = new OrderCtrl();
        empUI = new EmployeeUI();
        custCtrl = new CustomerCtrl();
    }

    protected String findOrder(){
        if(!ordCtrl.getOrders().isEmpty()){
            System.out.println("Write the id of the order");
            String str = inputNotRestrictedString();
            if(ordCtrl.findTrade(str) != null){
                System.out.println(ordCtrl.findTrade(str));
                return str;
            }else{
                System.out.println("No order with that id");
            }
        }else{
            System.out.println("No orders");
        }
        return null;
    }

    /**
     * Registration of a customer order
     */
    protected void RegisterOrder(){
        empUI.makesale();
        System.out.println("To send the products to the customer's address (y) / (n)");
        String string = inputNotRestrictedString();
        String str =empUI.getCurrentPerson();
        if(empUI.checkIfY(string)){
            System.out.println("The products will be send to " + custCtrl.findCustomer(str).getName() + " with address " +custCtrl.findCustomer(str).getAddress());
        }else{
            System.out.println("Write an id for the order");
            String id = inputNotRestrictedString();
            ordCtrl.newOrder(empUI.getTotalPrice(),empUI.applyDiscount(),empUI.getCurrentPerson(),empUI.getCurrentEmployee(),id);
            System.out.println("The order has been saved under the id of " + id);
        }
    }

    protected void StartOrderMenu(){
        boolean finished = false;

        while(!finished){
            int choice = writeOrderMenu();
            if (choice ==1){
                RegisterOrder();
            }else if(choice == 2){
                findOrder();
            }else if(choice == 3){
                activateOrder();
            }else if(choice ==4){
                System.out.println(ordCtrl.getOrders());
            }else if(choice ==5){
                finished = true;
            }else{
                newLine();
            }
        }
    }

    private void activateOrder(){
        String str = findOrder();
        if(str != null){
            ordCtrl.findTrade(str);
            if(empUI.payment()){
                ordCtrl.removeTrade(str);
                ordCtrl.storeTradeInFile(ordCtrl.getFilename(),ordCtrl.getOrders());
            }
        }
    }

    private int writeOrderMenu(){
        System.out.println("To registrate order (1)");
        System.out.println("To find order (2) ");
        System.out.println("To make order active (3) ");
        System.out.println("To see all orders (4) ");
        System.out.println("To go back (5)");
        return inputInteger();
    }

}
