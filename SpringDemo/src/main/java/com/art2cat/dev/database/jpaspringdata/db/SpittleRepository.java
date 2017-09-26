package com.art2cat.dev.database.jpaspringdata.db;

import com.art2cat.dev.database.jpaspringdata.domain.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * Repository interface with operations for {@link Spittle} persistence.
 * @author habuma
 */
public interface SpittleRepository extends JpaRepository<Spittle, Long>, SpittleRepositoryCustom {
  
  List<Spittle> findBySpitterId(long spitterId);
  
}
