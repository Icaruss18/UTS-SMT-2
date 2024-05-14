import java.util.ArrayList;
import java.util.Scanner;

public class ItemManager {
    private ArrayList<Item> items;
    private int nextId;

    public ItemManager() {
        items = new ArrayList<>();
        nextId = 1;
    }

    public void createItem(String name, double price) {
        items.add(new Item(nextId++, name, price));
        System.out.println("Item created successfully.");
    }

    public void readItems() {
        if (items.isEmpty()) {
            System.out.println("No items found.");
        } else {
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public Item searchItemById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(int id, String name, double price) {
        Item item = searchItemById(id);
        if (item != null) {
            item.setName(name);
            item.setPrice(price);
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    public void deleteItem(int id) {
        Item item = searchItemById(id);
        if (item != null) {
            items.remove(item);
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }
}
