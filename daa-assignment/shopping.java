import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    String name;
    double price;
    double weight;

    public Item(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
}

public class shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("rs");
        double budget = scanner.nextDouble();

        System.out.print("Enter your maximum carrying capacity: ");
        double capacity = scanner.nextDouble();

        List<Item> items = new ArrayList<>();
        items.add(new Item("Laptop", 800, 5));
        items.add(new Item("Smartphone", 400, 1));
        items.add(new Item("Headphones", 100, 0.5));
        items.add(new Item("Camera", 600, 3));
        items.add(new Item("Tablet", 300, 2));

        System.out.println("Available items:");

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.name + " - rs" + item.price + " (Weight: " + item.weight + " kg)");
        }

        List<Item> selectedItems = selectItems(items, budget, capacity);

        System.out.println("\nItems selected for purchase:");

        double totalPrice = 0;
        double totalWeight = 0;

        for (Item item : selectedItems) {
            System.out.println(item.name + " - rs" + item.price + " (Weight: " + item.weight + " kg)");
            totalPrice += item.price;
            totalWeight += item.weight;
        }

        System.out.println("\nTotal Price: rs" + totalPrice);
        System.out.println("Total Weight: " + totalWeight + " kg");

        scanner.close();
    }

    public static List<Item> selectItems(List<Item> items, double budget, double capacity) {
        int n = items.size();
        double[][] dp = new double[n + 1][(int) (capacity + 1)];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                Item item = items.get(i - 1);

                if (item.weight > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][(int) (w - item.weight)] + item.price);
                }
            }
        }

        int w = (int) capacity;
        List<Item> selectedItems = new ArrayList<>();

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Item item = items.get(i - 1);
                selectedItems.add(item);
                w -= item.weight;
            }
        }

        return selectedItems;
    }

}