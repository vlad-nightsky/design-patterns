package ru.nightsky.patterns.complex;

import ru.nightsky.patterns.complex.counter.QuackCounter;
import ru.nightsky.patterns.complex.duck.GooseAdapter;
import ru.nightsky.patterns.complex.duck.MallardDuck;
import ru.nightsky.patterns.complex.duck.RedheadDuck;
import ru.nightsky.patterns.complex.goose.Goose;

public class DuckSimulatorWithDecorator {
    public static void main(String[] args) {
        DuckSimulatorWithDecorator simulator = new DuckSimulatorWithDecorator();
        simulator.simulate();
    }

    private void simulate() {
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
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
