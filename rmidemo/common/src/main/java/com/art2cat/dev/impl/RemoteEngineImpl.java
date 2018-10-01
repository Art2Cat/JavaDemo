package com.art2cat.dev.impl;


import com.art2cat.dev.intf.IRemoteEngine;
import com.art2cat.dev.intf.Task;

import java.rmi.RemoteException;

public class RemoteEngineImpl implements IRemoteEngine {

    public RemoteEngineImpl() {
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }
}
