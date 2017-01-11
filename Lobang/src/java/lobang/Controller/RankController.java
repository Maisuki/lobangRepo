/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobang.Controller;

import lobang.Dao.*;
import lobang.Entity.Applicant;
import lobang.Entity.Job;

/**
 *
 * @author Thiara
 */
public class RankController {
    
    public static void rankUpdate(String username){
        JobApplicantHistoryDAO jahdao = new JobApplicantHistoryDAO();
        ArrayList<Job> jList = jahdao.retrieveJobApplicantHistory();
        ApplicantDAO aDAO = new ApplicantDAO();
        Applicant a = aDAO.retrieveApplicantByUsername(username);
        int currRankPoint = a.getRankPoint();
        int pointGain = 0;
        for(Job j : jList){
            pointGain = j.getPay()*j.getHour();
            currRankPoint += pointGain;
            pointGain = 0;
        }
    }
    
}
