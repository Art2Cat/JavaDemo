package com.art2cat.dev.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OptionalTest {
    
    
    @BeforeEach
    public void init() {
    
    }
    
    private Person generatePerson() {
        Insurance insurance = new Insurance();
        insurance.setName("insurance: " + insurance.hashCode());
        Car car = new Car(Optional.of(insurance));
        Person p = new Person(Optional.of(car));
        p.setMale(true);
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
    
    @Test
    public void test() {
        List<Object> personList = new ArrayList<>();
        personList.add(new Insurance());
        personList.add(new Insurance());
        personList.add(generatePerson());
        
        Optional<Person> person = personList.stream().filter(o -> o instanceof Person).map(o -> ((Person) o))
            .findFirst();
        
        if (person.map(Person::isMale).orElse(false)) {
            System.out.println(person.get().getCar().map(Car::getInsurance).orElse(null));
        } else {
            Assertions.fail();
        }
        
    }
}
