package com.art2cat.dev.concurrency.applying_thread_pools;

import java.util.List;
import java.util.concurrent.*;

public class ConcurrentPuzzleSolver<P, M> {
	protected final ValueLatch<PuzzleNode<P, M>> solution = new ValueLatch<PuzzleNode<P, M>>();
	private final Puzzle<P, M> puzzle;
	private final ExecutorService exec;
	private final ConcurrentMap<P, Boolean> seen;

	public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle) {
		this.puzzle = puzzle;
		this.exec = initThreadPool();
		this.seen = new ConcurrentHashMap<>();
		if (exec instanceof ThreadPoolExecutor) {
			ThreadPoolExecutor tpe = (ThreadPoolExecutor) exec;
			tpe.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
		}
	}

	private ExecutorService initThreadPool() {
		return Executors.newCachedThreadPool();
	}

	public List<M> solve() throws InterruptedException {
		try {
			P p = puzzle.initialPosition();
			exec.execute(newTask(p, null, null));
			// block until solution found
			PuzzleNode<P, M> solnPuzzleNode = solution.getValue();
			return (solnPuzzleNode == null) ? null : solnPuzzleNode.asMoveList();
		} finally {
			exec.shutdown();
		}
	}

	protected Runnable newTask(P p, M m, PuzzleNode<P, M> n) {
		return new SolverTask(p, m, n);
	}

	protected class SolverTask extends PuzzleNode<P, M> implements Runnable {
		SolverTask(P pos, M move, PuzzleNode<P, M> prev) {
			super(pos, move, prev);
		}

		@Override
		public void run() {
			if (solution.isSet()
					|| seen.putIfAbsent(pos, true) != null) {
				return; // already solved or seen this position
			}
			if (puzzle.isGoal(pos)) {
				solution.setValue(this);
			} else {
				puzzle.legalMoves(pos).forEach(m -> exec.execute(newTask(puzzle.move(pos, m), m, this)));
			}
		}
	}
}
