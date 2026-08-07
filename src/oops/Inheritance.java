package oops;// Base Class (Parent)


class Vehicle {
    private String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void startEngine() {
        System.out.println("The " + brand + " engine starts.");
    }

    public String getBrand() {
        return brand;
    }
}

// Derived Class (Child inheriting from Vehicle)
class Car extends Vehicle {
    private int doors;

    public Car(String brand, int doors) {
        super(brand); // Invokes Parent Constructor
        this.doors = doors;
    }

    // Method Overriding (Polymorphism)
    @Override
    public void startEngine() {
        System.out.println("The " + getBrand() + " Car (with " + doors + " doors) starts with a push-button!");
    }

    // Child-specific method
    public void drive() {
        System.out.println("Driving the " + getBrand() + " car...");
    }
}

// Execution Class
public class Inheritance {
    public static void main(String[] args) {
        // Polymorphism: Reference of Parent class, Object of Child class
        Vehicle myVehicle = new Car("Tesla", 4);

        // Calls the overridden method in Car at runtime (Dynamic Method Dispatch)
        myVehicle.startEngine();

        // Downcasting to access child-specific methods
        Car myCar = (Car) myVehicle;
        myCar.drive();
    }
}