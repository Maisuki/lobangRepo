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
import java.util.Locale;
import lobang.Entity.Applicant;
import lobang.Entity.Employer;
import lobang.Entity.Job;

/**
 *
 * @author Thiara
 */
public class JobDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private static String jobID;
    private static String jobDescription;
    private static String jobScope;
    private static long pay;
    private static String paymentMode;
    private static String location;
    private static String dateTime;
    private static int pax;
    private static int hour;

    public static ArrayList<Job> retrieveAllJob() {

        ArrayList<Job> jList = new ArrayList<Job>();

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from job");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                jobID = rs.getString("jobID");
                paymentMode = rs.getString("paymentMode");
                jobDescription = rs.getString("jobDescription");
                jobScope = rs.getString("jobScope");
                pay = rs.getLong("pay");
                location = rs.getString("location");
                dateTime = rs.getString("dateTime");
                pax = rs.getInt("pax");
                hour = rs.getInt("hour");
                Job job = new Job(jobID, jobDescription, jobScope, pay, paymentMode, location, dateTime, pax, hour);
                jList.add(job);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return jList;
    }
    public static Job retrieveJobByJobID(String jobID){

        

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from job where jobID = ?");
            pstmt.setString(1, jobID);
            rs = pstmt.executeQuery();
            rs.next();
            
            jobID = rs.getString("jobID");
            jobDescription = rs.getString("jobDescription");
            jobScope = rs.getString("jobScope");
            pay = rs.getLong("pay");
            paymentMode = rs.getString("paymentMode");
            location = rs.getString("location");
            dateTime = rs.getString("dateTime");
            pax = rs.getInt("pax");
            hour = rs.getInt("hour");
            Job job = new Job(jobID, jobDescription, jobScope, pay, paymentMode, location, dateTime, pax, hour);
            return job;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return null;
    }
    public static void updateJob(Job job) {

        try {

            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE job SET jobDescription='?', jobScope='?', pay='?', paymentMode='?', location='?', dateTime='?', pax='?', hour='?' WHERE jobID='?'");

            
            ps.setString(1, job.getJobDescription());
            ps.setString(2, job.getJobScope());
            ps.setLong(3, job.getPay());
            ps.setString(4, job.getPaymentMode());
            ps.setString(5, job.getLocation());
            ps.setString(6, job.getDateTime());
            ps.setInt(7, job.getPax());
            ps.setInt(8, job.getHour());       
            ps.setString(9, job.getJobID());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }
        public static void deleteJob(String jobID) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM job WHERE jobID='?'");

            pstmt.setString(1, jobID);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }
            public static void createJob(Job job) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO job (jobID, jobDescription, jobScope, pay, paymentMode,  location, dateTime, pax, hour) VALUES (?,?,?,?,?,?,?,?,?)");
            
            pstmt.setString(1, job.getJobID());
            pstmt.setString(2, job.getJobDescription());
            pstmt.setString(3, job.getJobScope());
            pstmt.setLong(4, job.getPay());
            pstmt.setString(5, job.getPaymentMode());
            pstmt.setString(6, job.getLocation());
            pstmt.setString(7, job.getDateTime());
            pstmt.setInt(8, job.getPax());
            pstmt.setInt(9, job.getHour());       
            
            
            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }
}
