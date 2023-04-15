
import java.util.PriorityQueue;
import java.util.Properties;

/**
 * Shortest Job First Scheduler
 *
 * @version 2017
 */
public class SJFScheduler extends AbstractScheduler {

    private PriorityQueue<Process> readyQueue;
    private float alphaBE; //alpha Burst Estimate
    private int latestBE; //latest Burst Estimate

    public SJFScheduler() {
        readyQueue = new PriorityQueue<Process>();
    }
    
    @Override
    public void initialize(Properties parameters) {
        alphaBE = Float.parseFloat(parameters.getProperty("alphaBurstEstimate"));
        latestBE = Integer.parseInt(parameters.getProperty("initialBurstEstimate"));
    }

    /**
     * Adds a process to the ready queue. usedFullTimeQuantum is true if process
     * is being moved to ready after having fully used its time quantum.
     */
    public void ready(Process process, boolean usedFullTimeQuantum) {

        //exponential average formula: new estimate = (alpha) * recentCPUburst + (1 - alpha) * old estimate
        int predictedBurstTime = (int) ((alphaBE * process.getRecentBurst()) + ((1 - alphaBE) * latestBE));
        process.setPriority(predictedBurstTime);
        readyQueue.offer(process);

        latestBE = predictedBurstTime; //overwriting Burst Estimate to ensure it is always up to date with the current burst prediction

    }

    /**
     * Removes the next process to be run from the ready queue and returns it.
     * Returns null if there is no process to run.
     */
    public Process schedule() {
        return readyQueue.poll();
    }
    
    
}

//priority of process defined by:
//for each process use exponential averaging to estimate its next burst duration
//use getRecentBurst() method to get duration of most recent CPU burst of process

//non-preemptive scheduler
