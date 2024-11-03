package test1;

import java.util.*;


public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product product, int quantity) throws Exception {
        if (!product.inStock(quantity)) {
            throw new Exception("Requested quantity for " + product.getName() + " is not in stock.");
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public Map<Product, Integer> getItems() {

        return items;
    }

    public boolean isEmpty() {

        return items.isEmpty();
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            subtotal += entry.getKey().getPrice() * entry.getValue();
        }
        return subtotal;
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> shippable = new ArrayList<>();
        for (Product product : items.keySet()) {
            if (product instanceof Shippable) {
                shippable.add((Shippable) product);
            }
        }
        return shippable;
    }
}