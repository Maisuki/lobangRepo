/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiara
 */
import java.util.Random;

public class RunnableTask implements Runnable {
    private int taskId;
    private int loopCounter;
    private Random random = new Random();

    public RunnableTask(int taskId, int loopCounter) {
        this.taskId = taskId;
        this.loopCounter = loopCounter;
    }
        public void run() {
        for(int i = 1; i <= loopCounter; i++) {
            try {
                int sleepTime = random.nextInt(5) + 1;
                System.out.println("Task #" + this.taskId +
                    " - Iteration #" + i + " is going to sleep for "
                    + sleepTime + " seconds.");
                Thread.sleep(sleepTime * 1000);
            } catch(Exception e) {
                System.out.println("Task #" + this.taskId +
                    " has been interrupted.");
                break;
}   }   }   }


