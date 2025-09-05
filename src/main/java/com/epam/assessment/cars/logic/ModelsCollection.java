package com.epam.assessment.cars.logic;

import com.epam.assessment.cars.domain.ElectricModel;
import com.epam.assessment.cars.domain.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ModelsCollection {

    ArrayList<Model> models = new ArrayList<>();

    public void readFromFile(String filePath) throws RuntimeException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    models.add(ModelParser.parse(line));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while reading file: " + filePath);
        }
    }

    public Optional<Model> getModel(String manufacturer, String modelName) {
        for (Model model : models) {

            if (model.getManufacturer().equals(manufacturer) && model.getModelName().equals(modelName)) {
                return Optional.of(model);
            }
        }
        return Optional.empty();
    }

    public List<ElectricModel> getElectricModelsByBatteryCapacity(int batteryCapacityLimit) {
        ArrayList<ElectricModel> electricModels = new ArrayList<>();

        for (Model model : models) {
            if (model instanceof ElectricModel && ((ElectricModel) model).getBatteryCapacity() >= batteryCapacityLimit) {
                electricModels.add((ElectricModel) model);
            }
        }

        Collections.sort(electricModels);

        return electricModels;
    }
}
