class Customer{
    protected int customerId;
    protected String customerName;
    protected String email;

    public Customer(int customerId, String customerName, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
    }

    void registerCustomer(){
        System.out.println(customerName+" has registered successfully");
    }
    void displayCustomer(){
        System.out.println("Customer Id : " + customerId);
        System.out.println("Customer Name : " +customerName);
        System.out.println("Customer email : "+email);
    }

}
class PremiumCustomer extends Customer{
    String membershipLevel;
    Double rewardPoints;

    public PremiumCustomer(int customerId, String customerName, String email, String membershipLevel, Double rewardPoints) {
        super(customerId, customerName, email);
        this.membershipLevel = membershipLevel;
        this.rewardPoints = rewardPoints;
    }

    void applyPremiumBenefits(){
        System.out.println("Premium is applied to Customer Id: "+customerId);
    }
    void displayPremiumCustomer(){
        System.out.println("============Premium Customer Additional Details=========");
        displayCustomer();
        System.out.println("membership level : " + membershipLevel);
        System.out.println("reward Points : "+rewardPoints);
    }
}

public class a27ecommerce {
    public static void main(String[] args){
        PremiumCustomer premiumCustomer = new PremiumCustomer(101,"Kumar","Kumar@gmail.com","Level 2",50.0);
        premiumCustomer.registerCustomer();
        premiumCustomer.applyPremiumBenefits();
        premiumCustomer.displayPremiumCustomer();

    }
}
