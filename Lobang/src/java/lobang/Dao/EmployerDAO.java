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

/**
 *
 * @author Thiara
 */
public class EmployerDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private static String username;
    private static String password;
    private static String address;
    private static String name;
    private static String cName;
    private static String photo;
    private static String phone;
    private static long review;
    private static String cURL;
    private static boolean isVerified;

    public static ArrayList<Employer> retrieveAllEmployer() {

        ArrayList<Employer> eList = new ArrayList<Employer>();

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from Employer");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                username = rs.getString("username");
                password = rs.getString("password");
                name = rs.getString("name");
                address = rs.getString("address");
                phone = rs.getString("phone");
                photo = rs.getString("photo");
                review = rs.getLong("review");
                cName = rs.getString("cName");
                cURL = rs.getString("cURL");
                isVerified = rs.getBoolean("isVerified");
                Employer employer = new Employer(username, address, password, name, cName, photo, review, cURL, phone, isVerified);
                eList.add(employer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return eList;
    }
    public static Employer retrieveEmployerByUsername(String username) {

        

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from employer where username = ?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            rs.next();
            
            username = rs.getString("username");
            password = rs.getString("password");
            name = rs.getString("name");
            address = rs.getString("address");
            cName = rs.getString("cName");
            cURL = rs.getString("cURL");
            phone = rs.getString("phone");
            photo = rs.getString("photo");
            review = rs.getLong("review");
            isVerified = rs.getBoolean("isVerified");
            Employer employer = new Employer(username, address, password, name, cName, photo, review, cURL, phone, isVerified);
            return employer;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return null;
        
    }
    public static void updateApplicant(Employer employer) {

        try {

            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE employer SET address='?', name='?', phone='?', photo='?', password='?', cURL='?', cName='?', review='?', isVerified='?' WHERE username='?'");

            ps.setString(1, employer.getAddress());
            ps.setString(2, employer.getName());
            ps.setString(3, employer.getPhone());
            ps.setString(4, employer.getPhoto());
            ps.setString(5, employer.getPassword());
            ps.setString(6, employer.getCURL());
            ps.setString(7, employer.getCName());
            ps.setLong(8, employer.getReview());
            ps.setBoolean(9, employer.getVerification());       
            ps.setString(10, employer.getUsername());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }
        public static void deleteEmployer(String username) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM employer WHERE username='?'");

            pstmt.setString(1, username);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }
            public static void createApplicant(Employer employer) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO employer (username, password, name, address, cName,  phone, review, isVerified, photo, cURL) VALUES (?,?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, employer.getUsername());
            pstmt.setString(2, employer.getPassword());
            pstmt.setString(3, employer.getName());
            pstmt.setString(4, employer.getAddress());
            pstmt.setString(5, employer.getCName() + "");
            pstmt.setString(6, employer.getPhone());
            pstmt.setLong(7, employer.getReview());
            pstmt.setBoolean(8, employer.getVerification());
            pstmt.setString(9, employer.getPhoto());
            pstmt.setString(10, employer.getCURL());
            
            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }
}
