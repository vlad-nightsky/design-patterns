package ru.nightsky.patterns.state.state;

import ru.nightsky.patterns.state.schema.GumballMachineContext;
import ru.nightsky.patterns.state.schema.State;

public class NoQuarterState implements State {

    @Override
    public void insertQuarter(GumballMachineContext gumballMachine) {
        System.out.println("Монетка принята");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter(GumballMachineContext gumballMachine) {
        System.out.println("Монетки нет в аппарате");
    }

    @Override
    public void turnCrank(GumballMachineContext gumballMachine) {
        System.out.println("Нужно бросить сначала монетку");
    }

    @Override
    public void dispense(GumballMachineContext gumballMachine) {
        System.out.println("Жвачку выдать не получится");
    }
}
