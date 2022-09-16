package ru.nightsky.patterns.state.schema;

/**
 * Интерфейс состояния
 */
public interface State {
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
