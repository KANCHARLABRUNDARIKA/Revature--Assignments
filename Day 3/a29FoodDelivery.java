class AppUser{
    int userId;
    String name;
    private long phone;

    public AppUser(int userId, String name, long phone) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
    }

    public long getPhone() {
        return phone;
    }


    void login(){
        System.out.println("===========User Login Details ==========");
        System.out.println(" User Id : "+userId);
        System.out.println(" Name : "+name);
        System.out.println(" PhoneNumber : "+getPhone());
    }
    void logout(){
        System.out.println("==========User logged out Successfully==========");
    }

}

class Customer1 extends AppUser{

    String deliveryAddress;

    public Customer1(int userId, String name, long phone, String deliveryAddress) {
        super(userId, name, phone);
        this.deliveryAddress = deliveryAddress;
    }

    void placeOrder(){
        System.out.println("Order is placed to address : "+deliveryAddress);
    }
    void viewOrderHistory(){
        System.out.println("Order History");
        System.out.println("--------Message from Customer side :----------- ");
        login();
        placeOrder();
        logout();
    }
}

class DeliveryPartner extends AppUser{

    String vehicleType;

    public DeliveryPartner(int userId, String name, long phone, String vehicleType) {
        super(userId, name, phone);
        this.vehicleType = vehicleType;
    }

    void acceptDelivery(){
        System.out.println(" Accept Delivery ");
        System.out.println(" Vehicle Type : " +vehicleType);

    }
    void updateDeliveryStatus(){
        System.out.println("---------Delivery Partner Side --------");
        System.out.println(" Accepted " );
    }

}
class RestaurantOwner extends AppUser{
    String restaurantName;

    public RestaurantOwner(int userId, String name, long phone, String restaurantName) {
        super(userId, name, phone);
        this.restaurantName = restaurantName;
    }

    void addMenuItem(){
        System.out.println("--------------Restaurant Owner Side-----------");
        login();
        System.out.println("Menu");
        System.out.println(" Restaurant Name " + restaurantName);

    }
    void updateOrderStatus(){
        System.out.println("Status is Updated ");
        logout();
    }


}

public class a29FoodDelivery {
    public static void main(String[] args) {
        Customer1 customer = new Customer1(101, "Brunda", 1234567890, "Vijayawada AP");
        customer.viewOrderHistory();
        System.out.println();

        DeliveryPartner deliveryPartner = new DeliveryPartner(102, "Sam", 1234565432, "Car");
        deliveryPartner.updateDeliveryStatus();
        deliveryPartner.login();
        deliveryPartner.acceptDelivery();
        deliveryPartner.logout();
        System.out.println();

        RestaurantOwner restaurantOwner = new RestaurantOwner(103, "Ram", 1567113451, "Paradise");
        restaurantOwner.addMenuItem();
        restaurantOwner.updateOrderStatus();
    }
}
