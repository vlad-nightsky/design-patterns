package ru.nightsky.patterns.state.impl;

import ru.nightsky.patterns.state.GumballMachine;
import ru.nightsky.patterns.state.State;

public class NoQuarterState implements State {
    /**
     * Ссылка на объект автомата
     */
    GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Монетка принята");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Монетки нет в аппарате");
    }

    @Override
    public void turnCrank() {
        System.out.println("Нужно бросить сначала монетку");
    }

    @Override
    public void dispense() {
        System.out.println("Жвачку выдать не получится");
    }
}
