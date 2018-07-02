package com.art2cat.dev.state;

/**
 * com.art2cat.dev.state
 *
 * @author art2c
 * @date 6/13/2018
 */
public class DayState implements IState {
    

    private static DayState singleton = new DayState();
    
    private DayState() {
    }
    
    public static IState getInstance() {
        return singleton;
    }
    
    @Override
    public void doClock(IContext context, int hour) {
        if (hour < START_TIME || END_TIME <= hour) {
            context.changeState(NightState.getInstance());
        }
    }
    
    @Override
    public void doUse(IContext context) {
        context.recordLog("use repository.");
    }
    
    @Override
    public void doAlarm(IContext context) {
        context.callSecurityCenter("press alert button(Daytime).");
    }
    
    @Override
    public void doPhone(IContext context) {
        context.callSecurityCenter("normal call(Daytime).");
    }
    
    @Override
    public String toString() {
        return "[DayTime]";
    }
}
