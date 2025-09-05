package com.epam.assessment.cars.domain;

public class ElectricCar extends Car {
    private int batteryLevel;

    public ElectricCar(String licensePlate, ElectricModel electricModel, int batteryLevel) {
        super(licensePlate, electricModel);
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void drive(int distance) throws IllegalStateException {
        Model carModel = this.getModel();

        double energyConsumptionPerKilometer = ((ElectricModel) carModel).getEnergyConsumption() / 100.0;
        double totalEnergyConsumption = energyConsumptionPerKilometer * distance;

        if ((int) (batteryLevel - totalEnergyConsumption) <= 0) {
            throw new IllegalStateException();
        }

        this.batteryLevel = (int) (batteryLevel - totalEnergyConsumption);
        this.setDistanceDriven(this.getDistanceDriven() + distance);

        System.out.println("Simulating" + carModel.getManufacturer() + " " + carModel.getModelName() + " driving...");
        System.out.println("Driving for " + distance + " km");
        System.out.println("    Odometer: " + this.getDistanceDriven() + " km");
        System.out.println("    Consumption: " + energyConsumptionPerKilometer + " kWh");
        System.out.println("    Battery level: " + batteryLevel);

    }

    public int getBatteryLevel() {
        return this.batteryLevel;
    }
}
