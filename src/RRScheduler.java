
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;

/**
 * Round Robin Scheduler
 *
 * @version 2017
 */
public class RRScheduler extends AbstractScheduler {

    private Queue<Process> readyQueue;
    private int timeQuantum;

    //create local time quantum variable
    public RRScheduler() {
        readyQueue = new LinkedList<Process>();
    }

    /**
     * Initialises the scheduler from the given parameters
     */
    public void initialize(Properties parameters) {
        timeQuantum = Integer.parseInt(parameters.getProperty("timeQuantum"));
    }

    /**
     * Adds a process to the ready queue. usedFullTimeQuantum is true if process
     * is being moved to ready after having fully used its time quantum.
     */
    public void ready(Process process, boolean usedFullTimeQuantum) {
        readyQueue.offer(process);
    }

    /**
     * Removes the next process to be run from the ready queue and returns it.
     * Returns null if there is no process to run.
     */
    public Process schedule() {
        return readyQueue.poll();
    }

    public int getTimeQuantum() {
        return timeQuantum;
    }

    /**
     * Returns whether the scheduler is preemptive
     */
    public boolean isPreemptive() {
        return true;
    }

}
