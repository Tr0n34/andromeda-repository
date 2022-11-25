package org.andromeda.models;

import lombok.*;

import java.time.LocalDateTime;

@Builder(builderMethodName = "newBuilder")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@EqualsAndHashCode
public class User {

    private String name;
    private String surname;
    private String login;
    private String password;
    private LocalDateTime createdOn;

}
