package com.art2cat.dev.concert.xmlconfig;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AudienceXML {
    private List<String> getAudience(String name) {
        return audience.getOrDefault(name, list);
    }

    public String getMessage(String name, int num) {
        return getAudience(name).isEmpty()? "empty": getAudience(name).get(num);
    }

    public void setAudience(Map<String, List<String>> audience) {
        this.audience = audience;
    }

    private Map<String, List<String>> audience = new HashMap<>();
    private List<String> list = Lists.newArrayList();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void performance() {}

    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
        list.add("Silencing cell phones");
    }

    public void takeSeats() {
        System.out.println("Taking seats");
        list.add("Taking seats");
    }

    public void applause() {
        System.out.println("Clap Clap Clap!!!");
        list.add("Clap Clap Clap!!!");
        audience.put(name, list);
    }

    public void demandRefund() {
        System.out.println("Demanding a refund");
        list.add("Demanding a refund");
        audience.put(name, list);
    }


}
