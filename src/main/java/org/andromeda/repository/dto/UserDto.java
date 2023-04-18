package org.andromeda.repository.dto;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users", indexes = { }, schema = "andromeda", uniqueConstraints = {
        @UniqueConstraint(name = "uc_login_user", columnNames = {"login"})
})
@Builder(builderMethodName = "newBuilder")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class UserDto {

    @Id
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String login;
    private String password;
    private LocalDateTime createdOn;
    @Version
    private Long version;

}
