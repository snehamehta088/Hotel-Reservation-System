import java.util.Scanner;

public class Payment {

    public static String processPayment(double amount) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n========== PAYMENT ==========");
        System.out.println("Amount to Pay : ₹" + amount);

        System.out.println("\nChoose Payment Method");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. UPI");

        System.out.print("Enter Choice : ");
        int choice = sc.nextInt();

        String paymentMethod;

        switch (choice) {

            case 1:
                paymentMethod = "Cash";
                break;

            case 2:
                paymentMethod = "Card";
                break;

            case 3:
                paymentMethod = "UPI";
                break;

            default:
                System.out.println("Invalid Choice!");
                paymentMethod = "Cash";
        }

        System.out.println("\nPayment Successful!");
        System.out.println("Paid via : " + paymentMethod);

        return paymentMethod;
    }
}