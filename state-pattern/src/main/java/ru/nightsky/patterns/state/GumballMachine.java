package ru.nightsky.patterns.state;

import ru.nightsky.patterns.state.impl.HasQuarterState;
import ru.nightsky.patterns.state.impl.NoQuarterState;
import ru.nightsky.patterns.state.impl.SoldOutState;
import ru.nightsky.patterns.state.impl.SoldState;

/**
 * Автомат по продаже шариков
 */
public class GumballMachine {
    /**
     * Нет шариков
     */
    State soldOutState;
    /**
     * Нет монетки
     */
    State noQuarterState;
    /**
     * Есть монетка
     */
    State hasQuarterState;
    /**
     * Шарик продан
     */
    State soldState;

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

        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.soldState = new SoldState(this);

        if (numberGumballs > 0)
            state = noQuarterState;
        else
            state = soldOutState;
    }

    /**
     * В аппарат бросают монетку
     */
    public void insertQuarter() {
        state.insertQuarter();
    }

    /**
     * Покупатель пытается вернуть монетку
     */
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * Покупатель пытается дёрнуть рычаг
     * <p>
     * Для метода dispense() в классе GumBallMachine метод не нужен,
     * потому что это внутреннее действие; пользователь не может напрямую потребовать,
     * чтобы автомат выдал шарик.
     * Однако метод dispense() для объектов State вызывается из метода turnCrank().
     */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
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
        return this.hasQuarterState;
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
        return this.soldState;
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
        return this.soldOutState;
    }

    /**
     * @return состояние Нет монетки
     */
    public State getNoQuarterState() {
        return this.noQuarterState;
    }
}
