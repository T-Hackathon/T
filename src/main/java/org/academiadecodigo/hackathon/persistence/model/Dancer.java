package org.academiadecodigo.hackathon.persistence.model;

import util.Security;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dancer")
public class Dancer extends AbstractModel{
    //Fields
    private String userName;
    private String password;
    private String email;
    private Integer age;
    private String city;
    private String phone;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove recipients if unlinked from customer
            orphanRemoval = true,

            // use recipient foreign key on recipient table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "dancer",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private List<Video> videos = new ArrayList<>();

    //Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Video> getVideos() {
        return videos;
    }

}
