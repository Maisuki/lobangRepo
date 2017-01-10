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
public class Employer {

    private String username;
    private String password;
    private String address;
    private String name;
    private String cName;
    private String photo;
    private String phone;
    private long review;
    private String cURL;

    public Employer(String username, String address, String password, String name, String cName, String photo, long review, String cURL, String Phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.cName = cName;
        this.address = address;
        this.photo = photo;
        this.phone = phone;
        this.review = review;
        this.cURL = cURL;
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

    public String getCName() {
        return this.cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCURL() {
        return this.cURL;
    }

    public void setCURL(String cURL) {
        this.cURL = cURL;
    }
    
    public long getReview(){
        return this.review;
    }
    
    public void setReview(long review){
        this.review = review;
    }
}
