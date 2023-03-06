package ru.nightsky.patterns.complex.composite;

import ru.nightsky.patterns.complex.Quackable;
import ru.nightsky.patterns.complex.observer.Observer;
import ru.nightsky.patterns.complex.observer.QuackObservable;

import java.util.ArrayList;
import java.util.List;

/*
    Хотим скомпоновать уток в стаю.
    Для этого подходит паттерн компоновщик.

    Компоновщик наследуем от интерфейса элементов содержащихся в нём
*/
public class Flock implements Quackable {
    List<Quackable> quackers = new ArrayList<>();


    public void add(Quackable quackable){
        this.quackers.add(quackable);
    }

    @Override
    public void quack() {//а это кстати итератор. ещё один паттерн
        quackers.forEach(Quackable::quack);
    }

    @Override
    public void registerObserver(Observer observer) {
        quackers.forEach(quacker -> quacker.registerObserver(observer));
    }

    @Override
    public void notifyObservers() {
        quackers.forEach(QuackObservable::notifyObservers);
    }
}
