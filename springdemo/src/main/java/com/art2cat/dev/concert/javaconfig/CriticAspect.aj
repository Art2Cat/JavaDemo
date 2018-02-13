package com.art2cat.dev.concert.javaconfig;

import com.art2cat.dev.concert.ICriticismEngine;

public aspect CriticAspect {

    private ICriticismEngine criticismEngine;

    pointcut performance(): execution(* perform(..));

    //    after afterReturning() : performance() {
//        System.out.println(criticismEngine.getCriticism());
//    }

    public CriticAspect() {
    }

    public void setCriticismEngine(ICriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

}
