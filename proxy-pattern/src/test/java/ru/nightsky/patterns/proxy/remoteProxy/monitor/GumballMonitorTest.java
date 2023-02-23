package ru.nightsky.patterns.proxy.remoteProxy.monitor;

import org.junit.Test;
import ru.nightsky.patterns.proxy.remoteProxy.remote.GumballMachineRemote;

import java.rmi.Naming;

public class GumballMonitorTest {

    @Test
    public void test() {
        String[] location = {"rmi://127.0.0.1/gumball-machine"};

        GumballMonitor[] monitor = new GumballMonitor[location.length];

        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitor[i] = new GumballMonitor(machine);

                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (GumballMonitor gumballMonitor : monitor) {
            gumballMonitor.report();
        }

    }
}
