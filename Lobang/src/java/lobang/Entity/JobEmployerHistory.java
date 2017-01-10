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
public class JobEmployerHistory {
    private Job job;
    private Employer employer;
    
    public JobEmployerHistory(Job job,Employer employer)
    {
        this.job = job;
        this.employer = employer;
    }
}
