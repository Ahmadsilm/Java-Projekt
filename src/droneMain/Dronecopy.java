package droneMain;

//import java.util.Date;

public class Dronecopy {
    int ID;
    String manifacture, typeName, serialNumber;
    // Date createdDate ,lastUpdate;
    boolean status;
    
    public Dronecopy(int ID, String manifacture ,String typeName , String serialNumber, String createdDate,String lastUpdate, boolean status ) {
    // public Drone(int ID, String manifacture ,String typeName , String serialNumber, boolean status ) {

        this.ID = ID;
        this.manifacture = manifacture;
        this.typeName = typeName;
        this.serialNumber = serialNumber;
        //this.createdDate = createdDate;
        //this.lastUpdate = lastUpdate;
        this.status = status;
    }
    
    // public int getID(){
    //     return ID;
    // }
    // public String getManifacture(){
    //     return manifacture;
    // }
    // public String getTypeName(){
    //     return typeName;
    // }
    // public String getSerialNumber(){
    //     return serialNumber;
    // }
    //public Date getCreatedDate(){
    //    return createdDate;
    //}
    //public Date getLastUpdate(){
    //    return lastUpdate;
    //}
    // public boolean getStatus(){
    //     return status;
    // }
}