package com.art2cat.dev.concert.javaconfig;

import com.art2cat.dev.concert.ICriticismEngine;

public aspect CriticAspect {
    public CriticAspect() {}

    pointcut performance() : execution(* perform(..));

//    after afterReturning() : performance() {
//        System.out.println(criticismEngine.getCriticism());
//    }

    private ICriticismEngine criticismEngine;

    public void setCriticismEngine(ICriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

}
