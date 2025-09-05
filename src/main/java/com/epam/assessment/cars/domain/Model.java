package com.epam.assessment.cars.domain;

public class Model implements Comparable<Model> {

    private String manufacturer;
    private String modelName;
    private int power;

    public Model(String manufacturer, String modelName, int power) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.power = power;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModelName() {
        return this.modelName;
    }

    public int getPower() {
        return this.power;
    }

    @Override
    public String toString() {
        return "Model{" +
                "manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", power=" + power +
                '}';
    }

    @Override
    public int compareTo(Model m) {
        int manufacturerCompare = this.manufacturer.compareTo(m.manufacturer);

        if (manufacturerCompare != 0) {
            return manufacturerCompare;
        }

        return this.modelName.compareTo(m.modelName);
    }
}
