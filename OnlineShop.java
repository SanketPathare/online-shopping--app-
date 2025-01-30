import java.util.*;

// Product class to store item information
class Product {
    String id; // Product identifier
    String name; // Product name
    double price; // Product price

    // Constructor to create a new product
    Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Simple string representation of the product
    public String toString() {
        return id + " - " + name + " (" + price + ")";
    }
}

// Simple user class for authentication
class User {
    String username; // User's username
    String password; // User's password

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Check if provided password matches
    boolean isPasswordCorrect(String inputPassword) {
        return password.equals(inputPassword);
    }
}

// Shopping cart to hold selected items
class ShoppingCart {
    // Map to store products and their quantities
    Map<Product, Integer> items = new HashMap<>();

    // Add a product to cart
    void addProduct(Product product, int quantity) {
        int currentQuantity = items.getOrDefault(product, 0);
        items.put(product, currentQuantity + quantity);
    }

    // Remove a product from cart
    void removeProduct(Product product) {
        items.remove(product);
    }

    // Calculate total price of all items
    double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> item : items.entrySet()) {
            total += item.getKey().price * item.getValue();
        }
        return total;
    }

    // Empty the cart
    void emptyCart() {
        items.clear();
    }

    // Show cart contents
    void showCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        for (Map.Entry<Product, Integer> item : items.entrySet()) {
            System.out.printf("%s (Quantity: %d)\n",
                    item.getKey().toString(),
                    item.getValue());
        }
        System.out.printf("Total: $%.2f\n", calculateTotal());
    }
}

// Main shop class
public class OnlineShop {
    // Store all available products
    static List<Product> inventory = new ArrayList<>();
    // Store registered users
    static Map<String, User> users = new HashMap<>();
    // Current shopping session
    static User currentUser = null;
    static ShoppingCart cart = new ShoppingCart();
    // Scanner for user input
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some sample products
        setupSampleProducts();

        // Main program loop
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showShopMenu();
            }
        }
    }

    // Initialize sample products
    static void setupSampleProducts() {
        // Clothing
        inventory.add(new Product("C1", "Cotton T-shirt", 1659));
        inventory.add(new Product("C2", "Slim Fit Jeans", 4149));
        inventory.add(new Product("C3", "Running Shoes", 6639));
        inventory.add(new Product("C4", "Hooded Sweatshirt", 3319));
        inventory.add(new Product("C5", "Winter Jacket", 7469));

        // Electronics
        inventory.add(new Product("E1", "Wireless Earbuds", 10789));
        inventory.add(new Product("E2", "Smartphone", 58099));
        inventory.add(new Product("E3", "Laptop", 829993));
        inventory.add(new Product("E4", "Smart Watch", 20749));
        inventory.add(new Product("E5", "Bluetooth Speaker", 6639));

        // Home & Living
        inventory.add(new Product("H1", "Coffee Maker", 4979));
        inventory.add(new Product("H2", "Bed Sheets Set", 3819));
        inventory.add(new Product("H3", "Table Lamp", 2489));
        inventory.add(new Product("H4", "Storage Containers", 1659));
        inventory.add(new Product("H5", "Bath Towel Set", 2909));

        // Sports & Outdoors
        inventory.add(new Product("S1", "Yoga Mat", 2159));
        inventory.add(new Product("S2", "Dumbbell Set", 7469));
        inventory.add(new Product("S3", "Tennis Racket", 4979));
        inventory.add(new Product("S4", "Camping Tent", 12449));
        inventory.add(new Product("S5", "Basketball", 2489));
    }

    // Show login/register menu
    static void showLoginMenu() {
        System.out.println("\n1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Choose option: ");

        int choice = input.nextInt();
        input.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                loginUser();
                break;
            case 3:
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
    }

    // Show main shop menu
    static void showShopMenu() {
        System.out.println("\n1. View Products");
        System.out.println("2. Add to Cart");
        System.out.println("3. View Cart");
        System.out.println("4. Checkout");
        System.out.println("5. Logout");
        System.out.print("Choose option: ");

        int choice = input.nextInt();
        input.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                showProducts();
                break;
            case 2:
                addToCart();
                break;
            case 3:
                cart.showCart();
                break;
            case 4:
                checkout();
                break;
            case 5:
                logout();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    // Register new user
    static void registerUser() {
        System.out.print("Enter username: ");
        String username = input.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already taken");
            return;
        }

        System.out.print("Enter password: ");
        String password = input.nextLine();

        users.put(username, new User(username, password));
        System.out.println("Registration successful!");
    }

    // Login existing user
    static void loginUser() {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        User user = users.get(username);
        if (user != null && user.isPasswordCorrect(password)) {
            currentUser = user;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password");
        }
    }

    // Display all products
    static void showProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : inventory) {
            System.out.println(product);
        }
    }

    // Add product to cart
    static void addToCart() {
        showProducts();
        System.out.print("Enter product ID: ");
        String id = input.nextLine();

        // Find product in inventory
        Product selected = null;
        for (Product product : inventory) {
            if (product.id.equals(id)) {
                selected = product;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Product not found");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();
        input.nextLine(); // Clear buffer

        if (quantity <= 0) {
            System.out.println("Invalid quantity");
            return;
        }

        cart.addProduct(selected, quantity);
        System.out.println("Added to cart!");
    }

    // Process checkout
    static void checkout() {
        if (cart.items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        cart.showCart();
        System.out.print("Confirm purchase (y/n): ");
        String confirm = input.nextLine();

        if (confirm.toLowerCase().equals("y")) {
            System.out.println("Purchase complete! Thank you!");
            cart.emptyCart();
        } else {
            System.out.println("Purchase cancelled");
        }
    }

    // Logout current user
    static void logout() {
        currentUser = null;
        cart.emptyCart();
        System.out.println("Logged out successfully");
    }
}
