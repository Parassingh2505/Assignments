package Assignments;

class Car {
    private String modelName;
    private String manufacturerName;
    private int engineCapacity;
    private CarType carType;

    public Car(String modelName, String manufacturerName, int engineCapacity, CarType carType) {
        this.modelName = modelName;
        this.manufacturerName = manufacturerName;
        this.engineCapacity = engineCapacity;
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "{modelName: '" + modelName + "', manufacturerName: '" + manufacturerName +
               "', engineCapacity: " + engineCapacity + ", carType: '" + carType + "'}";
    }
}