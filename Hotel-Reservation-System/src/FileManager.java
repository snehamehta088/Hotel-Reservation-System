import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "src/bookings.txt";

    // Save Booking
    public static void saveBooking(Reservation reservation) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(
                    reservation.getBookingId() + "," +
                    reservation.getCustomerName() + "," +
                    reservation.getPhone() + "," +
                    reservation.getRoomNo() + "," +
                    reservation.getPaymentMethod() + "," +
                    reservation.getAmount() + "," +
                    reservation.getBookingDate()
            );
            System.out.println("Saving to: " + new File(FILE_NAME).getAbsolutePath());


            writer.newLine();

        }catch (IOException e) {

            e.printStackTrace();

        }

    }

    // Read All Bookings
    public static ArrayList<Reservation> loadBookings() {

        ArrayList<Reservation> bookings = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return bookings;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Reservation reservation = new Reservation(

                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4],
                        Double.parseDouble(data[5]),
                        LocalDate.parse(data[6])

                );

                bookings.add(reservation);

            }

        } catch (IOException e) {

            System.out.println("Error reading bookings!");

        }

        return bookings;

    }
    // Delete Booking by Booking ID
    public static void deleteBooking(int bookingId) {

        ArrayList<Reservation> bookings = loadBookings();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Reservation reservation : bookings) {

                if (reservation.getBookingId() != bookingId) {

                    writer.write(
                            reservation.getBookingId() + "," +
                            reservation.getCustomerName() + "," +
                            reservation.getPhone() + "," +
                            reservation.getRoomNo() + "," +
                            reservation.getPaymentMethod() + "," +
                            reservation.getAmount() + "," +
                            reservation.getBookingDate()
                    );

                    writer.newLine();
                }

            }

        } catch (IOException e) {

            System.out.println("Error deleting booking!");

        }

    }
    // Get Next Booking ID
    public static int getNextBookingId() {

        ArrayList<Reservation> bookings = loadBookings();

        if (bookings.isEmpty()) {
        return 1;
       }

        return bookings.get(bookings.size() - 1).getBookingId() + 1;
    }

   // Update Complete Booking File
    public static void updateBookings(ArrayList<Reservation> bookings) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Reservation reservation : bookings) {

                writer.write(
                        reservation.getBookingId() + "," +
                        reservation.getCustomerName() + "," +
                        reservation.getPhone() + "," +
                        reservation.getRoomNo() + "," +
                        reservation.getPaymentMethod() + "," +
                        reservation.getAmount() + "," +
                        reservation.getBookingDate()
               );

                writer.newLine();
            }

        } catch (IOException e) {

           System.out.println("Error updating bookings!");
        }

    }

}

