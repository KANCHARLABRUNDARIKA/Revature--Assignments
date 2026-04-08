interface Connectable{
    void  connectToWifi();
}

interface Controllable{
    void turnOn();
    void turnOff();
}

class SmartProjector implements Connectable,Controllable{
     int deviceId;
     String brand;

    public void connectToWifi(){
        System.out.println(" Wifi Details ");
        System.out.println(" Device ID : "+deviceId);
        System.out.println(" brand : "+brand);
    }
    public void turnOn(){
        System.out.println( deviceId +" is Turned On ");
    }
    public void turnOff(){
        System.out.println( deviceId +" is Turned Off ");
    }
    void displayDeviceInfo(){
        System.out.println("-----------Projector Details--------");

        connectToWifi();
        turnOn();
        turnOff();
     }
}

public class a30SmartDevices {
    public static void main(String[] args){
        SmartProjector smartProjector=new SmartProjector();
        smartProjector.deviceId = 123;
        smartProjector.brand = "xyz";
        smartProjector.displayDeviceInfo();
    }

}
