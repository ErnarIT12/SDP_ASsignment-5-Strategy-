package org.example;

import java.util.List;

public class TouchlessWashStrategy implements WashStrategy {
    @Override
    public List<String> wash() {
        return List.of(
                "Pre-rinse with high-pressure water",
                "Apply active foam",
                "Let the foam dissolve dirt",
                "Rinse with high-pressure water without brushes",
                "Air dry"
        );
    }
}
