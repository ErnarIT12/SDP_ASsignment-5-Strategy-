# Car Wash System - Strategy Pattern

A Java console project for Software Design Patterns Assignment 5.
It simulates different wash programs and switches between them at runtime.

## Structure

- `WashStrategy` - common interface with the `wash()` method.
- `BasicWashStrategy`, `TouchlessWashStrategy`, `PremiumWashStrategy` - three wash algorithms.
- `CarWash` - context that stores a strategy and delegates execution to it.
- `Main` - client that changes strategies on the same car wash object.
- `WaterlessWashStrategy` and `ExtensionDemo` - an example of adding a new algorithm.

## Clean Code

1. **Polymorphism:** the context calls `strategy.wash()` without checking the strategy type.
2. **Meaningful names:** each class name describes its wash program or pattern role.
3. **Single Responsibility:** strategies define wash steps; the client handles console output.
4. **Dependency Inversion:** `CarWash` depends on `WashStrategy`, not concrete algorithms.
5. **Open/Closed Principle:** the waterless strategy works without changing the context or existing strategies.
6. **Encapsulation:** the strategy field is private, and null strategies are rejected.

The tests check delegation, runtime switching, null validation and wash programs.
