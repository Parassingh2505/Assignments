package Assignments;

import java.util.ArrayList;
import java.util.List;

public class CarDetailsListCreation {
    private List<Car> carCatalog;

    public CarDetailsListCreation() {
        carCatalog = new ArrayList<>();
    }

    public String getCarDetails() {
        return carCatalog.toString();
    }

    public void setCarDetails(String modelName, String manufacturerName, int engineCapacity, String carType) {
        try {
            validateInputs(modelName, manufacturerName, engineCapacity, carType);
            CarType type = CarType.valueOf(carType.toUpperCase());
            Car car = new Car(modelName, manufacturerName, engineCapacity, type);
            carCatalog.add(car);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    private void validateInputs(String modelName, String manufacturerName, int engineCapacity, String carType)
            throws OutOfRangeException, WrongInputException {
        if (modelName == null || modelName.trim().isEmpty()) {
            throw new WrongInputException("Input might contain a null or empty or blank space value");
        }
        if (engineCapacity < 0 || engineCapacity > 10000) {
            throw new OutOfRangeException("Engine capacity out of range (0-10,000)");
        }
        if (!isValidCarType(carType)) {
            throw new WrongInputException("Invalid car type");
        }
    }

    private boolean isValidCarType(String carType) {
        try {
            CarType.valueOf(carType.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        CarDetailsListCreation carCatalog = new CarDetailsListCreation();

        carCatalog.setCarDetails("Vitara Brezza", "MarutiSuzuki", 1000, "suv");
        System.out.println(carCatalog.getCarDetails());

        carCatalog.setCarDetails(null, "MarutiSuzuki", 1200, "HatchBack");
        // It will throw a WrongInputException with the specified message.
    }
}