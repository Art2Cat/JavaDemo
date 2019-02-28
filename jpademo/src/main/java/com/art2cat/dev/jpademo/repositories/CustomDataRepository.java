package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.models.CustomData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomDataRepository extends JpaRepository<CustomData, Integer> {

}
