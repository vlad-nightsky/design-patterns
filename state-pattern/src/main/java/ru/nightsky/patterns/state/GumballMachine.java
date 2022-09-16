package ru.nightsky.patterns.state;

import ru.nightsky.patterns.state.schema.GumballMachineContext;
import ru.nightsky.patterns.state.schema.State;

/**
 * Автомат по продаже шариков
 */
public class GumballMachine implements GumballMachineContext {
    /**
     * Состояние
     */
    State state;
    /**
     * Кол-во шариков в автомате
     */
    int count;

    /**
     * Конструктор получает исходное кол-во шариков.
     * Если оно отлично от нуля, то переходи в состояние noQuarter, ожидая пока кто-нибудь кинет монетку.
     * В противном случае остаёмся в состояние soldOut
     *
     * @param numberGumballs кол-во шариков в аппарате
     */
    public GumballMachine(int numberGumballs) {
        this.count = numberGumballs;

        if (numberGumballs > 0)
            state = States.NO_QUARTER_STATE;
        else
            state = States.SOLD_OUT_STATE;
    }

    /**
     * В аппарат бросают монетку
     */
    public void insertQuarter() {
        state.insertQuarter(this);
    }

    /**
     * Покупатель пытается вернуть монетку
     */
    public void ejectQuarter() {
        state.ejectQuarter(this);
    }

    /**
     * Покупатель пытается дёрнуть рычаг
     */
    public void turnCrank() {
        state.turnCrank(this);
    }

    @Override
    public String toString() {
        return "Могучие Жвачечки, Ко.\n" +
                "Стационарный аппарат по продаже жвачек #2022\n" +
                "В наличии: " + count + " жвачек-шариков\n" +
                "Автомат ожидает монетку!";
    }

    /**
     * @return состояние Есть монетка
     */
    public State getHasQuarterState() {
        return States.HAS_QUARTER_STATE;
    }

    /**
     * Метод позволяет устанавливать состояние
     *
     * @param state новое состояние
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * @return состояния Шарик продан
     */
    public State getSoldState() {
        return States.SOLD_STATE;
    }

    /**
     * Возвращает кол-во шариков-жвачек
     *
     * @return кол-во шариков-жвачек
     */
    public int getCount() {
        return count;
    }

    /**
     * Устанавливает новое значение для шариков жвачек
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return состояние Нет шариков
     */

    public State getSoldOutState() {
        return States.SOLD_OUT_STATE;
    }

    /**
     * @return состояние Нет монетки
     */
    public State getNoQuarterState() {
        return States.NO_QUARTER_STATE;
    }

    /**
     * Каждый 10 шарик в подарок
     */
    public State getWinnerState() {
        return States.WINNER_STATE;
    }

    /**
     * @return текущее состояние
     */
    public State currentState() {
        return this.state;
    }
}
