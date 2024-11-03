package test1;
import java.util.*;

public class CheckoutService {
    private static final double SHIPPING_COST_PER_KG = 10.0;

    public void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty.");
        }

        double subtotal = cart.calculateSubtotal();
        double totalWeight = calculateTotalWeight(cart.getShippableItems());
        double shippingCost = totalWeight * SHIPPING_COST_PER_KG;
        double totalAmount = subtotal + shippingCost;

        if (!customer.canAfford(totalAmount)) {
            throw new Exception("Insufficient balance for the checkout.");
        }

        validateCartItems(cart);

        customer.deductAmount(totalAmount);
        updateProductQuantities(cart);

        printReceipt(cart, subtotal, shippingCost, totalAmount, customer.getBalance());

        if (totalWeight > 0) {
            sendToShippingService(cart);
        }
    }

    private void validateCartItems(Cart cart) throws Exception {
        for (Product product : cart.getItems().keySet()) {
            if (product instanceof Expirable) {
                Expirable expirableProduct = (Expirable) product;
                if (expirableProduct.isExpired()) {
                    throw new Exception("Product " + product.getName() + " is expired.");
                }
            }
            if (!product.inStock(cart.getItems().get(product))) {
                throw new Exception("Product " + product.getName() + " is out of stock.");
            }
        }
    }

    private void updateProductQuantities(Cart cart) {
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.reduceQuantity(quantity);
        }
    }

    private double calculateTotalWeight(List<Shippable> shippables) {
        return shippables.stream().mapToDouble(Shippable::getWeight).sum();
    }

    private void sendToShippingService(Cart cart) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;
                double itemWeightKg = shippable.getWeight();
                totalWeight += itemWeightKg * quantity;

                System.out.println(quantity + "x " + product.getName() + "        " + itemWeightKg + "kg");
            }
        }
        System.out.println("Total package weight " + String.format("%.1f", totalWeight) + "kg");
    }

    private void printReceipt(Cart cart, double subtotal, double shippingCost, double totalAmount, double remainingBalance) {
        System.out.println("** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(quantity + "x " + product.getName() + "        " + (product.getPrice() * quantity));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal         " + subtotal);
        System.out.println("Shipping         " + shippingCost);
        System.out.println("Amount           " + totalAmount);
        System.out.println("Remaining Balance " + remainingBalance);
    }
}
