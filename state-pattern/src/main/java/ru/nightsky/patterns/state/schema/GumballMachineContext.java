package ru.nightsky.patterns.state.schema;

/**
 * Контекст автомата по продаже шариков жвачек
 */
public interface GumballMachineContext {

    /**
     * @return состояние Есть монетка
     */
    State getHasQuarterState();

    /**
     * Метод позволяет устанавливать состояние
     *
     * @param state новое состояние
     */
    void setState(State state);

    /**
     * @return состояния Шарик продан
     */
    State getSoldState();

    /**
     * Возвращает кол-во шариков-жвачек
     *
     * @return кол-во шариков-жвачек
     */
    int getCount();

    /**
     * Устанавливает новое значение для шариков жвачек
     */
    void setCount(int count);

    /**
     * @return состояние Нет шариков
     */

    State getSoldOutState();

    /**
     * @return состояние Нет монетки
     */
    State getNoQuarterState();

    /**
     * Каждый 10 шарик в подарок
     */
    State getWinnerState();

    /**
     * @return текущее состояние
     */
    State currentState();
}
