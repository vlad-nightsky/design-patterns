package ru.nightsky.patterns.complex.duck;

import ru.nightsky.patterns.complex.Quackable;
import ru.nightsky.patterns.complex.observer.Observable;
import ru.nightsky.patterns.complex.observer.Observer;

public class MallardDuck implements Quackable {
    Observable observable;

    public MallardDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Кря Кря");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public String toString() {
        return "Кряква";
    }
}
