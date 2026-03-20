/**
 * Use Case 7: Add-On Service Selection
 *
 * Demonstrates mapping of reservations to multiple services
 * using Map + List and cost aggregation.
 *
 * @author Tirth
 * @version 7.0
 */

import java.util.*;

// Service class
class Service {
    private String name;
    private double cost;

    public Service(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}

// Manager class
class AddOnServiceManager {

    private Map<String, List<Service>> serviceMap = new HashMap<>();

    public void addService(String reservationId, Service service) {
        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);
    }

    public void displayServices(String reservationId) {
        System.out.println("Services for Reservation: " + reservationId);

        List<Service> services = serviceMap.getOrDefault(reservationId, new ArrayList<>());
        double total = 0;

        for (Service s : services) {
            System.out.println("- " + s.getName() + " ($" + s.getCost() + ")");
            total += s.getCost();
        }

        System.out.println("Total Add-On Cost: $" + total);
    }
}

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "RES-101";

        manager.addService(reservationId, new Service("Breakfast", 20));
        manager.addService(reservationId, new Service("Spa", 50));
        manager.addService(reservationId, new Service("Airport Pickup", 30));

        manager.displayServices(reservationId);
    }
}