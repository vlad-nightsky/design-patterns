package ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.state;


import ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.schema.GumballMachineContext;
import ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.schema.State;

/**
 * Нет шариков
 */
public class SoldOutState implements State {

    @Override
    public void insertQuarter(GumballMachineContext gumballMachine) {
        System.out.println("Монетку вставить вы не можете. Все жвачки распроданы");
    }

    @Override
    public void ejectQuarter(GumballMachineContext gumballMachine) {
        System.out.println("Монетки нет в аппарате. Все жвачки проданы");
    }

    @Override
    public void turnCrank(GumballMachineContext gumballMachine) {
        System.out.println("Выдача невозможна. Жвачки нет");
    }

    @Override
    public void dispense(GumballMachineContext gumballMachine) {
        System.out.println("Жвачку выдать не получится");
    }
}
