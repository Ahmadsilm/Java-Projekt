package droneMain;

public class DroneDynamic {
    int ID, speed, batteryStatus;
    String Timestamp, lastSeen;
    Drone drone;
    double alignmentRoll, controlRange, alignmentYaw, longitude, latitude;
    boolean status;

    public DroneDynamic(int ID, String Timestamp, Drone drone, int speed, double alignmentRoll,
            double controlRange, double alignmentYaw, double longitude, double latitude,
            int batteryStatus, String lastSeen, boolean status) {
        this.ID = ID;
        this.Timestamp = Timestamp;
        this.Timestamp = Timestamp;
        this.speed = speed;
        this.alignmentRoll = alignmentRoll;
        this.controlRange = controlRange;
        this.alignmentYaw = alignmentYaw;
        this.longitude = longitude;
        this.latitude = latitude;
        this.batteryStatus = batteryStatus;
        this.lastSeen = lastSeen;
        this.status = status;
    }
}