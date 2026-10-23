package org.example;

public class Main {
    public static void main(String[] args) {
        CarWash carWash = new CarWash(new BasicWashStrategy());
        printWash("Basic wash", carWash);

        // Change the behavior of the SAME context object at runtime.
        carWash.setStrategy(new TouchlessWashStrategy());
        printWash("Touchless wash", carWash);

        carWash.setStrategy(new PremiumWashStrategy());
        printWash("Premium wash", carWash);
    }

    private static void printWash(String title, CarWash carWash) {
        System.out.println("=== " + title + " ===");
        int stepNumber = 1;
        for (String step : carWash.washCar()) {
            System.out.println(stepNumber++ + ". " + step);
        }
        System.out.println("Car wash completed!\n");
    }
}
