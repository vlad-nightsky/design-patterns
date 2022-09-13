package ru.nightsky.patterns.state.impl;

import ru.nightsky.patterns.state.GumballMachine;
import ru.nightsky.patterns.state.State;

import java.util.Random;

public class HasQuarterState implements State {
    /**
     * Ссылка на объект автомата
     */
    GumballMachine gumballMachine;
    /**
     * Генератор случайных чисел с вероятностью 10% выигрыша
     */
    Random randomWinner = new Random(System.currentTimeMillis());

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
        int winner = randomWinner.nextInt(10);
        if(winner == 0 && (gumballMachine.getCount() > 1)){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }else{
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("Жвачку выдать не получится");
    }
}
