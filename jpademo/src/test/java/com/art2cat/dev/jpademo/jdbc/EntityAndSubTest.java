package com.art2cat.dev.jpademo.jdbc;

import com.art2cat.dev.jpademo.configuration.AppConfig;
import com.art2cat.dev.jpademo.model.ParentEntity;
import com.art2cat.dev.jpademo.model.Subsidiary;
import com.art2cat.dev.jpademo.repositories.ParentEntityRepository;
import com.art2cat.dev.jpademo.repositories.SubsidiaryRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * com.art2cat.dev.jpademo.jdbc
 *
 * @author rorschach
 * @date 4/12/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class EntityAndSubTest {
    
    @Autowired
    SubsidiaryRepository subsidiaryRepository;
    @Autowired
    private ParentEntityRepository parentEntityRepository;
    
    @Test
    public void getParentEntity() {
        ParentEntity entity = parentEntityRepository.findOne(1001);
        if (entity == null) {
            Assert.fail();
        }
        
        if (entity.getSubsidiaries().isEmpty()) {
            Assert.fail();
        }
        entity.getSubsidiaries().forEach(System.out::println);
    }
    
    @Test
    public void addEntity() {
        ParentEntity parentEntity = new ParentEntity();
        parentEntity.setId(1003);
        parentEntity.setName("test Entity1");
        parentEntity.setStock("NDQ");
        Subsidiary subsidiary = new Subsidiary();
        subsidiary.setId(1003001);
        subsidiary.setName("test 1");
        subsidiary.setParentEntity(parentEntity);
        
        List<Subsidiary> subsidiaries = new ArrayList<>();
        subsidiaries.add(subsidiary);
        parentEntity.setSubsidiaries(subsidiaries);
        
        parentEntityRepository.save(parentEntity);
        
        ParentEntity entity = parentEntityRepository.findEntityByName("test Entity1");
        if (entity == null) {
            Assert.fail();
        }
        
        if (entity.getSubsidiaries() != null) {
            Assert.assertEquals("test 1", entity.getSubsidiaries().get(0).getName());
        } else {
            Assert.fail();
        }
        
    }
}
