/**
 * BookMyStayApp
 *
 * Entry point for the Hotel Booking Management System.
 * This class demonstrates how a Java application starts execution
 * using the main() method and prints a welcome message to the console.
 *
 * @author Tirth
 * @version 1.0
 */

public class BookMyStayApp {

    /**
     * Main method - JVM starts program execution from here.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Application information
        String appName = "Book My Stay - Hotel Booking System";
        String version = "Version 1.0";

        // Welcome message
        System.out.println("=================================");
        System.out.println("       Welcome to " + appName);
        System.out.println("             " + version);
        System.out.println("=================================");

        // Informational message
        System.out.println("Your smart hotel booking assistant.");
        System.out.println("System initialized successfully.");

        // Program end message
        System.out.println("Application execution completed.");
    }
}