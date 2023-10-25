package Assignments;

class Car1 extends AbstractManufacturer implements Vehicle {
    public Car1(String name, String modelName, String carType) {
        super(name, modelName, carType);
    }

    @Override
    public int maxSpeed(String carType) {
        if (carType.equals("Sports")) {
            return 250;
        } else if (carType.equals("Sedan")) {
            return 190;
        } else {
            return 0;
        }
    }

    @Override
    public String getManufacturerInformation() {
        return "Car1{Manufacturer name:'" + getName() + "',Model Name:'" + getModelName() + "',Type:'" + getType() + "'}";
    }
}