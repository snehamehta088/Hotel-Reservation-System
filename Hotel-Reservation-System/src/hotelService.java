import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class hotelService {

    private ArrayList<Room> rooms;
    private Scanner sc;

    public hotelService() {

        rooms = new ArrayList<>();
        sc = new Scanner(System.in);

        initializeRooms();

        updateBookedRooms();
    }

    private void initializeRooms() {

        rooms.add(new Room(101, "Standard", 1200, "Available"));
        rooms.add(new Room(102, "Standard", 1200, "Available"));

        rooms.add(new Room(201, "Deluxe", 2000, "Available"));
        rooms.add(new Room(202, "Deluxe", 2000, "Available"));

        rooms.add(new Room(301, "Suite", 3500, "Available"));
        rooms.add(new Room(302, "Suite", 3500, "Available"));
    }

    // ================= VIEW ROOMS =================

    public void viewRooms() {

        System.out.println("\n========== ROOM LIST ==========");

        for (Room room : rooms) {

            room.displayRoom();

        }

    }

    // ================= SEARCH ROOM =================

    public void searchRoom() {

        System.out.print("\nEnter Room Type (Standard/Deluxe/Suite): ");

        String type = sc.next();

        boolean found = false;

        for (Room room : rooms) {

            if (room.getRoomType().equalsIgnoreCase(type)
                    && room.getStatus().equalsIgnoreCase("Available")) {

                room.displayRoom();

                found = true;

            }

        }

        if (!found) {

            System.out.println("No Available Rooms Found.");

        }

    }

    // ================= BOOK ROOM =================

    public void bookRoom() {

        System.out.print("\nEnter Customer Name : ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Phone Number : ");
        String phone = sc.nextLine();

        System.out.print("Enter Room Number : ");
        int roomNo = sc.nextInt();

        Room selectedRoom = null;

        for (Room room : rooms) {

            if (room.getRoomNo() == roomNo) {

                selectedRoom = room;
                break;

            }

        }

        if (selectedRoom == null) {

            System.out.println("Invalid Room Number!");
            return;

        }

        if (selectedRoom.getStatus().equalsIgnoreCase("Booked")) {

            System.out.println("Room Already Booked!");
            return;

        }

        String paymentMethod =
                Payment.processPayment(selectedRoom.getPrice());

        int bookingId = FileManager.getNextBookingId();

        Reservation reservation = new Reservation(

                bookingId,
                name,
                phone,
                roomNo,
                paymentMethod,
                selectedRoom.getPrice(),
                LocalDate.now()

        );

        FileManager.saveBooking(reservation);

        selectedRoom.setStatus("Booked");

        System.out.println("\nBooking Successful!");

        System.out.println("Booking ID : " + bookingId);

    }
    // ================= VIEW RESERVATIONS =================

    public void viewReservations() {

        ArrayList<Reservation> bookings = FileManager.loadBookings();

        if (bookings.isEmpty()) {

            System.out.println("\nNo Reservations Found.");
            return;

        }

        System.out.println("\n========== RESERVATIONS ==========");

        for (Reservation reservation : bookings) {

            reservation.displayReservation();

        }

    }

    // ================= CANCEL RESERVATION =================

    public void cancelReservation() {

        ArrayList<Reservation> bookings = FileManager.loadBookings();

        if (bookings.isEmpty()) {

            System.out.println("\nNo Reservations Found.");
            return;

        }

        System.out.print("\nEnter Booking ID to Cancel : ");
        int bookingId = sc.nextInt();

        boolean found = false;

        for (Reservation reservation : bookings) {

            if (reservation.getBookingId() == bookingId) {

                found = true;

                for (Room room : rooms) {

                    if (room.getRoomNo() == reservation.getRoomNo()) {

                        room.setStatus("Available");
                        break;

                    }

                }

                break;

            }

        }

        if (!found) {

            System.out.println("Booking ID Not Found.");
            return;

        }

        FileManager.deleteBooking(bookingId);

        System.out.println("Reservation Cancelled Successfully!");

    }
    private void updateBookedRooms() {
        ArrayList<Reservation> bookings = FileManager.loadBookings();

        for (Reservation reservation : bookings) {

            for (Room room : rooms) {

                if (room.getRoomNo() == reservation.getRoomNo()) {
                    room.setStatus("Booked");
                    break;
                }

            }

        }
    }

}