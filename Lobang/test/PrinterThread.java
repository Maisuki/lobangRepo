/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiara
 */
public class PrinterThread {
    public static void main(String[] args) {
        // Create a Thread object
        Thread t = new Thread(PrinterThread::print);
        // Start the thread
        t.start();
        System.out.println("Finished?");
    }
    public static void print() {
        for (int i = 1; i <= 500; i++) {
            System.out.println(i + " ");
        }			
    }
}

