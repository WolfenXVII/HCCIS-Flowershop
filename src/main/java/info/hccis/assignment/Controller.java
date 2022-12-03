package info.hccis.assignment;

import info.hccis.assignment.entity.Order;
import info.hccis.util.CisUtility;

/**
 * Main class which controls overall program flow and implements a menu.
 *
 * @author Noel Spurrell
 * @since 20221122
 */
public class Controller {

    public static final int EXIT = 0;
    
    public static final String MENU = "Main Menu" + System.lineSeparator()
            + "1 - Add an order" + System.lineSeparator()
            + "2 - Show total of all orders since program start" + System.lineSeparator()
            + "0 - Exit" + System.lineSeparator();

    private static double costOfAllOrders = 0;
    private static double total;

    public static void main(String[] args) {

        Order.showBusinessInformation();

        int option = 1;
        while (option != EXIT) {
            option = CisUtility.getInputInt(MENU);
            switch (option) {
                case 1:
                    addOrder(total);
                    break;
                case 2:
                    showCostOfAllOrders();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid option\n");
            }
        }
    }

    /**
     * Allow the user to create an order using the Order class.
     *
     * @param total
     * @return cost
     * @author Noel Spurrell
     * @since 20221122
     */
    public static double addOrder(double total) {

        Order order = new Order();
        order.getInformation();
        double cost = order.getTotal(total);
        costOfAllOrders += cost;
        order.display();

    return cost;
    }

    /**
     * Shows the cost of all orders created since the program start.
     *
     * @author Noel Spurrell
     * @since 20221122
     */
    public static void showCostOfAllOrders() {
        System.out.println("Total so far: " + CisUtility.toCurrency(costOfAllOrders)+"\n");

    }

}
