package com.art2cat.dev.iterator;

import com.art2cat.dev.flyweight.BigString;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * com.art2cat.dev.iterator
 *
 * @author art2c
 * @date 6/14/2018
 */
public class FlyweightTest {
    
    @Test
    public void test() {
        BigString bigString = new BigString("b4");
        bigString.print();
    }
    
    @Test
    public void test1() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(null));
        roles.add(new Role(null));
        roles.add(new Role(null));
        roles.add(new Role(true));
        roles.add(new Role(null));
        roles.add(new Role(null));
        
        
        if (roles.stream().noneMatch(role -> role.getEnabled() != null && role.getEnabled())) {
            System.out.println("pass");
        }
    }
    
}
