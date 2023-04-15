
import java.util.PriorityQueue;

/**
 * Ideal Shortest Job First Scheduler
 *
 * @author Candidate Number: 203068
 * @version 1.0 - 01/04/2020
 */
public class IdealSJFScheduler extends AbstractScheduler {

    private PriorityQueue<Process> readyQueue;

    //same as FCFS except now with priorities set to burst times
    public IdealSJFScheduler() {
        readyQueue = new PriorityQueue<Process>();
    }

    /**
     * Adds a process to the ready queue. usedFullTimeQuantum is true if process
     * is being moved to ready after having fully used its time quantum.
     */
    public void ready(Process process, boolean usedFullTimeQuantum) {
        process.setPriority(process.getNextBurst()); //priority of process being added to queue is equal to that of its burst time to pick the shortest job first
        readyQueue.offer(process);
    }

    /**
     * Removes the next process to be run from the ready queue and returns it.
     * Returns null if there is no process to run.
     */
    public Process schedule() {
        return readyQueue.poll();
    }

}
