package com.art2cat.dev.strategy;

/**
 * com.art2cat.dev.strategy
 *
 * @author art2c
 * @date 5/29/2018
 */
public class Player {
    
    private IStrategy strategy;
    private String name;
    private int winCount;
    private int loseCount;
    private int gameCount;
    
    public Player(IStrategy strategy, String name) {
        this.strategy = strategy;
        this.name = name;
    }
    
    public HandSign nexHand() {
        return strategy.nextHandSign();
    }
    
    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }
    
    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }
    
    public void even() {
        gameCount++;
    }
    
    @Override
    public String toString() {
        return "Player{" +
            "strategy=" + strategy +
            ", name='" + name + '\'' +
            ", winCount=" + winCount +
            ", loseCount=" + loseCount +
            ", gameCount=" + gameCount +
            '}';
    }
}
