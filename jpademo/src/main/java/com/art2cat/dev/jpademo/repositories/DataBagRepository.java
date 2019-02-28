package com.art2cat.dev.jpademo.repositories;

import com.art2cat.dev.jpademo.models.DataBag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBagRepository extends JpaRepository<DataBag, Integer> {

}
