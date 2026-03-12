/**
 * Service
 *
 * Represents an optional add-on service.
 *
 * @author Tirth
 * @version 7.0
 */

public class Service {

    private String serviceName;
    private double price;

    public Service(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void displayService() {
        System.out.println(serviceName + " - $" + price);
    }
}