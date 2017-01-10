/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobang.Entity;

/**
 *
 * @author Thiara
 */
public class PendingJob {
    private Job job;
    private Applicant applicant;
    
    public PendingJob(Job job, Applicant applicant){
        this.job = job;
        this.applicant = applicant;
    }
    
    public Job getPendingJob(){
        return this.job;
    }
    
    public void setPendingJob(Job job){
        this.job = job;
    }
    
    public Job getPendingApplicant(){
        return this.job;
    }
    
    public void setPendingApplicant(Applicant applicant){
        this.applicant = applicant;
    }
}
