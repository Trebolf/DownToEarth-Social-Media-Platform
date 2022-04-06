package com.earth.DownToEarth.models;

<<<<<<< HEAD
import lombok.*;
=======
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
<<<<<<< HEAD
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserId;

    @Column(nullable = false)
=======

@Entity
@Table(name = "_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
    private String username;

    @Column(nullable = false)
    private String password;

<<<<<<< HEAD
=======
    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = true)
    private String location;  //optional

    @Override
    public String toString() {
        return "\n" + "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
>>>>>>> 99742ad7e2cbb88404d80854f7480aa8e0031860
}
