package droneMain;

//import java.util.Date;

public class Drone {
    int ID, carriageWeight;
    String droneType, createdDate, serialNumber, carriageType;

    public Drone(int ID, String droneType, String createdDate, String serialNumber, int carriageWeight,
            String carriageType) {
        this.ID = ID;
        this.droneType = droneType;
        this.createdDate = createdDate;
        this.serialNumber = serialNumber;
        this.carriageWeight = carriageWeight;
        this.carriageType = carriageType;
    }
}