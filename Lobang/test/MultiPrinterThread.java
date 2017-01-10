/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiara
 */
public class MultiPrinterThread {
    static Thread t1;
    static Thread t2;
    public static void main(String[] args) throws InterruptedException {
        // Create two Thread objects
        
        Thread t1 = new Thread(MultiPrinterThread::print);
        Thread t2 = new Thread(MultiPrinterThread::print);
        // Start both threads
        
        t1.start();
        
        t2.start();
        
        
        System.out.println("----FINISHED----");
        
    }
    public static void print() {
        
        Thread thisThread = Thread.currentThread(); 
        try {
            
        System.out.println(thisThread.getName() + " I am going to sleep for 5 seconds.");
        Thread.sleep(20);    // The "main" thread will sleep
        System.out.println(thisThread.getName() + " I woke up.");
        
        
        
    } catch(InterruptedException e) {
        System.out.println(thisThread.getName() + " Someone interrupted me in my sleep.");
    }
    System.out.println(thisThread.getName() + " I am done.");
    
    	// working memory (stack)
        }			// of each thread, along with
    }			// the thread’s program

