package com.art2cat.dev.state;

/**
 * com.art2cat.dev.state
 *
 * @author art2c
 * @date 6/13/2018
 */
public interface IContext {
    
    void setClock(int hour);
    
    void changeState(IState state);
    
    void callSecurityCenter(String msg);
    
    void recordLog(String msg);
}
