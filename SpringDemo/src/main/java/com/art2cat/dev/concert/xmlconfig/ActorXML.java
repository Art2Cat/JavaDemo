package com.art2cat.dev.concert.xmlconfig;


import com.art2cat.dev.concert.IPerformance;

public class ActorXML implements IPerformance {
    @Override
    public void perform() {
        System.out.println("Actor performing...");
    }
}
