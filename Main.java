import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ItemManager manager = new ItemManager();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nOperasi SCRUD");
            System.out.println("1. Buat Item");
            System.out.println("3. Perbarui Item");
            System.out.println("4. Hapus Item");
            System.out.println("5. Cari Item berdasarkan ID");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan harga item: ");
                    double harga = scanner.nextDouble();
                    manager.createItem(nama, harga);
                    break;
                case 2:
                    manager.readItems();
                    break;
                case 3:
                    System.out.print("Masukkan ID item yang akan diperbarui: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Buang newline
                    System.out.print("Masukkan nama item baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan harga item baru: ");
                    double hargaBaru = scanner.nextDouble();
                    manager.updateItem(updateId, namaBaru, hargaBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID item yang akan dihapus: ");
                    int deleteId = scanner.nextInt();
                    manager.deleteItem(deleteId);
                    break;
                case 5:
                    System.out.print("Masukkan ID item yang akan dicari: ");
                    int searchId = scanner.nextInt();
                    Item item = manager.searchItemById(searchId);
                    if (item != null) {
                        System.out.println(item);
                    } else {
                        System.out.println("Item tidak ditemukan.");
                    }
                    break;
                case 0:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
