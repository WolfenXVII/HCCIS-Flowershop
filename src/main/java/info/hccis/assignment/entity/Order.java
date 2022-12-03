package info.hccis.assignment.entity;

import info.hccis.util.CisUtility;

/**
 * Represents an order
 *
 * @author Noel Spurrell
 * @since 20221101
 * 
 * @modified 20221122 NS - added looping to getInformation() method, commented out unused code
 */
public class Order {

    public static final String BUSINESS_NAME = "Bernadette's Flowers";

    public static final double WELCOME_BABY_BOY_COST = 90.0;
    public static final double WELCOME_BABY_GIRL_COST = 85.0;
    public static final double VERY_SPECIAL_DELIVERY_COST = 100.0;

    public static final double TAXES_RATE = 0.15;

    private int welcomeBabyBoy;
    private int welcomeBabyGirl;
    private int verySpecialDelivery;
    private int stuffedAnimalCode;

    public Order() {
        //default constructor
    }

    public Order(int welcomeBabyBoy, int welcomeBabyGirl, int verySpecialDelivery, int stuffedAnimalCode) {
        //custom constructor
        this.welcomeBabyBoy = welcomeBabyBoy;
        this.welcomeBabyGirl = welcomeBabyGirl;
        this.verySpecialDelivery = verySpecialDelivery;
        this.stuffedAnimalCode = stuffedAnimalCode;
    }

    /**
     * Shows the Business Information
     *
     * @author Noel Spurrell
     * @since 20221101
     */
    public static void showBusinessInformation() {
        //shows the business information
        System.out.println(BUSINESS_NAME + "\n25 Hopeton Road\nStratford, PE\nC1B 1H6" + System.lineSeparator());
    }

    public void getInformation() {
        //prompts and validates user input

        //welcomeBabyBoy prompt and validation
        do {
            welcomeBabyBoy = CisUtility.getInputInt("How many Welcome Baby Boy bouquets would you like?: \n");
            if (welcomeBabyBoy < 0 || welcomeBabyBoy > 20) {
                System.out.println("Invalid amount, please enter a number between 0-20");
            }
        } while (welcomeBabyBoy < 0 || welcomeBabyBoy > 20);

        //welcomeBabyGirl prompt and validation
        do {
            welcomeBabyGirl = CisUtility.getInputInt("How many Welcome Baby Girl bouquets would you like?: \n");
            if (welcomeBabyGirl < 0 || welcomeBabyGirl > 20) {
                System.out.println("Invalid amount, please enter a number between 0-20");
            }
        } while (welcomeBabyGirl < 0 || welcomeBabyGirl > 20);

        //verySpecialDelivery prompt and validation
        do {
            verySpecialDelivery = CisUtility.getInputInt("How many Very Special Delivery bouquets would you like?: \n");
            if (verySpecialDelivery < 0 || verySpecialDelivery > 20) {
                System.out.println("Invalid amount, please enter a number between 0-20");
            }
        } while (verySpecialDelivery < 0 || verySpecialDelivery > 20);

        //stuffedAnimalCode prompt and validation
        do {
            stuffedAnimalCode = CisUtility.getInputInt("Stuffed animal option (1=Small 2=Medium 3=Large 0=None): \n");
            if (stuffedAnimalCode < 0 || stuffedAnimalCode > 3) {
                System.out.println("Invalid code, please enter a number between 0-3");
            }
        } while (stuffedAnimalCode < 0 || stuffedAnimalCode > 3);
    }
    
        //    /**
        //     * Validates the inputted number using if statements
        //     *
        //     * @author Noel Spurrell
        //     * @param x
        //     * @param y
        //     * @return
        //     * @since 20221110
        //     */
        //    public int validateQuantities(int x, String y) {
        //        //ensures a valid quantity has been entered for the number of wanted bouquets
        //        if (x >= 0) {
        //        } else {
        //            System.out.println("ERROR: Invalid number entered for " + y + ", value has been set to 0");
        //            x = 0;
        //        }
        //        return x;
        //    }
        //
        //    public int validateCode(int x, String y) {
        //        //ensures a valid number has been entered for stuffedAnimalCode
        //        if (x >= 0 && x <= 3) {
        //        } else {
        //            System.out.println("ERROR: Invalid code entered for " + y + ", value has been set to 0");
        //            x = 0;
        //        }
        //        return x;
        //    }
    
        /**
         * Calculates the subtotal
         *
         * @author Noel Spurrell
         * @since 20221101
         * @return
         */
    public double getSubtotal() {
        //returns the subtotal of the order
        double subtotal = (welcomeBabyBoy * WELCOME_BABY_BOY_COST)
                + (welcomeBabyGirl * WELCOME_BABY_GIRL_COST)
                + (verySpecialDelivery * VERY_SPECIAL_DELIVERY_COST);
        switch (stuffedAnimalCode) {
            case 0:
                break;
            case 1:
                subtotal += 10.0;
                break;
            case 2:
                subtotal += 20.0;
                break;
            case 3:
                subtotal += 30.0;
                break;
        }

        return subtotal;
    }

    /**
     * Calculates tax amount
     *
     * @author Noel Spurrell
     * @since 20221101
     * @return
     */
    public double getTax() {
        //returns the subtotal multiplied by the tax rate
        double tax = getSubtotal() * TAXES_RATE;

        return tax;
    }

    /**
     * Calculates the total with taxes included
     *
     * @author Noel Spurrell
     * @param total
     * @since 20221101
     * @return
     */
    public double getTotal(double total) {
        //returns the sum of the subtotal and the tax amount
        total = getSubtotal() + getTax();

        return total;
    }

    //getters and setters
    public int getWelcomeBabyBoy() {
        return welcomeBabyBoy;
    }

    public void setWelcomeBabyBoy(int welcomeBabyBoy) {
        this.welcomeBabyBoy = welcomeBabyBoy;
    }

    public int getWelcomeBabyGirl() {
        return welcomeBabyGirl;
    }

    public void setWelcomeBabyGirl(int welcomeBabyGirl) {
        this.welcomeBabyGirl = welcomeBabyGirl;
    }

    public int getVerySpecialDelivery() {
        return verySpecialDelivery;
    }

    public void setVerySpecialDelivery(int verySpecialDelivery) {
        this.verySpecialDelivery = verySpecialDelivery;
    }

    public int getStuffedAnimalCode() {
        return stuffedAnimalCode;
    }

    public void setStuffedAnimalCode(int stuffedAnimalCode) {
        this.stuffedAnimalCode = stuffedAnimalCode;
    }

    @Override
    public String toString() {
        //outputs the order summary

        //Quantity and Code verification using if statements
//        System.out.println("\n");
//        this.welcomeBabyBoy = validateQuantities(welcomeBabyBoy, "Welcome Baby Boy");
//        this.welcomeBabyGirl = validateQuantities(welcomeBabyGirl, "Welcome Baby Girl");
//        this.verySpecialDelivery = validateQuantities(verySpecialDelivery, "Very Special Delivery");
//        this.stuffedAnimalCode = validateCode(stuffedAnimalCode, "Stuffed Animal");
        double total = 0;
        total = getTotal(total);

        String largeOrder = "";
        if (total < 500) {
        } else {
            largeOrder += "(Large Order!)";
        }

        String stuffedAnimalSize = "";
        switch (stuffedAnimalCode) {
            case 0:
                stuffedAnimalSize = "None";
                break;
            case 1:
                stuffedAnimalSize = "Small";
                break;
            case 2:
                stuffedAnimalSize = "Medium";
                break;
            case 3:
                stuffedAnimalSize = "Large";
                break;
        }

        return "\nOrder Summary " + largeOrder
                + "\nNumber of Welcome Baby Boy bouquets: " + welcomeBabyBoy
                + "\nNumber of Welcome Baby Girl bouquets: " + welcomeBabyGirl
                + "\nNumber of Very Special Delivery bouquets: " + verySpecialDelivery
                + "\nStuffed Animal: " + stuffedAnimalSize
                + "\nSubtotal: $" + getSubtotal()
                + "\nTax: $" + getTax()
                + "\nTotal: $" + getTotal(total)
                + "\n";
    }

    public void display() {
        System.out.println(this.toString());
    }

}
