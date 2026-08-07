package oops;

// Parent Class
class PaymentProcessor {
    // 1. Instance Field - NO dynamic dispatch (resolved by Reference Type)
    public String processorType = "Generic Processor";

    // 2. Overridable Instance Method - DYNAMIC DISPATCH applies
    public void processPayment(double amount) {
        System.out.println("[Parent] Processing generic payment of $" + amount);
    }

    // 3. Static Method - NO dynamic dispatch (Method Hiding)
    public static void showInfo() {
        System.out.println("[Parent Static] Standard payment system operational.");
    }

    // 4. Final Method - NO dynamic dispatch (bound statically by compiler)
    public final void logTransaction(String id) {
        System.out.println("[Parent Final] Transaction logged with ID: " + id);
    }
}

// Child Class 1
class CreditCardProcessor extends PaymentProcessor {
    public String processorType = "Credit Card Processor";

    // Overriding Instance Method
    @Override
    public void processPayment(double amount) {
        System.out.println("[CreditCard] Authorizing credit card for $" + amount + " with 2% fee.");
    }

    // Static Method Hiding (not overriding)
    public static void showInfo() {
        System.out.println("[CreditCard Static] Credit card processing network active.");
    }

    // Child-specific method
    public void verifyCVV() {
        System.out.println("[CreditCard] CVV verified successfully.");
    }
}

// Child Class 2
class CryptoProcessor extends PaymentProcessor {
    public String processorType = "Crypto Processor";

    // Overriding Instance Method
    @Override
    public void processPayment(double amount) {
        System.out.println("[Crypto] Executing blockchain transaction for $" + amount + " via gas fee.");
    }
}

// Execution / Test Class
public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. DYNAMIC METHOD DISPATCH IN ACTION ===");
        // Parent references holding different child objects
        PaymentProcessor card = new CreditCardProcessor();
        PaymentProcessor crypto = new CryptoProcessor();

        // Same method call, completely different runtime behavior via vtable lookup
        card.processPayment(150.00);   // Executes CreditCardProcessor.processPayment()
        crypto.processPayment(300.00); // Executes CryptoProcessor.processPayment()

        System.out.println("\n=== 2. HETEROGENEOUS POLYMORPHIC ARRAY ===");
        // Polymorphic processing loop
        PaymentProcessor[] pipeline = { new PaymentProcessor(), new CreditCardProcessor(), new CryptoProcessor() };
        for (PaymentProcessor p : pipeline) {
            p.processPayment(50.00); // Resolved dynamically per object at runtime
        }

        System.out.println("\n=== 3. WHAT DOES NOT GET DYNAMICALLY DISPATCHED ===");

        // A. Fields are resolved at COMPILE-TIME using the Reference Type
        System.out.println("Field Value: " + card.processorType);
        // Output: "Generic Processor" (Not "Credit Card Processor")

        // B. Static Methods are resolved at COMPILE-TIME using Reference Type (Method Hiding)
        card.showInfo();
        // Output: "[Parent Static]..." (Not "[CreditCard Static]...")

        // C. Final Methods execute parent logic directly (no overriding allowed)
        card.logTransaction("TXN-99823");

        System.out.println("\n=== 4. ACCESSIBILITY RESTRICTION & DOWNCASTING ===");
        // card.verifyCVV(); // COMPILE ERROR: Reference type PaymentProcessor doesn't have verifyCVV()

        // Explicit Downcasting allows access to child-specific methods
        if (card instanceof CreditCardProcessor) {
            CreditCardProcessor specificCard = (CreditCardProcessor) card;
            specificCard.verifyCVV();
        }
    }
}