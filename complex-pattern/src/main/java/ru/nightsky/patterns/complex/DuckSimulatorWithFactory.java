package ru.nightsky.patterns.complex;

import ru.nightsky.patterns.complex.counter.QuackCounter;
import ru.nightsky.patterns.complex.duck.GooseAdapter;
import ru.nightsky.patterns.complex.factory.AbstractDuckFactory;
import ru.nightsky.patterns.complex.factory.CountingDuckFactory;
import ru.nightsky.patterns.complex.goose.Goose;

public class DuckSimulatorWithFactory {
    public static void main(String[] args) {
        DuckSimulatorWithFactory simulator = new DuckSimulatorWithFactory();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory factory) {
        Quackable mallardDuck = factory.createMallardDuck();
        Quackable redheadDuck = factory.createRedheadDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());//гусиные крики мы не декорируем

        System.out.println("Запускаем симулятор уточек с декоратором");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(gooseDuck);

        System.out.println("Уточки крякнули ровно " + QuackCounter.getQuack() + " раз(а)");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
