import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompositeDemoTest {

    @Test
    void testMenuStructure() {
        MenuItem coffee = new MenuItem("Coffee", 2.99);
        MenuItem tea = new MenuItem("Tea", 1.99);
        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.add(coffee);
        drinksMenu.add(tea);

        assertEquals(2, drinksMenu.menuComponents.size()); // Check size
    }

    @Test
    void testPrint() {
        MenuItem sandwich = new MenuItem("Sandwich", 4.99);
        Menu foodMenu = new Menu("Food");
        foodMenu.add(sandwich);

        // Capture print output (use a library like SystemLambda for advanced testing)
        foodMenu.print();
    }
}