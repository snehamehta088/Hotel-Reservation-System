public class Main {

    public static void main(String[] args) {

        hotelService hotel = new hotelService();

        java.util.Scanner sc = new java.util.Scanner(System.in);

        int choice;

        do {

            System.out.println("\n=====================================");
            System.out.println("     HOTEL RESERVATION SYSTEM");
            System.out.println("=====================================");

            System.out.println("1. View Rooms");
            System.out.println("2. Search Room");
            System.out.println("3. Book Room");
            System.out.println("4. View Reservations");
            System.out.println("5. Cancel Reservation");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    hotel.viewRooms();
                    break;

                case 2:
                    hotel.searchRoom();
                    break;

                case 3:
                    hotel.bookRoom();
                    break;

                case 4:
                    hotel.viewReservations();
                    break;

                case 5:
                    hotel.cancelReservation();
                    break;

                case 6:
                    System.out.println("\nThank You for using Hotel Reservation System.");
                    break;

                default:
                    System.out.println("\nInvalid Choice!");

            }

        } while (choice != 6);

    }

}