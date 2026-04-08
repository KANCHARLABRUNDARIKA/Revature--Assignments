public class a15OnlineStore {
    private int productId =1;
    private String productName;
    private Double originalPrice;
    private Double discountPercentage;
    private int stockQuantity;


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if(productName == null){
            System.out.println("Name Cannot be Empty");
        }else {
            this.productName = productName;
        }
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        if(originalPrice<0){
            System.out.println("Price Cannot be Negative ");
        }else {
            this.originalPrice = originalPrice;
        }
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        if(discountPercentage<0 || discountPercentage>60){
            System.out.println("Invalid");
        }else {
            this.discountPercentage = discountPercentage;
        }
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        if(stockQuantity<0){
            System.out.println("Stock Cannot be negative");
        }else {
            this.stockQuantity = stockQuantity;
        }
    }

    public double calculateDiscountAmount() {
        return originalPrice * discountPercentage / 100;
    }

    public double calculateFinalPrice() {
        return originalPrice - calculateDiscountAmount();
    }

    public void sellProduct(int quantity) {
        if (quantity <= stockQuantity) {
            stockQuantity -= quantity;
            System.out.println(quantity + " items sold successfully.");
        } else {
            System.out.println("Insufficient stock!");
        }
    }

    public void displayProductDetails() {
        System.out.println("\n Product Details");
        System.out.println("Product ID   : " + getProductId());
        System.out.println("Name         : " + getProductName());
        System.out.println("Price        : " + getOriginalPrice());
        System.out.println("Discount %   : " + getDiscountPercentage());
        System.out.println("Discount Amt : " + calculateDiscountAmount());
        System.out.println("Final Price  : " + calculateFinalPrice());
        System.out.println("Stock        : " + getStockQuantity());
        System.out.println();
    }


}
