package com.art2cat.dev.state;

/**
 * com.art2cat.dev.state
 *
 * @author art2c
 * @date 6/13/2018
 */
public class NightState implements IState {
    
    private static IState singleton = new NightState();
    
    private NightState() {
    }
    
    public static IState getInstance() {
        return singleton;
    }
    
    @Override
    public void doClock(IContext context, int hour) {
        if (START_TIME <= hour && hour < END_TIME) {
            context.changeState(DayState.getInstance());
        }
    }
    
    @Override
    public void doUse(IContext context) {
        context.recordLog("use repository.");
        
    }
    
    @Override
    public void doAlarm(IContext context) {
        context.callSecurityCenter("press alert button(Nighttime).");
        
    }
    
    @Override
    public void doPhone(IContext context) {
        context.callSecurityCenter("normal call(Nighttime).");
    }
    
    @Override
    public String toString() {
        return "[NightTime]";
    }
}
