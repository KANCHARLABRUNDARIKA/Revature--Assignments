public class a19Main {
    public static void main(String[] args){
        a18MobileRecharge r1=new a18MobileRecharge(1,"monthly",30,560);
        r1.DisplayPlanDetails();

        a18MobileRecharge r2=new a18MobileRecharge(r1);
        r2.DisplayPlanDetails();

        r2.price = 600;
        r2.DisplayPlanDetails();


    }
}
