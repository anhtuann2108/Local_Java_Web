class Product {
    static int maxAmount;
    int amount;

    public Product(int amount) {
        this.amount = amount;
    }

    public void storeMax() {
        if (amount > maxAmount) {
            maxAmount = amount;
        }
    }

    public void printDetail() {
        System.out.println("amt : " + amount + " maxAmt : " + maxAmount);
    }
}

public class MainTest {
    public static void main(String[] args) {
        Product p1 = new Product(120);
        Product p2 = new Product(100);

        p1.storeMax();
        p2.storeMax();

        p1.printDetail();
        p2.printDetail();
    }
}