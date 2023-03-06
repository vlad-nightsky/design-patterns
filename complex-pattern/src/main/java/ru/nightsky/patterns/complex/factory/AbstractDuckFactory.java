package ru.nightsky.patterns.complex.factory;

import ru.nightsky.patterns.complex.Quackable;

public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
}
