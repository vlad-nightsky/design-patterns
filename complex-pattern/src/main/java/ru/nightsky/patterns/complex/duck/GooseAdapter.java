package ru.nightsky.patterns.complex.duck;

import ru.nightsky.patterns.complex.Quackable;
import ru.nightsky.patterns.complex.goose.Goose;
import ru.nightsky.patterns.complex.observer.Observable;
import ru.nightsky.patterns.complex.observer.Observer;

//поскольку гуси не умеют крякать используем паттерн адаптер
public class GooseAdapter implements Quackable {
    Goose goose;
    Observable observable;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();
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
        return "Гусёк, который притворяется уточкой,";
    }
}
