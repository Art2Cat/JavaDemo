package com.art2cat.dev.database.jpaspringdata.db;

import com.art2cat.dev.database.jpaspringdata.domain.Spitter;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpitterRepository extends JpaRepository<Spitter, Long>, SpitterSweeper {

    Spitter findByUsername(String username);

    List<Spitter> findByUsernameOrFullNameLike(String username, String fullName);

}
