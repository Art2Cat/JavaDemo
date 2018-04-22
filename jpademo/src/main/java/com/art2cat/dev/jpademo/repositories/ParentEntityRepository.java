package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.models.ParentEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * com.art2cat.dev.jpademo
 *
 * @author rorschach
 * @date 4/12/18
 */

public interface ParentEntityRepository extends CrudRepository<ParentEntity, Integer> {
    
    ParentEntity findEntityByName(String name);
    
    ParentEntity findEntityByEntityId(Integer entityId);
    
}
