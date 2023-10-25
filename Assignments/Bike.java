package Assignments;

class Bike extends AbstractManufacturer implements Vehicle {
    public Bike(String name, String modelName, String bikeType) {
        super(name, modelName, bikeType);
    }

    @Override
    public int maxSpeed(String bikeType) {
        if (bikeType.equals("Sports")) {
            return 300;
        } else if (bikeType.equals("Cruiser")) {
            return 170;
        } else {
            return 0;
        }
    }

    @Override
    public String getManufacturerInformation() {
        return "Bike{Manufacturer name:'" + getName() + "',Model Name:'" + getModelName() + "',Type:'" + getType() + "'}";
    }
}