import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemManager manager = new ItemManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSCRUD Operations");
            System.out.println("1. Create Item");
            System.out.println("2. Read Items");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Search Item by ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    manager.createItem(name, price);
                    break;
                case 2:
                    manager.readItems();
                    break;
                case 3:
                    System.out.print("Enter item ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new item name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new item price: ");
                    double newPrice = scanner.nextDouble();
                    manager.updateItem(updateId, newName, newPrice);
                    break;
                case 4:
                    System.out.print("Enter item ID to delete: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteItem(deleteId);
                    break;
                case 5:
                    System.out.print("Enter item ID to search: ");
                    int searchId = scanner.nextInt();
                    Item item = manager.searchItemById(searchId);
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
