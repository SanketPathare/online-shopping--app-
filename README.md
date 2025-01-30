
# Java Online Shop Application

A simple console-based e-commerce application implemented in Java that simulates an online shopping experience. The application provides basic functionality for user authentication, product browsing, shopping cart management, and checkout process.

## Features

### User Authentication

-   User registration with username and password
-   Login/logout functionality
-   Session management

### Product Management

-   Pre-loaded inventory with various product categories
-   Product display with ID, name, and price
-   Products organized in categories (Clothing, Electronics, Home & Living, Sports & Outdoors)

### Shopping Cart

-   Add products with specified quantities
-   View cart contents
-   Calculate total price
-   Remove products
-   Empty cart functionality

### Checkout Process

-   Order review
-   Purchase confirmation
-   Order completion

## Technical Details

### Class Structure

#### Product Class

-   Properties: id, name, price
-   Methods for product information management and display

#### User Class

-   Properties: username, password
-   Methods for authentication

#### ShoppingCart Class

-   Properties: Map of products and quantities
-   Methods for cart management and calculations

#### OnlineShop Class (Main)

-   Static inventory and user management
-   Menu-driven interface
-   Main program flow control

### Data Structures Used

-   `ArrayList<Product>`: For storing product inventory
-   `HashMap<String, User>`: For user management
-   `HashMap<Product, Integer>`: For shopping cart items and quantities

## Usage

### Starting the Application

text

Copy

```
java OnlineShop

```

### Initial Menu Options

-   Register (1): Create a new user account
-   Login (2): Access existing account
-   Exit (3): Close the application

### Shop Menu (After Login)

-   View Products (1): Display available items
-   Add to Cart (2): Select products for purchase
-   View Cart (3): Review selected items
-   Checkout (4): Complete purchase
-   Logout (5): Exit to login menu

## Sample Products

### Clothing

-   Cotton T-shirt ($19.99)
-   Slim Fit Jeans ($49.99)
-   Running Shoes ($79.99)
-   Hooded Sweatshirt ($39.99)
-   Winter Jacket ($89.99)

### Electronics

-   Wireless Earbuds ($129.99)
-   Smartphone ($699.99)
-   Laptop ($999.99)
-   Smart Watch ($249.99)
-   Bluetooth Speaker ($79.99)

### Home & Living

-   Coffee Maker ($59.99)
-   Bed Sheets Set ($45.99)
-   Table Lamp ($29.99)
-   Storage Containers ($19.99)
-   Bath Towel Set ($34.99)

### Sports & Outdoors

-   Yoga Mat ($25.99)
-   Dumbbell Set ($89.99)
-   Tennis Racket ($59.99)
-   Camping Tent ($149.99)
-   Basketball ($29.99)

## Implementation Notes

-   Input validation is implemented for user registration and product selection
-   Passwords are stored in plain text (not recommended for production use)
-   The application uses a console-based interface for simplicity
-   Product inventory is initialized with sample data at startup
-   Shopping cart data is maintained only for the current session

## Future Improvements

-   Add password encryption for security
-   Implement persistent storage for user and product data
-   Add inventory management functionality
-   Include order history tracking
-   Implement product categories filtering
-   Add payment processing simulation
-   Enhance input validation and error handling
-   Add product search functionality
-   Implement admin interface for product management
-   Add user profile management

## Requirements

-   Java Development Kit (JDK) 8 or higher
-   Console/Terminal for running the application

## Running the Application

1.  Compile the Java files:
    
    text
    
    Copy
    
    ```
    javac OnlineShop.java
    
    ```
    
2.  Run the application:
    
    text
    
    Copy
    
    ```
    java OnlineShop
    ```
