package ru.nightsky.patterns.complex;

import ru.nightsky.patterns.complex.observer.QuackObservable;

public interface Quackable extends QuackObservable {
    void quack();
}
