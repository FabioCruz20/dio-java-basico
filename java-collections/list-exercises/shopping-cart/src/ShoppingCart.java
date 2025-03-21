import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Item> items = new ArrayList<>();

    public void addItem(String name, double price, int amount) {
        items.add(new Item(name, price, amount));
    }

    public void removeItem(String name) {
        List<Item> toBeRemoved = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                toBeRemoved.add(item);
            }
        }
        items.removeAll(toBeRemoved);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice() * item.getAmount();
        }
        return total;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
