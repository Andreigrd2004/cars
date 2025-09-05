package com.epam.assessment.cars.logic;

import com.epam.assessment.cars.domain.ElectricModel;
import com.epam.assessment.cars.domain.Model;
import com.epam.assessment.cars.domain.RegularModel;

import java.util.Objects;

public class ModelParser {
    public static Model parse(String line) throws IllegalArgumentException {

        String[] fields = line.split(",");

        if (!Objects.equals(fields[0], "Regular") && !Objects.equals(fields[0], "Electric")) {
            throw new IllegalArgumentException("Unknown type: " + fields[0]);
        }

        if (fields.length != 6) {
            throw new IllegalArgumentException("Invalid number of parameters. Expected 6, received: " + fields.length);
        }
        String manufacturer = fields[1];
        String modelName = fields[2];
        int power = Integer.parseInt(fields[3]);

        if (fields[0].equals("Regular")) {
            int engineDisplacement = Integer.parseInt(fields[4]);
            double fuelConsumption = Double.parseDouble(fields[5]);
            return new RegularModel(manufacturer, modelName, power, engineDisplacement, fuelConsumption);
        }else{
            int batteryCapacity = Integer.parseInt(fields[4]);
            int energyConsumption = Integer.parseInt(fields[5]);
            return new ElectricModel(manufacturer, modelName, power, batteryCapacity, energyConsumption);
        }
    }
}
