package com.art2cat.dev;

import com.art2cat.dev.impl.RemoteEngineImpl;
import com.art2cat.dev.intf.IRemoteEngine;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerEngine {
    public static void main(String[] args) {
        // no remote download source, no need SecurityManager
        // if (System.getSecurityManager() == null) {
        //    System.setSecurityManager(new SecurityManager());
        // }
        try {
            String name = "RemoteEngine";
            IRemoteEngine engine = new RemoteEngineImpl();
            IRemoteEngine stub =
                    (IRemoteEngine) UnicastRemoteObject.exportObject(engine, 0);
            LocateRegistry.createRegistry(1099);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("IRemoteEngine bound");
        } catch (Exception e) {
            System.err.println("IRemoteEngine exception:");
            e.printStackTrace();
        }
    }
}
