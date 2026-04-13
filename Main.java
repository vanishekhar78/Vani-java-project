import java.util.ArrayList;
import java.util.Scanner;

// Item class
class Item {
    String name;
    int price;
    int quantity;

    Item(String n, int p, int q) {
        name = n;
        price = p;
        quantity = q;
    }

    int getTotal() {
        return price * quantity;
    }
}

// Bill class
class Bill {
    ArrayList<Item> items = new ArrayList<>();

    void addItem(Item i) {
        items.add(i);
    }

    void printBill() {
        int subtotal = 0;

        System.out.println("\n----- BILL -----");

        for (Item i : items) {
            int total = i.getTotal();
            subtotal += total;

            System.out.println(i.name + " - " + i.quantity + " x " + i.price + " = " + total);
        }

        double tax = subtotal * 0.18;
        double finalTotal = subtotal + tax;

        System.out.println("----------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Tax: " + tax);
        System.out.println("Total: " + finalTotal);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bill b = new Bill();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for item " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            int price = sc.nextInt();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine(); // clear buffer

            b.addItem(new Item(name, price, quantity));
        }

        b.printBill();
    }
}