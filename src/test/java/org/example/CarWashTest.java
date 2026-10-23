package org.example;

import java.util.List;

/** Dependency-free tests, executed by verify.ps1. */
public class CarWashTest {
    public static void main(String[] args) {
        delegatesAndSwitchesAtRuntime();
        rejectsNullStrategy();
        verifiesWashPrograms();
        System.out.println("PASS: delegation, runtime switching, null validation and wash programs");
    }

    private static void delegatesAndSwitchesAtRuntime() {
        int[] calls = {0};
        List<String> expected = List.of("Custom wash");
        WashStrategy custom = () -> {
            calls[0]++;
            return expected;
        };
        CarWash carWash = new CarWash(new BasicWashStrategy());
        carWash.setStrategy(custom);
        check(carWash.washCar() == expected, "Context must return the strategy result");
        check(calls[0] == 1, "Context must execute the selected strategy exactly once");

        carWash.setStrategy(new TouchlessWashStrategy());
        check(carWash.washCar().contains("Apply active foam"), "Switch must change behavior");
        check(calls[0] == 1, "Previous strategy must no longer run");

        carWash.setStrategy(new WaterlessWashStrategy());
        check(carWash.washCar().size() == 3, "New strategy must work with unchanged context");
    }

    private static void rejectsNullStrategy() {
        expectNullRejection(() -> new CarWash(null));
        CarWash carWash = new CarWash(new BasicWashStrategy());
        expectNullRejection(() -> carWash.setStrategy(null));
        check(carWash.washCar().contains("Apply shampoo"),
                "Rejected replacement must preserve the previous strategy");
    }

    private static void verifiesWashPrograms() {
        List<String> basic = new BasicWashStrategy().wash();
        List<String> touchless = new TouchlessWashStrategy().wash();
        List<String> premium = new PremiumWashStrategy().wash();
        List<String> waterless = new WaterlessWashStrategy().wash();

        check(basic.indexOf("Apply shampoo") < basic.indexOf("Clean with soft brushes"),
                "Shampoo must precede brushing");
        check(!touchless.contains("Clean with soft brushes"), "Touchless wash must not use brushes");
        check(premium.indexOf("Apply protective wax") > premium.indexOf("Rinse with water"),
                "Wax must follow rinsing");
        check(!basic.equals(touchless) && !basic.equals(premium), "Algorithms must differ");
        check(waterless.stream().noneMatch(step -> step.contains("Rinse")),
                "Waterless wash must not rinse with water");
        check(new PremiumWashStrategy().wash().equals(premium), "Strategies must be reusable");
    }

    private static void expectNullRejection(Runnable operation) {
        try {
            operation.run();
        } catch (NullPointerException expected) {
            return;
        }
        throw new AssertionError("Null strategy must be rejected");
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
