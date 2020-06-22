package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private boolean airConditionIsOn;
    private double fuelConsumption;


    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setAirConditionIsOn();
        this.setFuelConsumption(fuelConsumption);

    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private void setAirConditionIsOn() {
        this.airConditionIsOn = true;
    }

    public String drive(double distance) {
        String output = null;
        double fuelNeeded = distance * this.fuelConsumption;

        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;

            DecimalFormat format = new DecimalFormat("#.##");
            output = String.format("%s travelled %s km",
                    this.getClass().getSimpleName(),
                    format.format(distance));
        } else {
            output = String.format("%s needs refueling",
                    this.getClass().getSimpleName());
        }
        return output;
    }
    public void refuel(double fuel){
        this.fuelQuantity +=fuel;
    }

    @Override
    public String toString() {

        return String.format("%s: %.2f",this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
