package ru.nightsky.patterns.state.state;

import ru.nightsky.patterns.state.schema.GumballMachineContext;

public class SoldState extends ExampleSoldGumballState {

    @Override
    public void insertQuarter(GumballMachineContext gumballMachine) {
        System.out.println("Подождите. Мы уже выдаём вам жвачку");
    }

    @Override
    public void ejectQuarter(GumballMachineContext gumballMachine) {
        System.out.println("Вы уже повернули ручку чтоб забрать жвачку. Монетку вернуть нельзя");
    }

    @Override
    public void turnCrank(GumballMachineContext gumballMachine) {
        System.out.println("Дёрнув за ручку дважды, вы не получите ещё жвачку");
    }

    @Override
    public void dispense(GumballMachineContext gumballMachine) {
        System.out.println("Шарик жвачка сейчас выкатится");
        release(gumballMachine);
    }
}
