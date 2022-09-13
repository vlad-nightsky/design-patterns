package ru.nightsky.patterns.state.impl;

import ru.nightsky.patterns.state.GumballMachine;
import ru.nightsky.patterns.state.State;

public class SoldState implements State {
    /**
     * Ссылка на объект автомата
     */
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Подождите. Мы уже выдаём вам жвачку");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Вы уже повернули ручку чтоб забрать жвачку. Монетку вернуть нельзя");
    }

    @Override
    public void turnCrank() {
        System.out.println("Дёрнув за ручку дважды, вы не получите ещё жвачку");
    }

    @Override
    public void dispense() {
        System.out.println("Шарик жвачка сейчас выкатится");
        gumballMachine.setCount(gumballMachine.getCount() - 1);
        if (gumballMachine.getCount() == 0) {
            System.out.println("Жвачка закончилась");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    }
}
