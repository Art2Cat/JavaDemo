package com.art2cat.dev.database.jpaspringdata.db;

import com.art2cat.dev.database.jpaspringdata.domain.Spittle;

import java.util.List;


public interface SpittleRepositoryCustom {

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

}