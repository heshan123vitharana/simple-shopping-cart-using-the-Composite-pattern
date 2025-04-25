// Component 

import java.util.ArrayList;
import java.util.List;

interface chartComponent { 
    void print(); 
} 
 
// Leaf 
class ChartItem implements chartComponent { 
    private String product; 
    private double productbox; 
     
    public ChartItem(String product, double productbox) { 
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
class Chart implements chartComponent { 
    private String name; 
    private List<chartComponent> chartComponents = new ArrayList<>(); 
     
    public Chart(String name) { 
        this.name = name; 
    } 
     
    public void add(chartComponent chartComponent) { 
        if (chartComponent != null) {
            chartComponents.add(chartComponent);
        } else {
            System.out.println("Cannot add null chartComponent.");
        }
    } 

    public void remove(chartComponent chartComponent) {
        chartComponents.remove(chartComponent);
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
        for (chartComponent chartComponent :menuComponents) {
            if (chartComponent instanceof Chart) {
                ((Chart) chartComponent).print(indent + 1);
            } else {
                for (int i = 0; i <= indent; i++) {
                    System.out.print("  "); // Indentation for leaf nodes
                }
                chartComponent.print();
            }
        }
    }
} 
 
// Client code 
public class CompositeDemo { 
    public static void main(String[] args) { 
        // Create menu items 
        ChartItem PoloShirtMensM = new ChartItem("PoloShirtMens(M)", 5); 
        ChartItem DarkBlueMensDenim= new ChartItem("DarkBlueMensDenim", 10); 
        ChartItem PoloShirtWomensL = new ChartItem("PoloShirtWomens(L)", 7); 
        ChartItem SkirtsDenim = new ChartItem("SkirtsDenim", 15); 
         
        // Create menus 
        Chart MensMenu = new Chart("Mens"); 
        Chart WomensMenu = new Chart("Womens"); 
        Chart mainMenu = new Chart("Clothing"); 
         
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