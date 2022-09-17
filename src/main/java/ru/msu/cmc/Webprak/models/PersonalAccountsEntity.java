package ru.msu.cmc.Webprak.models;

import javax.persistence.*;
import lombok.*;
import java.util.Objects;

@Entity
@Table(name = "personal_accounts", schema = "public", catalog = "postgres")
public class PersonalAccountsEntity {
    @Basic
    @Column(name = "client_id")
    private int clientId;
    @Basic
    @Column(name = "type_of_clint")
    private String typeOfClint;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "middle_name")
    private String middleName;
    @Basic
    @Column(name = "email")
    private String email;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getTypeOfClint() {
        return typeOfClint;
    }

    public void setTypeOfClint(String typeOfClint) {
        this.typeOfClint = typeOfClint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalAccountsEntity that = (PersonalAccountsEntity) o;
        return clientId == that.clientId && Objects.equals(typeOfClint, that.typeOfClint) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(middleName, that.middleName) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, typeOfClint, name, surname, middleName, email);
    }
}
