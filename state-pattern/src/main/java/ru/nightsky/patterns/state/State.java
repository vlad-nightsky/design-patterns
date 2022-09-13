package ru.nightsky.patterns.state;

/**
 * Интерфейс состояния
 */
public interface State {
    /**
     * В аппарат бросают монетку
     */
    void insertQuarter();

    /**
     * Покупатель пытается вернуть монетку
     */
    void ejectQuarter();

    /**
     * Покупатель пытается дёрнуть рычаг
     */
    void turnCrank();

    /**
     * Вызывают для выдачи шарика
     */
    void dispense();
}
