import java.util.*;
public class a16Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Product Name");
        String productName=sc.nextLine();

        System.out.println("Enter Original Price");
        Double originalPrice=sc.nextDouble();

        System.out.println("Enter Discount Percentage");
        Double discountPercentage=sc.nextDouble();

        System.out.println("Enter Stock Quantity");
        int stockQuantity=sc.nextInt();

        System.out.println("Enter how many u want");
        int sellingQuantity = sc.nextInt();

        a15OnlineStore onlineStore=new a15OnlineStore();
        onlineStore.setProductName(productName);
        onlineStore.setOriginalPrice(originalPrice);
        onlineStore.setDiscountPercentage(discountPercentage);
        onlineStore.setStockQuantity(stockQuantity);

        onlineStore.displayProductDetails();
        onlineStore.sellProduct(sellingQuantity);
        onlineStore.displayProductDetails();
    }
}

