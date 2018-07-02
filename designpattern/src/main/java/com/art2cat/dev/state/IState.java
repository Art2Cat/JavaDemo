package com.art2cat.dev.state;

/**
 * com.art2cat.dev.state
 *
 * @author art2c
 * @date 6/13/2018
 */
public interface IState {
    
    public static final int START_TIME = 9;
    public static final int END_TIME = 17;
    
    void doClock(IContext context, int hour);
    
    void doUse(IContext context);
    
    void doAlarm(IContext context);
    
    void doPhone(IContext context);
}
