package com.art2cat.dev.intf;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteEngine extends Remote {
    <T> T executeTask(Task<T> t) throws RemoteException;
}
