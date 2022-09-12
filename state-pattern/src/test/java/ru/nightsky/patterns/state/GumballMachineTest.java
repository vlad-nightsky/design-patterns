package ru.nightsky.patterns.state;

import org.junit.Test;

public class GumballMachineTest {

    @Test
    public void test(){
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();
        System.out.println();

        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println();

        System.out.println(gumballMachine);
    }
}
