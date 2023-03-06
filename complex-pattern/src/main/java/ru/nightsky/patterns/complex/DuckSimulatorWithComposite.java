package ru.nightsky.patterns.complex;

import ru.nightsky.patterns.complex.composite.Flock;
import ru.nightsky.patterns.complex.counter.QuackCounter;
import ru.nightsky.patterns.complex.duck.GooseAdapter;
import ru.nightsky.patterns.complex.factory.AbstractDuckFactory;
import ru.nightsky.patterns.complex.factory.CountingDuckFactory;
import ru.nightsky.patterns.complex.goose.Goose;

public class DuckSimulatorWithComposite {
    public static void main(String[] args) {
        DuckSimulatorWithComposite simulator = new DuckSimulatorWithComposite();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory factory) {
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());//гусиные крики мы не декорируем

        System.out.println("Запускаем симулятор уточек с компоновщиком \"Стая\"");

        Flock flockOfDuck = new Flock();
        flockOfDuck.add(mallardDuck);
        flockOfDuck.add(redheadDuck);
        flockOfDuck.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());
        flockOfMallards.add(factory.createMallardDuck());

        flockOfDuck.add(flockOfMallards); //вау да мы так можем, потому что стая является реализацией конкретной уточки

        System.out.println("Крякают все уточки");
        simulate(flockOfDuck);//и тут ничего не меняем! Интерфейсы сила!!
        System.out.println("Крякают только Кряква");
        simulate(flockOfMallards);

        System.out.println("Уточки крякнули ровно " + QuackCounter.getQuack() + " раз(а)");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
