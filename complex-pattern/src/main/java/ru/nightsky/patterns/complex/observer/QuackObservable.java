package ru.nightsky.patterns.complex.observer;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void notifyObservers();
}
