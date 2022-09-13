package ru.nightsky.patterns.state.impl;

import ru.nightsky.patterns.state.GumballMachine;
import ru.nightsky.patterns.state.State;

/**
 * Нет шариков
 */
public class SoldOutState implements State {
    /**
     * Ссылка на объект автомата
     */
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Монетку вставить вы не можете. Все жвачки распроданы");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Монетки нет в аппарате. Все жвачки проданы");
    }

    @Override
    public void turnCrank() {
        System.out.println("Выдача невозможна. Жвачки нет");
    }

    @Override
    public void dispense() {
        System.out.println("Жвачку выдать не получится");
    }
}
