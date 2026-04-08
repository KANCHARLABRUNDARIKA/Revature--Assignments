import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product(1,"iPhone 15","Electronics","Apple",80000,5,4.8,10,true));
        products.add(new Product(2,"Samsung TV","Electronics","Samsung",55000,3,4.5,12,true));
        products.add(new Product(3,"Nike Shoes","Fashion","Nike",7000,10,4.3,15,true));
        products.add(new Product(4,"Laptop","Electronics","Dell",65000,2,4.7,8,true));
        products.add(new Product(5,"T-Shirt","Fashion","Puma",1500,0,4.0,20,false));
        products.add(new Product(6,"Rice Bag","Grocery","IndiaGate",2500,20,4.1,5,true));
        products.add(new Product(7,"Watch","Fashion","Fossil",9000,4,4.6,10,true));

        System.out.println("\n1. Product Names:");
        products.forEach(p -> System.out.println(p.productName));

        System.out.println("\n2. Price > 5000");
        products.stream()
                .filter(p -> p.price > 5000)
                .forEach(System.out::println);

        System.out.println("\n3. Electronics Products");
        products.stream()
                .filter(p -> p.category.equals("Electronics"))
                .forEach(System.out::println);

        System.out.println("\n4. In Stock Products");
        products.stream()
                .filter(p -> p.inStock)
                .forEach(System.out::println);

        System.out.println("\n5. Sort Price Ascending");
        products.stream()
                .sorted((a,b)->Double.compare(a.price,b.price))
                .forEach(System.out::println);

        System.out.println("\n6. Sort Price Descending");
        products.stream()
                .sorted((a,b)->Double.compare(b.price,a.price))
                .forEach(System.out::println);

        System.out.println("\n7. Sort Rating Highest");
        products.stream()
                .sorted((a,b)->Double.compare(b.rating,a.rating))
                .forEach(System.out::println);

        System.out.println("\n8. Sort by Name");
        products.stream()
                .sorted((a,b)->a.productName.compareTo(b.productName))
                .forEach(System.out::println);

        boolean anyHigh = products.stream()
                .anyMatch(p -> p.price > 70000);
        System.out.println("\n9. Any price > 70000: " + anyHigh);

        boolean allRating = products.stream()
                .allMatch(p -> p.rating > 3.5);
        System.out.println("\n10. All rating > 3.5: " + allRating);

        boolean noMedical = products.stream()
                .noneMatch(p -> p.category.equals("Medical"));
        System.out.println("\n11. No Medical Category: " + noMedical);

        System.out.println("\n12. Max Price Product");
        products.stream()
                .max((a,b)->Double.compare(a.price,b.price))
                .ifPresent(System.out::println);

        System.out.println("\n13. Min Price Product");
        products.stream()
                .min((a,b)->Double.compare(a.price,b.price))
                .ifPresent(System.out::println);

        System.out.println("\n15. Increase Electronics Price by 5%");
        products.stream()
                .filter(p -> p.category.equals("Electronics"))
                .forEach(p -> p.price *= 1.05);

        products.forEach(System.out::println);

        System.out.println("\n16. Add 10% Discount to Fashion");
        products.stream()
                .filter(p -> p.category.equals("Fashion"))
                .forEach(p -> p.discountPercentage += 10);

        products.forEach(System.out::println);

        System.out.println("\n17. Mark stock 0 out of stock");
        products.stream()
                .filter(p -> p.stock == 0)
                .forEach(p -> p.inStock = false);

        products.forEach(System.out::println);

        long fashionCount = products.stream()
                .filter(p -> p.category.equals("Fashion"))
                .count();

        System.out.println("\n18. Fashion Count: " + fashionCount);

        long ratingCount = products.stream()
                .filter(p -> p.rating > 4.5)
                .count();

        System.out.println("\n19. Rating > 4.5 Count: " + ratingCount);

        long outStock = products.stream()
                .filter(p -> !p.inStock)
                .count();

        System.out.println("\n20. Out of Stock Count: " + outStock);
    }
}