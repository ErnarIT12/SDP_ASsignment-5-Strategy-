package org.example;

import java.util.List;

public class BasicWashStrategy implements WashStrategy {
    @Override
    public List<String> wash() {
        return List.of(
                "Pre-rinse with water",
                "Apply shampoo",
                "Clean with soft brushes",
                "Rinse with water",
                "Air dry"
        );
    }
}
