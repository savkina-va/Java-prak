package ru.msu.cmc.Webprak.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "personal_accounts", schema = "public", catalog = "postgres")
public class PersonalAccounts implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @NonNull
    @Column(name = "type_of_clint")
    private String typeOfClint;

    @NonNull
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @NonNull
    @Column(name = "email")
    private String email;
}
