package ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.state;


import ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.schema.GumballMachineContext;
import ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.schema.State;

import java.util.Random;

public class HasQuarterState implements State {
    /**
     * Генератор случайных чисел с вероятностью 10% выигрыша
     */
    Random randomWinner = new Random(System.currentTimeMillis());

    @Override
    public void insertQuarter(GumballMachineContext gumballMachine) {
        System.out.println("Вы не можете вставить ещё монетку");
    }

    @Override
    public void ejectQuarter(GumballMachineContext gumballMachine) {
        System.out.println("Монетка возвращена");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank(GumballMachineContext gumballMachine) {
        System.out.println("Ручка повёрнута");

        int winner = randomWinner.nextInt(10);

        if (winner == 0 && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }

        gumballMachine.currentState().dispense(gumballMachine);
    }

    @Override
    public void dispense(GumballMachineContext gumballMachine) {
        System.out.println("Жвачку выдать не получится");
    }
}
