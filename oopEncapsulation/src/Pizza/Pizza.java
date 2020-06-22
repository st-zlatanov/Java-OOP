package Pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
        this.dough = null;
        this.toppings = new ArrayList<>(this.numberOfToppings);
    }

    private void setToppings(int numberOfToppings) {
        Validator.validateNumberOfToppings(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        Validator.validatePizzaName(name);
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping){
        if(this.toppings.size()<this.numberOfToppings){
            this.toppings.add(topping);
        }

    }

    public double getOverallCalories(){
        return this.dough.calculateCalories()+
                this.toppings.stream()
                        .mapToDouble(Topping::calculateCalories)
                .sum();
    }
}
