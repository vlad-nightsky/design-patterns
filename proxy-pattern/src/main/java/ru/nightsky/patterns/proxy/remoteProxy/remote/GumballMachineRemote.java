package ru.nightsky.patterns.proxy.remoteProxy.remote;

import ru.nightsky.patterns.proxy.remoteProxy.gumballMachine.schema.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GumballMachineRemote extends Remote {
    int getCount() throws RemoteException;

    String getLocation() throws RemoteException;

    State getState() throws RemoteException;
}
