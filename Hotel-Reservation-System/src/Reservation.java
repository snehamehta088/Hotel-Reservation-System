import java.time.LocalDate;

public class Reservation {

    private int bookingId;
    private String customerName;
    private String phone;
    private int roomNo;
    private String paymentMethod;
    private double amount;
    private LocalDate bookingDate;

    // Constructor
    public Reservation(int bookingId, String customerName, String phone,
                       int roomNo, String paymentMethod,
                       double amount, LocalDate bookingDate) {

        this.bookingId = bookingId;
        this.customerName = customerName;
        this.phone = phone;
        this.roomNo = roomNo;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.bookingDate = bookingDate;
    }

    // Getters
    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhone() {
        return phone;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    // Display Reservation Details
    public void displayReservation() {

        System.out.println("----------------------------------------");
        System.out.println("Booking ID      : " + bookingId);
        System.out.println("Customer Name   : " + customerName);
        System.out.println("Phone           : " + phone);
        System.out.println("Room Number     : " + roomNo);
        System.out.println("Payment Method  : " + paymentMethod);
        System.out.println("Amount Paid     : ₹" + amount);
        System.out.println("Booking Date    : " + bookingDate);
        System.out.println("----------------------------------------");
    }
}