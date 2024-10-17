// RestaurantMenuSystem.java

import java.util.ArrayList;
import java.util.List;

// Abstract Class: MenuComponent
abstract class MenuComponent {
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}

// Leaf Class: MenuItem (Individual Dishes)
class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println("  " + getName() + " -- " + getDescription() + " ($" + getPrice() + ")");
    }
}

// Composite Class: Menu (Contains MenuItems or Sub-Menus)
class Menu extends MenuComponent {
    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent component) {
        menuComponents.add(component);
    }

    @Override
    public void remove(MenuComponent component) {
        menuComponents.remove(component);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponents.get(index);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("\n" + getName() + " -- " + getDescription());
        System.out.println("---------------------");

        for (MenuComponent component : menuComponents) {
            component.print();
        }
    }
}

// Main Class: RestaurantApp (Demonstrating the Composite Pattern)
public class RestaurantMenuSystem {
    public static void main(String[] args) {
        // Create individual menu items
        MenuComponent burger = new MenuItem("Burger", "Classic beef burger", 8.99);
        MenuComponent fries = new MenuItem("Fries", "Crispy french fries", 3.49);
        MenuComponent soda = new MenuItem("Soda", "Coca-Cola", 1.99);

        MenuComponent pasta = new MenuItem("Pasta", "Spaghetti with marinara sauce", 12.99);
        MenuComponent salad = new MenuItem("Salad", "Fresh garden salad", 7.49);

        // Create a sub-menu for the lunch menu
        MenuComponent lunchMenu = new Menu("Lunch Menu", "Afternoon delights");
        lunchMenu.add(burger);
        lunchMenu.add(fries);
        lunchMenu.add(soda);

        // Create a sub-menu for the dinner menu
        MenuComponent dinnerMenu = new Menu("Dinner Menu", "Evening specials");
        dinnerMenu.add(pasta);
        dinnerMenu.add(salad);

        // Create the main menu and add the sub-menus
        MenuComponent mainMenu = new Menu("Main Menu", "All available dishes");
        mainMenu.add(lunchMenu);
        mainMenu.add(dinnerMenu);

        // Print the entire menu
        System.out.println("Restaurant Menu:");
        mainMenu.print();
    }
}

