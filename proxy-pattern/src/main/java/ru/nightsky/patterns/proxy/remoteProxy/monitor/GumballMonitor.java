package ru.nightsky.patterns.proxy.remoteProxy.monitor;

import ru.nightsky.patterns.proxy.remoteProxy.remote.GumballMachineRemote;

public class GumballMonitor {
    GumballMachineRemote gumballMachine;

    public GumballMonitor(GumballMachineRemote gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report(){
        try{
            System.out.println("Машина по продаже шариков-жвачек: " + gumballMachine.getLocation());
            System.out.println("Кол-во шариков: " + gumballMachine.getCount());
            System.out.println("Текущие состояние: " + gumballMachine.getState());}catch (Exception e){
            e.printStackTrace();
        }
    }
}
