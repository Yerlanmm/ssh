// PizzaOrderingSystem.java

// 1. Pizza Interface
interface Pizza {
    String getDescription();
    double getCost();
}

// 2. Concrete Classes for Basic Pizza Types
class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 6.99;
    }
}

class VegetarianPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Vegetarian Pizza";
    }

    @Override
    public double getCost() {
        return 7.99;
    }
}

// 3. Abstract ToppingDecorator Class
abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

// 4. Concrete Topping Decorators
class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50;
    }
}

class MushroomTopping extends ToppingDecorator {
    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.00;
    }
}

class PepperoniTopping extends ToppingDecorator {
    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.50;
    }
}

// 5. PizzaShop Class: Demonstrates the Decorator Pattern
public class PizzaOrderingSystem {
    public static void main(String[] args) {
        // Order 1: Margherita with Cheese and Mushroom toppings
        Pizza margheritaWithToppings = new MushroomTopping(new CheeseTopping(new MargheritaPizza()));
        System.out.println("Order 1: " + margheritaWithToppings.getDescription());
        System.out.println("Total Cost: $" + margheritaWithToppings.getCost());

        // Order 2: Vegetarian with Pepperoni topping
        Pizza vegetarianWithTopping = new PepperoniTopping(new VegetarianPizza());
        System.out.println("\nOrder 2: " + vegetarianWithTopping.getDescription());
        System.out.println("Total Cost: $" + vegetarianWithTopping.getCost());

        // Order 3: Margherita with all toppings
        Pizza fullyLoadedPizza = new PepperoniTopping(new MushroomTopping(new CheeseTopping(new MargheritaPizza())));
        System.out.println("\nOrder 3: " + fullyLoadedPizza.getDescription());
        System.out.println("Total Cost: $" + fullyLoadedPizza.getCost());
    }
}
