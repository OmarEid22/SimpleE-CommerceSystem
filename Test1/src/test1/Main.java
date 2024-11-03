package test1;

import java.util.*;

public class Main {
    public static void main(String[] args)  {
        /* "Car Is Empty"
        try {
            Expirableproduct milk = new Expirableproduct("milk", 20, 10, new Date(System.currentTimeMillis() + 1000));
            ShippableProduct tv = new ShippableProduct("TV", 500, 5, 15.0);
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20);
            Customer customer = new Customer("OMAR", 100000);
            Cart cart = new Cart();
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout Error: " + e.getMessage());
        }
         */

        /* "Requested Quantity for a Product not in stock "
        try {
            Expirableproduct milk = new Expirableproduct("milk", 20, 10, new Date(System.currentTimeMillis() + 1000));
            ShippableProduct tv = new ShippableProduct("TV", 500, 5, 15.0);
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20);
            Customer customer = new Customer("OMAR", 100000);
            Cart cart = new Cart();
            cart.addItem(milk, 100);
            cart.addItem(tv, 5);
            cart.addItem(scratchCard, 12);
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout Error: " + e.getMessage());
        }
         */

        /* "Insufficient Balance"
        try {
            Expirableproduct milk = new Expirableproduct("milk", 20, 10, new Date(System.currentTimeMillis() + 1000));
            ShippableProduct tv = new ShippableProduct("TV", 500, 5, 15.0);
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20);
            Customer customer = new Customer("OMAR", 100);
            Cart cart = new Cart();
            cart.addItem(milk, 10);
            cart.addItem(tv, 5);
            cart.addItem(scratchCard, 15);
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout Error: " + e.getMessage());
        }
         */

        /* "Product IS Expired"
        try {
            Expirableproduct milk = new Expirableproduct("milk", 20, 10, new Date(System.currentTimeMillis() + 1));
            ShippableProduct tv = new ShippableProduct("TV", 500, 5, 15.0);
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20);
            Customer customer = new Customer("OMAR", 100000);
            Cart cart = new Cart();
            cart.addItem(milk, 10);
            cart.addItem(tv, 5);
            cart.addItem(scratchCard, 15);
            CheckoutService checkoutService = new CheckoutService();
            checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout Error: " + e.getMessage());
        }
         */
        try {
            Expirableproduct milk = new Expirableproduct("Milk", 20, 10, new Date(System.currentTimeMillis() + 1000));
            ShippableProduct tv = new ShippableProduct("TV", 500, 5, 15.0);
            Product scratchCard = new Product("Mobile Scratch Card", 50, 20);
            Customer customer = new Customer("OMAR", 10000);
            Cart cart = new Cart();
            cart.addItem(milk, 10);
            cart.addItem(tv, 5);
            cart.addItem(scratchCard, 15);
            CheckoutService checkoutService = new CheckoutService();
           checkoutService.checkout(customer, cart);
        } catch (Exception e) {
            System.out.println("Checkout Error : " + e.getMessage());
        }
    }
}
