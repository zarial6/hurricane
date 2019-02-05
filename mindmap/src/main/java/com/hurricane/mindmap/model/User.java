package com.hurricane.mindmap.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    private String firstName;

    private String lastName;

    private String email;

    private String login;

    private String password;

}
