/**
 * Use Case 12: Data Persistence & System Recovery
 *
 * Demonstrates saving and loading system state using serialization.
 *
 * @author Tirth
 * @version 12.0
 */

import java.io.*;
import java.util.*;

// Serializable Inventory
class RoomInventory implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public void display() {
        System.out.println("Inventory: " + inventory);
    }
}

// Persistence Service
class PersistenceService {

    private static final String FILE_NAME = "inventory.dat";

    // Save
    public void save(RoomInventory inventory) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
            System.out.println("Data saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }

    // Load
    public RoomInventory load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Data loaded successfully.");
            return (RoomInventory) ois.readObject();
        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
            return new RoomInventory();
        }
    }
}

public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        PersistenceService service = new PersistenceService();

        // Load previous state
        RoomInventory inventory = service.load();

        // Modify state
        inventory.addRoom("Single Room", 5);

        inventory.display();

        // Save state
        service.save(inventory);
    }
}