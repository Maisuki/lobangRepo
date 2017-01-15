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

/**
 *
 * @author Thiara
 */
public class ApplicantDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private static String username;
    private static String password;
    private static String name;
    private static char gender;
    private static Calendar dob;
    private static String address;
    private static String bankAcct;
    private static String bankBranch;
    private static String phone;
    private static String photo;
    private static int rankpoint;

    public static ArrayList<Applicant> retrieveAllApplicant() throws ParseException {

        Applicant applicant;
        ArrayList<Applicant> aList = new ArrayList<Applicant>();

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from Applicant");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                username = rs.getString("username");
                password = rs.getString("password");
                name = rs.getString("name");
                gender = rs.getString("gender").charAt(0);

                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                cal.setTime(sdf.parse(rs.getString("dob")));
                dob = cal;
                address = rs.getString("address");
                bankAcct = rs.getString("bankAcct");
                bankBranch = rs.getString("bankBranch");
                phone = rs.getString("phone");
                photo = rs.getString("photo");
                rankpoint = rs.getInt("rankpoint");
                applicant = new Applicant(username, password, name, gender, dob, address, bankAcct, bankBranch, phone, photo, rankpoint);
                aList.add(applicant);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return aList;
    }

    public static Applicant retrieveApplicantByUsername(String username) throws ParseException {

        Applicant applicant = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from applicant where username = ?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            rs.next();
            username = rs.getString("username");
            password = rs.getString("password");
            name = rs.getString("name");
            gender = rs.getString("gender").charAt(0);

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            cal.setTime(sdf.parse(rs.getString("dob")));
            dob = cal;
            address = rs.getString("address");
            bankAcct = rs.getString("bankAcct");
            bankBranch = rs.getString("bankBranch");
            phone = rs.getString("phone");
            photo = rs.getString("photo");
            rankpoint = rs.getInt("rankpoint");
            applicant = new Applicant(username, password, name, gender, dob, address, bankAcct, bankBranch, phone, photo, rankpoint);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return applicant;
    }

    public static void updateApplicant(Applicant applicant) {

        try {

            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE applicant SET password='?', address='?', name='?', phone='?', photo='?', bankAcct='?', bankBranch='?', rankpoint='?', gender='?', dob='?' WHERE username='?'");

            ps.setString(1, applicant.getPassword());
            ps.setString(2, applicant.getAddress());
            ps.setString(3, applicant.getName());
            ps.setString(4, applicant.getPhone());
            ps.setString(5, applicant.getPhoto());
            ps.setString(6, applicant.getBankAcct());
            ps.setString(7, applicant.getBankBranch());
            ps.setInt(8, applicant.getRankPoint());
            ps.setString(9, applicant.getGender()+ "");
            SimpleDateFormat formatter=new SimpleDateFormat("DD-MMM-yyyy");        
            ps.setString(10, formatter.format(applicant.getdob().getTime()));
            ps.setString(11, applicant.getUsername());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

    public static void deleteApplicant(String username) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM applicant WHERE username='?'");

            pstmt.setString(1, username);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

    public static void createApplicant(Applicant applicant) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO applicant (username, password, bankAcct, bankBranch, gender,  phone, address, name, dob, photo, rankpoint) VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, applicant.getUsername());
            pstmt.setString(2, applicant.getPassword());
            pstmt.setString(3, applicant.getBankAcct());
            pstmt.setString(4, applicant.getBankBranch());
            pstmt.setString(5, applicant.getGender() + "");
            pstmt.setString(6, applicant.getPhone());
            pstmt.setString(7, applicant.getAddress());
            pstmt.setString(8, applicant.getName());
            SimpleDateFormat formatter=new SimpleDateFormat("DD-MMM-yyyy");        
            pstmt.setString(9, formatter.format(applicant.getdob().getTime()));
            pstmt.setString(10, applicant.getPhoto());
            pstmt.setInt(11, applicant.getRankPoint());
            
            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

}
