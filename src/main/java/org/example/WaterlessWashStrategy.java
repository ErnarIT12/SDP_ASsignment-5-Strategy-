package org.example;

import java.util.List;
public class WaterlessWashStrategy implements WashStrategy {
    @Override
    public List<String> wash() {
        return List.of(
                "Spray waterless cleaning solution",
                "Lift light dirt with a microfiber cloth",
                "Buff with a clean microfiber cloth"
        );
    }
}
