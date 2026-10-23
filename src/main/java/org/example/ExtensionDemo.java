package org.example;

public class ExtensionDemo {
    public static void main(String[] args) {
        CarWash carWash = new CarWash(new WaterlessWashStrategy());
        System.out.println("=== Waterless wash: extension example ===");
        carWash.washCar().forEach(System.out::println);
    }
}
