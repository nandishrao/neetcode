package oops;
// INTERFACE 1: Capability to make calls
interface Callable {
    // Constant: public static final by default
    int MAX_REDIAL_ATTEMPTS = 3;

    // Abstract Method: public abstract by default (NO BODY)
    void makeCall(String phoneNumber);
    void endCall();


    static  int a = 10;
}

// INTERFACE 2: Capability to track location
interface GPS {
    void getCoordinates();
}

// CONCRETE CLASS: Implements MULTIPLE interfaces
class SmartPhone implements Callable, GPS {
    private String model;

    public SmartPhone(String model) {
        this.model = model;
    }

    // Implementing methods from Callable interface
    @Override
    public void makeCall(String phoneNumber) {
        System.out.println(model + " dialing " + phoneNumber + "... [Attempt 1/" + MAX_REDIAL_ATTEMPTS + "]");
    }

    @Override
    public void endCall() {
        System.out.println(model + " ended the call.");
    }

    // Implementing method from GPS interface
    @Override
    public void getCoordinates() {
        System.out.println(model + " GPS: 12.9716° N, 77.5946° E");
    }
}
public class InterfacesOOPs {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("iPhone 15");

        // 1. Polymorphic Reference using 'Callable' Interface
        Callable phoneService = myPhone;
        phoneService.makeCall("+1-555-0199");
        phoneService.endCall();
        // phoneService.getCoordinates(); // COMPILE ERROR! Callable remote control doesn't have GPS buttons.

        System.out.println("---");

        // 2. Polymorphic Reference using 'GPS' Interface
        GPS navigationService = myPhone;
        navigationService.getCoordinates();
        // navigationService.makeCall(...); // COMPILE ERROR! GPS remote control doesn't have call buttons.
    }
}
