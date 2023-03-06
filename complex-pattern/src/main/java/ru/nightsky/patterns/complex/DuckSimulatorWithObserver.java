package ru.nightsky.patterns.complex;

import ru.nightsky.patterns.complex.composite.Flock;
import ru.nightsky.patterns.complex.counter.QuackCounter;
import ru.nightsky.patterns.complex.duck.GooseAdapter;
import ru.nightsky.patterns.complex.factory.AbstractDuckFactory;
import ru.nightsky.patterns.complex.factory.CountingDuckFactory;
import ru.nightsky.patterns.complex.goose.Goose;
import ru.nightsky.patterns.complex.observer.Quackologist;

public class DuckSimulatorWithObserver {
    public static void main(String[] args) {
        DuckSimulatorWithObserver simulator = new DuckSimulatorWithObserver();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory factory) {
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());//гусиные крики мы не декорируем


        Flock flockOfDuck = new Flock();
        flockOfDuck.add(mallardDuck);
        flockOfDuck.add(redheadDuck);
        flockOfDuck.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());

        flockOfDuck.add(flockOfMallards); //вау да мы так можем, потому что стая является реализацией конкретной уточки

        System.out.println("Запускаем симулятор уточек с Наблюдателем");

        Quackologist quackologist = new Quackologist();
        flockOfDuck.registerObserver(quackologist);

        simulate(flockOfDuck);//и тут ничего не меняем! Интерфейсы сила!!

        System.out.println("Уточки крякнули ровно " + QuackCounter.getQuack() + " раз(а)");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
