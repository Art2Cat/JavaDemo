package com.art2cat.dev.corejava.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * com.art2cat.dev.corejava
 *
 * @author rorschach
 * @date 3/11/18
 */
public class VehicleProxy implements InvocationHandler {
    
    private IVehicle vehicle;
    
    public VehicleProxy(IVehicle vehicle) {
        this.vehicle = vehicle;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(vehicle, args);
    }
}
