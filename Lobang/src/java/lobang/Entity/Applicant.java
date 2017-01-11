/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lobang.Entity;

import java.util.Calendar;

/**
 *
 * @author Thiara
 */
public class Applicant {

    private String username;
    private String password;
    private String name;
    private char gender;
    private Calendar dob;
    private String address;
    private String bankAcct;
    private String bankBranch;
    private String phone;
    private String photo;
    private int rankpoint;

    public Applicant(String username, String password, String name, char gender, Calendar dob, String address, String bankAcct, String bankBranch, String phone, String photo, int rankpoint) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.bankAcct = bankAcct;
        this.bankBranch = bankBranch;
        this.phone = phone;
        this.photo = photo;
        this.rankpoint = rankpoint;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAcct() {
        return this.bankAcct;
    }

    public void setBankAcct(String bankAcct) {
        this.bankAcct = bankAcct;
    }

    public String getBankBranch() {
        return this.bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getRankPoint() {
        return this.rankpoint;
    }

    public void setRankPoint(int rankpoint) {
        this.rankpoint = rankpoint;
    }
    
    public char getGender(){
        return this.gender;
    }
    
    public void setGender(char gender){
        this.gender = gender;
    }
    
    public Calendar getdob(){
        return dob;
    }
    
    public void setdob(Calendar dob){
        this.dob = dob;
    }
}
