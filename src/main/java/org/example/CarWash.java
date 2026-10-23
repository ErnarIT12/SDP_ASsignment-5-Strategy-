package org.example;

import java.util.List;
import java.util.Objects;

public final class CarWash {
    private WashStrategy strategy;

    public CarWash(WashStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(WashStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Wash strategy must not be null");
    }

    public List<String> washCar() {
        return strategy.wash();
    }
}
