package farm.animals;

import farm.foods.Food;

public abstract class Mammal extends Animal {
    private String livingRegion;
    protected Mammal(String name, String type, double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;

    }

    @Override
    public void eat(Food food){
        boolean foodIsMeat = food
                .getClass()
                .getSimpleName()
                .equals("Meat");

        if(foodIsMeat && !(this instanceof Felime)){
            String message = (this.getType()
                    + "s are not eating that type of food!")
                    .replace("Mouses", "Mice");

            throw new IllegalArgumentException(message);

        }else if(!foodIsMeat && this.getType().equals("Tiger")){
            throw new IllegalArgumentException
                    ("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public String toString() {
        return super.toString().replace("region", this.livingRegion);
    }
}
