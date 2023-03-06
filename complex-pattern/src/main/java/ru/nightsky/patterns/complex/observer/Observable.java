package ru.nightsky.patterns.complex.observer;

import java.util.ArrayList;
import java.util.List;

//Инкапсулируем методы наблюдателя здесь, чтобы не реализовывать отдельно в каждом классе
public class Observable implements QuackObservable {
    List<Observer> observers = new ArrayList<>();
    QuackObservable duck;

    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(duck));
    }
}
