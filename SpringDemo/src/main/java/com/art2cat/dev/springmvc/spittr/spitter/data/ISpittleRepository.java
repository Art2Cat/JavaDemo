package com.art2cat.dev.springmvc.spittr.spitter.data;

import java.util.List;

public interface ISpittleRepository {
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittelId);
}
