package com.epam.assessment.cars.domain;

public class ElectricModel extends Model {

    private int batteryCapacity;
    private int energyConsumption;

    public ElectricModel(String manufacturer, String modelName, int power, int batteryCapacity, int energyConsumption) {
        super(manufacturer, modelName, power);
        this.batteryCapacity = batteryCapacity;
        this.energyConsumption = energyConsumption;
    }

    public int getBatteryCapacity() {
        return this.batteryCapacity;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }

    @Override
    public String toString() {
        return "ElectricModel{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                ", modelName='" + super.getModelName() + '\'' +
                ", power=" + super.getPower() +
                ", batteryCapacity=" + batteryCapacity +
                ", energyConsumption=" + energyConsumption +
                '}';
    }
}
