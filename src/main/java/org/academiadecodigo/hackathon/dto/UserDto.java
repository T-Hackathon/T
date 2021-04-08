package org.academiadecodigo.hackathon.dto;

import org.academiadecodigo.hackathon.persistence.model.Video;
import util.Security;

import javax.validation.constraints.*;
import java.util.List;

public class UserDto {

    private Integer id;

    @NotNull(message = "UserName is mandatory")
    @NotBlank(message = "UserName is mandatory")
    @Size(min = 3, max = 64)
    private String userName;

    private Integer age;

    @Email
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
    @Size(min = 9, max = 16)
    private String phone;

    @NotNull(message = "City is mandatory")
    @NotBlank(message = "City is mandatory")
    @Size(min = 3, max = 64)
    private String city;

    @NotNull(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 3, max = 64)
    private String password;

    private List<Video> videos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Security.getHash(password);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", Age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", videos=" + videos +
                '}';
    }
}

