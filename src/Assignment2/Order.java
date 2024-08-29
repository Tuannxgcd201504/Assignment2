package Assignment2;

public class Order {
    private String orderId;
    private Book bookName;
    private int quantity;
    private String customerName;
    private String shippingAddress;

//    private static int orderCount = 1;

    public Order(String orderId, Book bookName, int quantity, String customerName, String shippingAddress) {
        this.orderId = orderId;
        this.bookName = bookName;
        this.quantity = quantity;
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        updateBookQuantity();
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
        return String.format("Order ID: %s\nBook: %s\nQuantity: %d\nCustomer Name: %s\nShipping Address: %s\n",
                orderId, bookName.getName(), quantity, customerName, shippingAddress);
    }
}
