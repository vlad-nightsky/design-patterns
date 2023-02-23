package ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.schema;

import java.io.Serializable;

/**
 * Интерфейс состояния
 */
public interface State extends Serializable {
    /**
     * В аппарат бросают монетку
     */
    void insertQuarter(GumballMachineContext context);

    /**
     * Покупатель пытается вернуть монетку
     */
    void ejectQuarter(GumballMachineContext context);

    /**
     * Покупатель пытается дёрнуть рычаг
     */
    void turnCrank(GumballMachineContext context);

    /**
     * Вызывают для выдачи шарика
     */
    void dispense(GumballMachineContext context);
}
