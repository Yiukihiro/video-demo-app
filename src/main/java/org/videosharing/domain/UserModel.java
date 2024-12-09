package org.videosharing.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

@Table(name = "auth")
public class UserModel {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "auth_generator")
    @SequenceGenerator(name = "auth_generator", sequenceName = "s_auth", allocationSize = 1)
    private Long id;
    private String login;
    private String password;
}
