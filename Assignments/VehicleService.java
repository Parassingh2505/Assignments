package Assignments;

class VehicleService {
    public Car1 createCar(String name, String modelName, String type) {
        return new Car1(name, modelName, type);
    }

    public Bike createBike(String name, String modelName, String type) {
        return new Bike(name, modelName, type);
    }

    public int compareMaxSpeed(Vehicle first, Vehicle second) {
        if (first.maxSpeed("Sports") > second.maxSpeed("Sports")) {
            return 1;
        } else if (first.maxSpeed("Sports") < second.maxSpeed("Sports")) {
            return -1;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        VehicleService service = new VehicleService();

        Car1 sportsCar = service.createCar("Tesla", "Model S", "Sports");
        Car1 sedanCar = service.createCar("Toyota", "Camry", "Sedan");

        Bike sportsBike = service.createBike("Ducati", "Monster", "Sports");
        Bike cruiserBike = service.createBike("Harley-Davidson", "Sportster", "Cruiser");

        System.out.println(sportsCar.getManufacturerInformation());
        System.out.println(sedanCar.getManufacturerInformation());
        System.out.println(sportsBike.getManufacturerInformation());
        System.out.println(cruiserBike.getManufacturerInformation());

        int comparisonResult1 = service.compareMaxSpeed(sportsCar, sportsBike);
        int comparisonResult2 = service.compareMaxSpeed(sedanCar, cruiserBike);

        System.out.println("Comparison Result 1: " + comparisonResult1);
        System.out.println("Comparison Result 2: " + comparisonResult2);
    }
}