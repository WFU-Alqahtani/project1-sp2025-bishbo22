import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Item[] store = setupStore();
        ArrayList<Item> cart = new ArrayList<>();
        cart = createCart(args,store);
        printReceiptInOrder(cart);
        emptyCartReverseOrder(cart);
    }
    public static Item[] setupStore() {
        Item[] store = new Item[5];
        store[0] = new Item("Bananas",1.5);
        store[1] = new Item("Oranges",2.0);
        store[2] = new Item("Frosted Flakes",6.0);
        store[3] = new Item("Glazed Doughnuts",10.0);
        store[4] = new Item("Gatorade Bottles",15.0);
        return store;
    }
    public static ArrayList<Item> createCart(String[] args,Item[] store) {
        ArrayList<Item> Cart = new ArrayList<Item>();
        for (int i = 0; i < args.length; i++){
            try {
                Cart.add(store[Integer.parseInt(args[i])]);
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("The store does not have an item of index " + args[i]);
            }
            catch (NumberFormatException e){
                System.out.println("\"" + args[i] + "\"" + " is not a valid integer.");
            }
        }
        if (Cart.isEmpty()){
            System.out.println("No valid Input to cart");
            System.exit(0);
        }
        System.out.println();
        return Cart;
    }
    public static void printReceiptInOrder(ArrayList<Item> cart){
        System.out.println("Receipt\n=========================");
        System.out.printf("%-20s %-10s%n","Item","Price");
        for (int i = 0; i < cart.size(); i++) {
            System.out.printf("%-20s %-10s%n",cart.get(i).getItemName(),cart.get(i).getItemPrice());
        }
        System.out.println("=========================");
        double subtotal = 0.0;
        for (int i = 0; i < cart.size(); i++){
            subtotal += cart.get(i).getItemPrice();
        }
        System.out.println("(a) Subtotal: " + subtotal);
        double salesTax = 0.05;
        System.out.println("(b) Sales Tax: " + Math.round(salesTax * 100) + "%");
        double total = subtotal + (subtotal * salesTax);
        System.out.println("(c) Total: " + total);
    }
    public static void emptyCartReverseOrder(ArrayList<Item> cart){
        System.out.println("Remove all items from the cart in \"Last In First Out\" Order..");
        int l = cart.size();
        for (int i = l-1; i >= 0; i--){
            System.out.println("Removing: " + cart.get(i).getItemName());
            cart.remove(i);
        }
        System.out.println("Cart has been emptied.");
    }
}