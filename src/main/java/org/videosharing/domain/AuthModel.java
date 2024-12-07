package org.videosharing.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor

@Table(name = "auth")
public class AuthModel {
    private String login;
    private String password;
    @Id
    @GeneratedValue
    private Long id;


}
