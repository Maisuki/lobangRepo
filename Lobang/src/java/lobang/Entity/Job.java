/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobang.Entity;

import java.util.Calendar;

/**
 *
 * @author Thiara
 */
public class Job {

    private String jobID;
    private String jobDescription;
    private String jobScope;
    private long pay;
    private String paymentMode;
    private String location;
    private String dateTime;
    private int pax;
    private int hour;

    public Job(String jobID, String jobDescription, String jobScope, long pay, String paymentMode, String location, String dateTime, int pax, int hour) {
        this.jobID = jobID;
        this.jobDescription = jobDescription;
        this.jobScope = jobScope;
        this.pay = pay;
        this.paymentMode = paymentMode;
        this.location = location;
        this.dateTime = dateTime;
        this.pax = pax;
        this.hour = hour;
    }
    
    public String getJobID(){
        return this.jobID;
    }
    public void setJobID(String jobID){
        this.jobID = jobID;
    }
 
    public String getJobDescription(){
        return this.jobDescription;
    }
    public void setJobDescription(String jobDescription){
        this.jobDescription = jobDescription;
    }
        
    public String getJobScope(){
        return this.jobScope;
    }
    public void setJobScope(String jobScope){
        this.jobScope = jobScope;
    }
        
    public long getPay(){
        return this.pay;
    }
    public void setPay(long pay){
        this.pay = pay;
    }
        
    public String getPaymentMode(){
        return this.paymentMode;
    }
    public void setPaymentMode(String paymentMode){
        this.paymentMode = paymentMode;
    }
        
    public String getLocation(){
        return this.location;
    }
    public void setLocation(String location){
        this.location = location;
    }
        
    public String getDateTime(){
        return this.dateTime;
    }
    public void setDateTime(String jobID){
        this.dateTime = dateTime;
    }
    
    public int getPax(){
        return this.pax;
    }
    
    public void setPax(int pax){
        this.pax = pax;
    }
    public int getHour(){
        return this.hour;
    }
    
    public void setHour(int hour){
        this.hour = hour;
    }
    
}
