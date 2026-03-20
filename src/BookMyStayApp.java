/**
 * Use Case 11: Concurrent Booking Simulation
 *
 * Demonstrates thread-safe booking using synchronization.
 *
 * @author Tirth
 * @version 11.0
 */

import java.util.*;

// Shared Inventory
class RoomInventory {

    private Map<String, Integer> inventory = new HashMap<>();

    public RoomInventory() {
        inventory.put("Single Room", 2);
    }

    // synchronized critical section
    public synchronized boolean bookRoom(String type) {

        int available = inventory.getOrDefault(type, 0);

        if (available > 0) {
            inventory.put(type, available - 1);
            System.out.println(Thread.currentThread().getName() + " booked " + type);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + " failed (no rooms)");
            return false;
        }
    }
}

// Booking Task (Thread)
class BookingTask implements Runnable {

    private RoomInventory inventory;

    public BookingTask(RoomInventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public void run() {
        inventory.bookRoom("Single Room");
    }
}

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        // Simulate multiple users
        Thread t1 = new Thread(new BookingTask(inventory), "User-1");
        Thread t2 = new Thread(new BookingTask(inventory), "User-2");
        Thread t3 = new Thread(new BookingTask(inventory), "User-3");

        t1.start();
        t2.start();
        t3.start();
    }
}