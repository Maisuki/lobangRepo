/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobang.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import lobang.Entity.Applicant;
import lobang.Entity.Employer;
import lobang.Entity.Job;
import lobang.Entity.JobApplicantHistory;

/**
 *
 * @author Thiara
 */
public class PendingJobDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private static Applicant applicant;
    private static Job job;
    private static ArrayList<Job> jList;
    private static ApplicantDAO aDAO;
    private static JobDAO jDAO;

    public static HashMap<Applicant, ArrayList<Job>> retrieveAllPendingJob() {

        HashMap<Applicant, ArrayList<Job>> map = new HashMap<Applicant, ArrayList<Job>>();

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from pendingJob");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String jobID = rs.getString("jobID");
                try {
                    applicant = aDAO.retrieveApplicantByUsername(username);
                    jList = retrievePendingJob(username);
                    map.put(applicant, jList);
                    
                    

                } catch (ParseException ex) {
                    Logger.getLogger(JobApplicantHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return map;
    }

    public static ArrayList<Job> retrievePendingJob(String username) {

        try {
            JobDAO jdao = new JobDAO();
            Job j = null;
            ArrayList<Job> jList = new ArrayList<Job>();
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from pendingJob where username = ?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while(rs.next()){
                String jobID = rs.getString("jobID");
                if(jobID != null){
                    j = jdao.retrieveJobByJobID(jobID);
                    jList.add(j);
                }
            }
            return jList;
          
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return null;
    }

    public static void updatePendingJob(String username, String jobID) {

        try {

            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE pendingJob SET username='?', jobID='?' WHERE username='?' && jobID = '?'");

            ps.setString(1, username);
            ps.setString(2, jobID);
           

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

    public static void deletePendingJob(String username, String jobID) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM pendingJob WHERE jobID='?' && username='?'");

            pstmt.setString(1, jobID);
            pstmt.setString(2, username);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

    public static void createPendingJob(String username, String jobID) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO pendingJob (username, jobID)  VALUES (?,?)");

            pstmt.setString(1, username);
            pstmt.setString(2, jobID);
            

            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }
}
