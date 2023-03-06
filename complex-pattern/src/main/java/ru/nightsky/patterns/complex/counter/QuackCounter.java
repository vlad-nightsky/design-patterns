package ru.nightsky.patterns.complex.counter;

import ru.nightsky.patterns.complex.Quackable;
import ru.nightsky.patterns.complex.observer.Observer;

//Расширим поведение интерфейса Quackable декоратором
public class QuackCounter implements Quackable {
    Quackable duck;
    static int numberOfQuack;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() { //вызов метода делегируется декорируемой реализации
        duck.quack();
        numberOfQuack++;
    }

    //Дополняем декоратор статическим методом
    public static int getQuack() {
        return numberOfQuack;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
