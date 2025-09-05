package com.epam.assessment.cars.domain;

public abstract class Car {
    private String licensePlate;
    private Model model;

    private int distanceDriven = 0;

    public Car(String licensePlate, Model model) {
        this.licensePlate = licensePlate;
        this.model = model;
    }

    public abstract void drive(int distance);

    public int getDistanceDriven() {
        return this.distanceDriven;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Model getModel() {
        return model;
    }

    public void setDistanceDriven(int distanceDriven) {
        this.distanceDriven = distanceDriven;
    }
}
