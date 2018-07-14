package com.art2cat.dev.corejava;

import com.art2cat.dev.corejava.reflect.Car;
import com.art2cat.dev.corejava.reflect.IVehicle;
import com.art2cat.dev.corejava.reflect.PrivateCar;
import com.art2cat.dev.corejava.reflect.VehicleProxy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.Test;


/**
 * com.art2cat.dev.corejava
 *
 * @author rorschach
 * @date 3/3/18
 */
public class ReflectTest {
    
    private Car initByDefaultConst()
        throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = loader.loadClass("com.art2cat.dev.corejava.reflect.Car");
        
        Constructor constr = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constr.newInstance();
        
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "AMG");
        Method setMaxSpeed = clazz.getDeclaredMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 330);
        
        return car;
    }
    
    @Test
    public void testCarReflect() {
        Car car = null;
        try {
            car = initByDefaultConst();
            car.introduce();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    
    
    /**
     * use reflect to avoid java accessible mechanism then access to private field or method. getDeclaredField/Method to
     * get private field or method, getField/Method to get public field or method.
     */
    @Test
    public void testPrivateCarReflect() {
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            Class<?> clazz = classLoader.loadClass("com.art2cat.dev.corejava.reflect.PrivateCar");
            
            PrivateCar privateCar = (PrivateCar) clazz.newInstance();
            
            Field color = clazz.getDeclaredField("color");
            color.setAccessible(true);
            color.set(privateCar, "Red");
            
            Method drive = clazz.getDeclaredMethod("drive", (Class[]) null);
            drive.setAccessible(true);
            drive.invoke(privateCar, (Object) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testVehicleProxy() {
        Car car = new Car();
        VehicleProxy vehicleProxy = new VehicleProxy(car);
        
        IVehicle proxy = (IVehicle) Proxy
            .newProxyInstance(car.getClass().getClassLoader(), car.getClass().getInterfaces(), vehicleProxy);
        
        proxy.introduce();
        
    }
}
