# Simple Shopping Cart using the Composite Pattern

Welcome to the **Simple Shopping Cart** project! 
This repository demonstrates the implementation of the **Composite Design Pattern** to create a flexible and hierarchical shopping cart system. The project is written in Java and showcases how to manage composite structures like menus and items in a shopping cart.

---

## 🛠️ **Features**
- **Composite Design Pattern**: Combines `Menu` (composite) and `MenuItem` (leaf) components to create a hierarchical structure.
- **Dynamic Menu Management**: Add or remove items and submenus dynamically.
- **Customizable Output**: Prints the menu structure with proper indentation for better readability.
- **Error Handling**: Validates inputs to ensure robust functionality.

---

## 📂 **Project Structure**
```
├── CompositeDemo.java   # Main file containing the implementation and client code
```

### Key Classes:
1. **`MenuComponent` (Interface)**:
   - Defines the common behavior (`print()`) for both composite and leaf components.

2. **`MenuItem` (Leaf)**:
   - Represents individual items in the shopping cart.
   - Stores product name and price.

3. **`Menu` (Composite)**:
   - Represents a collection of `MenuComponent` objects.
   - Can contain both `MenuItem` and other `Menu` objects.

4. **`CompositeDemo` (Client)**:
   - Demonstrates the usage of the composite structure by creating and printing a sample shopping cart.

---

## 🚀 **How to Run**
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. **Compile the Code**:
   ```bash
   javac CompositeDemo.java
   ```

3. **Run the Program**:
   ```bash
   java CompositeDemo
   ```

4. **Expected Output**:
   ```
   Clothing:
     Mens:
       PoloShirtMens(M) - $5.0
       DarkBlueMensDenim - $10.0
     Womens:
       SkirtsDenim - $15.0
       PoloShirtWomens(L) - $7.0
   ```

---

## 📖 **How It Works**
- **Composite Pattern**: The `Menu` class acts as a composite that can hold both `MenuItem` (leaf) and other `Menu` objects. This allows for a tree-like structure where menus can contain submenus and items.
- **Dynamic Printing**: The `print()` method recursively traverses the composite structure, printing each menu and its items with proper indentation.

---

## 🧪 **Example Usage**
Here’s how you can create and manage a shopping cart using this project:

```java
// Create menu items
MenuItem apple = new MenuItem("Apple", 1.5);
MenuItem banana = new MenuItem("Banana", 0.8);

// Create menus
Menu fruitsMenu = new Menu("Fruits");
fruitsMenu.add(apple);
fruitsMenu.add(banana);

// Print the menu
fruitsMenu.print();
```

---

## 🛡️ **Error Handling**
- **Null Checks**: Prevents adding `null` components to menus.
- **Input Validation**: Ensures product names are non-empty and prices are non-negative.

---

## 📜 **License**
This project is licensed under the MIT License. Feel free to use, modify, and distribute it as needed.

---

## 🤝 **Contributing**
Contributions are welcome! If you have ideas for improvements or new features, feel free to open an issue or submit a pull request.

---

## 📧 **Contact**
For any questions or feedback, please reach out to heshan123vitharana at vitharana8000@gmail.com.

Happy coding! 😊
