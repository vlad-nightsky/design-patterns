package ru.nightsky.patterns.proxy.remoteProxy;

import ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.GumballMachine;
import ru.nightsky.patterns.proxy.remoteProxy.remote.GumballMachineRemote;

import java.rmi.Naming;

public class GumballMachineTestDrive {

    public static void main(String[] args){
        GumballMachineRemote gumballMachine = null;
        int count;
        if(args.length<2){
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(0);
        }

        try{
            count = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(args[0], count);

            Naming.rebind("gumball-machine", gumballMachine);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
