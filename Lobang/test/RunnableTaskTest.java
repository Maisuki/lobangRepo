/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiara
 */
// RunnableTaskTest.java
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class RunnableTaskTest {
    public static void main(String[] args) {
        final int THREAD_COUNT = 3;
        final int LOOP_COUNT = 3;
        final int TASK_COUNT = 5;
        ExecutorService exec;    // declare ExecutorService

        // instantiate an executor with a fixed number of threads
        exec = Executors.newFixedThreadPool(THREAD_COUNT);

        // Create five tasks and submit them to the executor
        for(int i = 1; i <= TASK_COUNT; i++) {
            RunnableTask task = new RunnableTask(i, LOOP_COUNT);
            exec.submit(task);
        }
        // INSERT CODE HERE that shuts down the executor
}   }

