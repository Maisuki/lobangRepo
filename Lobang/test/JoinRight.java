/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiara
 */
// JoinRight.java
public class JoinRight {
    public static void main(String[] args){
        Thread t1 = new Thread(JoinRight::print);
        t1.start();
        try{
        t1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        // INSERT CODE HERE
        // that makes the “main” thread
        // wait until t1 is terminated
        //
        //
        //
        //
        System.out.println("We are done.");
    }
    public static void print() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("Counter: " + i);
                Thread.sleep(5000);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



