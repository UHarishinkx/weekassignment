import java.util.*;

class ParkingLot {

    String[] table = new String[10];

    int hash(String plate){
        return Math.abs(plate.hashCode()) % table.length;
    }

    void parkVehicle(String plate){

        int index = hash(plate);

        while(table[index]!=null)
            index=(index+1)%table.length;

        table[index]=plate;

        System.out.println("Vehicle parked at spot "+index);
    }

    public static void main(String[] args){

        ParkingLot p = new ParkingLot();

        p.parkVehicle("ABC123");
        p.parkVehicle("XYZ999");
    }
}