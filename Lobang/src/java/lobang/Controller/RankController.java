/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobang.Controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        ArrayList<Job> jList = null;
        jList = jahdao.retrieveJobApplicantHistory(username);
        ApplicantDAO aDAO = new ApplicantDAO();
        Applicant a = null;
        try {
            a = aDAO.retrieveApplicantByUsername(username);
        } catch (ParseException ex) {
            Logger.getLogger(RankController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int currRankPoint = a.getRankPoint();
        long pointGain = 0;
        for(Job j : jList){
            pointGain = j.getPay()*j.getHour();
            currRankPoint += pointGain;
            pointGain = 0;
        }
        a.setRankPoint((int) pointGain);
    }
    
}
