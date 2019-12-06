package citybike;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Integer, Bike> bikes = new HashMap<>();
    public static Map<Integer, Station> stations = new HashMap<>();

    public static void main(String[] args) {
        Bike bike1 = new Bike("red", "CanBeRented");
        Bike bike2 = new Bike("blue", "CanBeRented");
        Bike bike3 = new Bike("black", "CanBeRented");
        Bike bike4 = new Bike("white", "CanBeRented");
        Bike bike5 = new Bike("purple", "CanBeRented");
        Bike bike6 = new Bike("yellow", "CanBeRented");
        Bike bike7 = new Bike("turquoise", "CanBeRented");
        Bike bike8 = new Bike("green", "CanBeRented");


        bikes.put(bike1.getBikeID(), bike1);
        bikes.put(bike2.getBikeID(), bike2);
        bikes.put(bike3.getBikeID(), bike3);
        bikes.put(bike4.getBikeID(), bike4);
        bikes.put(bike5.getBikeID(), bike5);
        bikes.put(bike6.getBikeID(), bike6);
        bikes.put(bike7.getBikeID(), bike7);
        bikes.put(bike8.getBikeID(), bike8);

        Station station1 = new Station("Hauptbahnhof");
        Station station2 = new Station("Kettenbrückengasse");
        Station station3 = new Station("Reumannplatz");

        stations.put(station1.getStationID(), station1);
        stations.put(station2.getStationID(), station2);
        stations.put(station3.getStationID(), station3);

        stations.get(1).addBike(bikes.get(1));
        stations.get(1).addBike(bikes.get(2));
        stations.get(1).addBike(bikes.get(3));
        stations.get(2).addBike(bikes.get(4));
        stations.get(2).addBike(bikes.get(5));
        stations.get(2).addBike(bikes.get(6));
        stations.get(2).addBike(bikes.get(7));

        User user1 = new User("user1", "user1s");
        User user2 = new User("user2", "user2s");
        User user3 = new User("user3", "user3s");
        User user4 = new User("user4", "user4s");

        // USER 1 WANTS TO GET A BIKE FROM THE HAUPTBAHNHOF STATION
            // BIKES BEFORE THE RENT AT THE HBF STATION
            System.out.println("Bikes at the HBF station : " + stations.get(1).getBikesAtThisStation());
            // CALLING THE RENT A BIKE FUNCTION
            user1.rentABike(1);
            // USER RENTED BIKE :
            System.out.println("\nCurrently rented : " + user1.getCurrentlyRentedBike());
            // BIKES AFTER THE RENT AT THE HBF STATION
            System.out.println("\nBikes at the HBF station : " + stations.get(1).getBikesAtThisStation());
            // RETURN THE BIKE TO THE REUMANNPLATZ STATION
            user1.returnABike(3);
            // SHOW THE USER RENTED BIKE :
            System.out.println("\nCurrently rented : " + user1.getCurrentlyRentedBike());
            // SHOW THE ARRAYLIST AT REUMANNPLATZ STATION
            System.out.println(stations.get(3).getBikesAtThisStation());

        System.out.println(user1.getRents());
    }
}
