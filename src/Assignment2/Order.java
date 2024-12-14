package Assignment2;

public class Order {
    private String orderId;
    private Book bookName;
    private int quantity;
    private String customerName;
    private String shippingAddress;

    private static int orderCount = 1;

    public Order(Book bookName, int quantity, String customerName, String shippingAddress) {
        //this.orderId = orderId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        //updateBookQuantity();
        createOrderID();
    }

    private void createOrderID(){
        orderId = "ORD" + orderCount++;
    }
    private void updateBookQuantity() {
        if (bookName == null) {
            System.out.println("Book object is not initialized.");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        int currentQuantity = bookName.getQuantity();
        System.out.println("Current Quantity: " + currentQuantity);
        System.out.println("Requested Quantity: " + quantity);

        if (currentQuantity >= quantity) {
            bookName.setQuantity(currentQuantity - quantity);
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Not enough books in stock!");
        }
    }

    public String getOrderId() {

        return orderId;
    }

    public String getBookName() {

        return bookName.getName();
    }

    public int getQuantity() {
        return quantity;
    }
    public String getCustomerName(){
        return customerName;
    }

    public String getShippingAddress(){
        return shippingAddress;
    }

    @Override
    public String toString() {
        return String.format("Order ID: %s, Book: %s, Quantity: %d, Customer Name: %s, Shipping Address: %s",
                orderId, bookName.getName(), quantity, customerName, shippingAddress);
    }
}
