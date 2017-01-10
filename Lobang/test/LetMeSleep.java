/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiara
 */
public class LetMeSleep {
    public static void main(String[] args) {
    try {
        System.out.println("I am going to sleep for 5 seconds.");
        Thread.sleep(20);    // The "main" thread will sleep
        System.out.println("I woke up.");
    } catch(InterruptedException e) {
        System.out.println("Someone interrupted me in my sleep.");
    }
    System.out.println("I am done.");
    }
}

