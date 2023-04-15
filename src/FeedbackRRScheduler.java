
import java.util.PriorityQueue;
import java.util.Properties;

/**
 * Feedback Round Robin Scheduler
 *
 * @version 2017
 */
public class FeedbackRRScheduler extends AbstractScheduler {

    private PriorityQueue<Process> readyQueue;
    private int timeQuantum;

    /**
     *
     */
    public FeedbackRRScheduler() {
        readyQueue = new PriorityQueue<Process>();
    }

    /**
     * Initialises the scheduler from the given parameters
     * @param parameters
     */
    @Override
    public void initialize(Properties parameters) {
        timeQuantum = Integer.parseInt(parameters.getProperty("timeQuantum"));
    }

    /**
     * Adds a process to the ready queue. usedFullTimeQuantum is true if process
     * is being moved to ready after having fully used its time quantum.
     * @param process
     * @param usedFullTimeQuantum
     */
    @Override
    public void ready(Process process, boolean usedFullTimeQuantum) {

        process.setPriority(process.getPriority() + 1); //increment priority every time ready is called
        readyQueue.offer(process);
    }

    /**
     * Removes the next process to be run from the ready queue and returns it.
     * Returns null if there is no process to run.
     * @return 
     */
    @Override
    public Process schedule() {
        return readyQueue.poll();
    }

    @Override
    public int getTimeQuantum() {
        return timeQuantum;
    }

    /**
     * Returns whether the scheduler is preemptive
     * @return 
     */
    @Override
    public boolean isPreemptive() {
        return true;
    }
}

//increment priotiy every time ready is called i.e. lower the priority if its used up full quantum
//initialise time quantum like done with RR
