package com.art2cat.dev;

import com.art2cat.dev.impl.PI;
import com.art2cat.dev.intf.IRemoteEngine;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main {

    public static void main(String[] args) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = "RemoteEngine";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            IRemoteEngine comp = (IRemoteEngine) registry.lookup(name);
            PI task = new PI(Integer.parseInt(args[1]));
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}
