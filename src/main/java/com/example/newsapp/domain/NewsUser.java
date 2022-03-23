package com.example.newsapp.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class NewsUser {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate birthday;
    public NewsUser(String username,
                    String password,
                    String firstname,
                    String lastname,
                    LocalDate birthday) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

}

