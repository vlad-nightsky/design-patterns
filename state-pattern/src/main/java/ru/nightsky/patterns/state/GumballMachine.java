package ru.nightsky.patterns.state;

/**
 * Автомат по продаже шариков
 */
public class GumballMachine {
    /**
     * Нет шариков
     */
    final static int SOLD_OUT = 0;
    /**
     * Нет монетки
     */
    final static int NO_QUARTER = 1;
    /**
     * Есть монетка
     */
    final static int HAS_QUARTER = 2;
    /**
     * Шарик продан
     */
    final static int SOLD = 3;

    /**
     * Состояние
     */
    int state = SOLD_OUT;
    /**
     * Кол-во шариков в автомате
     */
    int count = 0;

    /**
     * Конструктор получает исходное кол-во шариков.
     * Если оно отлично от нуля то переходи в состояние NO_QUARTER, ожидая пока кто нибудь кинет монетку.
     * В противном случае остаёмся в состояние SOLD_OUT
     *
     * @param count кол-во шариков в аппарате
     */
    public GumballMachine(int count) {
        this.count = count;
        if (count > 0)
            state = NO_QUARTER;
    }

    /**
     * В аппарат бросают монетку
     */
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Вы не можете вставить ещё монетку");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("Монетка принята");
        } else if (state == SOLD_OUT) {
            System.out.println("Монетку вставить вы не можете. Все жвачки распроданы");
        } else if (state == SOLD) {
            System.out.println("Подождите. Мы уже выдаём вам жвачку");
        }
    }

    /**
     * Покупатель пытается вернуть монетку
     */
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("Монетка возвращена");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("Монетки нет в аппарате");
        } else if (state == SOLD_OUT) {
            System.out.println("Монетки нет в аппарате. Все жвачки проданы");
        } else if (state == SOLD) {
            System.out.println("Вы уже повернули ручку чтоб забрать жвачку. Монетку вернуть нельзя");
        }
    }

    /**
     * Покупатель пытается дёрнуть рычаг
     */
    public void turnCrank() {
        if (state == HAS_QUARTER) {
            System.out.println("Ручка повёрнута");
            state = SOLD;
            dispense();
        } else if (state == NO_QUARTER) {
            System.out.println("Нужно бросить сначала монетку");
        } else if (state == SOLD_OUT) {
            System.out.println("Выдача невозможна. Жвачки нет");
        } else if (state == SOLD) {
            System.out.println("Дёрнув за ручку дважды, вы не получите ещё жвачку");
        }
    }

    /**
     * вызывают для выдачи шарика
     */
    public void dispense() {
        if (state == HAS_QUARTER) {
            System.out.println("Жвачку выдать не получится");
        } else if (state == NO_QUARTER) {
            System.out.println("Жвачку выдать не получится");
        } else if (state == SOLD_OUT) {
            System.out.println("Жвачку выдать не получится");
        } else if (state == SOLD) {
            System.out.println("Шарик жвачка сейчас выкатится");
            count = count - 1;
            if (count == 0) {
                System.out.println("Жвачка закончилась");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        }
    }

    @Override
    public String toString() {
        return "Могучие Жвачечки, Ко.\n" +
                "Стационарный аппарат по продаже жвачек #2022\n" +
                "В наличии: " + count + " жвачек-шариков\n" +
                "Автомат ожидает монетку!";
    }
}
