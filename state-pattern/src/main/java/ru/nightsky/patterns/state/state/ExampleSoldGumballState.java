package ru.nightsky.patterns.state.state;

import ru.nightsky.patterns.state.schema.GumballMachineContext;
import ru.nightsky.patterns.state.schema.State;

public abstract class ExampleSoldGumballState implements State {
    /**
     * Возвращает покупателю жвачку. Если в диспансере осталась ещё жвачка, то вернёт true
     *
     * @return если в диспансере осталась ещё жвачка, то вернёт true
     */
    public boolean release(GumballMachineContext gumballMachine) {
        gumballMachine.setCount(gumballMachine.getCount() - 1);
        if (gumballMachine.getCount() == 0) {
            System.out.println("Жвачка закончилась");
            gumballMachine.setState(gumballMachine.getSoldOutState());
            return false;
        } else {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
            return true;
        }
    }
}
