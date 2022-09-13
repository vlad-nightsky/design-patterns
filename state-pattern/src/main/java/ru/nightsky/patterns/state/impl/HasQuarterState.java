package ru.nightsky.patterns.state.impl;

import ru.nightsky.patterns.state.GumballMachine;
import ru.nightsky.patterns.state.State;

public class HasQuarterState implements State {
    /**
     * Ссылка на объект автомата
     */
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Вы не можете вставить ещё монетку");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Монетка возвращена");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Ручка повёрнута");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("Жвачку выдать не получится");
    }
}
