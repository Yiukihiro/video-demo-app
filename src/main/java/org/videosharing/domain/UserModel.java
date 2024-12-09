package org.videosharing.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor

@Table(name = "auth")
public class UserModel {
    public UserModel(String login, String password){};
    private String login;
    private String password;
}
