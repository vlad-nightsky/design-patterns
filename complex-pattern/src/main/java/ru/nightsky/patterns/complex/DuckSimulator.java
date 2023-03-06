package ru.nightsky.patterns.complex;

import ru.nightsky.patterns.complex.duck.GooseAdapter;
import ru.nightsky.patterns.complex.duck.MallardDuck;
import ru.nightsky.patterns.complex.duck.RedheadDuck;
import ru.nightsky.patterns.complex.goose.Goose;

public class DuckSimulator {
    public static void main(String[] args){
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    private void simulate() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("Запускаем симулятор уточек с адаптером гусем");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(gooseDuck);

    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
