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
@Table(name = "personal_accounts", schema = "public", catalog = "postgres")
public class PersonalAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;
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

//    public Long getClientId() {
//        return clientId;
//    }
//
//    public void setClientId(Long clientId) {
//        this.clientId = clientId;
//    }
//
//    public String getTypeOfClint() {
//        return typeOfClint;
//    }
//
//    public void setTypeOfClint(String typeOfClint) {
//        this.typeOfClint = typeOfClint;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalAccounts that = (PersonalAccounts) o;
        return clientId.equals(that.clientId) && Objects.equals(typeOfClint, that.typeOfClint) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(middleName, that.middleName) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, typeOfClint, name, surname, middleName, email);
    }
}
