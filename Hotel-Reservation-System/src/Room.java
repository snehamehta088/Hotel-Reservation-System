public class Room {

    private int roomNo;
    private String roomType;
    private double price;
    private String status;

    // Constructor
    public Room(int roomNo, String roomType, double price, String status) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.price = price;
        this.status = status;
    }

    // Getters
    public int getRoomNo() {
        return roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Display Room Details
    public void displayRoom() {
        System.out.println("----------------------------------------");
        System.out.println("Room Number : " + roomNo);
        System.out.println("Room Type   : " + roomType);
        System.out.println("Price       : ₹" + price);
        System.out.println("Status      : " + status);
        System.out.println("----------------------------------------");
    }
}