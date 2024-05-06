import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product{
	String name;
	double price;

	public Product(String name, double price) {
        	this.name = name;
        	this.price = price;
    	}

   
    	public String getName() {
        	return name;
    	}

    
    	public double getPrice() {
        	return price;
    	}
}


class ShoppingCart{
	static private ShoppingCart instance;
	private List<Product> items;
	
	private ShoppingCart(){
		items = new ArrayList<>();
	}
	public static ShoppingCart getInstance(){
		if(instance == null){
			return new ShoppingCart();
		}
		return instance;
	}

	public void addProduct(String name, double price) {
        	Product product = new Product(name, price);
        	items.add(product);
        		System.out.println(product.getName() + " added to cart.");
    	}

    	public void removeProduct(String name) {
        	boolean removed = false;
        	for (Product item : items) {
            		if (item.getName().equalsIgnoreCase(name)) {
                		items.remove(item);
                		System.out.println(item.getName() + " removed from cart.");
                		removed = true;
                		break;
           		 }
        	}
        	if (!removed) {
            		System.out.println("Product not found in cart.");
        	}
    	}
	public void viewCart() {
        	if (items.isEmpty()) {
            		System.out.println("Your cart is empty.");
        	} 
		else {
            		System.out.println("Items in your cart:");
            		for (Product item : items) {
                		System.out.println(item.getName() + " - $" + item.getPrice());
            		}
        	}
    }
}

public class Customer {
    public static void main(String[] args) {
        ShoppingCart cart = ShoppingCart.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. Remove Product\n3. View Cart\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    cart.addProduct(name, price);
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String productName = scanner.nextLine();
                    cart.removeProduct(productName);
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
	
		
		

	
	