package vehicles;

public class Car  extends  Vehicle{
    private static final double ADDITIONALCONSUMPTION = 0.9;
    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption+ADDITIONALCONSUMPTION);
    }
}
