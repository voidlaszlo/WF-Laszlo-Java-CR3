package citybike;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private int stationID = 0;
    private String location = "";
    private List<Bike> bikesAtThisStation = new ArrayList<>();

    private static int idCount = 0;

    public Station(String location) {
        this.location = location;

        idCount++;
        this.stationID = idCount;
    }

    public void addBike(Bike bike) {
        if(this.getBikesAtThisStation().size() == 5) {
            System.out.println("Station " + this.getLocation() + " is full. Please return it to somewhere else.");
        } else {
            this.getBikesAtThisStation().add(bike);
        }
    }

    public void removeBike(Bike bike) {
        this.getBikesAtThisStation().remove(bike);
    }

    public int getStationID() {
        return stationID;
    }

    public String getLocation() {
        return location;
    }

    public List<Bike> getBikesAtThisStation() {
        return bikesAtThisStation;
    }
}
