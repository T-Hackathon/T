package org.academiadecodigo.hackathon.dto;

import org.academiadecodigo.hackathon.persistence.model.Video;

import javax.validation.constraints.*;
import java.util.List;

public class UserDto {

    private Integer id;

    @NotNull(message = "UserName is mandatory")
    @NotBlank(message = "UserName is mandatory")
    @Size(min = 3, max = 64)
    private String userName;

    @NotNull(message = " Age is mandatory")
    @NotBlank(message = "Age name is mandatory")
    @Size(min = 1, max = 3)
    private Integer Age;

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
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
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


    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", Age='" + Age + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", videos=" + videos +
                '}';
    }
}

