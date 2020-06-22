package vehicles;

public class Truck extends Vehicle {
    private static final double ADDITIONALCONSUMPTION = 1.6;
    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONALCONSUMPTION);
    }
    @Override
    public void refuel(double fuel){
        super.refuel(fuel*0.95);
    }
}
