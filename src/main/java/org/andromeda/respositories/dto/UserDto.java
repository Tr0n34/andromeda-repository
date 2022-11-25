package org.andromeda.respositories.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users", indexes = { }, schema = "andromeda", uniqueConstraints = {
        @UniqueConstraint(name = "uc_user", columnNames = {"id", "login"})
})
@Builder(builderMethodName = "newBuilder")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String login;
    private String password;
    private LocalDateTime createdOn;

}
