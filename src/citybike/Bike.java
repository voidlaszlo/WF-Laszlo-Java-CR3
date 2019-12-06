package citybike;

public class Bike {
    private int bikeID = 0;
    private String color = "";
    private String state = "";

    // STATIC COUNT FOR THE IDS(BIKE OBJECTS)
    public static int idCount = 0;

    public Bike(String color, String state) {
        this.color = color;
        this.state = state;

        idCount++;
        this.setBikeID(idCount);
    }

    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "\nBike{" +
                "bikeID=" + bikeID +
                ", color='" + color + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
