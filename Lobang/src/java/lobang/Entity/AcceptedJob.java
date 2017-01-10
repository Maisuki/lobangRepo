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
public class AcceptedJob {
    private Job job;
    private Applicant applicant;
    
        public AcceptedJob(Job job, Applicant applicant){
        this.job = job;
        this.applicant = applicant;
    }
    
    public Job getAcceptedJob(){
        return this.job;
    }
    
    public void setAcceptedJob(Job job){
        this.job = job;
    }
    
    public Job getAcceptedApplicant(){
        return this.job;
    }
    
    public void getAcceptedApplicant(Applicant applicant){
        this.applicant = applicant;
    }

}
