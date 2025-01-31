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
    public static Item[] setupStore() { //setup the store's items and prices
        Item[] store = new Item[5]; //declare the Item store
        store[0] = new Item("Bananas",1.5);
        store[1] = new Item("Oranges",2.0);
        store[2] = new Item("Frosted Flakes",6.0);
        store[3] = new Item("Glazed Doughnuts",10.0);
        store[4] = new Item("Gatorade Bottles",15.0);
        return store; //return the Item to the other methods
    }
    public static ArrayList<Item> createCart(String[] args,Item[] store) { //create the cart, an array list that can referenced in the other methods, taking in args and the store Item
        ArrayList<Item> Cart = new ArrayList<Item>(); //declare the cart to be used through the input of this method
        for (int i = 0; i < args.length; i++){ //iterates over the indices of args
            try {
                Cart.add(store[Integer.parseInt(args[i])]); //add the store item using the integer value from the args index at "i" to the cart
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("The store does not have an item of index " + args[i]); //catch the exception where the index value written is an incorrect value
            }
            catch (NumberFormatException e){
                System.out.println("\"" + args[i] + "\"" + " is not a valid integer."); //catch the exception where there is no integer present, an incorrect format
            }
        }
        if (Cart.isEmpty()){
            System.out.println("No valid Input to cart"); //catch the bug where the cart is empty and can't run the rest of the program
            System.exit(0);
        }
        System.out.println(); //aesthetic empty line
        return Cart; //return the array list for use in the other methods
    }
    public static void printReceiptInOrder(ArrayList<Item> cart){ //print the format of the receipt
        System.out.println("Receipt\n========================="); //title line printed
        System.out.printf("%-20s %-10s%n","Item","Price"); //using printf, correctly format the title of the table
        for (int i = 0; i < cart.size(); i++) { //iterate across the different parts of the cart
            System.out.printf("%-20s %-10s%n",cart.get(i).getItemName(),cart.get(i).getItemPrice()); //prints the item's name and price using the item-class methods getItemName and getItemPrice
        }
        System.out.println("========================="); //aesthetic line to match the example
        double subtotal = 0.0; //initialize and declare subtotal
        for (int i = 0; i < cart.size(); i++){ //iterate across the cart to find the subtotal using all the prices of the cart
            subtotal += cart.get(i).getItemPrice(); //uses getItemPrice from the item-class and add it to the subtotal
        }
        System.out.println("(a) Subtotal: " + subtotal); //print subtotal
        double salesTax = 0.05; //initialize and declare sales tax
        System.out.println("(b) Sales Tax: " + Math.round(salesTax * 100) + "%"); //print sales tax
        double total = subtotal + (subtotal * salesTax); //initialize and declare total
        System.out.println("(c) Total: " + total); //print total
    }
    public static void emptyCartReverseOrder(ArrayList<Item> cart){ //empties the cart one item at a time
        System.out.println("Remove all items from the cart in \"Last In First Out\" Order.."); //print statement mentioning the emptying of the cart
        int l = cart.size(); //declare and initialize the length of the loop below
        for (int i = l-1; i >= 0; i--){ //iterate from the bottom of the list to the top for removal
            System.out.println("Removing: " + cart.get(i).getItemName()); //print "Removing: " and then the last item left on the list
            cart.remove(i); //this actually removes the item from the array list
        }
        System.out.println("Cart has been emptied."); //prints a message to the user that the cart has been emptied
    }
}