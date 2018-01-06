package com.art2cat.dev.database.jpaspringdata.db;

import com.art2cat.dev.database.jpaspringdata.domain.Spittle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface with operations for {@link Spittle} persistence.
 *
 * @author habuma
 */
public interface SpittleRepository extends JpaRepository<Spittle, Long>, SpittleRepositoryCustom {

    List<Spittle> findBySpitterId(long spitterId);

}
