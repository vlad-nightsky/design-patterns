package ru.nightsky.patterns.complex.duck;

import ru.nightsky.patterns.complex.Quackable;
import ru.nightsky.patterns.complex.observer.Observable;
import ru.nightsky.patterns.complex.observer.Observer;

public class RedheadDuck implements Quackable {
    Observable observable;

    public RedheadDuck() {
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Кря кря");
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
        return "Красноголовый нырок";
    }
}
