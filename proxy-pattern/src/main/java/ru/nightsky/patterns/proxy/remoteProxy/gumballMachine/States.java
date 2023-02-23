package ru.nightsky.patterns.proxy.remoteProxy.gumballMachine;

import ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.schema.State;
import ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.state.*;

/**
 * Содержит в себе все состояния
 */
public class States {
    /**
     * Нет шариков
     */
    static final State SOLD_OUT_STATE = new SoldOutState();
    /**
     * Нет монетки
     */
    static final State NO_QUARTER_STATE = new NoQuarterState();
    /**
     * Есть монетка
     */
    static final State HAS_QUARTER_STATE = new HasQuarterState();
    /**
     * Шарик продан
     */
    static final State SOLD_STATE = new SoldState();
    /**
     * Каждый 10 шарик в подарок
     */
    static final State WINNER_STATE = new WinnerState();
}
