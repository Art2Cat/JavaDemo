package com.art2cat.dev.concurrency.concurrency_in_practice.applying_thread_pools;

import java.util.concurrent.atomic.AtomicInteger;

public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {
    
    private final AtomicInteger taskCount = new AtomicInteger(0);
    
    PuzzleSolver(Puzzle<P, M> puzzle) {
        super(puzzle);
    }
    
    @Override
    protected Runnable newTask(P p, M m, PuzzleNode<P, M> n) {
        return new CountingSolverTask(p, m, n);
    }
    
    class CountingSolverTask extends SolverTask {
        
        CountingSolverTask(P pos, M move, PuzzleNode<P, M> prev) {
            super(pos, move, prev);
            taskCount.incrementAndGet();
        }
        
        @Override
        public void run() {
            try {
                super.run();
            } finally {
                if (taskCount.decrementAndGet() == 0) {
                    solution.setValue(null);
                }
            }
        }
    }
}
