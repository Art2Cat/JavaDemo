package com.art2cat.dev;

import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class OptionalTest {
    
    
    @Before
    public void init() {
    
    }
    
    private Person generatePerson() {
        Insurance insurance = new Insurance();
        insurance.setName("insurance: " + insurance.hashCode());
        Car car = new Car(Optional.of(insurance));
        Person p = new Person(Optional.of(car));
        return p;
    }
    
    @Test
    public void getCarInsuranceName() {
        String name = Optional.of(generatePerson()).flatMap(Person::getCar)
            .flatMap(Car::getInsurance)
            .map(Insurance::getName)
            .orElse("Unknown");
        
        System.out.println(name);
    }
}
