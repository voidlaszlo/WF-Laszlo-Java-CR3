package citybike;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int userID = 0;
    private String name = "";
    private String surname = "";
    private Bike currentlyRentedBike = null;
    private Rent rent = new Rent();
    private List<Rent> rents = new ArrayList<>();

    private static int idCount = 0;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;

        idCount++;
        this.userID = idCount;
    }

    class Rent {
        private int bikeID = -1;
        private LocalDate rentStart = null;
        private LocalDate rentEnd = null;

        public Rent(){}
        public Rent(int bikeID) {
            this.bikeID = bikeID;
        }

        public int getBikeID() {
            return bikeID;
        }

        public void setBikeID(int bikeID) {
            this.bikeID = bikeID;
        }

        public LocalDate getRentStart() {
            return rentStart;
        }

        public void setRentStart(LocalDate rentStart) {
            this.rentStart = rentStart;
        }

        public LocalDate getRentEnd() {
            return rentEnd;
        }

        public void setRentEnd(LocalDate rentEnd) {
            this.rentEnd = rentEnd;
        }

        @Override
        public String toString() {
            return "Rent{" +
                    "bikeID=" + bikeID +
                    ", rentStart=" + rentStart +
                    ", rentEnd=" + rentEnd +
                    '}';
        }
    }

    public void rentABike(Integer stationID) {
        if(Main.stations.get(stationID).getBikesAtThisStation().size() != 0) {
            this.setCurrentlyRentedBike(Main.stations.get(stationID).getBikesAtThisStation().get(Main.stations.get(stationID).getBikesAtThisStation().size()-1));
            rent.setBikeID(Main.stations.get(stationID).getBikesAtThisStation().size());
            rent.setRentStart(LocalDate.now());
            Main.stations.get(stationID).removeBike(Main.stations.get(stationID).getBikesAtThisStation().get(Main.stations.size()-1));
        } else {
            System.out.println("There are no bikes here sadly...");
        }
    }

    public void returnABike(Integer stationID) {
        Main.stations.get(stationID).addBike(this.getCurrentlyRentedBike());
        this.setCurrentlyRentedBike(null);

        this.getRent().setRentEnd(LocalDate.now());
        this.getRents().add(this.getRent());
        this.setRent(null);
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Bike getCurrentlyRentedBike() {
        return currentlyRentedBike;
    }

    public void setCurrentlyRentedBike(Bike currentlyRentedBike) {
        this.currentlyRentedBike = currentlyRentedBike;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public List<Rent> getRents() {
        return rents;
    }
}
