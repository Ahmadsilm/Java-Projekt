package droneMain;

//import java.util.Date;

public class DroneType {
    int ID, weight, maxSpeed, batteryCapacity, controlRange, maxCarriage;
    String manifacture, typeName;

    public DroneType(int ID, String manifacture, String typeName, int weight, int maxSpeed,
            int batteryCapacity, int controlRange, int maxCarriage) {
        this.ID = ID;
        this.manifacture = manifacture;
        this.typeName = typeName;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.batteryCapacity = batteryCapacity;
        this.controlRange = controlRange;
        this.maxCarriage = maxCarriage;
    }
}