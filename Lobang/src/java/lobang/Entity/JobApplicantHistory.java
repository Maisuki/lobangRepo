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
public class JobApplicantHistory{
    private Job job;
    private Applicant applicant;
    
    public JobApplicantHistory(Job job,Applicant applicant)
    {
        this.job = job;
        this.applicant = applicant;
    }
}
