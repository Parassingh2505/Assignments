package Assignments;

public abstract class AbstractManufacturer {
    private String name;
    private String modelName;
    private String type;

    public AbstractManufacturer(String name, String modelName, String type) {
        this.name = name;
        this.modelName = modelName;
        this.type = type;
    }

    public String getModelName() {
        return modelName;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public abstract String getManufacturerInformation();
}