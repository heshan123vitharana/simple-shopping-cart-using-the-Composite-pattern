// Component 

import java.util.ArrayList;
import java.util.List;

interface MenuComponent { 
    void print(); 
} 
 
// Leaf 
class MenuItem implements MenuComponent { 
    private String product; 
    private double productbox; 
     
    public MenuItem(String product, double productbox) { 
        if (product == null || product.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (productbox < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.product = product;
        this.productbox = productbox;
    } 
     
    @Override 
    public void print() { 
        System.out.println(product + " - $" + productbox); 
    } 
} 
 
// Composite 
class Menu implements MenuComponent { 
    private String name; 
    private List<MenuComponent> menuComponents = new ArrayList<>(); 
     
    public Menu(String name) { 
        this.name = name; 
    } 
     
    public void add(MenuComponent menuComponent) { 
        if (menuComponent != null) {
            menuComponents.add(menuComponent);
        } else {
            System.out.println("Cannot add null MenuComponent.");
        }
    } 

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }
     
    @Override 
    public void print() { 
        print(0);
    }

    private void print(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  "); // Indentation
        }
        System.out.println(name + ":");
        for (MenuComponent menuComponent : menuComponents) {
            if (menuComponent instanceof Menu) {
                ((Menu) menuComponent).print(indent + 1);
            } else {
                for (int i = 0; i <= indent; i++) {
                    System.out.print("  "); // Indentation for leaf nodes
                }
                menuComponent.print();
            }
        }
    }
} 
 
// Client code 
public class CompositeDemo { 
    public static void main(String[] args) { 
        // Create menu items 
        MenuItem PoloShirtMensM = new MenuItem("PoloShirtMens(M)", 5); 
        MenuItem DarkBlueMensDenim= new MenuItem("DarkBlueMensDenim", 10); 
        MenuItem PoloShirtWomensL = new MenuItem("PoloShirtWomens(L)", 7); 
        MenuItem SkirtsDenim = new MenuItem("SkirtsDenim", 15); 
         
        // Create menus 
        Menu MensMenu = new Menu("Mens"); 
        Menu WomensMenu = new Menu("Womens"); 
        Menu mainMenu = new Menu("Clothing"); 
         
        // Add items to menus 
        MensMenu.add(PoloShirtMensM); 
        MensMenu.add(DarkBlueMensDenim); 
         
        WomensMenu.add(SkirtsDenim); 
        WomensMenu.add(PoloShirtWomensL); 
         
        // Add sub-menus to main menu 
        mainMenu.add(MensMenu); 
        mainMenu.add(WomensMenu); 
         
        // Print entire menu 
        mainMenu.print(); 
    } 
}