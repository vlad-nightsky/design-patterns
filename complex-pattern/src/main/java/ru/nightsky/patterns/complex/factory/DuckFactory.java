package ru.nightsky.patterns.complex.factory;

import ru.nightsky.patterns.complex.Quackable;
import ru.nightsky.patterns.complex.duck.MallardDuck;
import ru.nightsky.patterns.complex.duck.RedheadDuck;

public class DuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }
}
