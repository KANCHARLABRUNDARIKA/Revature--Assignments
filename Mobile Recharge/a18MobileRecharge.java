public class a18MobileRecharge {
    int planId;
    String planName;
    int validityDays;
    double price;

    public a18MobileRecharge(int planId,String planName,int validityDays,double price) {
        this.planId=planId;
        this.planName=planName;
        this.validityDays=validityDays;
        this.price=price;
    }

    public a18MobileRecharge(a18MobileRecharge recharge){
        this(recharge.planId,recharge.planName,recharge.validityDays,recharge.price);
    }

    public void DisplayPlanDetails(){
        System.out.println("=================================");
        System.out.println("Plan Details");
        System.out.println("=================================");
        System.out.println("plan Id : " + planId);
        System.out.println("plan Name : " + planName);
        System.out.println("validity Days: " + validityDays);
        System.out.println("price: " + price);

    }
}